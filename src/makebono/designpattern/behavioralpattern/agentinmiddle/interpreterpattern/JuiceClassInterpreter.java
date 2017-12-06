/**Note:
 * Interpreter pattern, interpret something into something else. In this case, it reads a juice class and return its
 * name in natural English format.
 * 
 * For example:
 *     input: makebono.designpattern.tools.entities.AppleJuice
 *     expected output: Apple Juice
 */
package makebono.designpattern.behavioralpattern.agentinmiddle.interpreterpattern;

import makebono.designpattern.tools.entities.intefaces.Juice;

/** 
 * @ClassName: JuiceInterpreter 
 * @Description: Interpreter pattern
 * @author makebono
 * @date 2017年12月6日 下午3:52:58 
 *  
 */
public class JuiceClassInterpreter {
    public String interpret(final Juice juice) {
        final String type = juice.getClass().getSimpleName();
        final int space = type.indexOf('J');
        return type.substring(0, space) + " " + type.substring(space);
    }
}
