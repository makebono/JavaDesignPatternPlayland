package com.makebono.javaplayland.concurrency.basicmultithread.runnerble;

/** 
 * @ClassName: SallyBono 
 * @Description: Bono marches ahead. Simply basic runnerble object.
 * @author makebono
 * @date 2017年12月8日 下午5:56:24 
 *  
 */
public class SallyBono implements Runnable {
    private final int countDown;

    public SallyBono(final int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {

    }
}
