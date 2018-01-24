package com.makebono.javaplayland.tools.entities;

import com.makebono.javaplayland.tools.entities.interfaces.Juice;

/** 
 * @ClassName: OrangeJuice 
 * @Description: Orange tastes good 
 * @author makebono
 * @date 2017年12月5日 上午11:48:24 
 *  
 */
public class OrangeJuice implements Juice {
    @Override
    public String type() {
        return "Mega size orange juice, boo!";
    }

    @Override
    public void init() {
        System.out.println("OrangeJuice initialized.");
    }
}
