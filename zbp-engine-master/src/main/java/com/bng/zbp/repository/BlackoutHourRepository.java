package com.bng.zbp.repository;

import com.bng.zbp.model.entity.BlackoutHours;

import org.springframework.stereotype.Repository;

/**
 * @Author Mansi Rajora
 */
@Repository
public interface BlackoutHourRepository extends BaseJpaRepository<BlackoutHours, Long> {

}
