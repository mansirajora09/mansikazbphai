package com.bng.zbp.repository;

import com.bng.zbp.model.entity.Campaign;
import com.bng.zbp.model.entity.Operator;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Mansi Rajora
 */
@Repository
public interface OperatorRepository extends BaseJpaRepository<Operator, Long> {


    
	@Query(
			  value = "SELECT * FROM operators u WHERE u.created_by = ?1", 
			  nativeQuery = true)
	List<Operator> findByUser(Long createdBy);
	

	

}
