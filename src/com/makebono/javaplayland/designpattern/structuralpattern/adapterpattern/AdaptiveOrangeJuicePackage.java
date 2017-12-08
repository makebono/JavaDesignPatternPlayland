package com.makebono.javaplayland.designpattern.structuralpattern.adapterpattern;

import com.makebono.javaplayland.designpattern.structuralpattern.adapterpattern.adapterinterface.AdaptiveJuicePackage;
import com.makebono.javaplayland.tools.entities.OrangeJuice;

/** 
 * @ClassName: AdaptiveOrangeJuicePackage 
 * @Description: Adapter pattern
 * @author makebono
 * @date 2017年12月5日 下午4:16:09 
 *  
 */
public class AdaptiveOrangeJuicePackage extends OrangeJuice implements AdaptiveJuicePackage {
    @Override
    public String taste() {
        return "It tastes like orange.";
    }
}
