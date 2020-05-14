package com.aky.neo4j.repository;

import com.aky.neo4j.model.MajorHazard;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorHazardRepository extends Neo4jRepository<MajorHazard,Long> {

    List<MajorHazard> findAllByChemicalsId(@Param("chemicalsId") Long chemicalsId);
}
