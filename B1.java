package ירושה;

import static Library.Print.*;

public class B1 extends A1
{
    private void pN(String s)
    {
        System.out.print(s);
    }
    public B1()
    {
        pN("B");
    }
    @Override
    public void arik()
    {
        pN("Arik_B");
    }
    public void yosef()
    {
        pN("Yosef");
    }
    public void superYosef()
    {
        super.yosef();
    }
}
