package com.bng.zbp.repository;

import java.util.List;

import com.bng.zbp.model.entity.Flow;
import com.bng.zbp.model.entity.FlowMapping;

public interface FlowMappingRepository extends BaseJpaRepository<FlowMapping, Long> {

	FlowMapping findAllByFlowName(String flowName);

	List<FlowMapping> findAllByUserId(int userid);

}
