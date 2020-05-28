package com.aky.neo4j.service.impl;

import com.aky.neo4j.model.ChemicalsTwo;
import com.aky.neo4j.repository.ChemicalsTwoRepository;
import com.aky.neo4j.service.ChemicalsTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChemicalsTwoServiceImpl extends BaseServiceImpl<ChemicalsTwo, Long, ChemicalsTwoRepository> implements ChemicalsTwoService {

    @Autowired
    private ChemicalsTwoRepository chemicalsTwoRepository;

    @Override
    public Page<ChemicalsTwo> findByChinaNameLike(String chinaName, Pageable pageable) {
        // neo4j 的占位符是使用的 *
        chinaName = "*" + chinaName + "*";
        return chemicalsTwoRepository.findByChinaNameLike(chinaName, pageable);
    }
}
