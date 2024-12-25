
/**
 * Class Efficiancy is a collection of examples of writing a method which is efficient
 * Based on example from lectures by DR. Amir Goren
 *
 * @author (Zvika Barak)
 * @version (24.12.2024)
 */
public class Efficiancy
{
    /**
     * Given an array of integers.
     * Write a method to split the array into 2 sub-arrays, based on an index i,
     * such that the left-array includes all the numbers to the laft of position i
     * (i included) and right-array with all the other numbers (to the right of the
     * ith position). Find difference (in absoluto value) between the average of
     * the 2 parts. Find the largest difference and returns it's index.
     * Example {5,7,-2,10}
     * 
     * Efficiancy if of n + (1+n-1)*(n-1)/2 = n + (n*n-n)/2 -> O(n2)
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
     * Given an array of size n+1 full with all the integers from 1 to n, and one
     * more integer from 1 to n, such that this number, appears twice.
     * Write a method to find that number
     * Example {2,3,1,4,3,5}
     */
    public static int findDuplicate(int[] a)
    {
        int n = a.length-1;
        int sum = (1 + n) * n / 2;
        for (int i=0; i<n+1; i++)
            sum -= a[i];
        return -sum;
    }
    /**
     * Write a function that takes a list of integers as input and checks whether
     * it is a superincreasing sequence. A sequence is superincreasing if each 
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
     * Given a superincreasing sequence and a number, determine if the number can 
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
