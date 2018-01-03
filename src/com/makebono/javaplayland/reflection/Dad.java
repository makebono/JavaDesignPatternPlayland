package com.makebono.javaplayland.reflection;

import com.makebono.datastructures.linkedlist.OrderedLinkedList;
import com.makebono.datastructures.linkedlist.linkedlistinterface.LinkedList;
import com.makebono.datastructures.tools.tcomparator.TComparator;

/** 
 * @ClassName: Dad 
 * @Description: A super class.
 * @author makebono
 * @date 2018年1月2日 下午4:10:21 
 *  
 */
@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
public class Dad<D extends LinkedList<?>, T> extends Granddad {
    private final D list = (D) new OrderedLinkedList(new TComparator());

    private void whatDoIHave() {
        System.out.println("I hold an " + this.list.getClass().getSimpleName());
    }
}
