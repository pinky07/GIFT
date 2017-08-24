package com.gft.GiFT.portfolios.comparator.businessLogic.response;
import lombok.Data;

import java.util.List;


@Data
public class PortfoiloComparatorDTO {
    String portfolioNames;
    private List<LastSnap> lastSnaps ;


}
