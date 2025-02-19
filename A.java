package ירושה;

import static Library.Print.*;
public class A
{
    protected int _num;

    public A(int n)
    {
        _num = n;
    }

    public int getNum()
    {
        return _num + 2;
    }
    
    public boolean equals(A a)
    {
        //p(_num, a._num);
        return _num == a._num;
    }
}