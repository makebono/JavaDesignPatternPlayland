package com.makebono.javaplayland.enumeration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/** 
 * @ClassName: IowaClass
 * @Description: Enumeration show case
 * @author makebono
 * @date 2018年1月11日 上午10:55:36 
 *  
 */
public enum IowaClass {
    Iowa("BB-61") {
        @Override
        public void info() {
            super.info();
            this.launchedYear();
        }

        @Override
        public void launchedYear() {
            System.out.println(1942);
        }
    },
    NewJersey("BB-62") {
        @Override
        public void info() {
            super.info();
            this.launchedYear();
        }

        @Override
        public void launchedYear() {
            System.out.println(1942);
        }
    },
    Missouri("BB-63") {
        @Override
        public void info() {
            super.info();
            this.launchedYear();
        }

        @Override
        public void launchedYear() {
            System.out.println(1944);
        }
    },
    Wisconsin("BB-64") {
        @Override
        public void info() {
            super.info();
            this.launchedYear();
        }

        @Override
        public void launchedYear() {
            System.out.println(1943);
        }
    };

    private String hullNo;
    private static Map<String, IowaClass> lookUpTable = new HashMap<String, IowaClass>();

    // If enum has value, a constructor is needed.
    private IowaClass(final String hullNo) {
        this.hullNo = hullNo;
    }

    static {
        for (final IowaClass candidate : EnumSet.allOf(IowaClass.class)) {
            lookUpTable.put(candidate.hullNo, candidate);
        }
    }

    // Use hullNo to get Enum name.
    public static IowaClass getByHullNo(final String hullNo) {
        return lookUpTable.get(hullNo);
    }

    public String gethullNo() {
        return this.hullNo;
    }

    // Can override and define different method for each enumeration candidate.
    public void info() {
        System.out.print(this.gethullNo() + " " + this.name() + " ");
    }

    // Abstract method will do either.
    public abstract void launchedYear();
}
