package makebono.designpattern.test;

import makebono.designpattern.behavioralpattern.agentinmiddle.interpreterpattern.JuiceClassInterpreter;
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
        final Juice j1 = new OrangeJuice();
        final Juice j2 = new AppleJuice();

        final JuiceClassInterpreter jci = new JuiceClassInterpreter();

        System.out.println(jci.interpret(j1));
        System.out.println(jci.interpret(j2));
    }
}
