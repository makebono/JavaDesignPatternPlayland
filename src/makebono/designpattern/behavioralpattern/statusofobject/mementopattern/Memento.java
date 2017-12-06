package makebono.designpattern.behavioralpattern.statusofobject.mementopattern;

import java.util.ArrayList;

import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: Memento 
 * @Description: Memento saves the status of Cart while being called.
 * @author makebono
 * @date 2017年12月6日 下午2:27:00 
 *  
 */
@SuppressWarnings("unchecked")
public class Memento {
    private ArrayList<Juice> record;

    public Memento(final Cart cart) {
        this.record = (ArrayList<Juice>) cart.getItems().clone();
    }

    public ArrayList<Juice> getRecord() {
        return this.record;
    }

    public void setRecord(final ArrayList<Juice> record) {
        this.record = record;
    }
}
