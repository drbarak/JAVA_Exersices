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
        boolean p = false;
        int[] run = {0,0,0,0,0,0,0,0,0,0,0,1,1};
        if (run[12] == 1)
        {
            Print.p("------ Recursion 4 - findAllNumsEqualN ------");
            int n = 5;
            Print.p("n="+n+",numbers=[" + 
                    Recursion.findAllNumsEqualN(n) + "]");

        }
        if (run[11] == 1)
        {
            Print.p("------ Recursion 4 - findNumbersEqualSum ------");
            int[][] nArr = {{0,1},{1,13},{1,3},{2,20},{2,13},{2,6},{2,18},
                {3,6},{3,13},{3,20},{4,6},{4,13},{5,42}};
            int n, sum;
            int start = 0, last = (int) Math.min(30, nArr.length);
            start = last - 1;
            start = 5;
            last = start + 1;
            for (int i=start; i < last; i++)
            {
                n = nArr[i][0];
                sum = nArr[i][1];
                    long startTime = System.currentTimeMillis();
                String result = Recursion.findNumbersEqualSum(n, sum, true).substring(1);
                Print.p("n="+n+",sum="+sum+",numbers=[" + 
                    result.substring(0, result.length() - 1) + "]");
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
            }
        }
        if (run[10] == 1)
        {
            Print.p("------ Recursion 3 - permutation ------");
            //String X = "123";
            Print.p(Recursion.permutation("123"));
        }
        if (run[9] == 1)
        {
            Print.p("------ Recursion 2 - power set ------");
            /*  int[] X = {1,2,3};
                Print.p(Recursion.powerSet(X));
            */
            Print.p(Recursion.powerSet("1234"));
        }
        if (run[8] == 1)
        {
            Print.p("------ Recursion 1 - interleaving ------");
            Print.p(Recursion.findInterleavings("12", "34").substring(1));
        }
        if (run[7] == 1)
        {
            Print.p("------ Edit Distance ------");
            String[] dict = {"applet","lake","banana","rice","mouse","bottle","apple",
                "ape","applets","appel"};
            //dict = new String[]{"A","b","aP"};//"APPLETS","APPLES"
            int indexWord = EditDistance.editDistance(dict, true, p);
            Print.p(dict[indexWord]);
        }
        if (run[6] == 1)
        {
            Print.p("------ Conway Game Of Life ------");
            char [][]grid = ConwayGameOfLife.createRandomGrid(10);
            Print.p("Original grid");
            Print.p(grid);
            ConwayGameOfLife.run(grid, 20);
        }
        if (run[5] == 1)
        {
            Print.p("------ Last Match ------");
            // these data need to be accepted from the user
            int[] gameData = {5, 2, 3, 1};
            int numMatches = gameData[0], maxMatches = gameData[1], 
                numGames = gameData[2], startPlayer = gameData[3];
            LastMatch.lastMatch(numMatches, maxMatches, numGames, startPlayer);
        }
        if (run[4] == 1)
        {
            Print.p("------ array of lights ------");
            boolean[] arr1 = {false, true, false, false, true};
            boolean[] arr2 = {false, false, true, false, false};
            Print.p("" + Disco.disco(arr1, arr2, 0));
        }
        if (run[3] == 1)
        {
            Point pt = new Point(1,2);
            System.out.println(pt);
        }
        if (run[2] == 1)
        {
            Print.p("\n------ factorial ------");
            int[] arr = {-2, 0, 1, 2, 3, 5, 6};
            arr = new int[]{4};
            for (int n: arr)    
                Print.p("factorial of = " + n + " is: " + Recursion.factorial(n));
        }
        if (run[1] == 1)
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
        if (run[0] == 1)
        {
            Print.p("\n------ longest arrow ------");
            p = false;
            // Page 8 in file Exercises
            // in a series of integers, an arrow is a subSeries with increasing numbers
            // and we need to fins the longest arrow
            int[][] array = {{},{1},{7,6},{-1,6},{1,6,12},{1,6,-12},{1,-6,-6},
                {1,6,12,-2},{1,-6,4,12,-2,3,-8},{1,6,12,-2,3,5,-8,0,3,10}};
            for (int[] subArray: array)
            {
                int a, b, len, longest, pos, maxPos, i;
                len = longest = pos = maxPos = a = b = 0;
                i = 0;
                if (subArray.length > 0)
                {
                    maxPos = pos = len = longest = 1;
                    a = b = subArray[i++];
                }
                while (i < subArray.length)
                {
                    b = subArray[i++];
                    if (b > a) 
                        len++;   // still monotone
                    else // breaking a monotone sequence�
                    {
                        len = 1;    // a new sequence starts here, its length is 1�
                        pos = i;
                    }
                    if (len > longest)  // if we're currently breaking a record
                    {
                        longest = len;  // update records�
                        maxPos = pos;
                    }
                    a = b;
                }
                pos = maxPos;
                /*
                int i, pos, len, longest, a, b;
                i = pos = len = longest = a = b = 0;
                if (subArray.length > 0)
                {
                    pos = len = 1;
                    a = b = subArray[i++];
                    //if (subArray.length > 7 ? true : false);
                }
                while (i < subArray.length)
                {
                    b = subArray[i]; 
                    if (p) System.out.println(""+1000+","+a+","+b+","+i+","+pos+","+len+","+longest);
                    if (a > b)
                    {
                        if (longest < len)
                        {
                            if (longest > 0) pos = i + 1 - len;
                            if (p) System.out.println(""+1100+","+a+","+b+","+i+","+pos);
                            longest = len;
                        }
                        while (a > b && i < subArray.length)
                        {
                            a = b;
                            if (i < subArray.length - 1)
                                b = subArray[++i];
                        }
                        if (p) Print.p(2000, a, b);
                        len = (i < subArray.length - 1? 1 : 0);
                    }
                    len++;
                    a = subArray[i++];
                }
                if (p) System.out.println(""+3000+","+a+","+b+","+i+","+pos+","+len+","+longest);
                if (longest < len)
                {
                    if (longest > 0) pos = i + 1 - len;
                    if (p) System.out.println(""+1100+","+a+","+b+","+i+","+pos);
                    longest = len;
                }
                */
                System.out.println("The longest arrow is of length " + longest + 
                " starting at position " + pos + " in " + Arrays.toString(subArray));
            }
        }
    }
}
