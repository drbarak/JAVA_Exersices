package ירושה;
public class Pizza extends Food
{
    protected int _numOfTops;
    protected int _numOfSlices;

    public Pizza()
    {
        _numOfTops = 1;
        _numOfSlices = 8;
        _cal = 100;
        _lastDate = "01/01/1900";
    }
    public Pizza(int numOfTopsint, int numOfSlices, int cal, String lastDate)
    {
        _numOfTops = numOfTopsint;
        _numOfSlices = numOfSlices;
        _cal = cal;
        _lastDate = lastDate;
    }
    
    public int getNumOfTops ()
    {
        return _numOfTops ;
    }
    public int getNumOfSlices ()
    {
        return _numOfSlices;
    }

    public void setNumOfTops(int numOfTops)
    {
        _numOfTops = numOfTops;
    }
    public void setNumOfSlices(int numOfSlices)
    {
        _numOfSlices = numOfSlices;
    }
    public void eat()
    {
        System.out.println("I'm eating pizza!!!");
    }
    public String toString()
    {
        return "Tops: "+_numOfTops+", Slices: "+_numOfSlices+", "+super.toString();
    }
}
