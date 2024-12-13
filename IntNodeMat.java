
/**
 * Write a description of class IntNodeMat here.
 *
 * @author (Zvi Barak ID: 050982479)
 * @version (30.11.2024)
 */
public class IntNodeMat
{
    private int _level, _index;
    private String _value;
    // the neighbours of the IntNodeMat object
    private IntNodeMat _down;

    /**
     * Constructors for objects of class IntNodeMat
     */
    public IntNodeMat(IntNodeMat other)   // copy an existing IntNodeMat object
    {
        if (other == null) return;
        _down = other._down;
    }
    public IntNodeMat(int level, int index, String value)   // initialise a default IntNodeMat
    {
        _down = null;
        _level = level;
        _index = index;
        _value = value;
    }
    public IntNodeMat()   // initialise a default IntNodeMat
    {
        _down = null;
        _level = _index = -1;
        _value = "";
    }
    public int getLevel()
    {
        return _level;
    }
    public int getIndex()
    {
        return _index;
    }
    public String getValue()
    {
        return _value;
    }
    public IntNodeMat getDown()
    {
        return _down;
    }
    /**
     * Method to set the x coordinate of the IntNodeMat, if it is valid
     *
     * @param   x   the new x coordinate to set
     */
    public void setValues(int level, int index, String value)
    {
        _level = level;
        _index = index;
        _value = value;
    }
    public void setDown(IntNodeMat other)
    {
        _down = other;
    }
    /**
     * Method to prepare the IntNodeMat for printing
     *
     * @return String the IntNodeMat in the format "(_x,_y)"
     */
    public String toString()
    {
        return "(" + _level + "," + _index + ",[" + _value + "])";
    }
} // end of class IntNodeMat
