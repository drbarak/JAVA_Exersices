package ירושה;

public class C extends A
{

    public C(int n)
    {
       super(n);
    }
    
    public boolean equals(A a)
    {
        return (a instanceof C) && _num == a._num;
    }
}
/*
    
    public boolean equals(B b)
    {
        return _num == b._num;
    }
*/    
