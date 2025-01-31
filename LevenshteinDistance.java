package תרגילים_נוספים;

import static Library.Print.p;
import static Library.MyLibrary.*;

import java.util.Arrays;
/**
 * EditDistance does Approximated String Matching.
 * Based on a homework exercise of U.O.Hiafa on 15/12/2002
 * One model of the distance between two strings. Our model deals with converting one
 * string of characters to another string of characters by a series of edit 
 * operations on single characters. The allowed operations are:
 *  INSERT - insertion of a single character to the rst string (e.g. CT!CAT).
 *  DELETE - deletion of a single character from the rst string (e.g. CAAT!CAT)
 *  SUBSTITUTE - substitution of a single character from the first string with a
 *      single character from the other string (e.g. KAT !CAT)
 *
 * Following are a few examples:
 *  1. Consider the string APPLETS. In order to convert it into the string APPLES we
 *  should perform one delete operation.
 *  2. Consider the string CSINTRO. In order to convert it into the string CASINO we
 *  need to perform one insert operation (insert the character A) and two delete
 *  operation (delete T, delete R).
 *  3. Consider the string BOLD. In order to convert it into the string BALD we need
 *  to perform one substitute operation (substitute O with A).
 *  
 *  Let A and B be character strings. We define the edit distance between A and B as
 *  the minimum number of operations (of insert, delete and substitute) needed to 
 *  be performed on the string A in order to transform it into the string B.
 *  
 *  function LevenshteinDistance(A, B):
    m = len(A)
    n = len(B)
    D = array of size (m+1, n+1)

    for i = 0 to m:
        D[i][0] = i
    for j = 0 to n:
        D[0][j] = j

    for i = 1 to m:
        for j = 1 to n:
            if A[i-1] == B[j-1]:
                cost = 0
            else:
                cost = 1
            D[i][j] = min(
                D[i-1][j] + 1,       # Deletion
                D[i][j-1] + 1,       # Insertion
                D[i-1][j-1] + cost   # Substitution
            )

    return D[m][n]
 *  
 * @author (your name)
 * @version (07.12.2024)
 */
public class LevenshteinDistance
{
    public static boolean p = true;;
    public static int approximatedStringMatching(String[] dict, boolean ignoreCase)
    {
        p(Arrays.toString(dict));
        String A = dict[0];
        int index = 1, minimum = A.length();
        for (int k = 1; k < dict.length; k++)
        {
            String B = dict[k];
            int lenA = A.length(), lenB = B.length();
            int[][] D = new int[lenA+1][lenB+1];
            int cost;
            for (int i = 0; i <= lenA; i++)
                D[i][0] = i;
            for (int j = 0; j <= lenB; j++)
                D[0][j] = j;
        
            for (int i = 1; i <= lenA; i++)
            {
                for (int j = 1; j <= lenB; j++)
                {
                    char charA = (ignoreCase ? Character.toUpperCase(A.charAt(i-1)) : A.charAt(i-1)); 
                    char charB = (ignoreCase ? Character.toUpperCase(B.charAt(j-1)) : B.charAt(j-1)); 
                    cost = (charA == charB ? 0 :1);
                    D[i][j] = min(
                        D[i-1][j] + 1,       // Deletion
                        D[i][j-1] + 1,       // Insertion
                        D[i-1][j-1] + cost   // Substitution
                    );
                }
            }
            if (p) System.out.println(A + "," + B);
            if (p) p(D);
            if (p) System.out.println("minOperations="+minimum+" now="+D[lenA][lenB]+" k="+k+" index="+index);
            if (minimum > D[lenA][lenB])
            {
                minimum = D[lenA][lenB];
                index = k;
            }
        }
        return index;
    }
    private static int min(int a, int b, int c)
    {
        return min(min(a,b), c);
    }
    private static int min(int a, int b)
    {
        return (a < b ? a : b);
    }
    public static void __editDistance(String A, String B)
    {
        p(1000, _editDistance(A, B));
    }
    public static int _editDistance(String A, String B)
    {
        int lenA = A.length(), lenB = B.length();
        if (lenA == 0 && lenA == 0) return 0;
        if (lenA == 0) return lenB;
        if (lenB == 0) return lenA;
        /* let the longest prefix of a String S which does not include the last 
         * character of S be pref(S) and let the last character of S be last(S).
         * We define p as: 0 if last(A) = last(B), 1 otherwise.
         */
        String prefA = A.substring(0, lenA - 1);
        String prefB = B.substring(0, lenB - 1);
        int p = (A.charAt(lenA - 1) == B.charAt(lenB - 1) ? 0 : 1);
        /*
        p(A);
        p(B);
        p(prefA);
        p(prefB);
        p(p);
        */
        int d1 = _editDistance(prefA, prefB) + p;
        p(1000, d1);
        int d2 = _editDistance(A, prefB) + 1;
        p(1000, d2);
        int d3 = _editDistance(prefA, B) + 1;
        p(1000, d3);
        return d1;
    }
}
