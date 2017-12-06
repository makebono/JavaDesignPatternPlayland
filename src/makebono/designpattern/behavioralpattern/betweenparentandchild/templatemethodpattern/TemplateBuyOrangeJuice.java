package makebono.designpattern.behavioralpattern.betweenparentandchild.templatemethodpattern;

import makebono.designpattern.behavioralpattern.betweenparentandchild.templatemethodpattern.abstracttemplate.VendingTemplate;
import makebono.designpattern.tools.entities.OrangeJuice;
import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: TemplateBuyOrangeJuice 
 * @Description: Template method pattern implementation
 * @author makebono
 * @date 2017年12月6日 上午10:31:40 
 *  
 */
public class TemplateBuyOrangeJuice extends VendingTemplate {

    @Override
    public Juice buy() {
        return new OrangeJuice();
    }

}
