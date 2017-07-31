package com.gft.GiFT.projects.dashboard;

import com.gft.GiFT.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardProjectRepository extends JpaRepository<Project, Integer> {

}