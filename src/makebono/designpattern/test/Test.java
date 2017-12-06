package makebono.designpattern.test;

import makebono.designpattern.behavioralpattern.interclasses.observerpattern.JuiceWarehouse;

/** 
 * @ClassName: Test 
 * @Description: Of course it's yet another test class, what else do you expect? 
 * @author makebono
 * @date 2017年12月5日 上午11:58:17 
 *  
 */
public class Test {
    public static void main(final String[] args) throws CloneNotSupportedException {
        final JuiceWarehouse jw = new JuiceWarehouse();
        jw.update("asd");
        jw.update("OrangeJuice");
        jw.update("AppleJuice");
        jw.update("OrangeJuice");
    }
}
