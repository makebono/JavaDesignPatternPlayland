package com.makebono.javaplayland.designpattern.behavioralpattern.interclasses.commandpattern;

import com.makebono.javaplayland.tools.entities.AppleJuice;
import com.makebono.javaplayland.tools.entities.OrangeJuice;
import com.makebono.javaplayland.tools.entities.intefaces.Juice;

/** 
 * @ClassName: Executor 
 * @Description: Executor following commander's order
 * @author makebono
 * @date 2017年12月6日 下午2:05:23 
 *  
 */
public class Executor {
    private Juice work;

    public void deal(final String task) {
        if (task.equals("OrangeJuice")) {
            System.out.println("Boss, here is your " + task + ".");
            work = new OrangeJuice();
            System.out.println(work.type());
        } else if (task.equals("AppleJuice")) {
            System.out.println("Boss, here is your " + task + ".");
            work = new AppleJuice();
            System.out.println(work.type());
        } else {
            System.out.println("Boss, I can give you " + task + ". But here's an orange juice for you.");
            work = new OrangeJuice();
            System.out.println(work.type());
        }
    }
}
