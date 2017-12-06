package makebono.designpattern.behavioralpattern.interclasses.iteratorpattern.iterator;

import java.util.ArrayList;

import makebono.designpattern.behavioralpattern.interclasses.iteratorpattern.iteratorinterface.IteratorInterface;

/** 
 * @ClassName: Iterator 
 * @Description: Realized that I have not written this before. 
 * @author makebono
 * @date 2017年12月6日 上午11:29:37 
 *  
 */
public class MyIterator<T> implements IteratorInterface<T> {
    private ArrayList<T> list = new ArrayList<T>();
    private int cursorIndex;

    public MyIterator(final ArrayList<T> list) {
        this.list = list;
        cursorIndex = 0;
    }

    @Override
    public T first() {
        return this.list.get(0);
    }

    @Override
    public T next() {
        if (cursorIndex < this.list.size()) {
            return this.list.get(cursorIndex++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (cursorIndex == this.list.size()) {
            return false;
        }
        return true;
    }

    @Override
    public T cursor() {
        return this.list.get(cursorIndex);
    }
}
