package makebono.designpattern.behavioralpattern.agentinmiddle.visitorpattern;

/** 
 * @ClassName: PlaceForVisit 
 * @Description: Visitor pattern, a place accepts visitor to visite.
 * @author makebono
 * @date 2017年12月6日 下午3:03:48 
 *  
 */
public class PlaceForVisit {
    private final String name;

    public PlaceForVisit(final String name) {
        this.name = name;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return this.name;
    }
}
