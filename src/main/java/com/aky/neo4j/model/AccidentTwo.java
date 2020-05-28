package com.aky.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Data
@NodeEntity
@NoArgsConstructor
@AllArgsConstructor
public class AccidentTwo {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "nodeId")
    private Long nodeId;

    /**
     *
     */
    @Property(name = "accidentDate")
    private String accidentDate;

    /**
     *
     */
    @Property(name = "accidentTitle")
    private String accidentTitle;

    /**
     *
     */
    @Property(name = "accidentDetail")
    private String accidentDetail;

    /**
     *
     */
    @Property(name = "accidentType")
    private String accidentType;

    /**
     *
     */
    @Property(name = "type")
    private String type;

    /**
     *
     */
    @Property(name = "accidentLevel")
    private String accidentLevel;

    /**
     *
     */
    @Property(name = "accidentReason")
    private String accidentReason;

    /**
     *
     */
    @Property(name = "accidentPlate")
    private String accidentPlate;

    /**
     *
     */
    @Property(name = "accidentThing")
    private String accidentThing;

    /**
     * 死亡人数
     */
    @Property(name = "deathes")
    private Integer deathes;

    /**
     * 轻伤人数
     */
    @Property(name = "minors")
    private Integer minors;

    /**
     * 重伤人数
     */
    @Property(name = "severely")
    private Integer severely;
}
