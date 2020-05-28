package com.aky.neo4j.service;

import com.aky.neo4j.model.EnterpriseInfo;
import com.aky.neo4j.model.GraphModel;
import com.aky.neo4j.repository.EnterpriseInfoRepository;

import java.util.List;

public interface EnterpriseInfoService extends BaseService<EnterpriseInfo, Long, EnterpriseInfoRepository> {

    /**
     * 全国单位性质对比情况
     *
     * @return
     */
    List<GraphModel> summaryByProvince();

    /**
     * 全国单位性质占比情况
     *
     * @return
     */
    List<GraphModel> summaryByNatureOfUnit();

    /**
     * 企业规模占比情况
     *
     * @return
     */
    List<GraphModel> summaryByEnterpriseScale();


}
