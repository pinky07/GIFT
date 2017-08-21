package com.gft.GiFT.projects.addCycleSnap.businessLogic;

import lombok.Data;
import javax.persistence.*;

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

    @Column(name = "start_date", columnDefinition = "DATE", nullable = false)
    private String startDate;

    @Column(name = "end_date", columnDefinition = "DATE", nullable = false)
    private String endDate;

    @Column(name = "targeted_points", nullable = false)
    private int targetedPoints;

    @Column(name = "achieved_points", nullable = false)
    private int achievedPoints;

    @Column(name = "is_mood_available", nullable = false)
    private Boolean isMoodAvailable;

    @Column(name = "mood_average", nullable = false)
    private double moodAverage;

    private int projectId;

}