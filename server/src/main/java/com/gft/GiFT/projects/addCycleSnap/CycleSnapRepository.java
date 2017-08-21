package com.gft.GiFT.projects.addCycleSnap;

import com.gft.GiFT.entities.CycleSnap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
@Transactional
public interface CycleSnapRepository extends JpaRepository<CycleSnap, Integer>  {

    Set<CycleSnap> findByProjectId(int projectId);
}