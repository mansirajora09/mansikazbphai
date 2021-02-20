package com.bng.zbp.repository;

import org.springframework.stereotype.Repository;

import com.bng.zbp.model.entity.LogData;

/**
 * @Author Mansi Rajora
 */
@Repository
public interface LogsRepository extends BaseJpaRepository<LogData, Long> {

}
