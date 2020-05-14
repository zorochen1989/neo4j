package com.aky.neo4j.controller;

import com.aky.neo4j.model.Chemicals;
import com.aky.neo4j.model.EnterpriseInfo;
import com.aky.neo4j.model.MajorHazard;
import com.aky.neo4j.service.ChemicalsService;
import com.aky.neo4j.service.EnterpriseInfoService;
import com.aky.neo4j.service.MajorHazardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chemicals")
public class ChemicalsController {

    @Autowired
    private ChemicalsService chemicalsService;

    @Autowired
    private MajorHazardService majorHazardService;

    @Autowired
    private EnterpriseInfoService enterpriseInfoService;

    /**
     * 新增化学品
     *
     * @param chemicals 化学品信息
     * @return 入库成功后的化学品
     */
    @PostMapping
    public Chemicals saveChemicals(@RequestBody Chemicals chemicals) {
        return chemicalsService.save(chemicals);
    }

    /**
     * 更新化学品
     *
     * @param chemicals 化学品信息
     * @return 入库成功后的化学品
     */
    @PutMapping
    public Chemicals updateChemicals(@RequestBody Chemicals chemicals) {
        return chemicalsService.save(chemicals);
    }

    /**
     * 根据化学品ID获取与化学品相关的企业信息
     *
     * @param chemicalsId 化学品ID
     * @return 企业列表
     */
    @GetMapping("/listEnterpriseInfo/{chemicalsId}")
    public List<EnterpriseInfo> listEnterpriseInfo(@PathVariable Long chemicalsId) {

        Chemicals chemicals = chemicalsService.findById(chemicalsId).get();

        return chemicalsService.listEnterpriseInfo(chemicals.getChName());
    }

    /**
     * 根据企业ID获取跟企业相关的化学品信息
     *
     * @param enterpriseId 企业ID
     * @return 化学品列表
     */
    @GetMapping("/listChemicals/{enterpriseId}")
    public List<Chemicals> listChemicals(@PathVariable Long enterpriseId) {
        EnterpriseInfo enterpriseInfo = enterpriseInfoService.findById(enterpriseId).get();
        return chemicalsService.listChemicals(enterpriseInfo.getEnterpriseName());
    }

    /**
     * 列出与化学品相关的重大危险源
     *
     * @param chemicalsId 化学品ID
     * @return 重大危险源的列表信息
     */
    @GetMapping("/majorHazardList/{chemicalsId}")
    public List<MajorHazard> majorHazardList(@PathVariable Long chemicalsId) {

        return majorHazardService.findAllByChemicalsId(chemicalsId);
    }


}
