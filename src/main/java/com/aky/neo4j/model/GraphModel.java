package com.aky.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图形属性
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphModel {

    /**
     * 键
     */
    private String key;

    /**
     * 数据
     */
    private Object data;
}
