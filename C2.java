package ירושה;

import static Library.Print.*;
public class C2 extends B2
{
    public C2(int i)
    {
        super(i);
    }

    public boolean equals(Object other)
    {
        pN("C2 ");
        return ((other != null) && (other instanceof C2) &&
            (_i == ((C2) other)._i));
    }
}