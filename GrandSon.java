package ירושה;

import static Library.Print.p;
import static Library.MyLibrary.*;
public class GrandSon extends Son
{
    private int x;
    public int _x;

    public GrandSon()
    {
        super();
        _x = 2;
        x = 0;
        //p(x, X);
    }

    public boolean equals(Object Obj)
    {
        p("GrandSon.equals(Object)");
        return true;
    }
    public boolean equals(Father Obj)
    {
        p("GrandSon.equals(Father)");
        return true;
    }
    public boolean equals(GrandSon Obj)
    {
        p("GrandSon.equals(GrandSon)");
        return true;
    }
    public boolean _equals(Son Obj)
    {
        p("GrandSon.equals(Son)");
        return true;
    }
    public void bar(int x, int y)
    {
        p("GrandSon.bar");
    }

    public int getX1()
    {
        return _x;
    }
    
    public void main()
    {
        Son b = new Son();
        //p(X);
        Father a = new Father();
        //p(b.getX());
        int[] arr = new int[]{1,2};
        p(arr);
        swap(arr, 1, 0);
        p(arr);
    }
} // Son

