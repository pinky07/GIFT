package com.gft.GiFT.entities;

import com.gft.GiFT.projects.dashboard.dataAccess.IncidentsReport;
import com.gft.GiFT.projects.dashboard.dataAccess.ReleaseSnap;
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

}