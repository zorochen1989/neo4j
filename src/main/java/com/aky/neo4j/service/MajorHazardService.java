package com.aky.neo4j.service;

import com.aky.neo4j.model.GraphModel;
import com.aky.neo4j.model.MajorHazard;
import com.aky.neo4j.repository.MajorHazardRepository;

import java.util.List;

public interface MajorHazardService extends BaseService<MajorHazard, Long, MajorHazardRepository> {

    List<MajorHazard> findAllByChemicalsId(Long chemicalsId);

    /**
     * 根据危险源等级进行聚合
     *
     * @return 将聚合结果封装到GraphModel列表中
     */
    List<GraphModel> groupByHazardsLevel();

    /**
     * 根据危险源投入年份进行聚合
     *
     * @return 将聚合结果封装到GraphModel列表中
     */
    List<GraphModel> groupByHazardsTime();

}
