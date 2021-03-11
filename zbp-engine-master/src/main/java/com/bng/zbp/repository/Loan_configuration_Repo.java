package com.bng.zbp.repository;

import com.bng.zbp.model.entity.LoanConfiguration;

import org.springframework.stereotype.Repository;

/*
  @Author Karan
 */
@Repository
public interface Loan_configuration_Repo extends BaseJpaRepository<LoanConfiguration, Long> {
	LoanConfiguration findByName(String name);
	
}
