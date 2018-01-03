package com.makebono.javaplayland.reflection;

import com.makebono.datastructures.linkedlist.linkedlistinterface.LinkedList;

/** 
 * @ClassName: AClass 
 * @Description: A class
 * @author makebono
 * @date 2018年1月2日 下午3:44:06 
 *  
 */
public class AClass extends Dad<LinkedList<Integer>, String> {
    protected class BClass extends AClass {}
}
