package com.makebono.javaplayland.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.makebono.javaplayland.annotation.ClassFileAnnotation;
import com.makebono.javaplayland.annotation.RuntimeAnnotation;
import com.makebono.javaplayland.designpattern.creationalpattern.singletonpattern.SingletonJuiceFactory;

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
            IllegalArgumentException, InvocationTargetException, NoSuchFieldException, IOException {
        System.out.println(SingletonJuiceFactory.accessFactory().produceOrangeJuice().type());
    }

}
