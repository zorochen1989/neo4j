package com.aky.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryPageable {

    /**
     * 页码
     */
    private int page;

    /**
     * 当前页显示条目最大数量
     */
    private int size;

    /**
     * 排序方式: null或者""为ASC 反之有数据则为DESC
     */
    private String direction;

    /**
     * 按哪些字段排序
     */
    private String[] properties;

    /**
     * 一共有多少页
     */
    private int pageCount;

    /**
     * 一共有多少条数据
     */
    private long itemCount;

    public QueryPageable(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
