package com.gft.GiFT.portfolios.compare.businessLogic.inputs;

import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.IncidentReportBO;
import lombok.Data;
import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table( name = "t_project" )
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "project_id")
    private int id;

    @Column(name = "project_name", nullable = false, length = 45)
    private String name;

    @Column(name = "portfolio_id", nullable = false)
    private int portfolioId;

    @OrderBy("endDate DESC")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectId")
    private List<CycleSnap> cycleSnapSet = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectId")
    private List<ReleaseSnap> releaseSnaps = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectId")
    private List<IncidentsReport> incidentsReports = new LinkedList<>();

    public CycleSnap getLastSnap(){
        Comparator<CycleSnap> dateComparator = new Comparator<CycleSnap>() {
            @Override
            public int compare(CycleSnap user1, CycleSnap user2) {
                return user1.getEndDate().compareTo(user2.getEndDate());
            }
        };

        Optional latest = cycleSnapSet.stream().max(dateComparator);
        if (latest.isPresent())
            return (CycleSnap) latest.get();
        else
            return null;
    }

    public List<String> getCyclesStartDates() {
        List<CycleSnap> cycles = getCycleSnapSet();
        List<String> datesAsString = new LinkedList<>();
        for (CycleSnap cycle : cycles) {
            String dateAsString = cycle.getStartDate();
            datesAsString.add(dateAsString);
        }

        return datesAsString;
    }

    public List<String> getReleasesDates() {
        List<ReleaseSnap> releaseSnaps = getReleaseSnaps();
        List<String> datesAsString = new LinkedList<>();
        for (ReleaseSnap snap : releaseSnaps) {
            String dateAsString = snap.getReleaseDate();
            datesAsString.add(dateAsString);
        }

        return datesAsString;
    }

    public List<IncidentReportBO> getIncidentsAsBusinessObjects() {
        List<IncidentReportBO> incidents = new LinkedList<>();
        for (IncidentsReport report : incidentsReports) {
            incidents.add(report.getAsBusinessObject());
        }

        return incidents;
    }
}