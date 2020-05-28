package com.aky.neo4j.service.impl;

import com.aky.neo4j.model.AccidentTwo;
import com.aky.neo4j.repository.AccidentTwoRepository;
import com.aky.neo4j.service.AccidentTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccidentTwoServiceImpl extends BaseServiceImpl<AccidentTwo, Long, AccidentTwoRepository> implements AccidentTwoService {

    @Autowired
    private AccidentTwoRepository accidentTwoRepository;

    @Override
    public Page<AccidentTwo> findByAccidentTitle(String startDate, String endDate, String accidentTitle, Pageable pageable) {
        accidentTitle = "*" + accidentTitle + "*";
        return accidentTwoRepository.findByAccidentDateBetweenAndAccidentTitleLike(startDate, endDate, accidentTitle, pageable);
    }
}
