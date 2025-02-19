package ירושה;

import static Library.Print.*;
public class Father extends GrandFather
{
    public boolean equals(Father Obj)
    {
        p("Father.equals");
        return true;
    }
    public boolean _equals(Son Obj)
    {
        p("Father.equals(Son)");
        return true;
    }
    public void foo()
    {
        p("Father.foo");
    }
    public void foo(String S)
    {
        p("Father.foo(String)");
    }
}
