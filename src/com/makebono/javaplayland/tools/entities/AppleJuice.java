package com.makebono.javaplayland.tools.entities;

import com.makebono.javaplayland.tools.entities.interfaces.Juice;

/** 
 * @ClassName: AppleJuice 
 * @Description: Not my favorite
 * @author makebono
 * @date 2017年12月5日 上午11:51:10 
 *  
 */
public class AppleJuice implements Juice {
    @Override
    public String type() {
        return "Cup of apple juice.";
    }

    @Override
    public void init() {
        System.out.println("AppleJuice initialized.");
    }
}
