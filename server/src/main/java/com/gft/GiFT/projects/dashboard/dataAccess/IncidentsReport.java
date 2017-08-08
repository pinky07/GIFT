package com.gft.GiFT.projects.dashboard.dataAccess;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "t_incidents_report" )
public class IncidentsReport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "report_id")
    private int id;

    @Column(name = "report_date", columnDefinition = "DATE", nullable = false)
    private String incidentsDate;

    @Column(name = "total_incidents", columnDefinition = "INT", nullable = false)
    private int totalIncidents;

    @Column(name = "projectId", columnDefinition = "INT", nullable = false)
    private int projectId;

}
