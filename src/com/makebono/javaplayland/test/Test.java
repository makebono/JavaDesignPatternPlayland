package com.makebono.javaplayland.test;

import java.lang.reflect.InvocationTargetException;

import com.makebono.javaplayland.reflection.BonoReflection;

/** 
 * @ClassName: Test 
 * @Description: Of course it's yet another test class, what else do you expect? 
 * @author makebono
 * @date 2017年12月5日 上午11:58:17 
 *  
 */
public class Test {
    public static void main(final String[] args) throws CloneNotSupportedException, InstantiationException,
            IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        final BonoReflection br = new BonoReflection("com.makebono.javaplayland.tools.entities.OrangeJuice");
        System.out.println(br.call("type"));

        final BonoReflection br2 = new BonoReflection("com.makebono.javaplayland.tools.entities.ReflectOrangeJuice", 10,
                "Bono");

        br2.call("yell");
        br2.call("advertise", "fantastic");

        Object o = br2.accessVariable("receiver");
        System.out.println(o);
        br2.setVariable("receiver", "Teru");
        o = br2.accessVariable("receiver");
        System.out.println(o);
    }
}
