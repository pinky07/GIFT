package com.gft.GiFT.portfolios.projectsList;

import com.gft.GiFT.portfolios.projectsList.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByPortfolioId(int projectId);

}