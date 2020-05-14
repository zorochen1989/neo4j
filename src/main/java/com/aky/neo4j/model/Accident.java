package com.aky.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

/**
 * 事故信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Accident {

    @Id
    @GeneratedValue
    private Long id;

    @Property("chemicalsId")
    private Long chemicalsId;


    /**
     * 事故名称
     */
    @Property(name = "accidentName")
    private String accidentName;

    /**
     * 事故时间
     */
    @Property(name = "accidentTime")
    private String accidentTime;

    /**
     * 事故物质
     */
    @Property(name = "accidentMaterial")
    private String accidentMaterial;

    /**
     * 事故类型
     */
    @Property(name = "accidentType")
    private String accidentType;

    /**
     * 事故板块
     */
    @Property(name = "accidentPlate")
    private String accidentPlate;

    /**
     * 国内/外
     */
    @Property(name = "atHomeAndAbroad")
    private String atHomeAndAbroad;

    /**
     * 死亡人数
     */
    @Property(name = "deathNumber")
    private String deathNumber;

    /**
     * 重伤人数
     */
    @Property(name = "seriouslyInjuredPeople")
    private String seriouslyInjuredPeople;

    /**
     * 轻伤人数
     */
    @Property(name = "minorNumber")
    private String minorNumber;

    /**
     * 事故原因
     */
    @Property(name = "accidentReason")
    private String accidentReason;

    /**
     * 事故经过
     */
    @Property(name = "accidentDetails")
    private String accidentDetails;

    /**
     * 化学品事发环节
     */
    @Property(name = "chemicalExposure")
    private String chemicalExposure;

    /**
     * 事故与化学品的外关联
     */
    @Relationship(direction = Relationship.OUTGOING)
    private Chemicals chemicalsOut;

    /**
     * 事故与化学品的内关联
     */
    @Relationship(direction = Relationship.INCOMING)
    private Chemicals chemicalsIn;

    public Accident(Long chemicalsId, String accidentName, String accidentTime, String accidentMaterial, String accidentType, String accidentPlate, String atHomeAndAbroad, String deathNumber, String seriouslyInjuredPeople, String minorNumber, String accidentReason, String accidentDetails, String chemicalExposure) {
        this.chemicalsId = chemicalsId;
        this.accidentName = accidentName;
        this.accidentTime = accidentTime;
        this.accidentMaterial = accidentMaterial;
        this.accidentType = accidentType;
        this.accidentPlate = accidentPlate;
        this.atHomeAndAbroad = atHomeAndAbroad;
        this.deathNumber = deathNumber;
        this.seriouslyInjuredPeople = seriouslyInjuredPeople;
        this.minorNumber = minorNumber;
        this.accidentReason = accidentReason;
        this.accidentDetails = accidentDetails;
        this.chemicalExposure = chemicalExposure;
    }
}
