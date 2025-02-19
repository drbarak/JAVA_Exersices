package ירושה;

import static Library.Print.*;
public class A2
{
    protected int _i;

    public A2(int i)
    {
        _i = i;
        pN("_i = "+_i);
    }

    public boolean equals(A2 other)
    {
        pN("A2 ");
        return ((other != null) && _i == other._i);
    }
}