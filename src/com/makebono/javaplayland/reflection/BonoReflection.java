package com.makebono.javaplayland.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
 * @ClassName: BonoReflection 
 * @Description: Simple reflection examples
 * @author makebono
 * @date 2017年12月8日 上午11:11:59 
 *  
 */
@SuppressWarnings("rawtypes")
public class BonoReflection {
    public static Object instantiate(final String object)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
        final Object newObject = Class.forName(object).newInstance();
        return newObject;
    }

    public static <T> Object instantiate(final String object, final Object... args)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
        final Object newObject = Class.forName(object).newInstance();
        final Class<?> newClass = newObject.getClass();

        // Initialized it as well
        final Class[] parameterTypes = new Class[args.length];

        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] = args[i].getClass();
        }

        final Method method = newClass.getMethod("init", parameterTypes);
        method.invoke(newObject, args);

        return newObject;
    }
}
