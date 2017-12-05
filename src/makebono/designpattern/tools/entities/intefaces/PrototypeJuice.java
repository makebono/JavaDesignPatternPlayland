package makebono.designpattern.tools.entities.intefaces;

/** 
 * @ClassName: PrototypeJuice 
 * @Description: Prototype juice interface
 * @author makebono
 * @date 2017年12月5日 上午11:47:32 
 *  
 */
public interface PrototypeJuice extends Juice, Cloneable {
    Object clone() throws CloneNotSupportedException;
}
