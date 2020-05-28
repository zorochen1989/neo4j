package com.aky.neo4j.repository;

import com.aky.neo4j.model.MajorHazard;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MajorHazardRepository extends Neo4jRepository<MajorHazard, Long> {

    List<MajorHazard> findAllByChemicalsId(@Param("chemicalsId") Long chemicalsId);

    /**
     * 根据nodeId删除无用的数据（仅测试）
     *
     * @param nodeId
     */
    @Query("match(n:MajorHazard{nodeId:{nodeId}}) delete n")
    void deleteIt(@Param("nodeId") Long nodeId);

    /**
     * 根据危险源等级进行聚合
     *
     * @return 将聚合结果封装到list map中
     */
    @Query("match(m:MajorHazard) return distinct m.hazardsLevel as level,count(m) as count")
    List<Map<String, String>> groupByHazardsLevel();

    /**
     * 根据危险源投入年份进行聚合分组
     *
     * @return 将聚合结果封装到list map中
     */
    @Query("match(m:MajorHazard) return distinct SUBSTRING(m.hazardsTime,0,4) as year, count(m) as count order by year")
    List<Map<String, String>> groupByHazardsTime();
}
