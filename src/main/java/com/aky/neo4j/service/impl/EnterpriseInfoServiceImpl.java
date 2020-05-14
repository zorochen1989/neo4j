package com.aky.neo4j.service.impl;

import com.aky.neo4j.model.EnterpriseInfo;
import com.aky.neo4j.repository.EnterpriseInfoRepository;
import com.aky.neo4j.service.EnterpriseInfoService;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseInfoServiceImpl extends BaseServiceImpl<EnterpriseInfo,Long, EnterpriseInfoRepository> implements EnterpriseInfoService {
}
