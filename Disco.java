package תרגילים_נוספים;

import static Library.Print.p;
import static Library.MyLibrary.*;
/**
 * Disco class, from lectures of the course, to find whether a set of lights
 * can be equsl to another set by pressing on lights of the first set, starting
 * from position 0 to the end of the array, so the when pressing on a light 
 * it's state and that of it's neighbours changes (on turns to off and off 
 * changes to on) while a light at position 0 changes the light of position 1 
 * only and simillarly for a light at the other end changes just the light 
 * before it only (in addition to it's own light).
 *
 * @author (Zvi Barak)
 * @version (01.12.2024)
 */
public class Disco
{
    public static boolean disco(boolean[] a, boolean[] b, int i)
    {
        if(equalArrays(a, b, 0)) return true;
        if(i == a.length) return false;
        press(a, i);
        if(disco(a, b, i+1)) return true;
        press(a, i);
        return disco(a, b, i+1);
    }

    private static boolean equalArrays(boolean[] a, boolean[] b, int i)
    {   
        if(i == a.length)
            return true;
        if(a[i] != b[i])
            return false;
        return equalArrays(a, b, i+1);
    }

    private static void press(boolean[] a, int i)
    {
        a[i] = !a[i];
        if(i > 0)
            a[i-1] = !a[i-1];
        if(i < a.length-1)
            a[i+1] = !a[i+1];
    }
}
