package com.makebono.javaplayland.designpattern.behavioralpattern.betweenparentandchild.templatemethodpattern;

import com.makebono.javaplayland.designpattern.behavioralpattern.betweenparentandchild.templatemethodpattern.abstracttemplate.VendingTemplate;
import com.makebono.javaplayland.tools.entities.AppleJuice;
import com.makebono.javaplayland.tools.entities.interfaces.Juice;

/** 
 * @ClassName: TemplateBuyAppleJuice 
 * @Description: Template method pattern implementation
 * @author makebono
 * @date 2017年12月6日 上午10:31:40 
 *  
 */
public class TemplateBuyAppleJuice extends VendingTemplate {

    @Override
    public Juice buy() {
        return new AppleJuice();
    }

}
