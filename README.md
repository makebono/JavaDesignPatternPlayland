# JavaPlayland
This was only for design patterns. Now it is more than that. Some mechanisms I'm not quite
familiar with will be put in here. A big wonderland for studying.

# Design patterns:
Why does the term "23 types of design pattern" sound like an idol unit?

Anyway the pattern lays like below:

  -Creational pattern
  
    1. Factory pattern
    2. Abstract factory pattern
    3. Builder pattern
    4. Prototype pattern
    5. Singleton pattern
  
  -Structural pattern
  
    6. Adapter pattern
    7. Bridge pattern
    8. Composite pattern
    9. Decorator pattern
    10. Facade pattern
    11. Flyweight pattern
    12. Proxy pattern
  
  -Behavioral pattern
  
    I. "Agent in middle" -- Access object through some kind of agent, mediator, etc.
      13. Interpreter pattern
      14. Mediator pattern
      15. Visitor pattern
      
    II. "Between parent and child" -- Pattern deploys in hierarchically class structure.
      16. Strategy pattern
      17. Template method pattern
    
    III. "Inter-Classes" -- Pattern deploys between classes.
      18. Chain of responsibility pattern
      19. Command pattern
      20. Iterator pattern
      21. Observer pattern
    
    IV. "Status of object" -- Pattern about state of an object.
      22. Memento pattern
      23. State pattern
      
Even this Readme takes hella times to write. What the fudge.

# Dynamic proxy
It's a lot differences between this and normal proxy implementation. So I created a new package 
for it. 

A class named InvocationHandler in java is for dynamic proxy, You should implements it for the
dynamic proxy call. 

And a method invoke(Object proxy, Method method, Object[] args) must be over-written. As its name
indicates, this method deals with the invoking of methods in the interface you want to cover with
a proxy. But you don't need to call this method by hand.

How to use your written proxy handler:

    final Juicer juicer = new BonoJuicer();
    final ProxyService proxy = ProxyService.class.newInstance();
    proxy.init((BonoJuicer) juicer);

    final Juicer newJuice = (Juicer) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                juicer.getClass().getInterfaces(), proxy);

And now the newJuice is ready to rock.

# Reflection
Everybody knows what is reflection. But as a reminder to myself, let me do a fast explain here again
for good.

Reflection is simply a mechanism that allows program to instatiates new object / modifies codes after
compiling, or say at runtime. It hands the authority/ability to users for deciding what method or object
to use while the program running. It's very important in AOP and Spring.

It's nothing special but need to know how it works.
