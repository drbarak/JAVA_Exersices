package ירושה;

import static Library.Print.p;
import static Library.MyLibrary.*;
public class Son extends Father
{
    
    private int x;
    public int _x;
/*
    public Son()
    {
        super();
        _x = 2;
        x = 0;
        //p(x, X);
    }
*/    
    public boolean equals(Object Obj)
    {
        p("Son.equals(Object)");
        return true;
    }
    public boolean equals(Son Obj)
    {
        p("Son.equals(Son)");
        return true;
    }
    public boolean _equals(GrandSon Obj)
    {
        p("Son.equals(GrandSon)");
        return true;
    }
    public boolean _equals(Father Obj)
    {
        p("Son.equals(Father)");
        return true;
    }
    public boolean _equals(GrandFather Obj)
    {
        p("Son.equals(GrandFather)");
        return true;
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

