package com.aky.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class MajorHazard {

    @Id
    @GeneratedValue
    private Long id;

    @Property("chemicalsId")
    private Long chemicalsId;

    /**
     * 危险源名称
     */
    @Property(name = "hazardsName")
    private String hazardsName;

    /**
     * 重大危险源危险级别
     */
    @Property(name = "hazardsLevel")
    private String hazardsLevel;

    /**
     * 危险源R值
     */
    @Property(name = "hazardsRNum")
    private String hazardsRNum;

    /**
     * 危险源所在详细地址
     */
    @Property(name = "hazardsAddress")
    private String hazardsAddress;

    /**
     * 危险源投用时间
     */
    @Property(name = "hazardsTime")
    private String hazardsTime;

    /**
     * 是否位于化工工业园区
     */
    @Property(name = "isInChemicalIndustrialPark")
    private String isInChemicalIndustrialPark;

    /**
     * 工业园区名称
     */
    @Property(name = "industrialParkName")
    private String industrialParkName;

    /**
     * 危险源生产规模
     */
    @Property(name = "hazardScale")
    private String hazardScale;

    /**
     * 安全距离
     */
    @Property(name = "safeDistance")
    private String safeDistance;

    /**
     * 500米内人数估算
     */
    @Property(name = "peopleNumWithin500Meters")
    private String peopleNumWithin500Meters;

    /**
     * 3年内安全事故情况
     */
    @Property(name = "safetyAccidentsWithin3Years")
    private String safetyAccidentsWithin3Years;

    /**
     * ID
     */
    @Property(name = "idNum")
    private String idNum;

    @Relationship
    private Chemicals chemicals;

    public MajorHazard(Long chemicalsId, String hazardsName, String hazardsLevel, String hazardsRNum, String hazardsAddress, String hazardsTime, String isInChemicalIndustrialPark, String industrialParkName, String hazardScale, String safeDistance, String peopleNumWithin500Meters, String safetyAccidentsWithin3Years, String idNum) {
        this.chemicalsId = chemicalsId;
        this.hazardsName = hazardsName;
        this.hazardsLevel = hazardsLevel;
        this.hazardsRNum = hazardsRNum;
        this.hazardsAddress = hazardsAddress;
        this.hazardsTime = hazardsTime;
        this.isInChemicalIndustrialPark = isInChemicalIndustrialPark;
        this.industrialParkName = industrialParkName;
        this.hazardScale = hazardScale;
        this.safeDistance = safeDistance;
        this.peopleNumWithin500Meters = peopleNumWithin500Meters;
        this.safetyAccidentsWithin3Years = safetyAccidentsWithin3Years;
        this.idNum = idNum;
    }
}
