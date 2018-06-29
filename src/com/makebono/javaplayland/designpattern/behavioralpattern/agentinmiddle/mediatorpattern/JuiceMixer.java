/**Note:
 * Mediator pattern. A mediator class provides manipulation/interaction on/between several different classes.
 */
package com.makebono.javaplayland.designpattern.behavioralpattern.agentinmiddle.mediatorpattern;

import java.util.ArrayList;

import com.makebono.javaplayland.tools.entities.interfaces.Juice;

/** 
 * @ClassName: JuiceMixer 
 * @Description: Mediator for mediator pattern.
 * @author makebono
 * @date 2017年12月6日 下午3:27:19 
 *  
 */
public class JuiceMixer {
    private final ArrayList<Juice> ingredients = new ArrayList<Juice>();

    public JuiceMixer(final Juice... juices) {
        for (final Juice cursor : juices) {
            this.ingredients.add(cursor);
        }
    }

    public void addIngredient(final Juice... juices) {
        for (final Juice cursor : juices) {
            this.ingredients.add(cursor);
        }
    }

    public void mix() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Making mixed juice:\n    ");

        Juice cursor = this.ingredients.get(0);
        String type = cursor.getClass().getSimpleName();
        int index = type.indexOf("J");
        sb.append(type.substring(0, index));

        for (int i = 1; i < this.ingredients.size(); i++) {
            cursor = this.ingredients.get(i);
            type = cursor.getClass().getSimpleName();
            index = type.indexOf("J");
            sb.append(" + " + type.substring(0, index));
        }

        sb.append("\nThere you go.");
        System.out.println(sb.toString());
    }
}
