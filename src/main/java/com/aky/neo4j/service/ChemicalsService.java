package com.aky.neo4j.service;

import com.aky.neo4j.model.Chemicals;
import com.aky.neo4j.model.EnterpriseInfo;
import com.aky.neo4j.repository.ChemicalsRepository;

import java.util.List;

public interface ChemicalsService extends BaseService<Chemicals, Long, ChemicalsRepository> {

    /**
     * 根据化学品的中文名称获取企业列表
     *
     * @param chName 化学品中文名称
     * @return 企业列表
     */
    List<EnterpriseInfo> listEnterpriseInfo(String chName);

    /**
     * 根据企业名称获取化学品的列表
     *
     * @param enterpriseName 企业名称
     * @return 化学品列表
     */
    List<Chemicals> listChemicals(String enterpriseName);
}
