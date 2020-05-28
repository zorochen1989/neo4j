package com.aky.neo4j.controller;

import com.aky.neo4j.model.ChemicalsTwo;
import com.aky.neo4j.model.QueryPageable;
import com.aky.neo4j.model.Result;
import com.aky.neo4j.service.ChemicalsTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chemicalsTwo")
public class ChemicalsTwoController {

    @Autowired
    private ChemicalsTwoService chemicalsTwoService;

    @GetMapping
    public Result findAll(@RequestBody QueryPageable queryPageable) {
        Result result = null;
        try {
            Page<ChemicalsTwo> page = chemicalsTwoService.findAll(chemicalsTwoService.createPageable(queryPageable, new ChemicalsTwo()));
            result = new Result("success", "200", page, "获取信息成功");
            page = null;
        } catch (Exception e) {
            result = new Result("error", "500", "", "获取数据失败！");
        }
        return result;
    }

    @GetMapping("/findByChinaName")
    public Result findByChinaName(@RequestBody QueryPageable queryPageable, String chinaName) {
        Result result = null;
        try {
            Page<ChemicalsTwo> page = chemicalsTwoService.findByChinaNameLike(chinaName, chemicalsTwoService.createPageable(queryPageable, new ChemicalsTwo()));
            result = new Result("success", "200", page, "获取信息成功");
            page = null;
        } catch (Exception e) {
            result = new Result("error", "500", "", "获取数据失败！");
        }
        return result;
    }

}
