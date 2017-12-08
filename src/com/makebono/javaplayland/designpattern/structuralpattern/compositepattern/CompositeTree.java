/**Note:
 * Composite objects into tree structures. So technically this is just a tree.
 */
package com.makebono.javaplayland.designpattern.structuralpattern.compositepattern;

import java.util.Comparator;

import com.makebono.datastructures.binarysearchtree.BinarySearchBonoTree;

/** 
 * @ClassName: CompositeTree 
 * @Description: CompositePattern
 * @author makebono
 * @date 2017年12月6日 上午8:50:22 
 *  
 */
public class CompositeTree<T> extends BinarySearchBonoTree<T> {
    public CompositeTree(final Comparator<T> sideKick) {
        super(sideKick);
    }
}
