import java.util.Arrays;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main()
    {
        int run = 1;//1000+100+10+1;
        boolean p = false;
        if (run >= 10000)
        {
            Print.p("------ array of lights ------");
            boolean[] arr1 = {false, true, false, false, true};
            boolean[] arr2 = {false, false, true, false, false};
            Print.p("" + Disco.disco(arr1, arr2, 0));
        }
        if (run % 10000 >= 1000)
        {
            Point pt = new Point(1,2);
            System.out.println(pt);
        }
        if (run % 1000 >= 100)
        {
            Print.p("\n------ factorial ------");
            int[] arr = new int []{-2, 0, 1, 2, 3, 5, 6};
            for (int n: arr)    
                Print.p("factorial of = " + n + " is: " + fact(n));
        }
        if (run % 100 >= 10)
        {
            Print.p("\n------ how many ------");
            // checking number of times a subsring appear in a string
            // not using String methods to do it
            // Page 8 in file Exercises
            String string = "bccaaaab?yabcabb*caabcca";
            String[] subStringArray = {"a", "ab", "abc", "abcc"};
            for (String subString: subStringArray)
            {
                int i = 0, j = 0, count = 0;
                int len = string.length();
                int lenSub = subString.length(); 
                char a, b;
                p = false;
                while (i < len)
                {
                    while (j < lenSub)
                    {
                        a = string.charAt(i++);
                        b = subString.charAt(j);
                        boolean inside = false;
                        while (a != b && i < len)
                        {
                            if (p) System.out.println(i+", "+a+","+j+", "+b+","+count);
                            a = string.charAt(i++);
                            j = 0;
                            inside = true;
                        }
                        if (p) System.out.println(""+len+","+i+", "+a+","+j+", "+b+","+count);
                        if (inside)
                        {
                            i--;
                            continue;
                        }
                        if (i == len) break;
                        if (j + 1 == lenSub)
                        {
                            count++;
                            j = 0;
                            continue;
                        }
                        if (a == b ||
                            // if the substring has same chars together such as 'bcc'
                                subString.charAt(j + 1) == b)
                            j++;
                    }
                }
                System.out.println("In [" + string + "] the sub string ["+ subString +
                "]\toccurs " + count + " times");
            }
        }
        if (run % 10 >= 1)
        {
            Print.p("\n------ longest arrow ------");
            p = false;
            // Page 8 in file Exercises
            // in a series of integers, an arrow is a subSeries with increasing numbers
            // and we need to fins the longest arrow
            int[][] array = {{},{1},{7,6},{-1,6},{1,6,12},{1,6,-12},{1,6,12,-2},{1,-6,4,12,-2,3,-8},{1,6,12,-2,3,5,-8,0,3,10}};
            for (int[] subArray: array)
            {
                int i, pos, len, longest, a, b;
                i = pos = len = longest = a = b = 0;
                if (subArray.length > 0)
                {
                    pos = len = 1;
                    a = b = subArray[i++];
                    if (subArray.length > 4)
                        p = true;
                    else
                        p = false;
                }
                while (i < subArray.length)
                {
                    b = subArray[i]; 
                    if (p) System.out.println(""+1000+","+a+","+b+","+i+","+len+","+pos+","+longest);
                    if (a > b)
                    {
                        if (longest < len) longest = len;
                        while (a > b && i < subArray.length)
                        {
                            a = b;
                            if (i < subArray.length - 1)
                                b = subArray[++i];
                        }
                        if (p) Print.p(2000, a, b);
                        len = 0;
                        //break;
                    }
                    len++;
                    a = subArray[i++];
                /*                 
                    while (i < subArray.length && a > subArray[i])
                    {
                        if (p) Print.p(1200, len, longest);
                        longest = len + 1;
                        len = 1;
                        a = subArray[i++];
                        if (p) Print.p(i, a, pos);
                    }
                    if (p) Print.p(1500, len, longest);
                    if (i < subArray.length)
                    {
                        if (p) Print.p(2000, a, subArray[i]);
                        if (a < subArray[i])
                            len++;
                    }
                    else if (i > 1 && a >= subArray[i - 2]) // end of array
                        len++;
                    if (p) Print.p(2500, len, longest);
                    if (longest < len)
                    {
                        longest = len;
                        pos = i - len + 1;
                    }
                    if (p) Print.p(longest, len);
                */
                }
                if (p) System.out.println(""+3000+","+a+","+b+","+i+","+len+","+len+","+longest);
                if (longest < len) longest = len;
                if (a < b)
                    longest--;// = i - 1;
                System.out.println("The longest arrow is of length " + longest + 
                " starting at position " + pos + " in " + Arrays.toString(subArray));
            }
        }
    }
    private static int fact(int n)
    {
        if (n < 0) return 0;
        if (n < 2) return 1;
        return n * fact(n-1);
    }
}
