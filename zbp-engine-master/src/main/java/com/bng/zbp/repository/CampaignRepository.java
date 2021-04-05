package com.bng.zbp.repository;

import com.bng.zbp.model.entity.Campaign;
import com.bng.zbp.model.entity.Operator;
import com.bng.zbp.model.response.CampaignResponseBO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author Mansi Rajora
 */
@Repository
public interface CampaignRepository extends BaseJpaRepository<Campaign, Long> {
    Campaign findByName(String name);
	
    @Query(
			  value = "SELECT * FROM campaign u WHERE u.type = ?1", 
			  nativeQuery = true)
	List<Campaign> findByType(String type);

}
