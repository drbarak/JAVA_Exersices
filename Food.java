package ירושה;
public class Food
{
    protected int _cal;
    protected String _lastDate;
    //abstract int _test;   //not allowed in Java - abstract is valid for methods only

    public Food()
    {
        _cal = 100;
        _lastDate = "01/01/1900";
    }
    public Food(int cal, String lastDate)
    {
        _cal = cal;
        _lastDate = lastDate;
    }
    
    public int getCal()
    {
        return _cal;
    }
    public String getLastDate()
    {
        return _lastDate;
    }

    public void setCal(int cal)
    {
        _cal = cal;
    }
    public void setLastDate(String lastDate)
    {
        _lastDate = lastDate;
    }
    public void eat()
    {
        System.out.println("I'm eating food");
    }
    public String toString()
    {
        return "Cal: "+_cal+", Last Date: "+_lastDate;
    }
}
/*

Cal: 100, Last Date: 01/01/1900
I'm eating food
New cal: 200, new Last Date: 1/1/2030

Cal: 350, Last Date: 5/4/2020
I'm eating food
New cal: 200, new Last Date: 1/1/2030

Tops: 1, Slices: 8, Cal: 100, Last Date: 01/01/1900
I'm eating pizza!!!
New cal: 200, new Last Date: 1/1/2035
New tops: 5, new slices: 6

Tops: 7, Slices: 4, Cal: 500, Last Date: 20/5/2025
I'm eating pizza!!!
New cal: 200, new Last Date: 1/1/2035
New tops: 5, new slices: 6
*/

