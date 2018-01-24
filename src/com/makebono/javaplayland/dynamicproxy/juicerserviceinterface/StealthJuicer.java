package com.makebono.javaplayland.dynamicproxy.juicerserviceinterface;

import com.makebono.javaplayland.tools.entities.interfaces.Juice;

/** 
 * @ClassName: StealthJuicer 
 * @Description: Hide the implementation of method in this interface.
 * @author makebono
 * @date 2017年12月11日 上午10:17:47 
 *  
 */
public interface StealthJuicer {
    Juice makeJuice(String ingredient);
}
