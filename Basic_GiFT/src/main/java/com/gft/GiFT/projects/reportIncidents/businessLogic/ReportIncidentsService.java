package com.gft.GiFT.projects.reportIncidents.businessLogic;
import com.gft.GiFT.projects.reportIncidents.businessLogic.inputs.IncidentsReport;

import java.text.ParseException;

public interface ReportIncidentsService {
    IncidentsReport createIncidentsReport(IncidentsReport releaseSnap) throws ParseException;

}

