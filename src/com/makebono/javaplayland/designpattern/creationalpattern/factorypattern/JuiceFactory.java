/**Note:
 * Factory pattern provides a factory to instantiate new objects.
 */
package com.makebono.javaplayland.designpattern.creationalpattern.factorypattern;

import com.makebono.javaplayland.tools.entities.AppleJuice;
import com.makebono.javaplayland.tools.entities.OrangeJuice;
import com.makebono.javaplayland.tools.entities.intefaces.Juice;

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
