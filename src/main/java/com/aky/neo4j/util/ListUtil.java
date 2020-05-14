package com.aky.neo4j.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListUtil {

    /**
     * 将Iterator转换成list
     * @param iterator
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(Iterator<T> iterator) {
        List list = new LinkedList();
        while (iterator.hasNext())
            list.add(iterator.next());

        return list;
    }
}
