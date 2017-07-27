package com.gft.GiFT.service;

import com.gft.GiFT.dto.ProjectDTO;

public interface ProjectService {

    ProjectDTO findDashboardByProjectId(int id);
}