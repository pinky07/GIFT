package com.gft.GiFT.projects.dashboard;

import com.gft.GiFT.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DashboardProjectRepository extends JpaRepository<Project, Integer> {
}