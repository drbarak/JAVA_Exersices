package ירושה;

public class D extends A
{
    public D(int n)
    {
       super(n);
    }

    public boolean equals(B b)
    {
        return _num == b._num;
    }
    
    public int getNumber()
    {
        return super.getNum() - _num;
    }
    
    public int getNum()
    {
        return _num + 1;
    }
}
