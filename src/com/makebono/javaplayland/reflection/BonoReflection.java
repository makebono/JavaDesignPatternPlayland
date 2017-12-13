/**Note:
 * Simple reflection handler. Use object's class name to instantiate handler, there are two kinds of constructor here,
 * one for non-parametric initializer and the other takes care of initializer with parameter(s) in the object you accessing.
 * As well as two kinds of call method for non-parametric and parametric method call.  
 * 
 * Instruction:
 * 
 *    final BonoReflection br = new BonoReflection("com.makebono.javaplayland.tools.entities.OrangeJuice");
 *    System.out.println(br.call("type"));
 *
 *    final BonoReflection br2 = new BonoReflection("com.makebono.javaplayland.tools.entities.ReflectOrangeJuice", 10,
 *              "Bono");

 *    br2.call("yell");
 *    br2.call("advertise", "fantastic"); 
 *    
 * Lines above are equal with:
 * 
 *    final OrangeJuice oj = new OrangeJuice();
 *    System.out.println(oj.type())
 * 
 *    final ReflectOrangeJuice roj = new ReflectOrangeJuice();
 *    roj.init(10, "Bono");
 *
 *    roj.yell();
 *    roj.advertise("fantastic");
 */
package com.makebono.javaplayland.reflection;

import java.lang.reflect.Field;
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
    private final Object object;

    public BonoReflection(final String object, final Object... args)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
        if (args.length == 0) {
            this.object = Class.forName(object).newInstance();
        } else {
            this.object = Class.forName(object).newInstance();

            // Initialized it as well
            final Class[] parameterTypes = new Class[args.length];

            for (int i = 0; i < args.length; i++) {
                parameterTypes[i] = args[i].getClass();
            }

            final Method method = this.object.getClass().getMethod("init", parameterTypes);
            method.invoke(this.object, args);
        }
    }

    public Object getObject() {
        return this.object;
    }

    // Notice this also accept call(method), without args input. In this case, args.length = 0
    public Object call(final String method, final Object... args) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        final Class[] parameterTypes = new Class[args.length];

        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] = args[i].getClass();
        }

        // Notice getMethod() would only find public method.
        final Method call = this.object.getClass().getDeclaredMethod(method, parameterTypes);
        // No matter the method is public or not, set it accessible whatsoever.
        call.setAccessible(true);
        return call.invoke(this.object, args);
    }

    // Access variable no matter it's private or public.
    public Object accessVariable(final String field)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        // Similarily, getField() would only look for public variable.
        final Field f = this.object.getClass().getDeclaredField(field);
        f.setAccessible(true);
        return f.get(this.object);
    }

    // Modify variable no matter it's private or public.
    public void setVariable(final String field, final Object value)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final Field f = this.object.getClass().getDeclaredField(field);
        f.setAccessible(true);
        f.set(this.object, value);
    }
}
