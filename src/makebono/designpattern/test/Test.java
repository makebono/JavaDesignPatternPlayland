package makebono.designpattern.test;

import makebono.designpattern.structuralpattern.facadepattern.BoxOfJuices;

/** 
 * @ClassName: Test 
 * @Description: Of course it's yet another test class, what else do you expect? 
 * @author makebono
 * @date 2017年12月5日 上午11:58:17 
 *  
 */
public class Test {
    public static void main(final String[] args) throws CloneNotSupportedException {
        final BoxOfJuices boj = new BoxOfJuices();
        System.out.println(boj.getAppleJuice().getClass().getName());
        System.out.println(boj.getOrangeJuice().getClass().getName());
        boj.openBox();
    }
}
