package com.gft.GiFT.projects.addCycleSnap.dataAccess;

import com.gft.GiFT.projects.addCycleSnap.businessLogic.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CycleProjectRepository extends JpaRepository<Project, Integer> {
}