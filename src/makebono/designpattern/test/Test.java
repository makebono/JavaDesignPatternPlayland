package makebono.designpattern.test;

import makebono.designpattern.behavioralpattern.agentinmiddle.mediatorpattern.JuiceMixer;
import makebono.designpattern.structuralpattern.decoratorpattern.GreatValueJuice;
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
    public static void main(final String[] args)
            throws CloneNotSupportedException, InstantiationException, IllegalAccessException {
        final Juice j1 = new OrangeJuice();
        final Juice j2 = new AppleJuice();
        final Juice j3 = new OrangeJuice();
        final Juice j4 = new OrangeJuice();
        final Juice j5 = new OrangeJuice();
        final Juice j6 = new AppleJuice();

        final JuiceMixer jm = new JuiceMixer(j1, j2, j3, j4, j5, j6);
        jm.mix();

        final GreatValueJuice gvj = new GreatValueJuice(j1);

        System.out.println(gvj.type());

    }
}
