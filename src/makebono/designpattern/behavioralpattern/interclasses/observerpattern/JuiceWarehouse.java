/**Note:
 * Observer pattern has subjects and observer. Subject has responsibilities to notify the changes to observer.
 * Observer has responsibilities to observe the changes. 
 */
package makebono.designpattern.behavioralpattern.interclasses.observerpattern;

import java.util.ArrayList;

import makebono.designpattern.behavioralpattern.interclasses.observerpattern.observer.AppleJuiceInspector;
import makebono.designpattern.behavioralpattern.interclasses.observerpattern.observer.OrangeJuiceInspector;
import makebono.designpattern.behavioralpattern.interclasses.observerpattern.observerinterface.StockInspector;

/** 
 * @ClassName: JuiceWarehouse 
 * @Description: Observer pattern, this is a subject that updates stock condition, notifies observer.
 * @author makebono
 * @date 2017年12月6日 上午10:56:39 
 *  
 */
public class JuiceWarehouse {
    private static ArrayList<StockInspector> observer = new ArrayList<StockInspector>();
    static {
        observer.add(new OrangeJuiceInspector());
        observer.add(new AppleJuiceInspector());
    }

    public JuiceWarehouse() {}

    public void update(final String type) {
        notify(type);
    }

    private void notify(final String type) {
        if (type.equals("OrangeJuice")) {
            for (final StockInspector inspector : observer) {
                if (inspector.getType().equals("OrangeJuiceInspector")) {
                    inspector.observe();
                }
            }
        } else if (type.equals("AppleJuice")) {
            for (final StockInspector inspector : observer) {
                if (inspector.getType().equals("AppleJuiceInspector")) {
                    inspector.observe();
                }
            }
        } else {}
    }
}
