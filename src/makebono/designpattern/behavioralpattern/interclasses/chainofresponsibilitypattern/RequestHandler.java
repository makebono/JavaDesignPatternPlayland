package makebono.designpattern.behavioralpattern.interclasses.chainofresponsibilitypattern;

/** 
 * @ClassName: RequestHandler 
 * @Description: Deal with it.
 * @author makebono
 * @date 2017年12月6日 下午1:39:46 
 *  
 */
public class RequestHandler {
    private String juiceForHandling = null;
    private final String name;
    private RequestHandler next;

    public RequestHandler(final String name, final String type) {
        this.next = null;
        this.name = name;
        if (type.equals("OrangeJuice")) {
            this.juiceForHandling = type;
        } else if (type.equals("AppleJuice")) {
            this.juiceForHandling = type;
        }
    }

    public void setNext(final RequestHandler next) {
        this.next = next;
    }

    public RequestHandler getNext() {
        return this.next;
    }

    public boolean hasNext() {
        return this.getNext() != null;
    }

    public boolean canHandle(final String type) {
        return this.juiceForHandling.equals(type) ? true : false;
    }

    @Override
    public String toString() {
        return "This is handler " + this.name + "(" + this.juiceForHandling + ").";
    }
}
