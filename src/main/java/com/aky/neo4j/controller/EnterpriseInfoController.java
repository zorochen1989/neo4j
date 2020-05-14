package com.aky.neo4j.controller;

import com.aky.neo4j.model.Chemicals;
import com.aky.neo4j.model.EnterpriseInfo;
import com.aky.neo4j.service.ChemicalsService;
import com.aky.neo4j.service.EnterpriseInfoService;
import com.aky.neo4j.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseInfoController {

    @Autowired
    private EnterpriseInfoService enterpriseInfoService;

    @Autowired
    private ChemicalsService chemicalsService;

    /**
     * 添加企业
     *
     * @param enterpriseInfo
     * @return 企业详情信息
     */
    @PostMapping
    public EnterpriseInfo saveEnterprise(@RequestBody EnterpriseInfo enterpriseInfo) {
        return enterpriseInfoService.save(enterpriseInfo);
    }

    /**
     * 更新企业信息
     *
     * @param enterpriseInfo
     * @return
     */
    @PutMapping
    public EnterpriseInfo update(@RequestBody EnterpriseInfo enterpriseInfo) {
        return enterpriseInfoService.save(enterpriseInfo);
    }

    /**
     * 设置企业与化学品的内向关系
     *
     * @param enterpriseId 企业ID
     * @param chemicalsIds 化学品ID
     */
    @GetMapping("/setRelationshipIn/{enterpriseId}")
    public void setRelationshipIn(@PathVariable Long enterpriseId, @RequestBody Map<String, List<Long>> chemicalsIds) {
        EnterpriseInfo enterpriseInfo = enterpriseInfoService.findById(enterpriseId).get();
        Iterator<Chemicals> iterator = chemicalsService.findAllById(chemicalsIds.get("chemicalsIds")).iterator();
        List<Chemicals> list = ListUtil.toList(iterator);

        enterpriseInfo.setInChemicals(list);
        enterpriseInfoService.save(enterpriseInfo);

        iterator = null;
        list = null;
    }

    /**
     * 设置企业与化学品的外向关系
     *
     * @param enterpriseId 企业ID
     * @param chemicalsIds 化学品ID
     */
    @GetMapping("/setRelationshipOut/{enterpriseId}")
    public void setRelationshipOut(@PathVariable Long enterpriseId, @RequestBody Map<String, List<Long>> chemicalsIds) {
        EnterpriseInfo enterpriseInfo = enterpriseInfoService.findById(enterpriseId).get();
        Iterator<Chemicals> iterator = chemicalsService.findAllById(chemicalsIds.get("chemicalsIds")).iterator();
        List<Chemicals> list = ListUtil.toList(iterator);

        enterpriseInfo.setOutChemicals(list);
        enterpriseInfoService.save(enterpriseInfo);

        iterator = null;
        list = null;

    }

    /**
     * 根据企业ID查询与企业相关的化学品
     *
     * @param enterpriseId 企业ID
     * @return 使用map封装取到的数据 "in"  "out"  为键
     */
    @GetMapping("/listChemicals/{enterpriseId}")
    public Map<String, List<Chemicals>> listChemicals(@PathVariable Long enterpriseId) {
        Map<String, List<Chemicals>> map = new HashMap<>();
        EnterpriseInfo enterpriseInfo = enterpriseInfoService.findById(enterpriseId).get();

        map.put("in", enterpriseInfo.getInChemicals());
        map.put("out", enterpriseInfo.getOutChemicals());
        return map;
    }


}
