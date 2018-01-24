package com.makebono.javaplayland.designpattern.creationalpattern.abstractfactorypattern;

import com.makebono.javaplayland.designpattern.creationalpattern.abstractfactorypattern.factoryinterface.AbstractJuiceFactory;
import com.makebono.javaplayland.tools.entities.OrangeJuice;
import com.makebono.javaplayland.tools.entities.interfaces.Juice;

/** 
 * @ClassName: OrangeJuiceFactory 
 * @Description: OrangeJuiceFactory 
 * @author makebono
 * @date 2017年12月5日 下午1:42:44 
 *  
 */
public class OrangeJuiceFactory implements AbstractJuiceFactory {
    @Override
    public Juice produce() {
        return new OrangeJuice();
    }
}
