import java.util.Arrays;
/**
 * Write a description of class Recursion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recursion
{
    static String used = "";    // to prevent duplicates
    static boolean p = false;
    //static IntNodeMat head, tail;
    public static String permutation(String X)
    {
        used = "";
        p = true;
        //head = tail = null;
        permutation(X.toCharArray(), 0);
        return used.substring(1);
    }
    private static void permutation(char[] str, int index)
    {
        if (index == str.length)
        {
            used +=  "," + new String(str);
            return;
        }
        recursiveLoop(str, index, index); // Start the recursive loop
    }
    private static void recursiveLoop(char[] str, int index, int i)
    {
        if (i < str.length)
        {
            swap(str, index, i); // Swap the characters at index and i
            permutation(str, index + 1); // Recurse for the next index
            swap(str, index, i); // Backtrack by swapping back
        
            recursiveLoop(str, index, i + 1); // Continue with the next value of i
        }
    }
    // the above solution using for-loop but avoiding 2 recursive functions
    private static void _permutation(char[] str, int index)
    {
        if (index == str.length)
        {
            used +=  "," + new String(str);
            return;
        }
        // Recursively generate permutations by swapping characters
        for (int i = index; i < str.length; i++)
        {
            swap(str, index, i);  // Swap the characters at index and i
            _permutation(str, index + 1);  // Recurse for the next index
            swap(str, index, i);  // Backtrack by swapping the characters back
        }
    }
    private static String swap(String str, int i, int j)
    {
        char[] arr = str.toCharArray();
        swap(arr, i, j);
        return new String(arr);
    }
    private static void swap(char[] str, int i, int j)
    {
        if (i == j) return;
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    /*  Not working' keeping code for the usage of a TREE
    private static String toString(IntNodeMat head)
    {
        IntNodeMat cell = head;
        String s = "";
        while (cell != null)
        {
            //if (p) System.out.println(cell);
            s += cell.toString();
            //Print.p(s);
            cell = cell.getDown();
            s += ",";
        }
        return s;
    }
    private static String permutation(String curr, String X, String Y, int index, int level)
    {
        if (index < X.length()) Y = X.substring(index, index + 1);
        if (p) Print.p("index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        if (index >= X.length())
        {
            if (false && X.length() > 0)
            {
                if (p) Print.p("Calling 3, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
                String newX = X.substring(1);
                index = 0;
                if (p) Print.p("Calling 3A, index=[" + index + "], X=["+newX+ "], Y=["+Y+"], curr=["+curr+"]");
                permutation(curr, newX, Y, 0, 0);
                if (p) Print.p("Returning 3A, index=[" + index + "], X=["+newX+ "], Y=["+Y+"], curr=["+curr+"]");
                return used;
            }
            // Base case: We've considered all elements
            //used += "," + Y;
            //Print.p(used);
            return Y;//used;
        }
        // Recursive case: Exclude the current element
        IntNodeMat cell = new IntNodeMat(level, index, Y);
        if (head == null)
            head = tail = cell;
        else
        {
            tail.setDown(cell);
            tail = cell;
        }
            /* start of nested comment
            System.out.println(head);
            System.out.println(head.getDown());
            System.out.println(tail);
            System.out.println(cell.getDown());
            // end of nested comment
        Print.p(toString(head));
        if (p) Print.p("Calling 1, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        //Y = X.substring(index, index + 1); // Add the element to the current subset
        Print.p("1000," + permutation(curr, X, Y, index + 1, level));
        level++;
        Print.p(level);
        if (p) Print.p("Returning 1, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        if (X.length() > 0)
        {
            //if (p) Print.p("Calling 4, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
            String newX = X.substring(0, index) + X.substring(index + 1);
            index = 0;
            //Y += X.substring(index, index + 1);
            if (p) Print.p("Calling 4A, index=[" + index + "], X=["+newX+ "], Y=["+Y+"], curr=["+curr+"]");
            permutation(curr, newX, Y, 0, level);
            if (p) Print.p("Returning 4A, index=[" + index + "], X=["+newX+ "], Y=["+Y+"], curr=["+curr+"]");
            curr += Y;
            Print.p(curr);
        }
        if (true) return used;
        // Recursive case: Include the current element
        Y += X.substring(index, index + 1); // Add the element to the current subset
        if (p) Print.p("Calling 2, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        permutation(curr, X.substring(1), Y, index + 1, level);
        if (p) Print.p("Returning 2, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        return used;
    }
    */
    public static int factorial(int n)
    {
        //Print.p(1000, n);
        if (n < 0) return 0;
        if (n < 2) return 1;
        int newN = n * factorial(n-1);
        //Print.p(2000, newN);
        return newN;
    }

    public static String powerSet(String X)
    {
        used = "";
        X = "123";//234";
        powerSet(X, "", 0);
        return used;
    }

    private static String powerSet(String X, String Y, int index)
    {
        if (index == X.length())
        {
            // Base case: We've considered all elements
            used += "," + Y;
            //Print.p(used);
            return used;
        }
        // Recursive case: Exclude the current element
        powerSet(X, Y, index + 1);
        // Recursive case: Include the current element
        Y += X.substring(index, index + 1); // Add the element to the current subset
        powerSet(X, Y, index + 1);
        return used;
    }

    public static String powerSet(int[] inputSet)
    {
        used = "";
        inputSet = new int[]{1,2,3};//"12";//234";
        int[] currentSet = new int[inputSet.length];
        powerSet(inputSet, currentSet, 0, 0);
        return used;
    }

    private static String powerSet(int[] inputSet, int[] currentSet, int index, int currentSize)
    {
        if (index == inputSet.length)
        {
            // Base case: We've considered all elements
            used += "," + makeSet(currentSet,currentSize);
            //Print.p(used);
            return used;
        }
        // Recursive case: Exclude the current element
        powerSet(inputSet, currentSet, index + 1, currentSize);
        // Recursive case: Include the current element
        currentSet[currentSize] = inputSet[index]; // Add the element to the current subset
        powerSet(inputSet, currentSet, index + 1, currentSize + 1);
        return used;
    }

    private static String makeSet(int[] arr)
    {
        return makeSet(arr, arr.length);
    }

    private static String makeSet(int[] arr, int len)
    {
        String result = "{";
        for (int i=0; i < len; i++)
            result += arr[i] + (i + 1 < len ? "," : "");
        return result + "}";
    }

    private static String makeSet(String arr)
    {
        String result = "{" + arr;
        return result + "}";
    }
    // Function to find all interleaving of string `X` and `Y`
    public static String findInterleavings(String X, String Y)
    {
        p = true;
        used = "";
        return findInterleavings("", X, Y);
    }

    public static String findInterleavings(String curr, String X, String Y)
    {
        // insert `curr` into the set if the end of both strings is reached
        if (X.length() == 0 && Y.length() == 0)
        {
            if (used.indexOf(curr) < 0)
                used += "," + curr;
            if (p) Print.p(used);
            return "";//used;
        }
        // if the string `X` is not empty, append its first character in the
        // result and recur for the remaining substring
        if (X.length() > 0) {
            //if (p) Print.p("1000," + curr + " ,["+X.substring(1)+"]");
            //if (p) Print.p("1100," + used);
            if (p) Print.p("Calling 1, curr=[" + curr + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
            findInterleavings(curr + X.charAt(0), X.substring(1), Y);
            //if (p) Print.p("1200," + X);
            if (p) Print.p("Returning 1, curr=[" + curr + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        }
        // if the string `Y` is not empty, append its first character in the
        // result and recur for the remaining substring
        if (Y.length() > 0) {
            //if (p) Print.p("2000, " + curr + " [" + Y);
            //if (p) Print.p("2100," + used);
            if (p) Print.p("Calling 2, curr=[" + curr + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
            findInterleavings(curr + Y.charAt(0), X, Y.substring(1));
            //if (p) Print.p("2200," + Y);
            if (p) Print.p("Returning 2, curr=[" + curr + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        }
        if (p) Print.p("3000 " +used);
        return used;
    }
    static String DA[][] = null, DB[][] = null;
    private static void initD(String S, int i, int j, String[][] D)
    {
        boolean p = false;
        if (p) Print.p(1000, i, j);
        int lenj = S.length() - i;
        if (p) Print.p(2000, j, lenj);
        if (j + lenj > S.length()) lenj = 0;
        String subj = S.substring(j, j + lenj); 
        if (p) Print.p(subj);
        D[i][j] = subj;
        if (p) Print.p(Arrays.deepToString(D));
        if (j-- > 0)
            initD(S, i, j, D);
        else
        {
            j = S.length() - 1;
            if (i-- > 0)
                initD(S, i, j, D);
        }
    }
}
