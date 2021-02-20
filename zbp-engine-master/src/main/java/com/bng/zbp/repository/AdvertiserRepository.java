package com.bng.zbp.repository;

import com.bng.zbp.model.entity.Advertiser;
import com.bng.zbp.model.entity.Operator;
import org.springframework.stereotype.Repository;

/**
 * @Author Mansi Rajora
 */
@Repository
public interface AdvertiserRepository extends BaseJpaRepository<Advertiser, Long> {

}
