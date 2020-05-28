package com.aky.neo4j.service.impl;

import com.aky.neo4j.model.EnterpriseInfo;
import com.aky.neo4j.model.GraphModel;
import com.aky.neo4j.repository.EnterpriseInfoRepository;
import com.aky.neo4j.service.EnterpriseInfoService;
import com.aky.neo4j.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class EnterpriseInfoServiceImpl extends BaseServiceImpl<EnterpriseInfo, Long, EnterpriseInfoRepository> implements EnterpriseInfoService {

    @Autowired
    private EnterpriseInfoRepository enterpriseInfoRepository;

    @Override
    public List<GraphModel> summaryByProvince() {
        // 初始化返回的实例数据
        List<GraphModel> list = new LinkedList<>();
        // 省列表
        List<String> provinces = enterpriseInfoRepository.groupByProvince();

        // 遍历省列表
        for (int i = 0; i < provinces.size(); i++) {
            // 根据省名称对企业类型情况进行分组聚合查询
            List<Map<String, String>> stringStringMap = enterpriseInfoRepository.groupByProvinceNatureOfUnit(provinces.get(i));

            // 初始化图形属性实例
            GraphModel graphModel = new GraphModel();
            // 为图形的键设值
            graphModel.setKey(provinces.get(i));
            // 初始化存储图形数据的实例  eg. key:山东省  data：{生产企业：4386，经营带存储企业：0，使用构成重大危险源企业：0 }
            List<Map<String, String>> data = new LinkedList<>();

            // 解析查询到的数据
            for (int j = 0; j < stringStringMap.size(); j++) {
                Map<String, String> map = new LinkedHashMap<>();
                Map<String, String> stringStringMap1 = stringStringMap.get(j);
                map.put(stringStringMap1.get("e.natureOfUnit"), stringStringMap1.get("count(e)"));
                data.add(map);
            }

            graphModel.setData(data);
            list.add(graphModel);
        }
        provinces = null;
        return list;
    }

    @Override
    public List<GraphModel> summaryByNatureOfUnit() {
        // 初始化返回的实例数据
        List<GraphModel> list = new LinkedList<>();

        String key1 = "生产企业";
        String key2 = "贸易型进口企业";
        String key3 = "使用型进口企业";

        long all = enterpriseInfoRepository.count();
        Long countSheng = enterpriseInfoRepository.natureOfUnitNum(key1);
        Long countMaoyi = enterpriseInfoRepository.natureOfUnitNum(key2);
        Long countShiyong = enterpriseInfoRepository.natureOfUnitNum(key3);

        GraphModel graphModel1 = new GraphModel(key1, countSheng + "(" + MathUtil.percent(countSheng, all) + ")");
        GraphModel graphModel2 = new GraphModel(key2, countSheng + "(" + MathUtil.percent(countMaoyi, all) + ")");
        GraphModel graphModel3 = new GraphModel(key3, countSheng + "(" + MathUtil.percent(countShiyong, all) + ")");

        list.add(graphModel1);
        list.add(graphModel2);
        list.add(graphModel3);
        return list;
    }

    @Override
    public List<GraphModel> summaryByEnterpriseScale() {
        List<GraphModel> list = new LinkedList<>();
        List<Map<String, String>> maps = enterpriseInfoRepository.groupByEnterpriseScale();
        for (int i = 0; i < maps.size(); i++) {
            GraphModel graphModel = new GraphModel();
            graphModel.setKey(maps.get(i).get("e.enterpriseScale"));
            graphModel.setData(maps.get(i).get("count(e)"));
            list.add(graphModel);
        }
        maps = null;
        return list;
    }
}
