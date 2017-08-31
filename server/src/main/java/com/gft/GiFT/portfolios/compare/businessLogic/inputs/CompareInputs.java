package com.gft.GiFT.portfolios.compare.businessLogic.inputs;

import lombok.Data;

import java.util.Date;

@Data
public class CompareInputs {
    private Portfolio portFolio;
    private int portfolioId;
    private Date currentDate;

    public boolean portfolioDoesNotExist() {
        return portFolio == null;
    }
}
