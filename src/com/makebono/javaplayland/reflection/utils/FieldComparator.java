package com.makebono.javaplayland.reflection.utils;

import java.lang.reflect.Field;
import java.util.Comparator;

/** 
 * @ClassName: FieldComparator 
 * @Description: Compare fields by their names.
 * @author makebono
 * @date 2018年1月11日 上午9:00:22 
 *  
 */
public class FieldComparator implements Comparator<Field> {

    @Override
    public int compare(final Field o1, final Field o2) {
        return (o1.getName().compareTo(o2.getName()));
    }

}
