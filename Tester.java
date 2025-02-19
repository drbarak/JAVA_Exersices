package ירושה;

import static Library.Print.*;

public class Tester
{
    public static void main()
    {
        B3 g4 = new B3();
        if (false)
        {
            Girrafe g1 = new Girrafe(450);
            Girrafe g2 = new Girrafe(460);
            //p(g1._height); // compilation error - private access
            /*
            p(g1._height2);       // OK because Girrafe in the same package
            
            p(g1.compareTo(g2));
            p(g2.compareTo(g1));
            */
            B3 g3 = new B3();
            p(g3._c);       // OK because B3 in the same package
            //p(g1.compareTo(g3));
        }
        if (false)
        {
            B3 b3 = new B3();
            A3 a3 = b3;
            b3.f1(a3);
        }
        if (false)
        {
            AA a = new AA();
            System.out.println(a._x);
            System.out.println(a.getX());
        
            BB b = new BB();
            System.out.println(b._x);
            System.out.println(b.getX());
    
            a = new BB();
    System.out.println(a._x);
    System.out.println(a.getX());
            
            b = (BB)a;
    /*7*/   //System.out.println(b._x);
    /*8*/   //System.out.println(b.getX());
    
            Object o = new BB();
    /*9*/   //System.out.println(o._x);
    /*10*/  //System.out.println(o.getX());
    
        }

        //B b = new A(1);
        A a = new B(1);
        if (false)
        {
            testABC();
            testA1B1();
            testInstanceof();
            testEquals();
        }
        if (false)
        {
            testA2B2C2D2();
        }
        if (false) // from lecture by Hen
        {
            Father f = new Son();
            Son s = new GrandSon();
            f.equals(s);
            s.equals(f);
            
            f = new GrandSon();
            s.equals(f);
            
            GrandSon gs = new GrandSon();
            s.equals(gs);
            
            f.foo(5);
            //s.bar(4,5);   compilation error
        }
        if (false)
        {
            Father f1 = new Father();
            Father f2 = new Father();
            f1.equals(f2);
            
            GrandFather g = new GrandFather();
            f1.equals(g);
    
            g = new Father();
            f1.equals(g);
            //f1.equals((Son)f2);   runtime error - can not downcast from Father to Son
            GrandSon gs1 = new GrandSon();
            GrandSon gs2 = new GrandSon();
            gs1.equals(gs2);
            
            Object o = new GrandSon();
            GrandSon gs = new GrandSon();
            o.equals(gs);
            
            //Son s = new Father(); compliation error - Father does not contains Son
            Son s = new Son();
            gs.equals(s);
            
            f1 = new GrandSon();
            f2 = new Son();
            //f1.equals((GrandSon)f2); runtime error since Son does not include GS
            f1.equals(f2);
            
            f1 = new Daughter();
            //f1 = new Father();
            GrandFather gf = new GrandFather();
            f1.equals(gf);
            f1.equals(f2);
            o.equals(gs);
        }
    }
    private static void testA2B2C2D2()
    {
        A2 a = new A2(1);   // 1
        p(" <= A2 a = new A2(1);");
        B2 b = new B2(1);   // 2
        p(" <= B2 b = new B2(1);");
        C2 c = new C2(1);   // 2
        p(" <= C2 c = new C2(1);");
        D2 d = new D2(1);   // 3
        p(" <= D2 d = new D2(1);");
        D2 d2 = new D2(1);  // 3
        p(" <= D2 d2 = new D2(1);");
        B2 b1 = new D2(1);  // 3
        p(" <= B2 b1 = new D2(1);");
        
        Object c1 = new C2(1);  // 2
        p(" <= Object c1 = new C2(1);");
        Object d1 = new D2(1);  // 3
        p(" <= Object d1 = new D2(1);");
        
        a = c;
        p(b1.equals(b)); // "B2 false"
            //At compilation: b1 is type B2 and parameter b of type B2
            //so equals of B2 is ok and it's signature is checked at runtime.
            //At runtime: b1 is type D2 and b stays type B2. So equals of
            //D2 is looked but requires (D2 other) so no match so looks at
            //superclass B2 that has equals that matches so B.equals is used
            //inside B2.equals():_i=3 for D2 and other._i is of B2 which is 2,
            //so false
        p(""+(b1.equals(b))+" <= b1.equals(b);");
        p(c1.equals(c)); // "C2 true"
            //At compilation: c1 is type Object and parameter c of type C2
            //so equals of Object is ok and it's signature is checked at runtime.
            //At runtime: c1 is type C2 and c stays type C2. So equals of
            //C2 is checked and it overrides Object equals so it is used.
            //though requires (Object other) becuase C2 is of type Object
            //inside C2.equals(): other is type C2, _i==other._i becuase both type C2
        p(""+(c1.equals(c))+" <= c1.equals(c);");
        p(d1.equals(d)); // "false"
            //At compilation: d1 is type Object and parameter d of type D2
            //is an Object so equals of Object signature is checked at runtime.
            //At runtime: d1 is type D2 and d stays type D2. So equals of
            //D2 is checked ONLY IF IT OVERIDES equals of Objects. But requires
            //(D2 other) so does not overrides so equals of B2 checked. Also does
            //not overrides Object.equals and also A2.equals() does not overrides,
            //so equals of Object is used.
            //inside Object.equals(): addresses are not equal
        p(""+(d1.equals(d))+" <= d1.equals(d);");
        p(d.equals(d1)); // "false"
            //At compilation: d is type D2 and parameter d1 of type Object.
            //D.equals has D2 parameter which no match so equals of B2 is checked.
            //It requires B2 parameter so no match so checks equals of A2. No
            //match too. So equals of Object signature is used at runtime.
            //At runtime: d, and d1 are type D2. So equals of D2 is checked 
            //to see if it OVERIDES equals of Objects. But requires (D2 other)
            //so does not overrides thus equals of B2 and A2 checked but still
            //do not override equals of Object, soObject is used.
            //inside Object.equals(): addresses are not equal
        p(""+(d.equals(d1))+" <= d.equals(d1);");
        p(d.equals(d2)); // "D2 true"
            //At compilation: d and d2 are type D2 and parameter d2 of 
            //D.equals has D2 parameter which matches so D2 signature is used at
            //runtime.
            //At runtime: d and d1 are type D2. So equals of D2 is checked and used.
            //inside D2.equals(): other is type D2, _i==other._i becuase both type D2
        p(""+(d.equals(d2))+" <= d.equals(d2);");
        p(c.equals(c1)); // "C2 true"
            //At compilation: c of type C2 and c1 is type Object. C2.equals
            //has parameter of Object so it's signature is used at runtime.
            //At runtime: c and c1 are type C2. So equals of C2 is checked
            //and it OVERRIDES equals of Object so C2.equals() is used.
        //Michal says: C2.equals has no equals that accepts C2 so we use
            //the method signature of compilation which is C2.equals(object)
            //which can be used because C2 is also an Object.
            //inside C2.equals(): other is type C2, _i==other._i becuase both type C2
        p(""+(c.equals(c1))+" <= c.equals(c1);");
        p("a=c");
        p(a.equals(c)); // "A2 true"
            //At compilation: a of type A2 and c is type C2. A2.equals
            //has parameter of A2 and since C2 is subclass of A2 it is ok and
            //it's signature is used at runtime.
            //At runtime: a and c are type C2. So equals of C2 is checked but
            //compared to A2.equals(). Since C2.equals(Object other) it does
            //overrides A2.equals(A2 other). Going up to B2, still no override
            //since B2.equals(B2 other). So A2.equals is used.
            //inside A2.equals(): other is type C2, _i==other._i becuase both type C2
        p(""+(a.equals(c))+" <= a.equals(c);");
        p(c.equals(a)); // "A2 true"
            //At compilation: c is type C2 and a of type A2. C2.equals
            //has parameter of Object and since A2 is subclass of Object it
            //is ok and C2.equals signature is used at runtime 
            //BUT WITH A2 PARAMETER.
            //At runtime: a and c are type C2. So equals of C2 is checked 
            //but it has Object paramenter so no match, same for B2 but A2 matches.
            //inside A2.equals(): other is type C2, _i==other._i becuase both type C2
        p(""+(c.equals(a))+" <= c.equals(a);");
        p(b.equals(c)); //"B2 true"
            //At compilation: b is type B2 and c of type C2. B2.equals
            //has parameter of B2 and since c is of class C2 no match.
            //But C2 is subclass of B2 so it contains B2 so it is ok.
            //Thus, B2.equals signature is used at runtime BUT WITH C2 PARAMETER.
            //At runtime: b is Type B2 and c is type C2. So equals of B2 is 
            //checked. It has B2 paramenter so it is ok because B2 is part
            //of C2,  thus B2.equals is used.
            //inside B2.equals():_i=2 for B2 and other._i is of C2 which is 2,
        p(""+(b.equals(c))+" <= b.equals(c);");
        p(b.equals(b1)); //"B2 false"
            //At compilation: b is type B2 and b1 of type B2. B2.equals
            //has parameter of B2 so there is a match and B2.equals signature
            //is used with parameter type B2.
            //At runtime: b is Type B2 and b1 is type D2. So equals of B2 is 
            //checked. It has B2 paramenter so it is ok because B2 is part
            //of D2, thus B2.equals is used.
            //inside B2.equals():_i=2 for B2 and other._i is of D2 which is 3,
            //so false
        p(""+(b.equals(b1))+" <= b.equals(b1);");
        p(b.equals(a)); // "A2 true"
            //At compilation: b is type B2 and a of type A2. B2.equals has
            //parameter of B2 so there is a no match because B2 is not part
            //of A2. Thus B2.equals signature is used with parameter type A2.
            //At runtime: b is Type B2 and a is type C2. So equals of B2 is 
            //checked. It has B2 paramenter so it is not ok because B2 is 
            //not part of A2. So A2.equals is checked and there is a match.
            //inside A2.equals():_i=2 for B2 and other._i is of C2 which is 2,
        p(""+(b.equals(a))+" <= b.equals(a);");
        p(d1.equals(b)); // "false"
            //At compilation: d1 is type Object and b of type B2. Object.equals
            //has parameter of Object so there is a a match.
            //Thus Object.equals signature is used with parameter type B2.
            //At runtime: d1 is Type D2 and b is type B2. So equals of D2 is 
            //checked. It has D2 paramenter so it does not overrides 
            //Object.equals and the same for B2 and A2. So Object.equals is used
            //inside Object.equals(): addresses are not equal
        p(""+(d1.equals(b))+" <= d1.equals(b);");
    }
    private static void testABC()
    {
        A y1 = new B(5);    // implicit upcasting
        B y2 = new B(5);
        A z1 = new C(5);    // implicit upcasting
        C z2 = new C(5);

        //C z3 = new B(5);   // invalid, compilation error of incompatible types 
        //C c = (C)y2;       // invalid, compilation error of incompatible types 
        p(y1.getNum());
//        p(y1.getNumber());   // compliation error - unknown method (does not exists in A)
        B b = (B) y1;    // downcasting allowed since B is subclass of A
        p(b.getNumber());   // allowed since getNumber() is a method of B
        p(b.getNum());  // valid - getNUm() in A but also in B because subclass of A
        
        A a = new A(5);
        //B bb = (B) a;       //invalid - runtime error because A cannot downcast to B
            // but
        B bbb = (B) y1;     // valid because y1 is of type B
        
        p(y1._num == y2._num);  // TRUE
        p(""+(y1._num == y2._num)+" <= y1._num == y2._num;");
        
        p("Runtime error: C cannot cast to B"+" <= y1.getNum() == ((B)z1).getNum();");
        //p(y1.getNum() == ((B)z1).getNum()); // runtime error - C cannot cast to B
                            // it is not downcasting since C is not a sub-class of B

        p(y1.equals(z2));   // TRUE - equals() of A is used because y1 is type A, and
                            // parameters of that equals is ok because C is subclass of A
        p(""+(y1.equals(z2))+" <= y1.equals(z2);");
        
        p(y2.equals(z2));   // TRUE -  y2 is of type B but no equals in B so equals of A is
                            // used, and the rest as above
        p(""+(y2.equals(z2))+" <= y2.equals(z2);");
        
        p(z2.equals(y2));   // FALSE - z2 type C so equals of C is used which requires parameter
                            // of type A, but gets y2 which is of type B which is also A
                            // so equals of C is used: (a instanceof C) is false
        p(""+(z2.equals(y2))+" <= z2.equals(y2);");
        
        //p(z2.equals((C)y2));                             
        p("Compilation error: B cannot cast to B"+" <= z2.equals((C)y2);");
    }
    private static void testEquals()
    {
        A y1 = new A(2);
        Object y2 = new A(2);
           //will use the method in Object because the one in A 
           //does not override it and the pointer y2 is of type Object
           //at compilation time - that is the time when the method
           //to be exceuted is chose
        p(y2.equals(y1));
           //will use the method in A because pointer y2 is of type A
           //at compilation time - that is the time when the method to be
           //exceuted is chosen, and the parameters type match the call
        p(((A)y2).equals(y1));
        return;
    }    
    private static void testA1B1() // B1 subclass of A1
    {
        A1 a = (A1) new B1();   // AB
        p(" <= A1 a = (A1) new B1();");
        A1 aa = new A1();   // A
        p(" <= "+"A1 aa = new A1(); ");
        A1 ab = new B1();   // AB
        p(" <= "+"A1 ab = new B1();");
        //B1 ba = new A1();   // compiler error B1 is not part of A1
        B1 bb = new B1();   // AB
        p(" <= "+"B1 bb = new B1();");
        /*
        aa.yosef();    // Arik_A
        p(" <= "+"aa.yosef();");
        ab.yosef();    // Yosef
        p(" <= "+"ab.yosef();");
        bb.yosef();    // Yosef
        p(" <= "+"bb.yosef();");
        ((A1)aa).yosef();    // Arik_A
        p(" <= "+"((A1)aa).yosef();");
        ((A1)ab).yosef();    // Arik_A->no, Yosef
        p(" <= "+"((A1)ab).yosef();");
        ((A1)bb).yosef();    // Arik_A->no, Yosef
        p(" <= "+"((A1)bb).yosef();");
        */
        //((B1)aa).yosef();        // Arik_A -> runtime error because A can not be cast to B
        p(" <= "+"((B1)aa).yosef(); - runtime error because A can not be cast to B");
        //((B1)aa).superYosef();    // run time error 
        p(" <= "+"((B1)aa).superYosef(); - runtime error because A can not be cast to B");
        ((B1)ab).yosef();    // Yosef 
        p(" <= "+"((B1)ab).yosef();");
        ((B1)ab).superYosef();    // Arik_A - no, Arik_B
        p(" <= "+"((B1)ab).superYosef();");
        ((B1)bb).superYosef();    // Arik_A - no, Arik_B
        p(" <= "+"((B1)bb).superYosef();");
    }
    private static void testInstanceof()
    {
        // usage of instanceof
        A[] array = new A[3]; 
        array[0] = new C(0); 
        array[1] = new B(1);
        array[2] = new B(2);
        B b2 = new B(5);
        int n0 = b2.justInB();
        B temp = (B) array[2];
        int n1 = temp.justInB();
        int n = ((B)array[2]).justInB();
        for (int i=0; i<array.length; i++) 
            if (array[i] instanceof B)
               ((B)array[i]).justInB();
        A a0 = new A(1);
        p(a0 instanceof B);
        p(array[0] instanceof B);
        p(array[1] instanceof B);
        p(b2 instanceof A);
    }
}
