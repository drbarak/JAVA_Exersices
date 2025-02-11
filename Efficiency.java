package תרגילים_נוספים;

import static Library.Print.p;
import static Library.MyLibrary.*;
import java.util.Arrays;
/**
 * Class Efficiancy is a collection of examples of writing a method which is efficient
 * Based on example from lectures by DR. Amir Goren
 *
 * @author (Zvika Barak)
 * @version (24.12.2024)
 */
public class Efficiency
{
    private static int count = 0;
    private static boolean p = false;
    /**
     * Given an array of integers (+ve, 0 and -ve) such that in even positions
     * the numbers are in increasing order and in odd positions the numbers
     * are in decreasing order, and in each series there are no equal numbers.
     * Write a method to order the array.
     * 
     * Example: {1,9,2,8,4,7,7,4,12}
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int[] orderCrossedArray(int[] a)
    {
        if (a == null) return a;
        int n = a.length;
        if (n < 1) return a;
        //reverse Odd sub array
        int left = 1;
        int right = n - (n%2 == 0 ? 1 : 2);
        while (left < right) {
            swap(a, left, right);
            left += 2;
            right -= 2;
        }
        // Use two pointers to merge the even and odd indexed elements
        int e = (n%2 == 0 ? n-2 : n-1);
        int o = (n%2 == 0 ? n-1 : n-2);
        final boolean LEFT = false;
        while (e >= 0 && o >= 1)
        {
            while (a[e] < a[o] && o >=1)
            {
                bubbleSwap(a, e, o, LEFT);
                o -= (o > 1 ? 2 : o);
                if (a[e] > a[o])
                    e--;
            }
            while (a[e] > a[o])
                e--;
            e -= (e > 0 ? 1 : e);
            while (a[e] > a[o] && e < o)
                bubbleSwap(a, e++, o, !LEFT);
        }
        return a;
    }
    private static void bubbleSwap(int[] a, int i, int j, boolean right)
    {
        if (right)
            while (a[i] > a[j] && i < j)
                swap(a, i++, j++);
         else
             while (a[i] < a[j] && i > j)
                swap(a, i--, j);
    }
    
    public static int[] orderCrossedArrayOK(int[] a)
    {
        int n = a.length;
        count = 0;
        p = false;
        p(a);
        
        reverseOddIndicesOK(a);
        if (p) p(a);
        // Use two pointers to merge the even and odd indexed elements
        int e = (n%2 == 0 ? n-2 : n-1);
        int o = (n%2 == 0 ? n-1 : n-2);
        final boolean LEFT = false;
        while (e >= 0 && o >= 1)
        {
            count++;
            if (p) p(e, o, a[e], a[o]);
            while (a[e] < a[o] && o >=1)
            {
                if (p) p("1st while left");
                bubbleSwapOK(a, e, o, LEFT);
                if (p) p("back");
                if (p) p(e, o, a[e], a[o]);
                o -= (o > 1 ? 2 : o);
                if (a[e] > a[o])
                    e--;
                if (p) p(a);
                if (p) p(e, o, a[e], a[o]);
            }
            while (a[e] > a[o])
            {
                e--;
                if (p) p(e, o, a[e], a[o]);
            }
            e -= (e > 0 ? 1 : e);
            if (p) p(e, o, a[e], a[o]);
            while (a[e] > a[o] && e < o)
            {
                if (p) p("2nd while right");
                bubbleSwapOK(a, e, o, !LEFT);
                e++;
                if (p) p(a);
                if (p) p(e, o, a[e], a[o]);
            }
        }
        boolean ordered = true;
        for (int i = 0; i < n-1 && ordered; i++)
            if (a[i] > a[i + 1]) ordered = false;
        p("ORDERED = " + ordered);
        p("count = " + count + ", len = " + n);
        return a;
    }
    private static void bubbleSwapOK(int[] a, int i, int j, boolean right)
    {
        if (p) p("in bubble");
        if (p) p(i, j, a[i], a[j]);
        if (false && a[i] > a[j])
        {
            int temp = i;
            i = j;
            j = temp;
        }
        if (right)
        {
            while (a[i] > a[j] && i < j)
            {
                count++;
                if (p) p(i, j);
                swap(a, i++, j++);
                if (p) p(a);
            }
            return;
        }
        while (a[i] < a[j] && i > j)
        {
            count++;
            if (p) p(i, j);
            swap(a, i--, j);
            if (p) p(a);
        }
    }
    private static void reverseOddIndicesOK(int[] a) {
        int n = a.length;
        // Determine the first and last odd indices.
        int left = 1;
        int end = (n%2 == 0 ? 1 : 2);
        int right = n - end;
        while (left < right) {
            swap(a, left, right);
            left += 2;
            right -= 2;
        }
    }
    /*
    public static int[] orderCrossedArray(int[] a)
    {
        p(a);
        if (a == null || a.length == 0) return a;
        int n = a.length-1;
        if (n == 0) return a;
        int end1 = (n % 2 == 0 ? n : n-1); // the end of the decreasing sub-array
        int start1 = 0;
        int start2 = (n % 2 == 0 ? n-1 : n); // the start of the decreasing sub-array
        int end2 = (n % 2 == 0 ? n-1 : n);
        int[] b = new int[n+1];
        for (int i = 0; i <= n; i++)
        {
            p(i, start1, start2, end1); 
            if (start2 < 0 || (start1 <= end1 && a[start1] <= a[start2]))
            {
                b[i] = a[start1];
                start1 += 2;
            }
            else
            {
                b[i] = a[start2];
                start2 -= 2;
            }
            p(b);
            p(i, start1, start2, n);
        }
        return b;
    }
    */
    /**
     * Given an ordered array of integers.
     * Write a method to find lowest sum of 2 absolute value of neighbours
     *  (if a member is -ve then look at it's absolute value before adding)
     * 
     * Time Complexity: O(logn)
     * Space Complexity: O(1) becuase the loops do not uses additional memory
     */
    public static int findMinAbsSum(int[] a)
    {
        if (a == null || a.length == 0) return 0;
        int n = a.length;
        if (n == 1) return Math.abs(a[0]);
        if (n == 2) return Math.abs(a[0]) + Math.abs(a[1]);
        if (a[0] >= 0) return a[0] + a[1];   // in case only +ve numbers
        if (a[n-1] < 0) return -a[n-1] - a[n-2];  // in case only -ve numbers
            // find where -ve numbers end
        int lo = 0, hi = n-1, mid = 0;
        while (lo <= hi)
        {
            mid = (lo + hi) / 2;
            p(lo, mid, hi, a[mid]);
            if (a[mid] == 0) break;
            if (a[mid] < 0) lo = mid+1;
            else if (a[mid] > 0) hi = mid-1;
        }
        p(mid, a[mid]);
        int num1, num2, num3 = Integer.MAX_VALUE;
        if (mid == n-1) {
            num1 = a[mid] - a[mid-1];   // last member must be +ve and prev is -ve
            num2 = -a[mid-2] - a[mid-1];
        }
        else if (mid == 0) {
            num1 = -a[mid] + a[mid+1];   // 1st member must be -ve and next is +ve
            num2 = a[mid+2] + a[mid+1];
        }
        else if (a[mid] >= 0){
            num1 = a[mid] + Math.abs(a[mid-1]);
            num2 = a[mid] + a[mid+1];
            num3 = Math.abs(a[mid-2]) + Math.abs(a[mid-1]);
        }
        else {
            num1 = -a[mid] - a[mid-1];
            num2 = -a[mid] + a[mid+1];
            num3 = a[mid+2] + a[mid+1];
        }
        //return minOf3(num1, num2, num3);
        return Math.min(Math.min(num1, num2), num3);
    }
    /**
     * A helper method to calculate the minimum out of 3 integer numbers
     */
    private static int minOf3(int num1, int num2, int num3)
    {
        return Math.min(Math.min(num1, num2), num3);
    }
    /**
     * A helper method to calculate the minimum out of 4 integer numbers
     */
    private static int minOf4(int num1, int num2, int num3, int num4)
    {
        return Math.min(Math.min(num1, num2), Math.min(num3, num4));
    }
    /**
     * Given an array of non-negative integers (>=0).
     * Write a method to find a continuous sub-array whose sum equals a Target number.
     * Return the indices of the start and end of the sub-array.
     * 
     * Note: the following solution will not work if we allow -ve integers in the array
     * 
     * Time Complexity: n + n -> O(n)
     * Space Complexity: O(1) becuase the loops do not uses additional memory
     */
    public static int[] findSubarraySumTarget(int[] a, int target)
    {
        count = 0;
        int sum = 0, j, i = 0;
        if (target < 0) i = a.length;
        int[] result = new int[]{0,0};
        for (;i<a.length;i++)
        {
            count++;
            sum += a[i];
            //Print.p(i, sum, target, a[i]);
            if (sum == target)
            {
                result[1] = i;
                return result;
            }
            if (sum > target) // here we assume all numbers are non negetive
            {
                j = result[0];
                while (sum > target) // also here we assume all numbers are non negetive
                    sum -= a[j++];
                result[0] = j;
                if (sum == target)
                {
                    result[1] = i;
                    return result;
                }
            }
        }
        p("count=" + count);
        result[0] = result[1] = -1;
        return result;
    }
    
