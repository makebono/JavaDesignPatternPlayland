package com.makebono.javaplayland.tools.entities;

import com.makebono.javaplayland.tools.entities.interfaces.PrototypeJuice;

/** 
 * @ClassName: PrototypeOrangeJuice 
 * @Description: Prototype orange juice
 * @author makebono
 * @date 2017年12月5日 下午3:50:41 
 *  
 */
public class PrototypeOrangeJuice extends OrangeJuice implements Cloneable, PrototypeJuice {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
