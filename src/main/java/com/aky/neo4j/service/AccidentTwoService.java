package com.aky.neo4j.service;

import com.aky.neo4j.model.AccidentTwo;
import com.aky.neo4j.repository.AccidentTwoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccidentTwoService extends BaseService<AccidentTwo, Long, AccidentTwoRepository> {

    /**
     * 根据起始日期模糊查询事件标题
     *
     * @param startDate     开始时间
     * @param endDate       结束时间
     * @param accidentTitle 事件标题
     * @param pageable      所需要的pageable对象
     * @return 分页的详细信息
     */
    Page<AccidentTwo> findByAccidentTitle(String startDate, String endDate, String accidentTitle, Pageable pageable);

}
