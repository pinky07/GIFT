package com.gft.GiFT.portfolios.comparator.businessLogic.inputs;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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
    private Set<Project> projects = new LinkedHashSet<>();

}

