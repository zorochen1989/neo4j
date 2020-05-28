package com.aky.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class ChemicalsTwo {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "chinaName")
    private String chinaName;

    @Property(name = "cas")
    private String cas;

    @Property(name = "index")
    private String index;

    @Property(name = "type")
    private String type;

    @Property(name = "nodeId")
    private Long nodeId;
}
