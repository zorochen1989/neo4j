package com.aky.neo4j.service;

import com.aky.neo4j.model.ChemicalsTwo;
import com.aky.neo4j.repository.ChemicalsTwoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChemicalsTwoService extends BaseService<ChemicalsTwo,Long, ChemicalsTwoRepository>{

    Page<ChemicalsTwo> findByChinaNameLike(String chinaName, Pageable pageable);
}
