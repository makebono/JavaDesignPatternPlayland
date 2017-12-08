package com.makebono.javaplayland.dynamicproxy.juicerserviceinterface;

import com.makebono.javaplayland.tools.entities.intefaces.Juice;

/** 
 * @ClassName: Juicer 
 * @Description: An interface for proxy handler calls.
 * @author makebono
 * @date 2017年12月8日 上午10:01:05 
 *  
 */
public interface Juicer {
    Juice makeJuice(String ingredient);
}
