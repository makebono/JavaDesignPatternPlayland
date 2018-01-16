package com.makebono.javaplayland.innerclasstest;

import com.makebono.javaplayland.innerclasstest.testinterface.BrandTitle;
import com.makebono.javaplayland.innerclasstest.testinterface.JuicePackage;

/** 
 * @ClassName: Demo 
 * @Description: A demo for inner class related stuffs.
 * @author makebono
 * @date 2018年1月16日 上午10:27:43 
 *  
 */
public class Demo {
    public static void main(final String args[]) {
        final JuiceEX jex = new JuiceEX();

        // JuicePackage jp = jex.new juicePackage(); <- Of course, access to private class would be rejected.
        final JuicePackage jp = jex.pack();

        // final BrandTitle bt = jex.new juiceBrand(); <- This demo class is in same package of JuiceEX class, hence it
        // works this way.
        final BrandTitle bt = jex.title();

        // final JuiceEX.info info = new JuiceEX.info(); <- Illegal.
        // Even for a public inner class, you have to instantiate it by a instance of the enclosing class like this.
        final JuiceEX.info info = jex.new info();

        System.out.println("Accessing instance of JuiceEX class:\n    " + jex + "\n");
        System.out.println("Accessing instance of juicePackage private class:\n    " + jp.color() + "\n");
        System.out.println("Accessing instance of juiceBrand protected class:\n    " + bt.font() + "\n");
        System.out.print("Accessing instance of info public class:\n    ");
        info.printInfo();

        System.out.println();
        System.out.println(jp.getClass().getName() + " enclosed by " + jp.getClass().getEnclosingClass() + "\n");
        System.out.println(bt.getClass().getName() + " enclosed by " + jp.getClass().getEnclosingClass() + "\n");
        System.out.println(info.getClass().getName() + " enclosed by " + jp.getClass().getEnclosingClass() + "\n");
    }
}
