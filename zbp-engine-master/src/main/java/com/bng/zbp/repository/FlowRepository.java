package com.bng.zbp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.bng.zbp.model.entity.Flow;
/*
  @Author Karan
 */
@Repository
public interface FlowRepository extends BaseJpaRepository<Flow, Long>{
 
	List<Flow> findAllByFlowIdOrderById(int flowId);
}
