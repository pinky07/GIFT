package com.gft.GiFT.projects.addReleaseSnap.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;
import com.gft.GiFT.projects.addReleaseSnap.businessLogic.inputs.ReleaseSnap;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReleaseSnapRepository extends JpaRepository<ReleaseSnap, Integer> {
}
