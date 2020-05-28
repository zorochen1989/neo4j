package com.aky.neo4j.controller;

import com.aky.neo4j.model.AccidentTwo;
import com.aky.neo4j.model.QueryPageable;
import com.aky.neo4j.model.Result;
import com.aky.neo4j.service.AccidentTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accidentTwo")
public class AccidentTwoController {

    @Autowired
    private AccidentTwoService accidentTwoService;

    /**
     * 事故列表
     *
     * @param queryPageable 封装了请求参数
     * @return 将结果封装到Result中返回
     */
    @GetMapping
    public Result list(@RequestBody QueryPageable queryPageable) {
        Result result = null;
        try {
            Page<AccidentTwo> page = accidentTwoService.findAll(accidentTwoService.createPageable(queryPageable, new AccidentTwo()));
            result = new Result("success", "200", page, "获取信息成功");
            page = null;
        } catch (Exception e) {
            result = new Result("error", "500", "", "获取数据失败！");
        }
        return result;
    }

    /**
     * 根据事故的名称和时间进行查询
     *
     * @param queryPageable 封装的请求信息
     * @param startDate     开始时间
     * @param endDate       结束时间
     * @param title         需要查询的事故标题
     * @return 将结构封装到Result中
     */
    @GetMapping("/findByAccidentTitle")
    public Result findByAccidentTitle(@RequestBody QueryPageable queryPageable, String startDate, String endDate, String title) {
        Result result = null;
        try {
            Page<AccidentTwo> page = accidentTwoService.findByAccidentTitle(startDate, endDate, title, accidentTwoService.createPageable(queryPageable, new AccidentTwo()));
            result = new Result("success", "200", page, "获取信息成功");
            page = null;
        } catch (Exception e) {
            result = new Result("error", "500", "", "获取数据失败！");
        }
        return result;
    }
}
