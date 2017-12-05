package makebono.designpattern.creationalpattern.abstractfactorypattern;

import makebono.designpattern.creationalpattern.abstractfactorypattern.factoryinterface.AbstractJuiceFactory;
import makebono.designpattern.tools.entities.OrangeJuice;
import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: OrangeJuiceFactory 
 * @Description: OrangeJuiceFactory 
 * @author makebono
 * @date 2017年12月5日 下午1:42:44 
 *  
 */
public class OrangeJuiceFactory implements AbstractJuiceFactory {
    @Override
    public Juice produce() {
        return new OrangeJuice();
    }
}
