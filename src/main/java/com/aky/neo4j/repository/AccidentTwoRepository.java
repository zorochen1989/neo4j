package com.aky.neo4j.repository;

import com.aky.neo4j.model.AccidentTwo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentTwoRepository extends Neo4jRepository<AccidentTwo, Long> {

    /**
     * 根据起始日期模糊查询事件标题
     *
     * @param startDate     开始时间
     * @param endDate       结束时间
     * @param accidentTitle 事件标题
     * @param pageable      所需要的pageable对象
     * @return 分页的详细信息
     */
    Page<AccidentTwo> findByAccidentDateBetweenAndAccidentTitleLike(String startDate, String endDate, String accidentTitle, Pageable pageable);
}
