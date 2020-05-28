package com.aky.neo4j.service;

import com.aky.jsoup.service.WebService;
import com.aky.neo4j.model.*;
import com.aky.neo4j.repository.*;
import com.aky.neo4j.util.ListUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChemicalsServiceTest {

    @Autowired
    private ChemicalsTwoService chemicalsTwoService;

    @Autowired
    private AccidentTwoRepository accidentTwoRepository;

    @Autowired
    private AccidentTwoService accidentTwoService;

    @Autowired
    private EnterpriseInfoService enterpriseInfoService;

    @Autowired
    private ChemicalsService chemicalsService;

    @Autowired
    private ChemicalsRepository chemicalsRepository;

    @Autowired
    private AccidentRepository accidentRepository;

    @Autowired
    private MajorHazardRepository majorHazardRepository;

    @Autowired
    private ChemicalsTwoRepository chemicalsTwoRepository;

    @Test
    public void test01() {
        Chemicals chemicals = new Chemicals("甲醇", "METHANOL", "67-56-1", "CH4O", "1230");
        chemicals.setId(0L);
        chemicalsService.save(chemicals);
    }

    @Test
    public void test02() {

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

    @Test
    public void testSaveList() throws IOException {
        List<ChemicalsTwo> list = WebService.getChemicalsTwoList();
//        chemicalsTwoRepository.saveAll(list);
        for (ChemicalsTwo chemicalsTwo : list) {
            chemicalsTwo.setId(null);
            chemicalsTwoRepository.save(chemicalsTwo);
        }

    }

    @Test
    public void test08() throws IOException {
        List<AccidentTwo> list = WebService.getAccidentTwoList();
        for (int i = 0; i < list.size(); i++) {
            AccidentTwo accidentTwo = list.get(i);
            accidentTwo.setNodeId(accidentTwo.getId());
            accidentTwo.setId(null);
            accidentTwoRepository.save(accidentTwo);

        }
    }

    @Test
    public void test06() {

        Iterable<ChemicalsTwo> all = chemicalsTwoRepository.findAll();
        List<ChemicalsTwo> list = ListUtil.toList(all.iterator());
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i));
        }
    }

    @Test
    public void test07() {
        long count = chemicalsTwoService.count();
        int pageSize = 10;
        int allPage = 0;
        QueryPageable queryPageable = new QueryPageable(1, pageSize, "", null, allPage, count);
        Pageable pageable = chemicalsTwoService.createPageable(queryPageable, new ChemicalsTwo());
        Page<ChemicalsTwo> all = chemicalsTwoService.findAll(pageable);
        System.out.println(all);
    }

    @Test
    public void test09() {
        Page<ChemicalsTwo> page = chemicalsTwoService.findByChinaNameLike("*乙醇*", chemicalsTwoService.createPageable(new QueryPageable(0, 10), new ChemicalsTwo()));
        System.out.println(page.getTotalElements());

        Page<AccidentTwo> page2 = accidentTwoService.findByAccidentTitle("2000-01-01", "2020-05-01", "*河南*", accidentTwoService.createPageable(new QueryPageable(0, 10), new AccidentTwo()));
        System.out.println(page2.getTotalElements());


    }

    @Test
    public void test10() throws IOException {

        List<EnterpriseInfo> enterpriseInfoList = WebService.getEnterpriseInfoList();
        for (EnterpriseInfo enterpriseInfo : enterpriseInfoList) {
            enterpriseInfoService.save(enterpriseInfo);
        }
    }
}
