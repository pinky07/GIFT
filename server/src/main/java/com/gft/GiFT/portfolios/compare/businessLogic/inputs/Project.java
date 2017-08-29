package com.gft.GiFT.portfolios.comparator.businessLogic.inputs;

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
    private Set<CycleSnap> cycleSnapSet = new LinkedHashSet<>();

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectId")
//    private List<ReleaseSnap> releaseSnaps = new LinkedList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectId")
//    private List<IncidentsReport> incidentsReports = new LinkedList<>();

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
}