package com.makebono.javaplayland.lambdaexpressions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

import com.makebono.javaplayland.tools.entities.Destroyer;
import com.makebono.javaplayland.tools.entities.interfaces.BonoFunctionalInterface;
import com.makebono.javaplayland.tools.entities.interfaces.NonParameterizedMethodInterface;

/** 
 * @ClassName: LambdaDemo 
 * @Description: Demo for Lambda expressions
 * @author makebono
 * @date 2018年1月23日 下午3:13:21 
 *  
 */
public class LambdaDemo {
    public static void show() {
        synchronized (System.out) {
            System.out.print("Implementing BiFunction interface:\n    ");
            // Lambda expression could only be apply to @FunctionalInterface, another good example is the Runnable
            // interface.
            final BiFunction<Integer, Integer, Integer> lambdaAddition = (x, y) -> {
                return x + y;
            };

            System.out.println("15 + 20 = " + lambdaAddition.apply(15, 20));

            // Start a new thread by 'lambda' its Runnable method.
            new Thread(() -> {
                System.out.println(
                        "\nStarting new thread. Because I locked the System.out, this will not be executed until others done their works.");
            }).start();

            System.out.print("\nImplementing self-defined parameterized functional interface:\n    ");
            // Implements a self-defined functional interface
            final BonoFunctionalInterface bfi = (x, y) -> {
                System.out.println(x + " from " + y + ".");
            };

            bfi.bo("Akebono", "the 7th destroyer squad");

            System.out.print("\nImplementing self-defined non-parameterized functional interface:\n    ");
            // () for non parameterized method
            final NonParameterizedMethodInterface npi = () -> {
                System.out.println("I don't take parameters.");
            };

            npi.play();

            System.out.print("\nLambda expression in Collection's forEach() method\n    ");
            // The most utilized method by lambda expression would be internal iteration (.forEach()) in Collections.
            final List<String> l = new LinkedList<String>();
            l.add("a");
            l.add("b");
            l.add("c");
            l.add("d");
            final String[] order = new String[] { "1st", "2nd", "3rd", "4th" };

            l.forEach(x -> {
                System.out.print(x + " is the " + order[l.indexOf(x)] + " letter in the alphabet.\n    ");
            });

            System.out.println("\nArray sorting by lambda expression for comparable class.");
            // Use lambda expression for sorting arrays.
            Destroyer[] destroyer = new Destroyer[] { new Destroyer(4, "Inazuma", "Special Type-III class"),
                    new Destroyer(1, "Akatsuki", "Special Type-III class"),
                    new Destroyer(3, "Ikazuchi", "Special Type-III class"),
                    new Destroyer(2, "Hibiki", "Special Type-III class") };

            System.out.println("Array before sorting:\n    " + Arrays.toString(destroyer));
            Arrays.sort(destroyer, Destroyer::compareTo);
            System.out.println("Array after sorting:\n    " + Arrays.toString(destroyer));

            System.out.println("\nArray sorting by lambda expression with anonymous method.");
            destroyer = new Destroyer[] { new Destroyer(4, "Inazuma", "Special Type-III class"),
                    new Destroyer(1, "Akatsuki", "Special Type-III class"),
                    new Destroyer(3, "Ikazuchi", "Special Type-III class"),
                    new Destroyer(2, "Hibiki", "Special Type-III class") };
            // Below is doing same thing as above, but using a anonymous method.
            System.out.println("Array before sorting:\n    " + Arrays.toString(destroyer));

            Arrays.sort(destroyer, (x, y) -> {
                if (x.getHullNo() > y.getHullNo()) {
                    return 1;
                }
                if (x.getHullNo() < y.getHullNo()) {
                    return -1;
                }
                return 0;
            });
            System.out.println("Array after sorting:\n    " + Arrays.toString(destroyer));

            System.out.print(
                    "\nUse Predicate generating method to .test() a condition.\n    Is Akatsuki the named ship? - ");
            // Boolean test on Predicate
            System.out.println(Destroyer.isLeadShip().test(new Destroyer(1, "Akatsuki", "Special Type-III class")));

            System.out.print("\nUse predicate for Stream.filter(Predicate predicate)\n    ");
            // Stream.filter(Predicate predicate).
            final Stream<Destroyer> stream = Stream.of(new Destroyer(2, "Shikinami", "Special Type-II class"),
                    new Destroyer(1, "Akatsuki", "Special Type-III class"),
                    new Destroyer(3, "Ikazuchi", "Special Type-III class"),
                    new Destroyer(2, "Teruzuki", "Akizuki class"), new Destroyer(5, "Satsuki", "Mutsuki class"),
                    new Destroyer(1, "Shimakaze", "Shimakaze (C) class"),
                    new Destroyer(3, "Ikazuchi", "Special Type-III class"),
                    new Destroyer(1, "Fubuki", "Special Type-I class"));

            stream.filter(Destroyer.isLeadShip()).forEach(x -> System.out.print(x + "\n    "));

            // Lambda way to invoke a method, used above in the sorting part but it would be nice to list it out clearly
            // here.
            final Destroyer kamikaze = new Destroyer(1, "Kamikaze", "Kamikaze class");
            final Function<Destroyer, String> getName = Destroyer::getName;
            System.out.println("\nUse lambda expression to invoke method\n    " + getName.apply(kamikaze));
        }
    }
}