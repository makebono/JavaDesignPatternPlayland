/**Note:
 * Adding new factory could be done by adding new classes implements this interface. In stead of 
 * modifying code inside the factory.
 */
package makebono.designpattern.creationalpattern.abstractfactorypattern.factoryinterface;

import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: AbstractJuiceFactory 
 * @Description: AbstractJuiceFactory
 * @author makebono
 * @date 2017年12月5日 下午1:36:49 
 *  
 */
public interface AbstractJuiceFactory {
    Juice produce();
}
