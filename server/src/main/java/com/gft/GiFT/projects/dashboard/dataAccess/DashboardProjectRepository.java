package com.gft.GiFT.projects.dashboard.dataAccess;

import com.gft.GiFT.projects.dashboard.businessLogic.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DashboardProjectRepository extends JpaRepository<Project, Integer> {
}