package com.aky.neo4j.controller;

import com.aky.neo4j.model.Accident;
import com.aky.neo4j.model.Chemicals;
import com.aky.neo4j.service.AccidentService;
import com.aky.neo4j.service.ChemicalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accident")
public class AccidentController {

    @Autowired
    private AccidentService accidentService;

    @Autowired
    private ChemicalsService chemicalsService;

    /**
     * 保存事件信息
     * @param accident 事件信息
     * @return 入库后的事件信息
     */
    @PostMapping
    public Accident save(@RequestBody Accident accident) {
        return accidentService.save(accident);
    }

    /**
     * 设置事件与化学品的内向关系
     * @param accidentId 事件ID
     * @param chemicalsId 化学品ID
     */
    @GetMapping("/setRelationIn/{accidentId}/{chemicalsId}")
    public void setRelationIn(@PathVariable Long accidentId, @PathVariable Long chemicalsId) {
        Accident accident = accidentService.findById(accidentId).get();
        Chemicals chemicals = chemicalsService.findById(chemicalsId).get();

        accident.setChemicalsIn(chemicals);
        accidentService.save(accident);

    }

    /**
     * 设置事件与化学品之间的外向关系
     *
     * @param accidentId  事件ID
     * @param chemicalsId 化学品ID
     */
    @GetMapping("/setRelationOut/{accidentId}/{chemicalsId}")
    public void setRelationOut(@PathVariable Long accidentId, @PathVariable Long chemicalsId) {
        Accident accident = accidentService.findById(accidentId).get();
        Chemicals chemicals = chemicalsService.findById(chemicalsId).get();

        accident.setChemicalsOut(chemicals);
        accidentService.save(accident);
    }

    /**
     * 根据化学品ID获取事件列表
     *
     * @param chemicalsId 化学品ID
     * @return 事件列表
     */
    @GetMapping("/accidentList/{chemicalsId}")
    public List<Accident> accidentList(@PathVariable Long chemicalsId) {

        return accidentService.findAllByChemicalsId(chemicalsId);

    }


}
