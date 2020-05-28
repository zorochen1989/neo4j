package com.aky.neo4j.repository;

import com.aky.neo4j.model.EnterpriseInfo;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EnterpriseInfoRepository extends Neo4jRepository<EnterpriseInfo, Long> {

    /**
     * 根据单位性质的值计算数量
     *
     * @param natureOfUnit 单位性质
     * @return 数量值
     */
    @Query("match(n:EnterpriseInfo{natureOfUnit:{natureOfUnit}}) return count(n)")
    Long natureOfUnitNum(@Param("natureOfUnit") String natureOfUnit);

    /**
     * 根据nodeId删除相关单位
     *
     * @param nodeId
     */
    @Query("match(n:EnterpriseInfo{nodeId:{nodeId}}) delete n")
    void deleteIt(@Param("nodeId") Long nodeId);

    /**
     * 根据单位性质进行分组聚合
     *
     * @return 将结构封装到List Map中
     */
    @Query("match(e:EnterpriseInfo) return distinct e.natureOfUnit, count(e)")
    List<Map<String, String>> groupByNatureOfUnit();

    /**
     * 根据单位所在省份对单位性质进行分组聚合
     *
     * @return 将结构封装到List Map 中
     */
    @Query("match(e:EnterpriseInfo{province:{province}}) return distinct e.natureOfUnit, count(e)")
    List<Map<String, String>> groupByProvinceNatureOfUnit(@Param("province") String province);

    /**
     * 获取省份列表
     *
     * @return
     */
    @Query("match(e:EnterpriseInfo) return distinct e.province ")
    List<String> groupByProvince();

    /**
     * 根据企业规模进行聚合分组
     * @return
     */
    @Query("match(e:EnterpriseInfo) return distinct e.enterpriseScale, count(e)")
    List<Map<String,String>> groupByEnterpriseScale();

}
