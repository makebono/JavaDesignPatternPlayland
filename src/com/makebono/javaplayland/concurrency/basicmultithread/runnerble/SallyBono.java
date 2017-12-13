package com.makebono.javaplayland.concurrency.basicmultithread.runnerble;

/** 
 * @ClassName: SallyBono 
 * @Description: Bono marches ahead. Simply basic runnerble object.
 * @author makebono
 * @date 2017年12月8日 下午5:56:24 
 *  
 */
public class SallyBono implements Runnable {
    private int countDown;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public SallyBono(final int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (this.countDown >= 0) {
            System.out.print(" Bono#" + this.id + "(" + this.countDown-- + ") ");
        }
        System.out.println("\nSuper star destroyer Bono-chan#" + this.id + " weigh anchor!");
    }
}
