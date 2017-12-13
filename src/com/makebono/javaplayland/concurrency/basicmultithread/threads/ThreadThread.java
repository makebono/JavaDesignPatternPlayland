package com.makebono.javaplayland.concurrency.basicmultithread.threads;

import com.makebono.javaplayland.concurrency.basicmultithread.runnerble.SallyBono;

/** 
 * @ClassName: ThreadThread 
 * @Description: A trivial thread acts thread-ly.
 * @author makebono
 * @date 2017年12月11日 下午5:34:36 
 *  
 */
public class ThreadThread {
    public static void call(final int countDown) {
        final Thread t = new Thread(new SallyBono(countDown));
        t.start();
        System.out.println("Go Go Bono");
    }
}
