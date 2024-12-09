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
    public static String powerSet(String curr, int[] X, int[] Y, int len)
    {
        // insert `curr` into the set if the end of strings reached
        if (X.length == 0 && Y.length == 0)
        {
            if (used.indexOf(curr) < 0)
                used += "," + curr;
            Print.p(used);
            len--;
            Print.p(len, 100);
            return used;
        }
            Print.p(len, 500);
        // if the string `X` is not empty, append its first character in the
        // result and recur for the remaining substring
        if (X.length > 0 && len == 3) {
            int[] subArray = Arrays.copyOfRange(X, 1, X.length);
            Print.p("1000," + curr + Arrays.toString(subArray));
            String result = powerSet(curr + "{" + X[0] + "}", subArray, Y, len);
            Print.p("1500," + result);
            Print.p(--len, X.length);
            Print.p(X);
        }
        if (len == 2) {
            int[] subArray = Arrays.copyOfRange(X, 2, X.length);
            Print.p("2000," + curr + " ,"+Arrays.toString(subArray));
            Print.p(Arrays.copyOfRange(X, 0, len));
            Print.p(subArray);
            //powerSet(curr + ",{" + Arrays.copyOfRange(X, 0, len) + "}", subArray, Y, len);
        }
        return used;
    }
    public static String powerSet(String curr, int[] X, int[] Y)
    {
        // insert `curr` into the set if the end of both strings is reached
        if (X.length == 0)// && Y.length == 0)
        {
            if (used.indexOf(curr) < 0)
                used += "," + curr;
            Print.p(used);
            return used;
        }
        // if the string `X` is not empty, append its first character in the
        // result and recur for the remaining substring
        if (X.length > 0) {
            int[] subArray = Arrays.copyOfRange(X, 1, X.length);
            int[] newArray = Arrays.copyOfRange(X, 0, 1);
            Print.p("1000," + curr + ","+Arrays.toString(subArray));
            powerSet(curr + "," + makeSet(newArray), subArray, Y);
        }
         // if the string `Y` is not empty, append its first character in the
        // result and recur for the remaining substring
        if (false && Y.length > 0) {
            Print.p("1900, " + curr + "," + Arrays.toString(Y));
            int[] subArray = Arrays.copyOfRange(Y, 2, Y.length);
            int[] newArray = Arrays.copyOfRange(Y, 0, 2);
            Print.p("2000, " + curr);
            powerSet(curr + makeSet(newArray), X, subArray);
        }
        return used.substring(1);
    }
    private static String makeSet(int[] arr)
    {
        String result = "{";
        for (int i=0; i < arr.length; i++)
            result += arr[i] + (i + 1 < arr.length ? "," : "");
        return result + "}";
    }

    // Function to find all interleaving of string `X` and `Y`
    public static String findInterleavings(String curr, String X, String Y)
    {
        // insert `curr` into the set if the end of both strings is reached
        if (X.length() == 0 && Y.length() == 0)
        {
            if (used.indexOf(curr) < 0)
                used += "," + curr;
            Print.p(used);
            return used;
        }
        // if the string `X` is not empty, append its first character in the
        // result and recur for the remaining substring
        if (X.length() > 0) {
            Print.p("1000," + curr + " ,["+X.substring(1)+"]");
            findInterleavings(curr + X.charAt(0), X.substring(1), Y);
        }
         // if the string `Y` is not empty, append its first character in the
        // result and recur for the remaining substring
        if (Y.length() > 0) {
            Print.p("2000, " + curr);
            findInterleavings(curr + Y.charAt(0), X, Y.substring(1));
        }
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
