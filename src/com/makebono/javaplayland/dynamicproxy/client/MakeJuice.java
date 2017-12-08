package com.makebono.javaplayland.dynamicproxy.client;

import java.lang.reflect.Proxy;

import com.makebono.javaplayland.dynamicproxy.juicerserviceimplement.BonoJuicer;
import com.makebono.javaplayland.dynamicproxy.juicerserviceinterface.Juicer;
import com.makebono.javaplayland.dynamicproxy.proxy.ProxyService;

/** 
 * @ClassName: MakeJuice 
 * @Description: Do the proxy call here. A client role.
 * @author makebono
 * @date 2017年12月8日 上午10:14:02 
 *  
 */
public class MakeJuice {
    public static void make(final String ingredient) throws InstantiationException, IllegalAccessException {
        final Juicer juicer = new BonoJuicer();

        // A simple reflection here.
        final ProxyService proxy = ProxyService.class.newInstance();
        proxy.init((BonoJuicer) juicer);

        // Remember these parameters..
        final Juicer newJuice = (Juicer) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                juicer.getClass().getInterfaces(), proxy);

        // Notice the class name of Juicer won't be Juicer now. Since you are using the dynamic proxy call.
        System.out.println(newJuice.getClass().getSimpleName());

        // Call the method from Juicer interface.
        System.out.println(newJuice.makeJuice(ingredient).type());
    }
}
