package com.gft.GiFT.projects.cycleSnapsAdd;

import com.gft.GiFT.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CycleProjectRepository extends JpaRepository<Project, Integer> {
}