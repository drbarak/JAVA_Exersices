package ירושה;

import static Library.Print.p;
public class Daughter extends Father
{
    private int x;
    
    public Daughter()
    {
        // initialise instance variables
        x = 0;
    }

    public boolean equals(Object obj) { /** equals 5 **/
        p("Daughter.equals(Object)");
        return true;
        /*
    System.out.println("5");
		if (obj == null || !(obj instanceof Daughter))
			return false;
		
		return super.equals(obj);
		*/
	}
}
