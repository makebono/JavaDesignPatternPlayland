package com.makebono.javaplayland.dynamicproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.makebono.javaplayland.dynamicproxy.juicerserviceimplement.BonoJuicer;

/** 
 * @ClassName: ProxyService 
 * @Description: Proxy handler
 * @author makebono
 * @date 2017年12月8日 上午10:07:36 
 *  
 */
public class ProxyService implements InvocationHandler {
    private Object juice;

    /* Cannot have a constructor here if you want to use reflection to instantiate this.
    public ProxyService(final BonoJuicer juice) {
        this.juice = juice;
    }
    */

    public void init(final BonoJuicer juice) {
        this.juice = juice;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        if (this.juice instanceof BonoJuicer) {
            System.out.println("Proxy called!");
            return method.invoke(this.juice, args);
        } else {
            System.out.println("Stealth proxy called!");
            return new BonoJuicer().makeJuice((String) args[0]);
        }
    }
}
