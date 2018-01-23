/**Note:
 * Decorator pattern would keep the original Interface as well as adding new utility to the methods under that
 * interface.
 */
package com.makebono.javaplayland.designpattern.structuralpattern.decoratorpattern;

import com.makebono.javaplayland.tools.entities.intefaces.Juice;

/** 
 * @ClassName: GreatValueJuice 
 * @Description: Decorator pattern
 * @author makebono
 * @date 2017年12月5日 下午4:43:52 
 *  
 */
public class GreatValueJuice implements Juice {
    private final Juice juice;

    public GreatValueJuice(final Juice juice) {
        this.juice = juice;
    }

    @Override
    public String type() {
        final StringBuilder sb = new StringBuilder();

        sb.append("I am a Great Value ");
        final String type = this.juice.getClass().getSimpleName();
        final int space = type.indexOf('J');
        sb.append(type.substring(0, space) + " " + type.substring(space) + "\n");
        sb.append(this.juice.type());
        sb.append("\nI am great and cheap");
        return sb.toString();
    }

    @Override
    public void init() {}
}
