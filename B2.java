package ירושה;

import static Library.Print.*;
public class B2 extends A2
{
    public B2(int i)
    {
        super(i + 1);
    }

    public boolean equals(B2 other)
    {
        pN("B2 ");
        return ((other != null) && _i == other._i);
    }
    /*
    public boolean equals(Object other)
    {
        pN("B2 ");
        return ((other != null));// && _i == other._i);
    }
    */
}