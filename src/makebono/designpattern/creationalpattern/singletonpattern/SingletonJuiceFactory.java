/**Note:
 * Obviously, the factory inside will only be instantiate during compilling since its static. So this factory is unique.
 * It can be easily observed by following:
 *     final SingletonJuiceFactory sjf = new SingletonJuiceFactory();
 *     final SingletonJuiceFactory sjf2 = new SingletonJuiceFactory();        
 *     System.out.println(sjf.accessFactory() == sjf2.accessFactory());
 *  
 *  Ouput: true
 */
package makebono.designpattern.creationalpattern.singletonpattern;

import makebono.designpattern.tools.entities.AppleJuice;
import makebono.designpattern.tools.entities.OrangeJuice;
import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: SingletonJuiceFactory 
 * @Description: This is the Alpha, this is the Omega. This is last JuiceFactory of its kind. 
 * @author makebono
 * @date 2017年12月5日 下午1:47:18 
 *  
 */
public class SingletonJuiceFactory {
    public SingletonJuiceFactory() {}

    private static class singletonjuicefactory {
        private static SingletonJuiceFactory factory = new SingletonJuiceFactory();
    }

    public static SingletonJuiceFactory accessFactory() {
        return singletonjuicefactory.factory;
    }

    public Object readResolve() {
        return SingletonJuiceFactory.accessFactory();
    }

    public Juice produceOrangeJuice() {
        return new OrangeJuice();
    }

    public Juice produceAppleJuice() {
        return new AppleJuice();
    }
}
