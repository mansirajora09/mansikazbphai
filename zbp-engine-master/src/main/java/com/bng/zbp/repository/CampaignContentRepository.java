package com.bng.zbp.repository;

import com.bng.zbp.model.entity.CampaignContent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Mansi Rajora
 */
@Repository
public interface CampaignContentRepository extends BaseJpaRepository<CampaignContent, Long> {
    @Query(value = "select * from campaign_content where campaign_id = ?1", nativeQuery = true)
    List<CampaignContent> findByCampaignId(Long id);
}
