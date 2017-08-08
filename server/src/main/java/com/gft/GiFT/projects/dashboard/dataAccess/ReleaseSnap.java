package com.gft.GiFT.projects.dashboard.dataAccess;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "t_release_snap" )
public class ReleaseSnap {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "release_id")
    private int id;

    @Column(name = "release_date", columnDefinition = "DATE", nullable = false)
    private String releaseDate;

    private int projectId;
}