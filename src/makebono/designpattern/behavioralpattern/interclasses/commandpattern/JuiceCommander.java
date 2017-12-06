/**Note:
 * In command pattern, typically there are two kinds of classes: commander and executor.
 * Commander gives order to executor and executor deal with it. Everyone only care about
 * its own duty.
 */
package makebono.designpattern.behavioralpattern.interclasses.commandpattern;

/** 
 * @ClassName: JuiceCommander 
 * @Description: Gives commands like a boss. 
 * @author makebono
 * @date 2017年12月6日 下午2:01:49 
 *  
 */
public class JuiceCommander {
    private final Executor executor;

    public JuiceCommander() {
        this.executor = new Executor();
    }

    public void commands(final String task) {
        System.out.println("Giving command, get a " + task + " for me");
        executor.deal(task);
    }
}
