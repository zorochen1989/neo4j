package com.aky.neo4j.repository;

import com.aky.neo4j.model.Accident;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends Neo4jRepository<Accident,Long> {

    List<Accident> findAllByChemicalsId(@Param("chemicalsId") Long chemicalsId);
}
