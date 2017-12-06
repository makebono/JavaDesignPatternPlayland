package makebono.designpattern.test;

import java.util.ArrayList;

import makebono.designpattern.behavioralpattern.interclasses.iteratorpattern.JuiceCollection;
import makebono.designpattern.tools.entities.AppleJuice;
import makebono.designpattern.tools.entities.OrangeJuice;
import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: Test 
 * @Description: Of course it's yet another test class, what else do you expect? 
 * @author makebono
 * @date 2017年12月5日 上午11:58:17 
 *  
 */
public class Test {
    public static void main(final String[] args) throws CloneNotSupportedException {
        final ArrayList<Juice> a = new ArrayList<Juice>();
        a.add(new OrangeJuice());
        a.add(new AppleJuice());
        a.add(new OrangeJuice());
        a.add(new AppleJuice());
        a.add(new AppleJuice());

        final JuiceCollection jc = new JuiceCollection(a);
        jc.traverse();
    }
}
