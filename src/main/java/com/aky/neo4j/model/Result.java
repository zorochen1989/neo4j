package com.aky.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    /**
     * 返回结果 success error等
     */
    private String result;

    /**
     * 结果编码 0000 200 500
     */
    private String code;

    /**
     * 封装的数据，json格式
     */
    private Object data;

    /**
     * 信息展示
     */
    private String msg;
}
