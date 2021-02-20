package com.bng.zbp.repository;

import com.bng.zbp.model.entity.Campaign;
import com.bng.zbp.model.entity.Operator;
import com.bng.zbp.model.response.CampaignResponseBO;
import org.springframework.stereotype.Repository;

/**
 * @Author Mansi Rajora
 */
@Repository
public interface CampaignRepository extends BaseJpaRepository<Campaign, Long> {
    Campaign findByName(String name);

}
