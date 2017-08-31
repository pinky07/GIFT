package com.gft.GiFT.portfolios.compare.businessLogic.inputs;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "t_portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "portfolio_id")
    private int id;

    @Column(name = "portfolio_name", nullable = false, length = 200)
    private String portfolioName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "portfolioId")
    private List<Project> projects = new LinkedList<>();

}

