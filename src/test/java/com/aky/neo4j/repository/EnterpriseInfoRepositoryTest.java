package com.aky.neo4j.repository;

import com.aky.neo4j.model.GraphModel;
import com.aky.neo4j.util.MathUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EnterpriseInfoRepositoryTest {

    @Autowired
    private EnterpriseInfoRepository enterpriseInfoRepository;

    @Test
    public void groupByEnterpriseScale() {
        List<GraphModel> list = new LinkedList<>();
        List<Map<String, String>> maps = enterpriseInfoRepository.groupByEnterpriseScale();
        for (int i = 0; i < maps.size(); i++) {
            System.out.println(i + ":" + maps.get(i));
            GraphModel graphModel = new GraphModel();
            graphModel.setKey(maps.get(i).get("e.enterpriseScale"));
            graphModel.setData(maps.get(i).get("count(e)"));
            list.add(graphModel);
        }

        String s = Arrays.toString(list.toArray());
        System.out.println(s);
    }

    @Test
    public void natureOfUnitNum() {
        long all = enterpriseInfoRepository.count();
        Long countSheng = enterpriseInfoRepository.natureOfUnitNum("生产企业");
        Long countMaoyi = enterpriseInfoRepository.natureOfUnitNum("贸易型进口企业");
        Long countShiyong = enterpriseInfoRepository.natureOfUnitNum("使用型进口企业");
        Long countOther = enterpriseInfoRepository.natureOfUnitNum("");
        System.out.println("countSheng:" + MathUtil.percent(countSheng, all));
        System.out.println("countMaoyi:" + MathUtil.percent(countMaoyi, all));
        System.out.println("countShiyong:" + MathUtil.percent(countShiyong, all));
        System.out.println("countOther:" + MathUtil.percent(countOther, all));


    }


    @Test
    public void groupByProvince() {

        // 初始化返回的实例数据
        List<GraphModel> list = new LinkedList<>();
        // 省列表
        List<String> provinces = enterpriseInfoRepository.groupByProvince();

        // 遍历省列表
        for (int i = 0; i < provinces.size(); i++) {
            // 根据省名称对企业类型情况进行分组聚合查询
            List<Map<String, String>> stringStringMap = enterpriseInfoRepository.groupByProvinceNatureOfUnit(provinces.get(i));

            GraphModel graphModel = new GraphModel();
            graphModel.setKey(provinces.get(i));

            List<Map<String, String>> data = new LinkedList<>();

            for (int j = 0; j < stringStringMap.size(); j++) {
                Map<String, String> map = new LinkedHashMap<>();
                Map<String, String> stringStringMap1 = stringStringMap.get(j);
                map.put(stringStringMap1.get("e.natureOfUnit"), stringStringMap1.get("count(e)"));
                data.add(map);
            }

            graphModel.setData(data);
            list.add(graphModel);
        }

        String s = Arrays.toString(list.toArray());
        System.out.println(s);
    }

    @Test
    public void groupByNatureOfUnit() {
        List<Map<String, String>> maps = enterpriseInfoRepository.groupByNatureOfUnit();
        for (int i = 0; i < maps.size(); i++) {
//            System.out.println(maps.get(i));
            System.out.println(i + ":" + maps.get(i).get("e.natureOfUnit") + "||" + maps.get(i).get("count(e)"));
        }
    }
}
