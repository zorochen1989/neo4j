package com.aky.neo4j.service.impl;

import com.aky.neo4j.model.Accident;
import com.aky.neo4j.repository.AccidentRepository;
import com.aky.neo4j.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentServiceImpl extends BaseServiceImpl<Accident, Long, AccidentRepository> implements AccidentService {

    @Autowired
    private AccidentRepository accidentRepository;

    @Override
    public List<Accident> findAllByChemicalsId(Long chemicalsId) {
        return accidentRepository.findAllByChemicalsId(chemicalsId);
    }
}
