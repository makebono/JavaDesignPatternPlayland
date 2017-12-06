/**Note:
 * Bridge pattern means using one interface to manipulate different types of object from same interface. It decouples 
 * abstraction from implementation to give them independency from each other. For here, use setJuice to decide which 
 * object(type) to dealing with. 
 * 
 * Another example is JDBC connector using different drivers for different data bases.
 */
package makebono.designpattern.structuralpattern.bridgepattern.abstractbridge;

import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: AbstractBridge 
 * @Description: Abstract type of bridge
 * @author makebono
 * @date 2017年12月5日 下午5:42:07 
 *  
 */
public abstract class AbstractBridge {
    private Juice juice;

    public abstract String type();

    public Juice getJuice() {
        return this.juice;
    }

    public void setJuice(final Juice juice) {
        this.juice = juice;
    }
}
