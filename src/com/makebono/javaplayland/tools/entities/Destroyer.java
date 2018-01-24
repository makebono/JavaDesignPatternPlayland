package com.makebono.javaplayland.tools.entities;

import java.util.function.Predicate;

/** 
 * @ClassName: Destroyer 
 * @Description: LJN Destroyer
 * @author makebono
 * @date 2018年1月24日 下午4:20:32 
 *  
 */
public class Destroyer implements Comparable<Destroyer> {
    private int hullNo;
    private String name;
    private String clazz;
    boolean translated = false;

    public Destroyer(final int hullNo, final String name, final String clazz) {
        this.hullNo = hullNo;
        this.name = name;
        this.clazz = clazz;
    }

    // Could be used in Stream.filter(Predicate predicate).
    public static Predicate<Destroyer> isLeadShip() {
        return x -> x.getHullNo() == 1;
    }

    public void setHullNo(final int hullNo) {
        this.hullNo = hullNo;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setClazz(final String clazz) {
        this.clazz = clazz;
    }

    public int getHullNo() {
        return hullNo;
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return this.clazz;
    }

    public void translate() {
        this.translated = true;
    }

    @Override
    public String toString() {
        return translated
                ? ("(帝国海軍" + this.clazz + "駆逐艦" + (this.hullNo == 1 ? ("旗") : (this.hullNo + "番艦") + this.name + ")"))
                : "(LJN destroyer, " + this.clazz
                        + (this.hullNo == 1 ? (". Class leader ") : (", Hull#" + this.hullNo + " ")) + this.name + ")";
    }

    @Override
    public int compareTo(final Destroyer o) {
        if (this.hullNo > o.hullNo) {
            return 1;
        } else if (this.hullNo < o.hullNo) {
            return -1;
        }
        return 0;
    }
}