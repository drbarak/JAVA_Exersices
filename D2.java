package ירושה;

import static Library.Print.*;
public class D2 extends B2
{
    public D2(int i)
    {
        super(i + 1);
    }

    public boolean equals(D2 other)
    {
        pN("D2 ");
        return ((other != null) && (_i == ((D2) other)._i));
    }
}