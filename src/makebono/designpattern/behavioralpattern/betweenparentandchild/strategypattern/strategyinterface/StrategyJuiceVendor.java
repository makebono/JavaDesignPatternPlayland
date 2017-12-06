package makebono.designpattern.behavioralpattern.betweenparentandchild.strategypattern.strategyinterface;

import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: StrategyJuiceVendor 
 * @Description: Strategy pattern interface
 * @author makebono
 * @date 2017年12月6日 上午10:07:39 
 *  
 */
public interface StrategyJuiceVendor {
    Juice buy(String type);
}
