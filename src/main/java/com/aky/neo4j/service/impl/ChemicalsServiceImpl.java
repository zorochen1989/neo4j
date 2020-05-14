package com.aky.neo4j.service.impl;

import com.aky.neo4j.model.Chemicals;
import com.aky.neo4j.model.EnterpriseInfo;
import com.aky.neo4j.repository.ChemicalsRepository;
import com.aky.neo4j.service.ChemicalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChemicalsServiceImpl extends BaseServiceImpl<Chemicals, Long, ChemicalsRepository> implements ChemicalsService {

    @Autowired
    private ChemicalsRepository chemicalsRepository;

    @Override
    public List<EnterpriseInfo> listEnterpriseInfo(String chName) {
        return chemicalsRepository.listEnterpriseInfo(chName);
    }

    @Override
    public List<Chemicals> listChemicals(String enterpriseName) {
        return chemicalsRepository.listChemicals(enterpriseName);
    }
}
