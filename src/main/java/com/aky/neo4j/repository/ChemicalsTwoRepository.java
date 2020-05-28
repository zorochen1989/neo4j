package com.aky.neo4j.repository;

import com.aky.neo4j.model.ChemicalsTwo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemicalsTwoRepository extends Neo4jRepository<ChemicalsTwo, Long> {

    /**
     * 根据中文名称模糊查询
     *
     * @param chinaName 中文名称恒
     * @param pageable  所需的pageable对象
     * @return 分页详细信息
     */
    Page<ChemicalsTwo> findByChinaNameLike(String chinaName, Pageable pageable);


}
