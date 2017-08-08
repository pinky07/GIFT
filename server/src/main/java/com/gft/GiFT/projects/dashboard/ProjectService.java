package com.gft.GiFT.projects.dashboard;

import java.text.ParseException;

public interface ProjectService {

    ProjectDTO findDashboardByProjectId(int id) throws ParseException;
}