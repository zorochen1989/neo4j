package com.aky.neo4j.service.impl;

import com.aky.neo4j.model.GraphModel;
import com.aky.neo4j.model.MajorHazard;
import com.aky.neo4j.repository.MajorHazardRepository;
import com.aky.neo4j.service.MajorHazardService;
import com.aky.neo4j.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class MajorHazardServiceImpl extends BaseServiceImpl<MajorHazard, Long, MajorHazardRepository> implements MajorHazardService {

    @Autowired
    private MajorHazardRepository majorHazardRepository;

    @Override
    public List<MajorHazard> findAllByChemicalsId(Long chemicalsId) {
        return majorHazardRepository.findAllByChemicalsId(chemicalsId);
    }

    @Override
    public List<GraphModel> groupByHazardsLevel() {
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
        return list;
    }

    @Override
    public List<GraphModel> groupByHazardsTime() {
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
        return list;
    }
}
