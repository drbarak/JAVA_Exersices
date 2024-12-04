
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
        if (run >= 1000)
        {
            Print.p("------ array of lights ------");
            boolean[] arr1 = {false, true, false, false, true};
            boolean[] arr2 = {false, false, true, false, false};
            Print.p("" + Disco.disco(arr1, arr2, 0));
        }
        if (run % 1000 >= 100)
        {
            Point pt = new Point(1,2);
            System.out.println(pt);
        }
        if (run % 100 >= 10)
        {
            Print.p("\n------ factorial ------");
            int[] arr = new int []{-2, 0, 1, 2, 3, 5, 6};
            for (int n: arr)    
                Print.p("factorial of = " + n + " is: " + fact(n));
        }
        if (run % 10 >= 1)
        {
            Print.p("\n------ how many ------");
            // checking number of times a subsring appear in a string
            // not using String methods to do it
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
                Print.p(string + ", " + count + ",\t" + subString);
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
