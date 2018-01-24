/**Note:
 * Flyweight pattern shares existing object, which means it will make new object only if no more object "in stock".
 * This will save memory for over-instantiating new objects again and again.
 * In this particular case, object(juice) will be consumed after been ordered, but it depends on the situation. 
 * Maybe in other case object will not be consumed so it can be re-used rather than instantiating new.
 */
package com.makebono.javaplayland.designpattern.structuralpattern.flyweightpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.makebono.javaplayland.tools.entities.AppleJuice;
import com.makebono.javaplayland.tools.entities.OrangeJuice;
import com.makebono.javaplayland.tools.entities.interfaces.Juice;

/** 
 * @ClassName: FlyweightJuiceFactory 
 * @Description: Flyweight juice factory
 * @author makebono
 * @date 2017年12月6日 上午9:10:19 
 *  
 */
public class FlyweightJuiceFactory {
    private static ArrayList<Juice> warehouse = new ArrayList<Juice>();
    private static Map<String, Integer> stock = new HashMap<String, Integer>();

    static {
        stock.put("OrangeJuice", 0);
        stock.put("AppleJuice", 0);
        produceAppleJuice();
        produceAppleJuice();
        produceOrangeJuice();
        produceOrangeJuice();
    }

    public FlyweightJuiceFactory() {};

    public static void JuiceInStock() {
        System.out.println("Orange juice in stock: " + stock.get("OrangeJuice") + ".\nApple juice in stock: "
                + stock.get("AppleJuice") + ".");
    }

    public static Juice orderOrangeJuice() {
        final int orangeJuiceInStock = stock.get("OrangeJuice");
        if (orangeJuiceInStock > 0) {
            System.out.println(
                    "Orange juice you order is in stock! Currently has: " + orangeJuiceInStock + " remaining.");
            return shipOrangeJuice();
        } else {
            produceOrangeJuice();
            System.out.println("Orange juice you order is not in stock! Currently has: " + orangeJuiceInStock
                    + " remaining.\nBut it is produced and delivering to your door.");
            return shipOrangeJuice();
        }
    }

    public static Juice orderAppleJuice() {
        final int appleJuiceInStock = stock.get("AppleJuice");
        if (appleJuiceInStock > 0) {
            System.out
                    .println("Apple juice you order is in stock! Currently has: " + appleJuiceInStock + " remaining.");
            return shipAppleJuice();
        } else {
            produceAppleJuice();
            System.out.println("Apple juice you order is not in stock! Currently has: " + appleJuiceInStock
                    + " remaining.\nBut it is produced and delivering to your door.");
            return shipAppleJuice();
        }
    }

    private static Juice shipOrangeJuice() {
        int orangeJuiceInStock = stock.get("OrangeJuice");
        for (final Juice cursor : warehouse) {
            if (cursor.getClass().getName().equals("makebono.designpattern.tools.entities.OrangeJuice")) {
                warehouse.remove(cursor);
                orangeJuiceInStock--;
                updateStock("OrangeJuice", orangeJuiceInStock);
                return cursor;
            }
        }
        System.out.println("No more orange juice in stock!");
        return null;
    }

    private static Juice shipAppleJuice() {
        int appleJuiceInStock = stock.get("AppleJuice");
        if (appleJuiceInStock > 0) {
            for (final Juice cursor : warehouse) {
                if (cursor.getClass().getName().equals("makebono.designpattern.tools.entities.AppleJuice")) {
                    warehouse.remove(cursor);
                    appleJuiceInStock--;
                    updateStock("AppleJuice", appleJuiceInStock);
                    return cursor;
                }
            }
        }
        System.out.println("No more apple juice in stock!");
        return null;
    }

    private static void produceOrangeJuice() {
        System.out.println("Producing orange juice.");
        warehouse.add(new OrangeJuice());
        final int orangeJuiceInStock = stock.get("OrangeJuice") + 1;
        updateStock("OrangeJuice", orangeJuiceInStock);
    }

    private static void produceAppleJuice() {
        System.out.println("Producing apple juice.");
        warehouse.add(new AppleJuice());
        final int appleJuiceInStock = stock.get("AppleJuice") + 1;
        updateStock("AppleJuice", appleJuiceInStock);
    }

    private static void updateStock(final String juice, final int amount) {
        stock.put(juice, amount);
    }
}
