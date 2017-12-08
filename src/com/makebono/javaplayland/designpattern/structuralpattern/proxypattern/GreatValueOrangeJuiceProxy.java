/**Note:
 * Different from decorator, proxy pattern does not have to provide same interface as its target. 
 * It gives access to orginal target. Decorator pattern modifies method of original target, keeping same interface.
 */
package com.makebono.javaplayland.designpattern.structuralpattern.proxypattern;

import com.makebono.javaplayland.tools.entities.OrangeJuice;
import com.makebono.javaplayland.tools.entities.intefaces.Juice;

/** 
 * @ClassName: GreatValueOrangeJuiceProxy 
 * @Description: Proxy pattern
 * @author makebono
 * @date 2017年12月5日 下午5:06:06 
 *  
 */
public class GreatValueOrangeJuiceProxy implements Juice {
    private final Juice juice;

    public GreatValueOrangeJuiceProxy() {
        this.juice = new OrangeJuice();
    }

    @Override
    public String type() {
        return this.juice.type();
    }

    public String brand() {
        return "Great Value";
    }
}