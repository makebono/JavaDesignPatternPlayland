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

    public JuicePackage pack() {
        return new juicePackage();
    }

    public BrandTitle title() {
        return new juiceBrand();
    }
}
