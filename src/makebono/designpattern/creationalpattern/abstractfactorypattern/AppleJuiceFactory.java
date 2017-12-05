package makebono.designpattern.creationalpattern.abstractfactorypattern;

import makebono.designpattern.creationalpattern.abstractfactorypattern.factoryinterface.AbstractJuiceFactory;
import makebono.designpattern.tools.entities.AppleJuice;
import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: AppleJuiceFactory 
 * @Description: AppleJuiceFactory 
 * @author makebono
 * @date 2017年12月5日 下午1:42:44 
 *  
 */
public class AppleJuiceFactory implements AbstractJuiceFactory {
    @Override
    public Juice produce() {
        return new AppleJuice();
    }
}
