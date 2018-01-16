/**Note:
 * Use method for accessing non-public inner classes. And use an instance of enclosing class to instantiate public inner
 * class. Remember public or not, there's no way to directly 'new' a inner class.
 * 
 * See the Demo class for further information. 
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
