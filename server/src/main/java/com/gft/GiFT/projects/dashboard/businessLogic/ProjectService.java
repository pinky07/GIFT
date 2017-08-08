package com.gft.GiFT.projects.dashboard.businessLogic;

import java.text.ParseException;

public interface ProjectService {

    ProjectDTO findDashboardByProjectId(int id) throws ParseException;
}