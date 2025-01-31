
package תרגילים_נוספים;

import static Library.Print.p;
import static Library.MyLibrary.*;
/**
 * Write a description of class IntNodeMat here.
 *
 * @author (Zvi Barak ID: 050982479)
 * @version (30.11.2024)
 */
public class IntNodeMat
{
    private int _level, _value;
    private String _data;
    // the neighbours of the IntNodeMat object
    private IntNodeMat _next;

    /**
     * Constructors for objects of class IntNodeMat
     */
    public IntNodeMat()   // initialise a default IntNodeMat
    {
        _next = null;
        _level = _value = -1;
        _data = "";
    }
    public IntNodeMat(int value)   // initialise a default IntNodeMat
    {
        this();
        _value = value;
    }
    public int getValue() {return _value;}
    public void setValue(int value) { _value = value;}
    
    public IntNodeMat getNext() { return _next;}
    public void setNext(IntNodeMat other) {_next = other;}
    
    public IntNodeMat(IntNodeMat other)   // copy an existing IntNodeMat object
    {
        if (other == null) return;
        _next = other._next;
    }
    // constructors and method for extra info: level & data    
    public IntNodeMat(int level, int value, String data)   // initialise a default IntNodeMat
    {
        _next = null;
        _level = level;
        _value = value;
        _data = data;
    }
    public int getLevel() {return _level;}
    public String getdata() {return _data;}
    /**
     * Method to set the x coordinate of the IntNodeMat, if it is valid
     *
     * @param   x   the new x coordinate to set
     */
    public void setDatas(int level, int value, String data)
    {
        _level = level;
        _value = value;
        _data = data;
    }
    /**
     * Method to prepare the IntNodeMat for printing
     *
     * @return String the IntNodeMat in the format "(_x,_y)"
     */
    public String toString()
    {
        if (_level != -1)
            return "(" + _level + "," + _value + ",[" + _data + "])";
        return "(" + _value + ")";
    }
} // end of class IntNodeMat
