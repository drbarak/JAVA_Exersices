package ירושה;


public class BB extends AA  
{
    public int _x;

    public BB() {
        this(3);
    }

    public BB(int k)  {
        super(k+2);
        _x = super.getX() + 1;
    }    
}