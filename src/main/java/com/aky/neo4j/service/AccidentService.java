package com.aky.neo4j.service;

import com.aky.neo4j.model.Accident;
import com.aky.neo4j.repository.AccidentRepository;

import java.util.List;

public interface AccidentService extends BaseService<Accident, Long, AccidentRepository> {

    List<Accident> findAllByChemicalsId(Long chemicalsId);
}