    /**
     * Allow -ve numbers
     * Create map[][] where map[i][] has 3 numbers{sumToI,i,target-sumToI}
             for each i in the array
     * Search to see if map[i][2] already exists in map[i][0]
            // which means, find an index where the cumulative sum equals
            // sumMap-target, because if we start with that index until the
            // current one we will have the sub array
            // for example with array {3,3,-7,-1,3,3,1,-4} and target 7,
            // the map[3] is [-2, 3, 9] and map[6] = [5, 6, -2] thus the
            // subarray starts at 4 and ends at 6, and indeed 3+3+1=7
            // because if we subtract the cumulative sum of index 3 (-2)
            // from the difference between cumulative sum and the target of
            // index 6 (=-2) we get to 0, which means the cumulative sum between
            // the index after and the current one will give us the required
            // sub array
     * Time Complexity: n*(n+1)/2 -> O(n^2) (worst case=not found)
     * Space Complexity: O(1) becuase the loops do not uses additional memory
     */
    public static int[] findSubarrayAlsoNegative(int[] a, int target)
    {
        count = 0;
        int sum = 0, j, i = 0, sumMap = 0;
        int[] result = new int[]{0,0};
        int[][] map = new int[a.length+1][3];
        map[0]=new int[]{0,0,0};
        boolean p = false;
        for (;i<a.length;i++)
        {
            sum += a[i];
            sumMap += a[i];
            //Print.p(i, sum, target, a[i]);
            // search the map - if we HashMap there will not be a need to do a loop
            // just use the method containsKey() pf HashMap to find the 
            // key=(sumMap-target) which we stored as key the value we currently
            // save in map[i][0]
            if (p) p(i, sumMap, sumMap-target);
            for (j=0; j<=i;j++)
            {
                count++;
                if (sumMap - target == map[j][0])
                {
                    result[0] = j;
                    result[1] = i;
                    //Print.p("count="+count);
                    return result;
                }
            }
            map[i+1][0] = sumMap;
            map[i+1][1] = i;
            map[i+1][2] = sumMap - target;
            if (p) p("i+1="+(i+1)+",target="+target+", "+Arrays.toString(map[i+1]));
            //Print.p("i="+i+"count="+count);
        }
        //for (i=0;i<a.length;i++)  Print.p(Arrays.toString(map[i]));
        p("count=" + count);
        result[0] = result[1] = -1;
        return result;
    }
    /**
     * Given an array of integers.
     * Write a method to split the array into 2 sub-arrays, based on an index i,
     * such that the left-array includes all the numbers to the laft of position i
     * (i included) and right-array with all the other numbers (to the right of the
     * ith position). Find difference (in absolute value) between the average of
     * the 2 parts. Find the largest difference and returns it's index.
     * Example {5,7,-2,10}
     * 
     * Efficiancy is of n + (1+n-1)*(n-1)/2 = n + (n*n-n)/2 -> O(n^2)
     * Complexity is O(1) becuase the loops do not uses additional memory
     */
    public static int findLargestAverageDiff(int[] a)
    {
        int index = 0;
        double maxAverageDiff =-1;
        int sumOfArray = 0;
        for (int i=0;i<a.length;i++)
            sumOfArray += a[i];
        int leftSum;
        double avgLeft, avgRight, diff; 
        for (int i=0;i<a.length-1;i++)  // loop over all possible indecies
        {
            leftSum = 0;
            for (int j=0; j<i+1;j++)
               leftSum += a[j];
            avgLeft = ((double)leftSum / (double)(i + 1));
            avgRight = (double)(sumOfArray - leftSum) / (double)(a.length - 1 - i);
            //Print.p(""+sumOfArray+", "+leftSum+", "+avgLeft+", "+avgRight);
            diff = Math.abs(avgLeft - avgRight);
            if (maxAverageDiff < diff)
                index = i;
            //Print.p(""+i+", "+index+", "+diff);
        }
        return index;
    }
    /**
     * Given an array of size n+1 full with all the integers from 1 to n, and
     * one more integer from 1 to n, such that this number, appears twice.
     * Write a method to find that number
     * Example {2,3,1,4,3,5}
     */
    public static int findDuplicateNumInArray(int[] a)
    {
        int n = a.length-1;
        int sum = (1 + n) * n / 2;
        for (int i=0; i<n+1; i++)
            sum -= a[i];
        return -sum;
    }
    /**
     * Write a function that takes a list of integers as input and checks whether
     * it is a super-increasing sequence. A sequence is super-increasing if each 
     * element is greater than the sum of all previous elements.
     * Thus, given the serie <a1,a2,a3,a4,,,an> then for each element aj
     *     aj = sum of a1,a2,a3,...,aj-1 for eacg j >= 2
     * Example {1, 2, 4, 8, 16} is True, but {1, 2, 3, 8, 16} is False
     */
    public static boolean isSuperIncreasing(int[] a)
    {
        if (a.length < 2) return false;
        int sum = a[0] + a[1];
        for (int i=2; i<a.length; i++)
        {
            if (sum >= a[i]) return false;
            sum += a[i];
        }
        return true;
    }
    /**
     * Given a super-increasing sequence and a number, determine if the number can 
     * be represented as the sum of a subset of the sequence. If yes, return the 
     * binary representation of the subset (1 for each number included in the sum, 0 
     * otherwise). If no, return None.
     * Example: Sequence: [1, 2, 4, 8, 16] and number 23 returns [1, 1, 1, 0, 1]
     *          Same sequence: [1, 2, 4, 8, 16] and number 3 returns null
     */
    public static int[] superIncreasingRepresentation(int []a, int number)
    {
        int num = number;
        int[] result = new int[a.length];
        for (int i=a.length-1; i>=0; i--)
        {
            if (num == a[i])
            {
                result[i]=1;
                return result;
            }
            if (num > a[i])
            {
                num -= a[i];
                result[i]=1;
            }
            else
                continue;
        }
        return null;
    }
}// class Efficiancy
