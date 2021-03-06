/**Note:
 * Gathering different interfaces/objects for more complicated 
 * combined interface/object.
 */
package com.makebono.javaplayland.designpattern.structuralpattern.facadepattern;

import com.makebono.javaplayland.tools.entities.AppleJuice;
import com.makebono.javaplayland.tools.entities.OrangeJuice;

/** 
 * @ClassName: BoxOfJuices 
 * @Description: Facade pattern
 * @author makebono
 * @date 2017年12月5日 下午5:21:26 
 *  
 */
public class BoxOfJuices {
    private final OrangeJuice orangeJuice;
    private final AppleJuice appleJuice;

    public BoxOfJuices() {
        this.orangeJuice = new OrangeJuice();
        this.appleJuice = new AppleJuice();
    }

    public void openBox() {
        System.out.println(this.orangeJuice.type());
        System.out.println(this.appleJuice.type());
    }

    public OrangeJuice getOrangeJuice() {
        return this.orangeJuice;
    }

    public AppleJuice getAppleJuice() {
        return this.appleJuice;
    }
}
