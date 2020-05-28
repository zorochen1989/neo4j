package com.aky.neo4j.util;

import java.text.NumberFormat;

public class MathUtil {

    public static String percent(long num, long allCount) {
        // 实例化数据格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 精确等到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        double x = num;
        double y = allCount;
        return numberFormat.format(x / y * 100) + "%";
    }
}
