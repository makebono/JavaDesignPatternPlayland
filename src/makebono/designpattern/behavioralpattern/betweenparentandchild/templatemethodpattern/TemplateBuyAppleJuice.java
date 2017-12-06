package makebono.designpattern.behavioralpattern.betweenparentandchild.templatemethodpattern;

import makebono.designpattern.behavioralpattern.betweenparentandchild.templatemethodpattern.abstracttemplate.VendingTemplate;
import makebono.designpattern.tools.entities.AppleJuice;
import makebono.designpattern.tools.entities.intefaces.Juice;

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
