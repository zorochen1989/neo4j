package com.aky.neo4j.repository;

import com.aky.jsoup.service.WebService;
import com.aky.neo4j.model.GraphModel;
import com.aky.neo4j.model.MajorHazard;
import com.aky.neo4j.util.MathUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MajorHazardRepositoryTest {

    @Autowired
    private MajorHazardRepository majorHazardRepository;

    @Test
    public void saveList() throws IOException {
        String filePath = "D:\\chl\\work\\major\\majorHNaO.txt";
        List<MajorHazard> majorHazardList = WebService.getMajorHazardList(filePath);
        majorHazardRepository.saveAll(majorHazardList);


    }

    @Test
    public void delByNodeId() {
//        majorHazardRepository.deleteIt(11312L);
    }

    @Test
    public void groupByHazardsLevel() {

        List<GraphModel> list = new LinkedList<>();
        List<Map<String, String>> maps = majorHazardRepository.groupByHazardsLevel();
        long allCount = majorHazardRepository.count();
        for (int i = 0; i < maps.size(); i++) {
            GraphModel graphModel = new GraphModel();
            Map<String, String> map = maps.get(i);
            if (map.get("level") != null) {
                graphModel.setKey("等级" + map.get("level") + ":");
            } else {
                graphModel.setKey("未知:");
            }
            Long num = Long.parseLong(map.get("count"));
            graphModel.setData(num + "(" + MathUtil.percent(num, allCount) + ")");
            list.add(graphModel);
        }

        String s = Arrays.toString(list.toArray());
        System.out.println(s);

    }

    @Test
    public void groupByHazardsTime() {
        List<GraphModel> list = new LinkedList<>();
        List<Map<String, String>> maps = majorHazardRepository.groupByHazardsTime();
        for (int i = 0; i < maps.size(); i++) {
            Map<String, String> map = maps.get(i);
            GraphModel graphModel = new GraphModel();
            if (map.get("year") != null) {
                graphModel.setKey(map.get("year"));
            } else {
                graphModel.setKey("未知");
            }
            graphModel.setData(map.get("count"));
            list.add(graphModel);
        }

        String s = Arrays.toString(list.toArray());
        System.out.println(s);
    }
}
