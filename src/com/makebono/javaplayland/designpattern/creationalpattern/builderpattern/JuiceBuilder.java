/**Note:
 * Difference from factory pattern: builder creates multiple objects into one object, it can build a complicated customized object. 
 * As for here, it's a list contains multiple juices, this could be change any way depends on requirement. 
 */
package com.makebono.javaplayland.designpattern.creationalpattern.builderpattern;

import java.util.ArrayList;

import com.makebono.javaplayland.tools.entities.AppleJuice;
import com.makebono.javaplayland.tools.entities.OrangeJuice;
import com.makebono.javaplayland.tools.entities.intefaces.Juice;

/** 
 * @ClassName: JuiceBuilder 
 * @Description: Builder pattern
 * @author makebono
 * @date 2017年12月5日 下午2:14:07 
 *  
 */
public class JuiceBuilder {
    private final ArrayList<Juice> appleJuice = new ArrayList<Juice>();
    private final ArrayList<Juice> orangeJuice = new ArrayList<Juice>();

    public void produceOrangeJuice(final int cups) {
        for (int i = 0; i < cups; i++) {
            this.orangeJuice.add(new OrangeJuice());
        }
    }

    public void produceAppleJuice(final int cups) {
        for (int i = 0; i < cups; i++) {
            this.appleJuice.add(new AppleJuice());
        }
    }

    public ArrayList<Juice> getOrangeJuice() {
        return this.orangeJuice;
    }

    public ArrayList<Juice> getAppleJuice() {
        return this.appleJuice;
    }
}
