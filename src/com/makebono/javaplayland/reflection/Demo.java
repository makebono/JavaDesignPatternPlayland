package com.makebono.javaplayland.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/** 
 * @ClassName: Demo 
 * @Description: A easy demo for some reflection and anonymous class related stuffs.
 * @author makebono
 * @date 2018年1月2日 下午3:45:01 
 *  
 */
@SuppressWarnings(value = { "unused" })
public class Demo {
    final String str = "An anonymous class can access variables of its enclosing class. It must be defined as static for directly accessing from anonymous class.";
    final static String str2 = "An anonymous class can access static variables of its enclosing class";

    private class babyDemo {
        void print() {
            System.out.println(str);
        }
    }

    public static <T> void show() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        final AClass class1 = new AClass();
        // Cannot call private method
        // class1.whatDoIHave();

        System.out.println("AClass class1, full class name is:\n    " + class1.getClass().getName());

        System.out.println("\nSimpleName is:\n    " + class1.getClass().getSimpleName());

        // Access private methods
        final Method[] privateMethods = class1.getClass().getSuperclass().getDeclaredMethods();

        System.out.print("\nIt has method(s):\n    ");
        System.out.println(privateMethods[0]);

        System.out.print("\nCalling private method:\n    ");
        privateMethods[0].setAccessible(true);
        privateMethods[0].invoke(class1);

        // Access private variables
        final Field[] privateVariables = class1.getClass().getSuperclass().getDeclaredFields();
        privateVariables[0].setAccessible(true);
        final Object privateVariable = privateVariables[0].get(class1);
        System.out.println("\nAccessing private variable:\n    " + privateVariable.getClass());
        System.out.println("\nAClass has super class:\n    " + class1.getClass().getSuperclass());
        System.out.println("\nAClass has direct super class:\n    " + class1.getClass().getGenericSuperclass());

        System.out.println("\nIt has parameterized types:\n    "
                + ((ParameterizedType) class1.getClass().getGenericSuperclass()).getActualTypeArguments()[0] + "\n    "
                + ((ParameterizedType) class1.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);

        System.out.println(
                "\nThere's a inner class inside:\nIt's class name is:\n    " + class1.new BClass().getClass().getName()
                        + "\nIt's canonical class name is:\n    " + class1.new BClass().getClass().getCanonicalName());

        // It seems wield but you won't get the true name of this temporary class.
        new AnonymousClass() {
            public void yell() {
                System.out
                        .println("\nThis is an anonymous class.\nIt's class name is:\n    " + this.getClass().getName()
                                + "\nIt's canonical class name is:\n    " + this.getClass().getCanonicalName()
                                + "\nIt's simple name is:\n    " + this.getClass().getSimpleName());
            }
        }.yell();

        final AnonymousClass a1 = new AnonymousClass() {
            @Override
            public void whoAmI() {
                System.out.println(
                        "\nThis is another anonymous class.\nIt's class name is:\n    " + this.getClass().getName()
                                + "\nIt's canonical class name is:\n    " + this.getClass().getCanonicalName()
                                + "\nIt's simple name is:\n    " + this.getClass().getSimpleName());
                // Cannot directly access to a non-static variable in enclosing class.
                // System.out.println(str);
                System.out.println(str2);
            }

            public void yell() {
                System.out
                        .println("\nThis is an anonymous class.\nIt's class name is:\n    " + this.getClass().getName()
                                + "\nIt's canonical class name is:\n    " + this.getClass().getCanonicalName()
                                + "\nIt's simple name is:\n    " + this.getClass().getSimpleName());
            }
        };
        // Doesn't work if not invoke it right after definition.
        // a1.yell();
        a1.whoAmI();

        // Interface also works.
        new AnonymousInterface() {
            // Cannot define any static mamber in anonymous class.
            final String str = "But it can also define a variable as same name as its enclosing class. To access enclosing "
                    + "\nclass's variable , need a new instatiation of its enclosing class.";

            @Override
            public void whoAmI() {

                System.out.println(
                        "\nThis is an anonymous Interface.\nIt's class name is:\n    " + this.getClass().getName()
                                + "\nIt's canonical class name is:\n    " + this.getClass().getCanonicalName()
                                + "\nIt's simple name is:\n    " + this.getClass().getSimpleName());
                System.out.println(this.str);
                System.out.println(new Demo().str);
            }
        }.whoAmI();

        System.out.println("\nStatic or not, an inner class can directly access the outer class's defined variable.");
        new Demo().new babyDemo().print();
    }

}

class AnonymousClass {
    public void whoAmI() {
        System.out.println("\nThis is an anonymous class.\nIt's class name is:\n    " + this.getClass().getName()
                + "\nIt's canonical class name is:\n    " + this.getClass().getCanonicalName()
                + "\nIt's simple name is:\n    " + this.getClass().getSimpleName());
    }
}

interface AnonymousInterface {
    void whoAmI();
}
