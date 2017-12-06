/**Note:
 * Iterator pattern provide a way to traverse a collection of something. Without exposing its inner representation.
 * A black box traversal as I prefer to say that.
 */
package makebono.designpattern.behavioralpattern.interclasses.iteratorpattern;

import java.util.ArrayList;

import makebono.designpattern.behavioralpattern.interclasses.iteratorpattern.iterator.MyIterator;
import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: JuiceCollection 
 * @Description: Iterator pattern
 * @author makebono
 * @date 2017年12月6日 上午11:24:12 
 *  
 */
public class JuiceCollection {
    private final ArrayList<Juice> juices;
    private final MyIterator<Juice> iterator;

    public JuiceCollection(final ArrayList<Juice> juices) {
        this.juices = juices;
        this.iterator = new MyIterator<Juice>(this.juices);
    }

    public Juice getFirst() {
        return this.iterator.first();
    }

    public Juice getNext() {
        return this.iterator.next();
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public Juice getCurrent() {
        return this.iterator.cursor();
    }

    public void traverse() {
        while (this.hasNext()) {
            System.out.println(this.getNext().type());
        }
    }
}
