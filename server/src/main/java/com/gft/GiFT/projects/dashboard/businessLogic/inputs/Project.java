package com.gft.GiFT.projects.dashboard.businessLogic.inputs;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectId")
    private List<ReleaseSnap> releaseSnaps = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectId")
    private List<IncidentsReport> incidentsReports = new LinkedList<>();

}