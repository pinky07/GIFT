package com.gft.GiFT.portfolios.compare.businessLogic.inputs;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_release_snap")
public class ReleaseSnap {

    public ReleaseSnap(){}

    public ReleaseSnap(String releaseDate, int projectId){
        this.releaseDate = releaseDate;
        this.projectId = projectId;
    }
                     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "release_id")
    private int id;

    @Column(name = "release_date", columnDefinition = "DATE", nullable = false)
    private String releaseDate;

    private int projectId;
}