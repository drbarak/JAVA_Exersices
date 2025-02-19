package ירושה;

import static Library.Print.p;
public class A3
{
    private int _a;
    public A3()  {
        _a = 1;
    }
    public void set(int j)    {
        _a = j;
    }
    public void set()    {
        set(2);
    }
    public int get()    {
        return(_a);
    }
    public void f1(A3 a)    {
        if (a instanceof B3)
            f1((B3)a);
        else
            p("nothing");
    }
    public void f2(A3 a)    {
            f2((B3)a);
    }
    public void f2(B3 b)    {
            p("A::f2(B)");
    }
}
