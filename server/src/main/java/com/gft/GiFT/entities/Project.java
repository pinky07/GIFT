package com.gft.GiFT.entities;

import com.gft.GiFT.projects.dashboard.IncidentsReport;
import com.gft.GiFT.projects.dashboard.ReleaseSnap;
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

    @Column(name = "release_pattern_id", nullable = false)
    private int releasePatternId;

    @Column(name = "cycle_type_id", nullable = false)
    private int cycleTypeId;

    @Column(name = "project_status", nullable = false)
    private int projectStatus;

    @OrderBy("endDate DESC")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectId")
    private Set<CycleSnap> cycleSnapSet = new LinkedHashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectId")
    private List<ReleaseSnap> releaseSnaps = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectId")
    private List<IncidentsReport> incidentsReport = new LinkedList<>();

}