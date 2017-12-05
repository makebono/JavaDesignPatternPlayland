package makebono.designpattern.structuralpattern.bridgepattern;

import makebono.designpattern.structuralpattern.bridgepattern.abstractbridge.AbstractBridge;

/** 
 * @ClassName: JuiceBridge 
 * @Description: Bridge pattern
 * @author makebono
 * @date 2017年12月5日 下午5:44:27 
 *  
 */
public class JuiceBridge extends AbstractBridge {
    @Override
    public String type() {
        return this.getJuice().type();
    }
}
