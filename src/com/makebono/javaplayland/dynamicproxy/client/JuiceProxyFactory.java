package com.makebono.javaplayland.dynamicproxy.client;

import java.lang.reflect.Proxy;

import com.makebono.javaplayland.dynamicproxy.juicerserviceimplement.BonoJuicer;
import com.makebono.javaplayland.dynamicproxy.juicerserviceinterface.Juicer;
import com.makebono.javaplayland.dynamicproxy.juicerserviceinterface.StealthJuicer;
import com.makebono.javaplayland.dynamicproxy.proxy.ProxyService;

/** 
 * @ClassName: JuiceProxyFactory 
 * @Description: Do the proxy calls here. A proxy factory.
 * @author makebono
 * @date 2017年12月8日 上午10:14:02 
 *  
 */
public class JuiceProxyFactory {
    public static void make(final String ingredient) throws InstantiationException, IllegalAccessException {
        final Juicer juicer = new BonoJuicer();

        // A simple reflection here.
        final ProxyService proxy = ProxyService.class.newInstance();

        // Actually don't even need to initialize the proxy.
        // proxy.init((BonoJuicer) juicer);

        // newProxyInstance will get all the job done. As long as you have well defined them in the invoke() method and
        // relative methods.
        // Remember format of these parameters..
        // It needs ClassLoader of your proxy, interface of the class you giving proxy to, and a reference of your
        // proxy.
        final Juicer newJuice = (Juicer) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                juicer.getClass().getInterfaces(), proxy);

        // Notice the class name of Juicer won't be Juicer now. Since you are using the dynamic proxy call.
        System.out.println(newJuice.getClass().getSimpleName());

        // Call the method from Juicer interface.
        System.out.println(newJuice.makeJuice(ingredient).type());
    }

    public static void stealthMake(final String ingredient) throws InstantiationException, IllegalAccessException {

        final ProxyService proxy = ProxyService.class.newInstance();

        // In normal case, StealthJuicer will not possibly be instantiated since it's only an interface without
        // implementation. But it could be instantiated by a newProxyInstance.
        final StealthJuicer newJuice = (StealthJuicer) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                new Class[] { StealthJuicer.class }, proxy);

        System.out.println(newJuice.getClass().getSimpleName());

        // Call the method from StealthJuicer interface. There is no direct implementation for this interface, since
        // it's hided by the ProxyService.
        System.out.println(newJuice.makeJuice(ingredient).type());
    }
}
