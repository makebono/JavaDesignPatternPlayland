package makebono.designpattern.behavioralpattern.interclasses.iteratorpattern.iteratorinterface;

/** 
 * @ClassName: IteratorInterface 
 * @Description: Interface of iterator, nothing spectial
 * @author makebono
 * @date 2017年12月6日 上午11:27:05 
 *  
 */
public interface IteratorInterface<T> {
    T first();

    T next();

    boolean hasNext();

    T cursor();
}
