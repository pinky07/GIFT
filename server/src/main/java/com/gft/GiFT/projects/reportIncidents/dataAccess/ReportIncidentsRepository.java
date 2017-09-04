package com.gft.GiFT.projects.reportIncidents.dataAccess;

import com.gft.GiFT.projects.reportIncidents.businessLogic.inputs.IncidentsReport;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReportIncidentsRepository extends JpaRepository<IncidentsReport, Integer> {
}
