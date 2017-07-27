package com.gft.GiFT.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_cycle_snap")
public class CycleSnap {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "cycle_snap_id")
    private int cycleSnapId;

    @Column(name = "cycle_snap_name", nullable = false, length = 200)
    private String cycleSnapName;

    @Column(name = "start_date", columnDefinition = "DATETIME", nullable = false)
    private Date startDate;

    @Column(name = "end_date", columnDefinition = "DATETIME", nullable = true)
    private Date endDate;

    @Column(name = "targeted_points", nullable = false)
    private int targetedPoints;

    @Column(name = "achieved_points", nullable = true)
    private int achievedPoints;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "project_id", nullable = false)
//    private Project project;

}