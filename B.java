package ירושה;

public class B extends A
{
    public B(int n)
    {
       super(n);
    }

    public boolean equals(B b)
    {
        return _num == b._num;
    }
    
    public int getNumber()
    {
        //return super.getNum1() - _num;
        return getNum1() - _num;
    }
    
    public int getNum1()
    {
        return _num + 1;
    }
    
    public int justInB()
    {
        return getNum1() - _num;
    }
}
