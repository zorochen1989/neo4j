package com.aky.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.util.List;

/**
 * 化学品实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Chemicals {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 化学品中文名
     */
    @Property(name = "chName")
    private String chName;

    /**
     * 化学品英文名
     */
    @Property(name = "enName")
    private String enName;

    /**
     * CAS
     */
    @Property(name = "cas")
    private String cas;

    /**
     * 分子式
     */
    @Property(name = "molecularFormula")
    private String molecularFormula;

    /**
     * 联合国危险货物编号
     */
    @Property(name = "number")
    private String number;

    @Relationship(direction = Relationship.OUTGOING)
    private EnterpriseInfo enterpriseInfo;

    @Relationship(direction = Relationship.OUTGOING)
    private List<EnterpriseInfo> enterpriseInfos;

    @Relationship(direction = Relationship.INCOMING)
    private List<MajorHazard> majorHazardList;

    public Chemicals(String chName, String enName, String cas, String molecularFormula, String number) {
        this.chName = chName;
        this.enName = enName;
        this.cas = cas;
        this.molecularFormula = molecularFormula;
        this.number = number;
    }
}
