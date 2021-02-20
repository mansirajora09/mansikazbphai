package com.bng.zbp.cache.repository;

import com.bng.zbp.cache.model.CampaignDummy;
import com.bng.zbp.model.response.CampaignResponseBO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author Mansi Rajora
 */
@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "Campaign";

    private static ObjectMapper mapper = new ObjectMapper();
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public Map<Object, Object> findAllCampaigns() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void add(CampaignDummy campaign) {
        hashOperations.put(KEY, campaign.getId(), campaign.getName());
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }

    @Override
    public CampaignDummy findCampaign(String id) {
        return (CampaignDummy) hashOperations.get(KEY, id);
    }

    @Override
    public void add(CampaignResponseBO campaignResponseBO, String key) {
        redisTemplate.opsForValue().set(key, campaignResponseBO);
    }



    @Override
    public CampaignResponseBO get(String key) {
        Object fromRedis = redisTemplate.opsForValue().get(key);
        CampaignResponseBO campaignResponseBO = mapper.convertValue(fromRedis, CampaignResponseBO.class);
        return campaignResponseBO;
    }


}
