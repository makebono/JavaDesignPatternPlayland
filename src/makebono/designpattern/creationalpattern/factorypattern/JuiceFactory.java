/**Note:
 * Factory pattern provides a factory to instantiate new objects.
 */
package makebono.designpattern.creationalpattern.factorypattern;

import makebono.designpattern.tools.entities.AppleJuice;
import makebono.designpattern.tools.entities.OrangeJuice;
import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: JuiceFactory 
 * @Description: Produce juice. Trivial factory pattern.
 * @author makebono
 * @date 2017年12月5日 上午11:52:58 
 *  
 */
public class JuiceFactory {
    public static Juice produceOrangeJuice() {
        return new OrangeJuice();
    }

    public static Juice produceAppleJuice() {
        return new AppleJuice();
    }
}
