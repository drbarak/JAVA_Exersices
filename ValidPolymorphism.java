/**
 * Insructions what to look for when checking if a statement is valid in terms
 * of passing compilation (syntax is correct), passing runtime, and how will
 * polymorphism affect the result of the statement.
 */
// BEFORE THE EXAM, TO REDO THE EXERCISES IN SECTION 7, 8 IN THE SITE
/**
 * 1. Casting: casting between unrelated objects is forbidden. Thus if A is a
 *  class and B is another class, and they are not related, casting will fail
 *  compilation, even if both are subclass of the same parent. 
 *  Example: 
 *      class A {} or class A extends Parent {}
        class B {} or class B extends Parent {}

        A a = new A();
        B b = (B) a; // Compilation error: Inconvertible types
 * 2. UpCasting: between Subclass → Superclass (Subclass extends Superclass) is
 *  always allowed, and can be even implicit:
 *  Example (related to "A/B extends Parnet"):
 *      Parnet p = new A(); // Upcasting (implicit)
 *      if getNum() a method in Parent and getNumber() a method in A then
 *          p.getNum(); is valid but
 *          p.getNUmber(); is invalid
 *      but the followings are valid:
 *          B b = (B) p;
 *          b.getNumber();  // because it is a method of B
 *          b.getNum()      // because B is subclass of Parent then every 
 *                          // method of parnet is a method of B
 * 3. Downcasting: between Superclass → Subclass is allowed
 *   Example (also related to "A/B extends Parnet"): 
 *       Parnet p = new A(); // Upcasting (implicit) 
 *       B b = (B) p;  // invalid, cannot downcast the parent to another subclass
 *                      but 
 *       Parnet p = new B(); // Upcasting (implicit) 
 *       B bb = (B) p;  // valid 
 *     In general: casting is allowed if the classes has direct inheritance link.
 *     That is, they are at the same branch of the inheritance: A() extends P()
 *     casting between A and P is allowed, the same if B() extends P() but not
 *     between A() and B()
 *     At compilation: son to father -> allowed automatically
 *                     father to son -> allowed, but not implicit
 *     At runtime: allowed if in memory exists the component (father exists
 *                  in son) - see exercises section 8.2 in the course site.
 *    Example 2: Son s = new Son(); Father f = s; -> allowed
 *               Father f = new Son(); Son s = f; -> invalid, BUT
 *                                     Son s = (Son)f; -> valid
 *     However:
 *              Father f = new Father(); Son s = (Son)f; no compilation error
 *                  because Son and Father are on the inheritance branch, 
 *              BUT gets a Runtime error because f in memory does not have 
 *                  a part of Son.
 *  4. Creating a class: using implicit empty constructor:
 *      - Cannot create a class type subclass from a superclass, only from
 *          it's own class or subclass below, same way a class of type X cannot
 *          create from a class Y that has no relation to it (X x = new Y() gives
 *          a compilation error.
 *          Son s = new Father() - compilation error.
 *      - When no constructor is defind at all in a class, the default empty
 *          constructor is used (when it is not a subclass).
 *      - If the class has a non empty constructor, and no empty one, then
 *          that constructor must be used, otherwise compilation error.
 *      - If the class has a non empty constructor, and empty one, then
 *          one of the constructors must be used, otherwise compilation error.
 *  5. Creating a subclass:
 *      - If there is a constructor, it MUST first create the parent.
 *      - If no empty constuctor in the subclass, then one of the non-empty
 *          must be used. If creating the subclass with no parameter a 
 *          compilation error occurs.
 *      - If a subclass has no constructors:
 *          If parent has an empty one, it will be used in the subclass.
 *          If parent also has no constructors then the default empty
 *          constructor is used for both the subclass and the parent.
 *          However, if parent has any constructor with parameters and no
 *              empty one, a compilation error occurs since no constructor
 *              exist.
 *  6. Cannot use super.super.x() - only one level is allowed.
 *  7. Access Permissions: 
 *      - private: only to the class where it is defined.
 *      - package-private: only to the original class and class in same package:
 *      - protected: all classes but class not in package (when a calls is
 *              created in another package (A a = new A() in class D (which is
 *              not in the package of A), only variables type public are available  
 *              using a._x, because it is a different package and even if D inherits
 *              A, when we create A inside D then it's variables are not the same
 *              as the inherited variables, that can be referenced uing _x directly,
 *              unless they are type private that needs get() and set() methods).
 *      - public: all classes.
 *  8. ABSTRACT:
 *      At compilation the compiler checks the validity of the pointer, according
 *      to its type declaration (on the left side), and not how actually it is 
 *      implemented (on the right side). Thus for A a = new B() it checks whether
 *      a has the properties of A and not of B (although it does check if the
 *      implicit casting is allowed - B must be a subclass of A for the declaration
 *      to be valid).
 *      Thus if later we use a.method() and there is no method() in A a compilation
 *      error occurs, even if method() exists in B (which will be used at run time
 *      once compilation is fixed). One way to fix it is to add an empty method() to
 *      class A, or to make A an ABSTRACT class by declaring method() as an abstract
 *      method. The reason is that if method() returns integer we must return a number
 *      even from the empty method() and it is too combersome and non natural to 
 *      implement such a method with a number that is not used. This restriction does
 *      not exist in an abstract method.
 *      An abstract method is declared without curly brackets {}, just the
 *      signature of the class, ending with semi-colon. For example
 *          protected abstract void method();
 *      An abstract class can have non abstract methods and properties.
 *      When a class inherits from an abstract class it must implement all the parent
 *      abstract methods, otherwise a compilation error occurs, unless it is
 *      itself an abstarct class too.
 *      Java does not supports abstract properties.
 *      A usefull use of abstarct method is to force all subclasses to implement
 *      it, and not to forget, and it causes consistency across of the subclasses.
 *      Also, an abstract class cannot be created, since it has non-implemented
 *      methods. Thus if A is abstract then the compiler gives an error for the 
 *      statement A a = new A().
 *      Also, once there is an abstract method in a class, the compiler gives
 *      an error if the class itself is not declared abstract.
 *      Abstract class can not be created, but can be declared as array since
 *      array contains pointers and a pointer can be of type abtract class.
 *      An abstarct class does not have to have abstract methods.
 *      An abstarct class genrally has at least one constructore in order to 
 *      initialize it's properties.
 *      An abstract method can not be private or final because we need to implement
 *      it in the subclasses and if ir is final or private the subclass has not
 *      access to it (private) or can not override it (final).
 *  9. INSTANCEOF: reserved keyword that returns if an object is of a certain
 *      type. For example p(A instanceof B) returns true if B is a subclass of A.
 *      Example: given an array of objects of type A which some of them implemented
 *      as ojects of B eg. A a = new B()). Given a method justInB() will give a
 *      compilation error if we do a.justInB() because it does not exist in A. 
 *      The problem can be solved by casting ((B)a).justInB(). Thus, given the array 
 *          A[] array = new A[3]; a[0] = new A(); a[1] = new B(); a[2] = new B(),
 *      the statement "for (int i=0; i<array.length,i++) array[i].justInB(); gives a
 *      compilation error because array is type A and A does not have a method 
 *      justInB(). But downcasting array to B using ((B) array[i]) will fix the
 *      compilation error.
 *      Note 1: notice that the casting must be enclosed in extra bracket so it is
 *          clear on what object the casting is done.
 *      Note 2: casting all the members of array[] will pass the compiler, but at
 *          runtime there might still be an error if the actual class is A because
 *          it does not have the method justInB(). To make sure that also at
 *          runtime the code works one can use the "instanceof" check, as follows:
 *              for (int i=0; i<array.length,i++) 
 *                  if (array[i] instanceof B) ((B)array[i]).justInB();
 *          Remember: if B is a subclass of A then it contains both A and B
 *              and thus (a instanceof B) is true (but the opposite
 *              B b = new B(); (b instanceof A) is false)
 *  10. Casting a method: casting affects only how the compiler treats the 
 *      reference type, but it does not change the actual runtime type of 
 *      the object. Casting affects only the reference type—essentially a
 *      "pointer" to the object.
 *      Thus, at compilation, as long as there is a relation between the class
 *      and the casting class, the compiler accepts it. But at runtime, Java 
 *      checks whether the object being castrd (A aa = new A(), an instance of A)
 *      is actually an instance of B. Since A is not a subclass of B (it's a base
 *      class), the cast is invalid, and a run time error occurs.
 *      Note: the compiler only looks at the casting and not at the new A() or 
 *      new B() - so it passes statements that can give runtime error due to the
 *      new() statement (B can be converted to A since B includes also an A part,
 *      but A cannot be converted (cast) to B since A does not have a B part).
 *  11. Calling a method in the super class, using super.method() does not cause
 *      any other methods inside super.method() to be confined to the super 
 *      class methods. Unless explicitly called with "super." keyword it starts
 *      looking for the method in the calling sub-class and only if it does not
 *      find there an appropriate method it will use the super-class method.
 *      For example, calling super.yosef() in subclass B, exectes arik() from
 *      class B and not from class A although there is arik() in the super-
 *      class A. Note that using the keyword "this" will not change the behaviour
 *      at runtime because still dynamic dispatch will start at B. the only way to
 *      prevents the dynamic dispatch is to change arik() in A so that it calls a
 *      method unique to A (such as arikA()) which does not exists in B and that
 *      method prints "Arik_A" as does arik() of class A.
 *  12. Overriding a method of superclass: in order to override the overriding
 *      method must return the same type and has same parameters. For example,
 *      the method equals(A other) does not override the equals(Object other)
 *      of the Object class, so if we have a method named equals in class A 
 *      but we declared it as type Object (Object a1 = new A(2)), and compare to
 *      (A a2 = new A(2)) then p(a1.equals(a2)) will execute the equals() of
 *      Object because equals() of A has parameter type A, not Object, so the
 *      method does not override the equals() of Object and thus it is the one
 *      that execute. In order for the equals of A to be exceuted we need to
 *      case a1 to A, and thus ((A)a1).equals(a2) will exceute equals() of A.
 *  13. How dynamic dispatch works:
 *      The method and parameters of compile time is called the Signature" or
 *      the "Original Method".
 *      At run time we look at the run time class for such a method using the
 *      runtime types. If it does
 *      not exists we check if it exists in the superClasses until Object. If
 *      not found then 
 *      The method used at runtime depends on the compile-time type of the 
 *      reference (pointer) and the runtime type of the object.
 *      At runtime, the actual type of the object (the runtime type) determines
 *      which implementation of the method is executed.
 *      This applies only to methods that override (not overload) a method in the
 *      superclass.
 *  14. Dynamic dispatch works on method BUT NOT ON PROPERTIES. The pointer
 *      determines what properties we use. Thus if BB is a subclass of AA, and
 *      _x is a property both in AA and BB, and AA a = new BB(), then the
 *      statement a._x uses the property _x of AA and not of BB!!
 *      
 */
