package com.gft.GiFT.projects.reportIncidents.businessLogic;

import com.gft.GiFT.projects.reportIncidents.businessLogic.inputs.IncidentsReport;
import com.gft.GiFT.projects.reportIncidents.businessLogic.inputs.ReportIncidentsValidation;
import com.gft.GiFT.projects.reportIncidents.dataAccess.ReportIncidentsRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class DefaultReportIncidentsService implements ReportIncidentsService {
    private final ReportIncidentsRepository reportRepository;

    public DefaultReportIncidentsService(ReportIncidentsRepository reportRepository){
        this.reportRepository= reportRepository;
    }

    @Override
    public IncidentsReport createIncidentsReport(IncidentsReport incidentsReport) throws ParseException {
        ReportIncidentsValidation.Validation(incidentsReport);
        reportRepository.save(incidentsReport);
        return incidentsReport;
    }
}
