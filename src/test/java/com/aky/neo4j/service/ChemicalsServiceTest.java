package com.aky.neo4j.service;

import com.aky.neo4j.model.Accident;
import com.aky.neo4j.model.Chemicals;
import com.aky.neo4j.model.EnterpriseInfo;
import com.aky.neo4j.model.MajorHazard;
import com.aky.neo4j.repository.AccidentRepository;
import com.aky.neo4j.repository.ChemicalsRepository;
import com.aky.neo4j.repository.MajorHazardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChemicalsServiceTest {

    @Autowired
    private ChemicalsService chemicalsService;

    @Autowired
    private ChemicalsRepository chemicalsRepository;

    @Autowired
    private AccidentRepository accidentRepository;

    @Autowired
    private MajorHazardRepository majorHazardRepository;

    @Test
    public void test01() {
        Chemicals chemicals = new Chemicals("甲醇","METHANOL","67-56-1","CH4O","1230");
        chemicals.setId(0L);
        chemicalsService.save(chemicals);
    }

    @Test
    public void test02(){

        List<MajorHazard> list = majorHazardRepository.findAllByChemicalsId(40L);
        System.out.println(list.size());

    }

    @Test
    public void test03() {

        List<Accident> list = accidentRepository.findAllByChemicalsId(40L);
        System.out.println(list.size());
    }

    @Test
    public void test04() {
        List<EnterpriseInfo> list = chemicalsRepository.listEnterpriseInfo("丙烷");

        System.out.println(list);

        List<Chemicals> list1 = chemicalsRepository.listChemicals("联力环保新能源股份有限公司");
        System.out.println(list1);

    }
}
