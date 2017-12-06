/**Note:
 * Adapter pattern extends ultilities to an already existing interface without modifying it. In this particular case
 * a new method taste() is extended to Juice interface. 
 */
package makebono.designpattern.structuralpattern.adapterpattern.adapterinterface;

/** 
 * @ClassName: AdaptiveJuicePackage 
 * @Description: Interface for adapter pattern
 * @author makebono
 * @date 2017年12月5日 下午4:21:33 
 *  
 */
public interface AdaptiveJuicePackage {
    String type();

    String taste();
}
