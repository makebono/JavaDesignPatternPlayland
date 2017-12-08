/**Note:
 * Save status to memento, and read the memento anytime to restore the saved status.
 */
package com.makebono.javaplayland.designpattern.behavioralpattern.statusofobject.mementopattern;

import java.util.ArrayList;

import com.makebono.javaplayland.tools.entities.intefaces.Juice;

/** 
 * @ClassName: Cart 
 * @Description: Cart with juice
 * @author makebono
 * @date 2017年12月6日 下午2:22:31 
 *  
 */
public class Cart {
    private ArrayList<Juice> items = new ArrayList<Juice>();

    public void add(final Juice juice) {
        items.add(juice);
    }

    public void remove(final Juice juice) {
        items.remove(juice);
    }

    public void clear() {
        this.items.clear();
    }

    public Memento recordStatus() {
        return new Memento(this);
    }

    public ArrayList<Juice> getItems() {
        return this.items;
    }

    public void readFromMemento(final Memento memento) {
        this.items = memento.getRecord();
    }

    public void traverse() {
        for (final Juice cursor : this.items) {
            System.out.println(cursor.type());
        }
    }
}
