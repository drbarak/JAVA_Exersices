package ירושה;

import static Library.Print.p;
public class Girrafe implements Comparable  {
    private int _height;
    protected int _height2;
    
    public Girrafe(int height) {
        _height = height;
        _height2 = _height + 1;
    }
    
    /* Write your code here */
    public int compareTo(Object other)
    {
        if (other instanceof Girrafe)
        {
            int h = ((Girrafe)other)._height;
            if (_height > h) return 1;
            if (_height < h) return -1;
            return 0;
        }
        p("Object must be of type Girrafe");
        return -999;
    }
    public int getH()
    {
        return _height;
    }
    
    
    public String toString() {
        return "height " + _height;
    }
}
