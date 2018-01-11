package com.makebono.javaplayland.reflection;

import com.makebono.javaplayland.reflection.utils.BonoEqualityCheckable;

/** 
 * @ClassName: EqualityCheckableDemo 
 * @Description: Demo for equality checking
 * @author makebono
 * @date 2018年1月11日 上午11:04:57 
 *  
 */
public class EqualityCheckableDemo {
    public static void show() {
        final aa a1 = new aa("123", "123");
        final aa a2 = new aa("123", "123");

        // false
        System.out.println(
                "Two object in same class with same field names/values but not extending customized equality checking class:\n    "
                        + a1.equals(a2) + "\n");

        final aaa a3 = new aaa("123", "123");
        final aaa a4 = new aaa("123", "123");

        // true
        System.out
                .println("Two object in same class extended equality checking class with same field names/values:\n    "
                        + a3.equals(a4) + "\n");

        final aaa a5 = new aaa("123", "123");
        final bbb a6 = new bbb("123", "123");
        // true
        System.out.println(
                "Two object in different class, both extended equality checking class with same field names/values:\n    "
                        + a5.equals(a6) + "\n");

        final a a7 = new a();
        final a a8 = new a();

        // true for 0-field class. Empty boxes considered to be same.
        System.out.println("Two object same empty class:\n    " + a7.equals(a8) + "\n");

        final aaa a9 = new aaa("123", "123");
        final aaa a10 = new aaa("123", "122");

        // true
        System.out.println(
                "Two object in same class extended equality checking class with same field names, different values:\n    "
                        + a9.equals(a10) + "\n");

        final aaa a11 = new aaa("123", "123");
        final bbb a12 = new bbb("113", "123");
        // true
        System.out.println(
                "Two object in different class, both extended equality checking class with same field names, different values:\n    "
                        + a11.equals(a12) + "\n");

        final aaa a13 = new aaa("123", "123");
        final ccc a14 = new ccc("123", "123");
        // true
        System.out.println(
                "Two object in different class, both extended equality checking class with different field names, same values:\n    "
                        + a13.equals(a14) + "\n");

    }
}

class aaa extends BonoEqualityCheckable {
    String a;
    String b;

    public aaa(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
}

class aa {
    String b;
    String a;

    public aa(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
}

class bbb extends BonoEqualityCheckable {
    String a;
    String b;

    public bbb(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
}

class ccc extends BonoEqualityCheckable {
    String a;
    String c;

    public ccc(final String a, final String c) {
        this.a = a;
        this.c = c;
    }
}

class a extends BonoEqualityCheckable {

}