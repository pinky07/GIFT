package com.gft.GiFT.projects.reportIncidents.businessLogic.inputs;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "t_incidents_report" )
public class IncidentsReport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "report_id")
    private int id;

    @Column(name = "report_date", columnDefinition = "DATE", nullable = false)
    private String incidentsDate;

    @Column(name = "total_incidents", columnDefinition = "INT", nullable = false)
    private int totalIncidents;

    @Column(name = "rationale_issues",  nullable = false,length = 60)
    private String rationale;

    private int projectId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIncidentsDate() {
		return incidentsDate;
	}

	public void setIncidentsDate(String incidentsDate) {
		this.incidentsDate = incidentsDate;
	}

	public int getTotalIncidents() {
		return totalIncidents;
	}

	public void setTotalIncidents(int totalIncidents) {
		this.totalIncidents = totalIncidents;
	}

	public String getRationale() {
		return rationale;
	}

	public void setRationale(String rationale) {
		this.rationale = rationale;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


}
