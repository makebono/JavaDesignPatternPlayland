package com.makebono.javaplayland.concurrency.basicmultithread.threads;

import com.makebono.javaplayland.concurrency.basicmultithread.runnerble.SallyBono;

/** 
 * @ClassName: BunchOfThreads 
 * @Description: Several threads run at same time. 
 * @author makebono
 * @date 2017年12月11日 下午5:45:12 
 *  
 */
public class BunchOfThreads {
    // Seems randomly assigns threads to different cpu cores. Every time gives different order and different count-down
    // per run.
    public static void call(final int countDown, final int threads) {
        for (int i = 0; i < countDown; i++) {
            new Thread(new SallyBono(countDown)).start();
        }
        System.out.println("Go Go Bono");
    }
}
