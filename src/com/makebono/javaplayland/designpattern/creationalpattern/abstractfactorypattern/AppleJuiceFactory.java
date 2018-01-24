package com.makebono.javaplayland.designpattern.creationalpattern.abstractfactorypattern;

import com.makebono.javaplayland.designpattern.creationalpattern.abstractfactorypattern.factoryinterface.AbstractJuiceFactory;
import com.makebono.javaplayland.tools.entities.AppleJuice;
import com.makebono.javaplayland.tools.entities.interfaces.Juice;

/** 
 * @ClassName: AppleJuiceFactory 
 * @Description: AppleJuiceFactory 
 * @author makebono
 * @date 2017年12月5日 下午1:42:44 
 *  
 */
public class AppleJuiceFactory implements AbstractJuiceFactory {
    @Override
    public Juice produce() {
        return new AppleJuice();
    }
}
