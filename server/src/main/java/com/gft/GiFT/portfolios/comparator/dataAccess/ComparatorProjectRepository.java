package com.gft.GiFT.portfolios.comparator.dataAccess;

import com.gft.GiFT.portfolios.comparator.businessLogic.inputs.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface  ComparatorProjectRepository extends JpaRepository<Portfolio, Integer> {
}
