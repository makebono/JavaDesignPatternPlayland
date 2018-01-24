/**Note:
 * Straight forward pattern. Method varies depending on changing state. 
 * In this situation, a juice vendor has 2 states, one for orange and one for apple.
 */
package com.makebono.javaplayland.designpattern.behavioralpattern.statusofobject.statepattern;

import com.makebono.javaplayland.tools.entities.AppleJuice;
import com.makebono.javaplayland.tools.entities.OrangeJuice;
import com.makebono.javaplayland.tools.entities.interfaces.Juice;

/** 
 * @ClassName: JuiceSwitchingVendor 
 * @Description: State pattern. 
 * @author makebono
 * @date 2017年12月6日 下午2:46:11 
 *  
 */
public class JuiceSwitchingVendor {
    public String state = "";

    public void changeState(final String state) {
        this.state = state;
    }

    public Juice buy() {
        if (this.state.equals("OrangeJuice")) {
            return Switch.orangeState();
        } else if (this.state.equals("AppleJuice")) {
            return Switch.appleState();
        } else {
            System.out.println("State not exists or no state set yet! But here's an orange juice!");
            return Switch.orangeState();
        }
    }
}

class Switch {
    public static Juice orangeState() {
        return new OrangeJuice();
    }

    public static Juice appleState() {
        return new AppleJuice();
    }
}
