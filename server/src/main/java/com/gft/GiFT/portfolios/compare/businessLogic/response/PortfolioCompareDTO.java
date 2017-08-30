package com.gft.GiFT.portfolios.compare.businessLogic.response;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;


@Data
public class PortfolioCompareDTO {
    String portfolioName;
    private List<LastSnapDTO> lastSnaps = new LinkedList<>();

    public void addSnap(LastSnapDTO snap){
        lastSnaps.add(snap);
    }
}