package ירושה;


public class B3 extends A3
{
    private int _a;
    private int _b;
    protected int _c;
    
    public B3()    {
        _b = 100;
        Girrafe g1 = new Girrafe(450);
        //_b = g1._height;    // compilation error - has private access
        _b = g1._height2;     // OK because B3 and Girrafe in the same package
        _c = _b - 1;
    }
    
    public B3(int aa)    {
        _a = aa;
    }
    
}
