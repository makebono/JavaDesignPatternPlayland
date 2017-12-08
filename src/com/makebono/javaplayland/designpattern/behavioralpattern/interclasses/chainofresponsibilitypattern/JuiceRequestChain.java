/**Note:
 * Chain of responsibility pattern is like a linked list. Each handler (or any orther shit in structure) has
 * at most one successor. A work signed to them and be passed handler by handler along the chain, until found
 * the first handler which can deal with it, or claim fail if no handler could help.
 */
package com.makebono.javaplayland.designpattern.behavioralpattern.interclasses.chainofresponsibilitypattern;

/** 
 * @ClassName: JuiceRequestChain 
 * @Description: Chain of responsibility pattern. 
 * @author makebono
 * @date 2017年12月6日 下午1:36:39 
 *  
 */
public class JuiceRequestChain {
    private final String task;

    public JuiceRequestChain(final String task) {
        this.task = task;
    }

    public void request(final RequestHandler handler) {
        RequestHandler cursor = handler;
        System.out.println(cursor);
        boolean dealWithIt = cursor.canHandle(task);
        while (!dealWithIt && cursor.hasNext()) {
            cursor = cursor.getNext();
            System.out.println(cursor);
            dealWithIt = cursor.canHandle(task);
        }

        if (!dealWithIt) {
            System.out.println("No handler can deal with the requested juice.");
        } else {
            System.out.println("Deal with it.");
        }
    }
}
