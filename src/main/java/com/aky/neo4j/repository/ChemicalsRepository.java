package com.aky.neo4j.repository;

import com.aky.neo4j.model.Chemicals;
import com.aky.neo4j.model.EnterpriseInfo;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemicalsRepository extends Neo4jRepository<Chemicals, Long> {

    /**
     * 根据化学品的中文名称获取企业列表
     *
     * @param chName 化学品中文名称
     * @return 企业列表
     */
    @Query("match(:Chemicals{chName:{chName}})--(enterpriseInfo) return enterpriseInfo")
    List<EnterpriseInfo> listEnterpriseInfo(@Param("chName") String chName);

    /**
     * 根据企业名称获取化学品的列表
     *
     * @param enterpriseName 企业名称
     * @return 化学品列表
     */
    @Query("match(:EnterpriseInfo{enterpriseName:{enterpriseName}})--(chemicals) return chemicals")
    List<Chemicals> listChemicals(@Param("enterpriseName") String enterpriseName);
}
