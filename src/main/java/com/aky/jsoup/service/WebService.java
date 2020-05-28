package com.aky.jsoup.service;

import com.aky.neo4j.model.AccidentTwo;
import com.aky.neo4j.model.ChemicalsTwo;
import com.aky.neo4j.model.EnterpriseInfo;
import com.aky.neo4j.model.MajorHazard;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * 爬虫测试1
 */
public class WebService {

    /**
     * 将文件中的化学品信息转换成List
     *
     * @return 封装好的数据
     * @throws IOException
     */
    public static List<ChemicalsTwo> getChemicalsTwoList() throws IOException {
        String jsonFilePath = "D:\\chl\\work\\chemicalData.txt";
        File file = new File(jsonFilePath);
        String input = FileUtils.readFileToString(file, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(input);
        JSONArray data = (JSONArray) jsonObject.get("data");
        List<ChemicalsTwo> list = data.toJavaList(ChemicalsTwo.class);
        return list;
    }

    /**
     * 获取事件列表
     *
     * @return 封装好的事件数据
     * @throws IOException
     */
    public static List<AccidentTwo> getAccidentTwoList() throws IOException {
        String jsonFilePath = "D:\\chl\\work\\accidentData.txt";
        File file = new File(jsonFilePath);
        String input = FileUtils.readFileToString(file, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(input);
        JSONObject obj = (JSONObject) jsonObject.get("data");
        JSONArray data = (JSONArray) obj.get("list");
        List<AccidentTwo> list = data.toJavaList(AccidentTwo.class);
        return list;
    }

    /**
     * 获取危险源列表
     *
     * @return 封装好的危险源数据
     */
    public static List<MajorHazard> getMajorHazardList(String filePath) throws IOException {
        List<MajorHazard> list = new LinkedList<>();
        File file = new File(filePath);
        String input = FileUtils.readFileToString(file);
        //JSONArray  {result:[{data:[{graph:{nodes:[]}}]}]}
        JSONObject jsonObject = JSONObject.parseObject(input);
        // 第一层的results
        JSONArray array = jsonObject.getJSONArray("results");
        if (array.size() > 0) {
            // 第二层的data
            JSONObject object = (JSONObject) array.get(0);
            JSONArray data = object.getJSONArray("data");
            for (int i = 0; i < data.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) data.get(i);
                // 第三层的graph
                JSONObject jsonObject2 = (JSONObject) jsonObject1.get("graph");

                //第四层的nodes
                JSONArray nodes = jsonObject2.getJSONArray("nodes");

                // 最后一层所需要的
                JSONObject object1 = (JSONObject) nodes.get(0);

                MajorHazard majorHazard = new MajorHazard();
                majorHazard.setNodeId(object1.getLong("id"));
                // 危险源属性信息
                JSONObject properties = object1.getJSONObject("properties");
                majorHazard.setSafeDistance(properties.getString("安全距离"));
                majorHazard.setHazardsTime(properties.getString("危险源投用时间"));
                majorHazard.setSafetyAccidentsWithin3Years(properties.getString("3年内安全事故情况"));
                majorHazard.setHazardsLevel(properties.getString("重大危险源危险级别"));
                majorHazard.setSource(properties.getString("来源"));
                majorHazard.setIsInChemicalIndustrialPark(properties.getString("是否位于化工工业园区"));
                majorHazard.setPeopleNumWithin500Meters(properties.getString("500米内人数估算"));
                majorHazard.setIndustrialParkName(properties.getString("工业园区名称"));
                majorHazard.setHazardsAddress(properties.getString("危险源所在详细地址"));
                majorHazard.setHazardScale(properties.getString("危险源生成规模"));
                majorHazard.setHazardsRNum(properties.getString("危险源R值"));
                majorHazard.setHazardsName(properties.getString("危险源名称"));
                majorHazard.setIdNum(properties.getLong("ID"));
                majorHazard.setImportTime(properties.getString("importTime"));
                majorHazard.setFileID(properties.getLong("fileID"));

                list.add(majorHazard);

            }

        }
        return list;
    }

    /**
     * 获取企业信息列表
     *
     * @return 封装好的企业信息数据
     * @throws IOException
     */
    public static List<EnterpriseInfo> getEnterpriseInfoList() throws IOException {
        List<EnterpriseInfo> list = new LinkedList<>();
        String jsonFilePath = "D:\\chl\\work\\company\\companyHNaO.txt";
        File file = new File(jsonFilePath);
        String input = FileUtils.readFileToString(file);
        //JSONArray  {result:[{data:[{graph:{nodes:[]}}]}]}
        JSONObject jsonObject = JSONObject.parseObject(input);
        // 第一层的results
        JSONArray array = jsonObject.getJSONArray("results");
        if (array.size() > 0) {
            // 第二层的data
            JSONObject object = (JSONObject) array.get(0);
            JSONArray data = object.getJSONArray("data");
            for (int i = 0; i < data.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) data.get(i);
                // 第三层的graph
                JSONObject jsonObject2 = (JSONObject) jsonObject1.get("graph");

                //第四层的nodes
                JSONArray nodes = jsonObject2.getJSONArray("nodes");

                // 最后一层所需要的
                JSONObject object1 = (JSONObject) nodes.get(1);

                EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
                enterpriseInfo.setNodeId(object1.getLong("id"));
                // 企业属性信息
                JSONObject properties = object1.getJSONObject("properties");

                enterpriseInfo.setProvince(properties.getString("省"));
                enterpriseInfo.setCity(properties.getString("市"));
                enterpriseInfo.setUnitCode(properties.getString("单位代码"));
                enterpriseInfo.setProductionScope(properties.getString("工商营业执照生产范围"));
                enterpriseInfo.setEnterpriseName(properties.getString("企业名称"));
                enterpriseInfo.setSource(properties.getString("来源"));
                enterpriseInfo.setRegisteredCapital(properties.getDouble("注册资本"));
                enterpriseInfo.setLicenseNum(properties.getString("工商营业执照编号"));
                enterpriseInfo.setRegisteredAddress(properties.getString("工商注册地址"));
                enterpriseInfo.setPostalCode(properties.getString("邮政编码"));
                enterpriseInfo.setEmployeesNumber(properties.getString("从业人员人数"));
                enterpriseInfo.setNatureOfUnit(properties.getString("单位性质"));
                enterpriseInfo.setEnterprisePrincipal(properties.getString("企业负责人"));
                enterpriseInfo.setLegalRepresentative(properties.getString("法定代表人"));
                enterpriseInfo.setEnterprisePrincipalPhone(properties.getString("企业负责人联系电话"));
                enterpriseInfo.setWorkerNumber(properties.getString("职工人数"));
                enterpriseInfo.setSetupTime(properties.getString("成立时间"));
                enterpriseInfo.setFax(properties.getString("传真"));
                enterpriseInfo.setEnterpriseScale(properties.getString("企业规模"));
                enterpriseInfo.setWebSite(properties.getString("企业网址"));
                enterpriseInfo.setImportTime(properties.getString("importTime"));
                enterpriseInfo.setProductAndScale(properties.getString("主要产品及生产规模"));
                enterpriseInfo.setFileID(properties.getLong("fileID"));

                list.add(enterpriseInfo);

            }

        }
        return list;
    }


    /**
     * http协议取数据
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String getResult(String url) throws IOException {
        java.net.URL restURL = null;
        HttpURLConnection conn = null;
        try {
            restURL = new URL(url);
        } catch (MalformedURLException var12) {
        }
        try {
            conn = (HttpURLConnection) restURL.openConnection();
            String str = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3303.99 Safari/537.36";
            String str1 = "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)";
            conn.setRequestProperty("User-Agent", str);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);

        } catch (Exception var11) {
            var11.printStackTrace();
        }
        conn.setConnectTimeout(10000);
        conn.setDoOutput(true);

        PrintWriter out = new PrintWriter(conn.getOutputStream());
        out.print("{\"page\":1,\n" +
                "\t\"pageSize\":38150,\n" +
                "\t\"keyword\":\"\"}");

//        conn.setAllowUserInteraction(true);
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        } catch (IOException var9) {
        }
        String resultStr = "";
        String line;
        try {
            while (null != (line = bReader.readLine())) {
                resultStr = resultStr + line;
            }
        } catch (IOException var13) {
        }

        try {
            bReader.close();
        } catch (IOException var8) {
        }

        return resultStr;
    }

}
