package com.makebono.javaplayland.overridingandoverloading;

/** 
 * @ClassName: OverrideAndOverload 
 * @Description: A short note about Overriding and Overloading feature. In case I forget it.
 * @author makebono
 * @date 2018年2月2日 下午3:55:32 
 *  
 */
@SuppressWarnings(value = { "unused" })
public class OverrideAndOverload {

    public Integer doStuff(final int i) throws Exception {
        return i;
    }

    // To put it short, this is overloading. 2 methods with same name and take different arguments. It's legit.
    // Notice autoboxing between primitive and wrapper type is working here.
    public int doStuff(final long i) throws NullPointerException {
        return (int) i;
    }

    // But they must return same type. Below is not compilable.
    /*public long doStuff(int i){
        return (long)i;
    }*/

    // Overloading is done by changing argument type. Only changing thrown Exception type is not valid. But 2 overloaded
    // methods can have different thrown Exception types, or one throws Exception while the the other does not.
    // Below is not compilable.
    /*public int doStuff(final int i) throws NullPointerException {
        return (int) i;
    }*/

    protected void doStuff2() {}

    private void dostuff3() {}

    public final void doStuff4() {}

}

class babyClass extends OverrideAndOverload {
    // Overriding method cannot return super class to overriden method's return type. But it's not visa versa, which
    // means overriding method can return child-class to the return type of the overriden method.
    /*public Number doStuff(int i){
        return i;
    }*/

    // Likes overloading, it is valid for overriding method to not throw Exception while overriden method does. And it
    // can throw child-class-Exception to its overriden method, but it cannot throw super-class-Exception of the
    // overriden method.
    @Override
    public Integer doStuff(final int i) throws IllegalArgumentException /*throws Throwable*/ {
        return i;
    }

    // Overriding method cannot reduce the access scope of the original method.
    // privite void doStuff2(){}

    // But it's okay to widen the access scope, like below
    @Override
    public void doStuff2() {}

    // Simply enough, private method cannot be overriden. It is possible to have method in child class with same name as
    // private method in super class, but they are totally different thing.
    public void doStuff3() {}

    // static and final method blocks overriding.
    // public void doStuff4() {}
}
