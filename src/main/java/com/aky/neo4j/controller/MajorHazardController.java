package com.aky.neo4j.controller;

import com.aky.neo4j.model.Chemicals;
import com.aky.neo4j.model.GraphModel;
import com.aky.neo4j.model.MajorHazard;
import com.aky.neo4j.model.Result;
import com.aky.neo4j.service.ChemicalsService;
import com.aky.neo4j.service.MajorHazardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/majorHazard")
public class MajorHazardController {

    @Autowired
    private MajorHazardService majorHazardService;

    @Autowired
    private ChemicalsService chemicalsService;

    /**
     * 保存重大危险源
     *
     * @param majorHazard 危险源信息
     * @return 将入库成功后的信息返回
     */
    @PostMapping
    public MajorHazard save(@RequestBody MajorHazard majorHazard) {

        return majorHazardService.save(majorHazard);

    }

    /**
     * 更新重大危险源
     *
     * @param majorHazard 重大危险源信息
     * @return 入库后的危险源信息
     */
    @PutMapping
    public MajorHazard update(@RequestBody MajorHazard majorHazard) {
        return majorHazardService.save(majorHazard);
    }

    /**
     * 设置重大危险源与化学品之间的关系
     *
     * @param majorHazardId 危险源ID
     * @param chemicalsId   化学品ID
     */
    @GetMapping("/setRelationshipOut/{majorHazardId}/{chemicalsId}")
    public void setRelationshipOut(@PathVariable Long majorHazardId, @PathVariable Long chemicalsId) {
        MajorHazard majorHazard = majorHazardService.findById(majorHazardId).get();
        Chemicals chemicals = chemicalsService.findById(chemicalsId).get();

        majorHazard.setChemicals(chemicals);

        majorHazardService.save(majorHazard);
    }

    /**
     * 根据化学品ID获取重大危险源列表
     *
     * @param chemicalsId 化学品ID
     * @return 重大危险源列表
     */
    @GetMapping("/hazardList/{chemicalsId}")
    public List<MajorHazard> hazardList(@PathVariable Long chemicalsId) {
        return majorHazardService.findAllByChemicalsId(chemicalsId);
    }

    /**
     * 重大危险源等级分布图形展示
     *
     * @return 将结构信息封装到Result中
     */
    @GetMapping("/groupByHazardsLevel")
    public Result groupByHazardsLevel() {
        Result result = null;
        try {
            List<GraphModel> list = majorHazardService.groupByHazardsLevel();
            result = new Result("success", "200", list, "获取信息成功");
            list = null;
        } catch (Exception e) {
            result = new Result("error", "500", "暂无数据", "获取数据失败！");
        }
        return result;
    }

    /**
     * 重大危险源投用时间趋势图形展示
     *
     * @return 将结构信息封装到Result中
     */
    @GetMapping("/groupByHazardsTime")
    public Result groupByHazardsTime() {
        Result result = null;
        try {
            List<GraphModel> list = majorHazardService.groupByHazardsTime();
            result = new Result("success", "200", list, "获取信息成功");
            list = null;
        } catch (Exception e) {
            result = new Result("error", "500", "暂无数据", "获取数据失败！");
        }
        return result;
    }


}
