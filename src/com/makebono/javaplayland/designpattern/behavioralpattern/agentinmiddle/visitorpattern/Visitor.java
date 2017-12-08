/**Note:
 * Visitors use visit() to visit some places(same data structure). And they may perform different reactions
 * depend on different place visiting. 
 */
package com.makebono.javaplayland.designpattern.behavioralpattern.agentinmiddle.visitorpattern;

/** 
 * @ClassName: Visitor 
 * @Description: Visitor
 * @author makebono
 * @date 2017年12月6日 下午3:04:52 
 *  
 */
public class Visitor {
    private final String name;

    public Visitor(final String name) {
        this.name = name;
    }

    public void visit(final PlaceForVisit place) {
        if (place.getName().equals("Marston's room")) {
            System.out.println(this.name + " refuses to visit " + place.getName()
                    + ". And yelling 'Kuso Marston!'. How rude, bad bad.");
        } else {
            System.out.println(this.name + " visiting " + place.getName() + ".");
        }
    }
}
