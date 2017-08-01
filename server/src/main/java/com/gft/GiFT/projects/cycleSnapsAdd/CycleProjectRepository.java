package com.gft.GiFT.projects.cycleSnapsAdd;

import com.gft.GiFT.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CycleProjectRepository extends JpaRepository<Project, Integer> {
}