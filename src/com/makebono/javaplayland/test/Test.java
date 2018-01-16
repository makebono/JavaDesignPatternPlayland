package com.makebono.javaplayland.test;

import java.lang.reflect.InvocationTargetException;

import com.makebono.javaplayland.annotation.ClassFileAnnotation;
import com.makebono.javaplayland.annotation.RuntimeAnnotation;
import com.makebono.javaplayland.innerclasstest.JuiceEX;
import com.makebono.javaplayland.innerclasstest.testinterface.BrandTitle;
import com.makebono.javaplayland.innerclasstest.testinterface.JuicePackage;

/** 
 * @ClassName: Test 
 * @Description: Of course it's yet another test class, what else do you expect? 
 * @author makebono
 * @date 2017年12月5日 上午11:58:17 
 *  
 */
public class Test {
    @RuntimeAnnotation(bono2 = "GBJJ")
    public void print() {
        System.out.println("Take a deep Bono.");
    }

    @ClassFileAnnotation
    public void print2() {
        System.out.println("Take a deep Bono.");
    }

    public static void main(final String[] args) throws CloneNotSupportedException, InstantiationException,
            IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        final JuiceEX jex = new JuiceEX();
        final JuicePackage jp = jex.pack();
        final BrandTitle bt = jex.title();
        // final JuiceEX.info info = new JuiceEX.info(); <- Illegal.
        final JuiceEX.info info = jex.new info();

        System.out.println(jex);
        System.out.println(jp.color());
        System.out.println(bt.font());
        info.printInfo();
    }

}
