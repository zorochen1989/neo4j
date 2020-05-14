package com.aky.neo4j.service.impl;

import com.aky.neo4j.model.MajorHazard;
import com.aky.neo4j.repository.MajorHazardRepository;
import com.aky.neo4j.service.MajorHazardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorHazardServiceImpl extends BaseServiceImpl<MajorHazard, Long, MajorHazardRepository> implements MajorHazardService {

    @Autowired
    private MajorHazardRepository majorHazardRepository;

    @Override
    public List<MajorHazard> findAllByChemicalsId(Long chemicalsId) {
        return majorHazardRepository.findAllByChemicalsId(chemicalsId);
    }
}
