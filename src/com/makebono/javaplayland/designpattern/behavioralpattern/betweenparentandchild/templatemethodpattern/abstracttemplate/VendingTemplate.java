/**Note:
 * Template method pattern. Abstract template class offers abstract methods for its subclass to modify depends on
 * different requirements. And it (may) gives non-abstract methods for its subclass to call as well. 
 * It's as easy as ABC but again, remember abstract class cannot be instantiated. 
 */
package com.makebono.javaplayland.designpattern.behavioralpattern.betweenparentandchild.templatemethodpattern.abstracttemplate;

import com.makebono.javaplayland.tools.entities.interfaces.Juice;

/** 
 * @ClassName: VendingTemplate 
 * @Description: Abstract template of template method pattern
 * @author makebono
 * @date 2017年12月6日 上午10:25:41 
 *  
 */
public abstract class VendingTemplate {
    public void Advertise() {
        System.out.println("Killer vending machine is so awesome, it takes no prisoner!");
    }

    abstract public Juice buy();
}
