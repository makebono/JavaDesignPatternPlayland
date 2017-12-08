package com.makebono.javaplayland.dynamicproxy.juicerserviceimplement;

import com.makebono.javaplayland.dynamicproxy.juicerserviceinterface.Juicer;
import com.makebono.javaplayland.tools.entities.AppleJuice;
import com.makebono.javaplayland.tools.entities.OrangeJuice;
import com.makebono.javaplayland.tools.entities.intefaces.Juice;

/** 
 * @ClassName: Juicer 
 * @Description: Implementation of juicer, a simple Juice factory.
 * @author makebono
 * @date 2017年12月8日 上午10:03:10 
 *  
 */
public class BonoJuicer implements Juicer {
    @Override
    public Juice makeJuice(final String ingredient) {
        if (ingredient.equals("Orange")) {
            return new OrangeJuice();
        } else if (ingredient.equals("Apple")) {
            return new AppleJuice();
        } else {
            System.out.println("We can't make that yet. Calm down, here's an orange juice for you.");
            return new OrangeJuice();
        }
    }
}
