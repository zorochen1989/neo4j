package com.aky.neo4j.repository;

import com.aky.neo4j.model.EnterpriseInfo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseInfoRepository extends Neo4jRepository<EnterpriseInfo, Long> {

}
