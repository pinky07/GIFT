package com.gft.GiFT.portfolios.comparator.businessLogic.response;

import lombok.Data;

@Data
public class LastSnapDTO {
    int projectId;
    String projectName;
    String tac;
    String daysWithoutRelease;
    String relatedIncidents;
    String waste;
    String mood;

}

