package ירושה;

import static Library.Print.*;

public class A1
{

    private void pN(String s)
    {
        System.out.print(s);
    }
    public A1() {
        pN("A");
    }
    public void arik()
    {
        pN("Arik_A");
    }
    public void yosef()
    {
        arik(); // if called from B1 will excute arik() that in B1 which print Arik_B
        //arikA(); // to make sure it prints Arik_A need to change to call arikA() instead
    }
    public void arikA()
    {
        pN("Arik_A");
    }
}
