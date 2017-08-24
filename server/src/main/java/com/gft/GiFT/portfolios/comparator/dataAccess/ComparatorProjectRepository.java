package com.gft.GiFT.portfolios.comparator.dataAccess;

import com.gft.GiFT.projects.dashboard.businessLogic.inputs.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface  ComparatorProjectRepository extends JpaRepository<Project, Integer> {
}
