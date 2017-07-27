package com.gft.GiFT.repository;

import com.gft.GiFT.entities.CycleSnap;
import com.gft.GiFT.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CycleSnapRepository extends JpaRepository<CycleSnap, Integer>  {

    @Query("SELECT cs FROM CycleSnap cs WHERE cs.project = :project")
    List<CycleSnap> findByProjectId(@Param("project") Project project);

}