/**Note:
 * Use method for accessing non-public inner classes. And use an instance of enclosing class to instantiate public inner
 * class. Remember public or not, there's no way to directly 'new' a inner class.
 * 
 * Instruction:
 *     final JuiceEX jex = new JuiceEX();
 *     final JuicePackage jp = jex.pack();
 *     final BrandTitle bt = jex.title();
 *     
 *     // final JuiceEX.info info = new JuiceEX.info(); <- Illegal.
 *     
 *     // Even for a public inner class, you have to instantiate it by a instance of the enclosing class like this.
 *     final JuiceEX.info info = jex.new info(); 
 *
 *     System.out.println(jex);
 *     System.out.println(jp.color());
 *     System.out.println(bt.font());
 *     info.printInfo();
 * 
 */
package com.makebono.javaplayland.innerclasstest;

import com.makebono.javaplayland.innerclasstest.testinterface.BrandTitle;
import com.makebono.javaplayland.innerclasstest.testinterface.JuicePackage;

/** 
 * @ClassName: JuiceEX 
 * @Description: Not quite familiar with inner class mechanism, test it here.
 * @author makebono
 * @date 2017年12月28日 下午5:42:42 
 *  
 */
public class JuiceEX {
    private class juicePackage implements JuicePackage {
        @Override
        public String color() {
            return new String("red");
        }
    }

    protected class juiceBrand implements BrandTitle {
        @Override
        public String font() {
            return new String("BJJ font");
        }
    }

    public class info {
        public void printInfo() {
            System.out.println("JuiceEX class for inner class testing.");
        }
    }

    public JuicePackage pack() {
        return new juicePackage();
    }

    public BrandTitle title() {
        return new juiceBrand();
    }
}
