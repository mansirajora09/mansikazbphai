package com.bng.zbp.cache.repository;

import com.bng.zbp.cache.model.CampaignDummy;
import com.bng.zbp.model.response.CampaignResponseBO;

import java.util.Map;
/**
 * @author Mansi Rajora
 */
public interface RedisRepository {

    /**
     * Return all movies
     */
    Map<Object, Object> findAllCampaigns();

    /**
     * Add key-value pair to Redis.
     */
    void add(CampaignDummy campaign);

    /**
     * Delete a key-value pair in Redis.
     */
    void delete(String id);

    /**
     * find a movie
     */
    CampaignDummy findCampaign(String id);

    void add(CampaignResponseBO campaignResponseBOs, String key);

    CampaignResponseBO get(String key);

}
