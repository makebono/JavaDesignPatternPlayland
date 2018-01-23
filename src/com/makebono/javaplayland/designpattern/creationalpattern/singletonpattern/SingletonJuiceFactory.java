/**Note:
 * Obviously, the factory inside will only be instantiated during compilling since it's static. So this factory is unique.
 * It can be easily observed by following:
 *     final SingletonJuiceFactory sjf = new SingletonJuiceFactory();
 *     final SingletonJuiceFactory sjf2 = new SingletonJuiceFactory();        
 *     System.out.println(sjf.accessFactory() == sjf2.accessFactory());
 *  
 *  Ouput: true
 * 
 * So what does singleton pattern do is, to make sure an object's uniqueness. This unique object can only be created once
 * thus memory wasting on redundant instantiation would not happen. Sometime A object is perfect enough for using.
 */
package com.makebono.javaplayland.designpattern.creationalpattern.singletonpattern;

import com.makebono.javaplayland.tools.entities.AppleJuice;
import com.makebono.javaplayland.tools.entities.OrangeJuice;
import com.makebono.javaplayland.tools.entities.intefaces.Juice;

/** 
 * @ClassName: SingletonJuiceFactory 
 * @Description: This is the Alpha, this is the Omega. This is last JuiceFactory of its kind. This is the singleton pattern. 
 * @author makebono
 * @date 2017年12月5日 下午1:47:18 
 *  
 */
public class SingletonJuiceFactory {
    // An empty constructor blocks any attempt for creating new JuiceFactory. Important to has it.
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
