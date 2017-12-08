package com.makebono.javaplayland.designpattern.structuralpattern.flyweightpattern;

import com.makebono.javaplayland.tools.entities.intefaces.Juice;

/** 
 * @ClassName: FlyweightJuiceRetailer 
 * @Description: Flyweight pattern, retailer make order from factory.
 * @author makebono
 * @date 2017年12月6日 上午8:55:41 
 *  
 */
public class FlyweightJuiceRetailer {
    public Juice orderOrangeJuice() {
        return FlyweightJuiceFactory.orderOrangeJuice();
    }

    public Juice orderAppleJuice() {
        return FlyweightJuiceFactory.orderAppleJuice();
    }

    public void queryStock() {
        FlyweightJuiceFactory.JuiceInStock();
    }
}
