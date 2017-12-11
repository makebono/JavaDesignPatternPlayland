package com.makebono.javaplayland.test;

import java.lang.reflect.InvocationTargetException;

import com.makebono.javaplayland.dynamicproxy.client.JuiceProxyFactory;

/** 
 * @ClassName: Test 
 * @Description: Of course it's yet another test class, what else do you expect? 
 * @author makebono
 * @date 2017年12月5日 上午11:58:17 
 *  
 */
public class Test {
    public static void main(final String[] args)
            throws CloneNotSupportedException, InstantiationException, IllegalAccessException, ClassNotFoundException,
            NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        JuiceProxyFactory.make("Orange");
        JuiceProxyFactory.stealthMake("Orange");
    }
}
