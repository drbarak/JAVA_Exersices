package ירושה;

import static Library.Print.*;
public class GrandFather
{
    public GrandFather()
    {
    }

    public boolean equals(Object Obj)
    {
        p("GrandFather.equals(Object)");
        return true;
    }
    public boolean _equals(Son Obj)
    {
        p("GrandFather.equals(Son)");
        return true;
    }
    public void foo(int x)
    {
        p("GrandFather.foo(int)");
    }

}
