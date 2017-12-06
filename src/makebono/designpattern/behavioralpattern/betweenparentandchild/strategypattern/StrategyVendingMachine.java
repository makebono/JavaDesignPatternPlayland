/**Note:
 * Strategy pattern offer same interface to different consumer, but gives different algorithm/method to them depends
 * on what they need. In this case, two private class offer different Juices return relies on input String. 
 */
package makebono.designpattern.behavioralpattern.betweenparentandchild.strategypattern;

import makebono.designpattern.behavioralpattern.betweenparentandchild.strategypattern.strategyinterface.StrategyJuiceVendor;
import makebono.designpattern.tools.entities.AppleJuice;
import makebono.designpattern.tools.entities.OrangeJuice;
import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: StrategyVendingMachine 
 * @Description: Strategy pattern implementation
 * @author makebono
 * @date 2017年12月6日 上午10:09:14 
 *  
 */
public class StrategyVendingMachine implements StrategyJuiceVendor {
    @Override
    public Juice buy(final String type) {
        if (type.equals("OrangeJuice")) {
            final OrangeJuiceOrder order = new OrangeJuiceOrder();
            return order.buy(type);
        } else if (type.equals("AppleJuice")) {
            final AppleJuiceOrder order = new AppleJuiceOrder();
            return order.buy(type);
        } else {
            System.out.println("We don't have that flavor. But whatsoever here an orange juice for ya!");
            final OrangeJuiceOrder order = new OrangeJuiceOrder();
            return order.buy("OrangeJuice");
        }
    }
}

class OrangeJuiceOrder implements StrategyJuiceVendor {
    @Override
    public Juice buy(final String type) {
        if (!type.equals("OrangeJuice")) {
            return null;
        }
        return new OrangeJuice();
    }
}

class AppleJuiceOrder implements StrategyJuiceVendor {
    @Override
    public Juice buy(final String type) {
        if (!type.equals("AppleJuice")) {
            return null;
        }
        return new AppleJuice();
    }
}