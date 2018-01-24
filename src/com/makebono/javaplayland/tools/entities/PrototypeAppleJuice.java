package com.makebono.javaplayland.tools.entities;

import com.makebono.javaplayland.tools.entities.interfaces.PrototypeJuice;

/** 
 * @ClassName: PrototypeAppleJuice 
 * @Description: Prototype apple juice
 * @author makebono
 * @date 2017年12月5日 下午3:50:41 
 *  
 */
public class PrototypeAppleJuice extends AppleJuice implements Cloneable, PrototypeJuice {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
