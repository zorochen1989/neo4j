package com.aky.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.util.List;

/**
 * 企业信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class EnterpriseInfo {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 企业名称
     */
    @Property(name = "enterpriseName")
    private String enterpriseName;

    /**
     * 省
     */
    @Property(name = "province")
    private String province;

    /**
     * 市
     */
    @Property(name = "city")
    private String city;

    /**
     * 县
     */
    @Property(name = "prefecture")
    private String prefecture;

    /**
     * 工商注册地址
     */
    @Property(name = "registeredAddress")
    private String registeredAddress;

    /**
     * 邮政编码
     */
    @Property(name = "postalCode")
    private String postalCode;

    /**
     * 单位性质
     */
    @Property(name = "natureOfUnit")
    private String natureOfUnit;

    /**
     * 成立时间
     */
    @Property(name = "setupTime")
    private String setupTime;

    /**
     * 法定代表人
     */
    @Property(name = "legalRepresentative")
    private String legalRepresentative;

    /**
     * 经济类型2
     */
    @Property(name = "economicType2")
    private String economicType2;

    /**
     * 经济类型1
     */
    @Property(name = "economicType1")
    private String economicType1;

    /**
     * 企业规模
     */
    @Property(name = "enterpriseScale")
    private String enterpriseScale;

    /**
     * 销售收入
     */
    @Property(name = "salesRevenue")
    private String salesRevenue;

    /**
     * 职工人数
     */
    @Property(name = "workerNumber")
    private String workerNumber;

    /**
     * 应急咨询服务电话
     */
    @Property(name = "enquiryHotline")
    private String enquiryHotline;

    /**
     * 位置经度
     */
    @Property(name = "longitude")
    private String longitude;

    /**
     * 位置纬度
     */
    @Property(name = "latitude")
    private String latitude;

    /**
     * 是否有仓储设施
     */
    @Property(name = "storageFacilitiesHave")
    private String storageFacilitiesHave;

    /**
     * 是否进口危险化学品
     */
    @Property(name = "hazardousChemicalsHave")
    private String hazardousChemicalsHave;

    /**
     * 邮箱
     */
    @Property(name = "email")
    private String email;

    /**
     * 主要产品及生产规模
     */
    @Property(name = "productAndScale")
    private String productAndScale;

    /**
     * 特种作业人员数
     */
    @Property(name = "specialOperatorsNumber")
    private String specialOperatorsNumber;

    /**
     * 生产场所地址
     */
    @Property(name = "productionSiteAddress")
    private String productionSiteAddress;

    /**
     * 安全值班电话
     */
    @Property(name = "securityTelephone")
    private String securityTelephone;

    /**
     * 储罐总容积
     */
    @Property(name = "totalTankCapacity")
    private String totalTankCapacity;

    /**
     * 传真
     */
    @Property(name = "fax")
    private String fax;

    /**
     * 从业人员数
     */
    @Property(name = "employeesNumber")
    private String employeesNumber;

    /**
     * 化学行业分类
     */
    @Property(name = "chemicalIndustryClassification")
    private String chemicalIndustryClassification;

    /**
     * 经办人
     */
    @Property(name = "agent")
    private String agent;

    /**
     * 联系电话
     */
    @Property(name = "contactPhoneNumber")
    private String contactPhoneNumber;

    /**
     * 企业分管安全负责人
     */
    @Property(name = "enterpriseSecurityCharge")
    private String enterpriseSecurityCharge;

    /**
     * 企业负责人
     */
    @Property(name = "enterprisePrincipal")
    private String enterprisePrincipal;

    /**
     * 企业负责人联系电话
     */
    @Property(name = "enterprisePrincipalPhone")
    private String enterprisePrincipalPhone;

    /**
     * 安全生产标准化等级
     */
    @Property(name = "standardizedLevelOfProductionSafety")
    private String standardizedLevelOfProductionSafety;

    @Relationship(direction = Relationship.OUTGOING,value = "")
    private List<Chemicals> outChemicals;

    @Relationship(direction = Relationship.INCOMING,value = "")
    private List<Chemicals> inChemicals;

    public EnterpriseInfo(String enterpriseName, String province, String city, String prefecture, String registeredAddress, String postalCode, String natureOfUnit, String setupTime, String legalRepresentative, String economicType2, String economicType1, String enterpriseScale, String salesRevenue, String workerNumber, String enquiryHotline, String longitude, String latitude, String storageFacilitiesHave, String hazardousChemicalsHave, String email, String productAndScale, String specialOperatorsNumber, String productionSiteAddress, String securityTelephone, String totalTankCapacity, String fax, String employeesNumber, String chemicalIndustryClassification, String agent, String contactPhoneNumber, String enterpriseSecurityCharge, String enterprisePrincipal, String enterprisePrincipalPhone, String standardizedLevelOfProductionSafety) {
        this.enterpriseName = enterpriseName;
        this.province = province;
        this.city = city;
        this.prefecture = prefecture;
        this.registeredAddress = registeredAddress;
        this.postalCode = postalCode;
        this.natureOfUnit = natureOfUnit;
        this.setupTime = setupTime;
        this.legalRepresentative = legalRepresentative;
        this.economicType2 = economicType2;
        this.economicType1 = economicType1;
        this.enterpriseScale = enterpriseScale;
        this.salesRevenue = salesRevenue;
        this.workerNumber = workerNumber;
        this.enquiryHotline = enquiryHotline;
        this.longitude = longitude;
        this.latitude = latitude;
        this.storageFacilitiesHave = storageFacilitiesHave;
        this.hazardousChemicalsHave = hazardousChemicalsHave;
        this.email = email;
        this.productAndScale = productAndScale;
        this.specialOperatorsNumber = specialOperatorsNumber;
        this.productionSiteAddress = productionSiteAddress;
        this.securityTelephone = securityTelephone;
        this.totalTankCapacity = totalTankCapacity;
        this.fax = fax;
        this.employeesNumber = employeesNumber;
        this.chemicalIndustryClassification = chemicalIndustryClassification;
        this.agent = agent;
        this.contactPhoneNumber = contactPhoneNumber;
        this.enterpriseSecurityCharge = enterpriseSecurityCharge;
        this.enterprisePrincipal = enterprisePrincipal;
        this.enterprisePrincipalPhone = enterprisePrincipalPhone;
        this.standardizedLevelOfProductionSafety = standardizedLevelOfProductionSafety;
    }
}
