package makebono.designpattern.behavioralpattern.interclasses.observerpattern.observer;

import makebono.designpattern.behavioralpattern.interclasses.observerpattern.observerinterface.StockInspector;

/** 
 * @ClassName: OrangeJuiceInspector 
 * @Description: Provides inspection on stock condition of orange juice
 * @author makebono
 * @date 2017年12月6日 上午10:53:00 
 *  
 */
public class AppleJuiceInspector implements StockInspector {
    @Override
    public void observe() {
        System.out.println("Apple juice inspector awares!");
    }

    @Override
    public String getType() {
        return "AppleJuiceInspector";
    }
}