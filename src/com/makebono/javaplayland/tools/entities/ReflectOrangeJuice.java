package com.makebono.javaplayland.tools.entities;

/** 
 * @ClassName: ReflectOrangeJuice 
 * @Description: OrangeJuice for reflecting
 * @author makebono
 * @date 2017年12月8日 上午11:29:42 
 *  
 */
public class ReflectOrangeJuice extends OrangeJuice {
    private int amount;
    private String receiver;

    // Need to write down full Class name for reading parameter types when reflecting.
    public void init(final java.lang.Integer amount, final java.lang.String receiver) {
        this.amount = amount;
        this.receiver = receiver;
    }

    public void yell() {
        System.out.println(
                this.amount + " cup(s) of freshly squeezed orange juice for " + this.receiver + " from Marston!");
    }

    public void advertise(final java.lang.String word) {
        System.out.println("What a " + word + " cup of orange juice!");
    }
}
