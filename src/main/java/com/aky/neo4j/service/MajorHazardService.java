package com.aky.neo4j.service;

import com.aky.neo4j.model.MajorHazard;
import com.aky.neo4j.repository.MajorHazardRepository;

import java.util.List;

public interface MajorHazardService extends BaseService<MajorHazard, Long, MajorHazardRepository> {

    List<MajorHazard> findAllByChemicalsId(Long chemicalsId);
}
