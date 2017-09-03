package com.gft.GiFT.projects.addCycleSnap.dataAccess;

import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.CycleSnap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CycleSnapRepository extends JpaRepository<CycleSnap, Integer>  {
    List<CycleSnap> findByProjectId(int projectId);
}