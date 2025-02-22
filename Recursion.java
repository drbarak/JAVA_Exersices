package תרגילים_נוספים;

import static Library.Print.*;
import static Library.MyLibrary.*;
import java.util.Arrays;
/**
 * Write a description of class Recursion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recursion
{
    private static boolean p = false;
    static int count = 0;
    /**
     * A method to find the longest common semi-substring LCS among three given
     * strings. 
     * A semi-substring is defined as a sequence of characters that appears in 
     * all three strings in the same order but not necessarily continuously.
     */
    public static String findLCS(String s1, String s2, String s3)
    {
        return findLCS(s1, s2, s3, 0,0,0, "");
    }
    private static String findLCS(String s1, String s2, String s3, 
                        int i, int j, int k, String current)
    {
        if (i == s1.length()|| j == s2.length() || k == s3.length())
            return current;
        if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k))
            return findLCS(s1, s2, s3, i+1, j+1, k+1, current + s1.charAt(i));
        String lcs1 = findLCS(s1, s2, s3, i + 1, j, k, current);
        String lcs2 = findLCS(s1, s2, s3, i, j + 1, k, current);
        String lcs3 = findLCS(s1, s2, s3, i, j, k+1, current);
        return maxString(lcs1, lcs2, lcs3);
    }
    private static String maxString(String a, String b, String c)
    {
        int lenA = a.length();
        int lenB = b.length();
        int lenC = c.length();
        if (lenA>= lenB && lenA >= lenC) return a;
        if (lenB >= lenA && lenB >= lenC) return b;
        return c;
    }
    
    public static int equalSum(int[] _arr)// array is sorted
    {
        return equalSum (_arr, 0, _arr.length - 1, _arr[0], _arr[_arr.length - 1]);
    }
    private static int equalSum(int[] _arr, int left, int right, int sumLeft, int sumRight)
    {
        if (left >= right) return -1;
        if (sumLeft == sumRight)
        {
            if (left + 1 == right) return left;
            return equalSum(_arr, left + 1, right - 1, sumLeft + _arr[left + 1], 
                                            sumRight + _arr[right - 1]);
        }
        if (sumLeft < sumRight)
          return equalSum(_arr, left + 1, right, sumLeft + _arr[left + 1], sumRight);
        return equalSum(_arr, left, right - 1, sumLeft, sumRight + _arr[right - 1]);
    }     
    public static int equalSumNoGood(int[] arr)
    {
        p(arr);
        int total = equalSum(arr, 0, 0);
        if (total % 2 == 1) return -1;
        return equalSum(arr, 0, total, 0);
    }
    private static int equalSum(int[] a, int i, int total)
    {
       if (i == a.length) return total;
       return equalSum(a, i + 1, total + a[i]);
    }
    private static int equalSum(int[] a, int i, int total, int sum)
    {
       if (i == a.length) return -1;
       sum += a[i];
       if (2 * sum == total) return i;
       return equalSum(a, i + 1, total, sum);
    }
    
    public static int howManySorted(int n, int max)    
    {
        //int[] a = new int[n];
        return howManySorted(null, 0, 1, n, max, 0);
    }
    private static int howManySorted(int[] a, int i, int start, 
                int n, int max, int counter)
    {
        if (i == n)
        {
            //p(a);
            return counter + 1;
        }
        return fillArray(a, i, start, n, max, counter);
    }
    private static int fillArray(int[] a, int i, int start, 
            int n, int max, int counter)
    {
        if (start <= max)
        {
            //a[i] = start;
            counter = howManySorted(a, i + 1, start, n, max, counter);
            return fillArray(a, i, start + 1, n, max, counter);
        }
        return counter;
    }
    
    public static boolean one(String s1, String s2)
    {
        pN(s1); pN(","); p(s2);
        if (s1.length() != s2.length()) return false;
        return one(s1, s2, 0);
    }
    private static boolean one(String s1, String s2, int i)
    {
        if (i == s1.length()) return true;
        if (s1.charAt(i) == s2.charAt(i))
            return one(s1, s2, i + 1);
        return (s1.substring(i+1).equals(s2.substring(i+1))); // found one ch not equal, the rest must be equals
    }

    public static int maxInMat(int[][]grid)
    {
        return maxInMat(grid, 0, 0, Integer.MIN_VALUE);
    }
    public static int maxInMat(int[][]grid, int x, int y, int max)
    {
        int n = grid.length;
        if (x == n) return max;   // end of matrix
        int m = grid[x].length;
        if (y == m) // end of a row
            return maxInMat(grid, x+1, 0, max);
        max = Math.max(max, grid[x][y]);
        return maxInMat(grid, x, y+1, max);
    }
    public static boolean zigzag(int[] a)
    {
        p(a);
        if (a.length == 1)
          return true;
        return zigzag(a,1);
    }
    private static boolean zigzag(int[] a, int i)
    {
        if (i == a.length) return true;
        if (i % 2 == 1 && a[i] <= a[i-1]) return false;
        if (i % 2 != 1 && a[i] >= a[i-1]) return false;
        return zigzag(a,i + 1);
    }
    public static int[] quickSort(int[] a)
    {
        p(a);
        // step 1: arrange the arry such that all members smaller
        // then the first member are to it's left and all higher to it's right
        int lo = 0, hi = a.length - 1;
        quickSort(a, lo, hi);
        return a;
    }
    public static void quickSort(int[] a, int lo, int hi)
    {
        // step 1: arrange the arry such that all members smaller
        // then the first member are to it's left and all higher to it's right
        if (lo < hi)
        {
            int mid = partition(a, lo, hi);
        if(p) p(mid, a[mid], lo, hi);
        if(p) p(a);
            quickSort(a, lo, mid - 1);
            quickSort(a, mid + 1, hi);
        }
    }
    private static int partition(int[] a, int lo, int hi)
    {
        if (lo < 0 || lo >= a.length) return lo;
        int pivot = a[lo];
        while (lo < hi)
        {
            while (lo < hi && a[lo] < pivot)
                lo++;
            while (a[hi] > pivot)
                hi--;
            //if(p) p(lo, hi);
            if (lo < hi)
                swap(a, lo, hi);
            //if(p) p(a);
            //if(p) p(lo, hi, a[lo],a[hi]);
        }
        return lo;
    }    
    public static int odd(int num)
    {
        return odd(num, 0);
    }
    public static int odd(int num, int counter)
    {
        if (num == 0) return counter;
        if (num % 10 % 2 == 1) counter += 1;
        return odd(num / 10, counter);
    }
    
    public static int necklace(int n)
    {
        //return necklace(n, 0, "");
        return necklace(n, 0);
    }
    private static int necklace(int n, int counter)
    {
        if (n <= 1) return counter + 1;
        counter = necklace(n-1, counter);
        //if (n > 1)
            counter = necklace(n-2, counter);
        return counter;
    }
    private static int necklace(int n, int counter, String s)
    {
        if (n <= 0)
        {
            p(s);
            return counter + 1;
        }
        else
        {
            counter = necklace(n-1, counter, s+"1");
            if (n > 1)
                counter = necklace(n-2, counter, s+"2");
        }
        return counter;
    }
    
    public static void binaryNumbers(int n)
    {
        p("binary numbers for n = "+n);
        binaryNumbers(n, "");
    }
    private static void binaryNumbers(int n, String s)
    {
        if (n == 0) p(s);
        else if (n == 1) binaryNumbers(n-1, s + "0");
        else binaryNumbers(n-2, s + "01");
    }
    /**
     * Given a 2-dim rectangular matrix with whole numbers.
     * The method will find the longest path from all paths formed by
     * moving up/down/left/right from a cell to its neighbour, and from any of
     * these cells move to the next valid cell, such that all cells in the path
     * form a continuous path and each new cell has a value larger by 1 than
     * the previuos cell in the path. Thus the path can not move to cell which
     * is less or equal the current one, so that it prevents duplicates or 
     * moving endlessly back and forth between cells, without the need to mark
     * those cells that are part of the path.
     * Note that the same cell can be the start of multiple pats, in different
     * directions.
     * Example:
     *          {3, 13, 15, 28,30}, // line 0
                {50,51,52,29,30}, // line 1
                {51,10,53,54,55}, // line 2
                {53,12,14,53,11}; // line 3
        has 3 worms: starting in (0,3) 28,29,30 ending in (1,4),
                     starting in (1,0) 50,51,52,53,54,55 ending in (2,4)
                     starting in (1,0) 50,51 ending in (2,0)
     */
    public static int longestWorm(int[][]grid)
    {
        //return longestWorm(grid, 0, 0, -1, 0, 0, 0);
        return longestWorm(grid, 0, 0, 0);  // school
    }
    public static int longestWorm(int[][]grid, int x, int y, int max)
    {
        p = true;
        int n = grid.length;
        if (x == n) return max;   // end of matrix
        int m = grid[x].length;
        if (y == m) // end of a row
            return longestWorm(grid, x+1, 0, max);
        if (p) p(900, x, y, max);
        int num = longestWormLoop(grid, x, y, grid[x][y]-1);
        max = Math.max(max, num);
        if (p) p(910, x, y, max);
        return longestWorm(grid, x, y+1, max);
    }
    public static int longestWormLoop(int[][]grid, int x, int y, int prev)
    {
        if (!isValid(grid, x, y) || grid[x][y]-1 != prev) return 0;
        //if (max <= len) max = len+1;
        if (p) p(1000, x, y, grid[x][y], prev);
        return maxOf4(1 + longestWormLoop(grid, x+1, y, grid[x][y]),
            1 + longestWormLoop(grid, x-1, y, grid[x][y]),
            1 + longestWormLoop(grid, x, y+1, grid[x][y]),
            1 + longestWormLoop(grid, x, y-1, grid[x][y]));
    }
    public static int longestWorm(int[][]grid, int x, int y, int prevX, int prevY, int len, int max)
    {
        p = true;
        int n = grid.length;
        if (x == n) return max;   // end of matrix
        int m = grid[x].length;
        if (y == m) // end of a row
            return longestWorm(grid, x+1, 0, prevX, prevY, len, max);
        if (p) p(900, x, y, len, prevX, prevY);
        int num=0;// = findWorm(grid, x, y, grid[x][y]-1);
        if (num >= 0)
            return Math.max(max, num);
        max = Math.max(max, -num);
        if (p) p(910, x, y, len, prevX, prevY);
        return longestWorm(grid, x, y+1, prevX, prevY, len, max);
    }
    public static int findWorm(int[][]grid, int x, int y, int prevX, int prevY, int len, int max)
    {
        int n = grid.length;
        int m = grid[0].length;
        if (prevX >= 0 && (!isValid(n, x, m, y) || grid[x][y]-1 != grid[prevX][prevY])) return -1;
        if (max <= len) max = len+1;
        if (p) p(1000, x, y, len, grid[x][y], max);
        if (findWorm(grid, x+1, y, x, y, len+1, max) > 0 ||
            findWorm(grid, x-1, y, x, y, len+1, max) > 0 ||
            findWorm(grid, x, y+1, x, y, len+1, max) > 0 ||
            findWorm(grid, x, y-1, x, y, len+1, max) > 0)
        {            
            if (p) p(1100, x, y, len, grid[x][y], max);
            if (max <= len) max = len+1;
            return max;
        }
        if (p) p(1200, x, y, len, grid[x][y], max);
        if (max <= len) max = len+1;
        return -max;//findWorm(grid, x, y+1, x, y, 0, max);
    }

    /**
     * Given a 2-dim square matrix with +ve whole numbers > 0.
     * The method will find all "path"s of 4 or less close neighbours of a 
     * cell such that the sum of those cells equal a supplied +ve whole target.
     * The method returns true or false to indicate if a path was found or not.
     * The supplied matrix, named path, should hold 1 at the cells which
     * belong to the path, 0 otherwise. If there are more than one path, any
     * of them is a valid solution, and will also show with 1 at the proper
     * cells. If a cell belongs to 2 different paths (at least 1 cell is new)
     * then it will have 11 (if it belongs to 2 paths, 111 belongs to 3 paths
     * and so on).
     * A variation of this method is when the parameter allowMultiplePaths is
     * set to false. In that case only the first path from a starting cell is
     * returned, but the path is not restricted to the cells adjacent to the
     * cell, but as long as the other cells are neighbours of the previuous
     * cell such that the form a continuous path, they are valid.
     * Example: for target 4 and the matrix
     *          {2, 41, 3, 14}, // line 0
                {2, 1, 24, 7}, // line 1
                {2, 15, 10, 54}, // line 2
                {63, 22, 2, 4}}; // line 3
        possible solutions are: (0,0)+(0,1), (0,1)+(0,2), (3,3)
     */
    public static boolean findSumInMatrix(int[][]grid, int sum, int[][]path)
    {
        String[] pathArr = new String[]{"",""};
        boolean allowMultiplePaths = false;
        p = true;
        if (allowMultiplePaths)
            return findSumInMatrix(grid, sum, path, 0, 0, true, pathArr);
        int x = -1, y = -1, i = -1;
        boolean res = true;
        while (true)
        {
            switch (i++){
                case -1: x = 0; y = 0; break;
                case 0: x = 0; y = 2; break;
                case 1: x = y = 3; break;
                case 2: x = 2; y = 1; break;
                case 3: x = 0; y = 3; break;
                case 4: x = 1; y = 1; break;
                case 5: x = 1; y = 2; break;
                case 6: x = 1; y = 3; break;
                default: i = 100;
            }
            if (i >= 1) break;
            clearArray(path);
            //res = findSumCorrected(grid, sum, path, x, y);  // find at 0,0
            res = findSum(grid, sum, path, x, y);  // find at 0,0
            if (res)
                p("found a solution starting at " + makePt(x,y));
            p(path);
            //if (i > 5) break;
        }
        return res;
    }
    private static void clearArray(int[][] path)
    {
        for (int i=0; i<path.length; i++)
            for (int j=0; j<path.length; j++)
                path[i][j] = 0;
    }
    // corrected school solution - search for one path only without the parameter "allowMultiplePaths"
    public static boolean findSumCorrected(int[][]grid, int sum, int[][]path, 
            int x, int y)
    {
        //p = true;
        int n = grid.length;
        if (x == n) return false;   // end of matrix
        if (y == n) // end of a row
            return findSumCorrected(grid, sum, path, x+1, 0);
        if (p) p(1000, x, y, sum, grid[x][y], 100000);
        if (sum >= grid[x][y])
        {
            int[] _sum = new int[]{sum, x, y};
            if (findPathCorrected(grid, x, y, sum, path, x, y, 0, _sum))
                return true;
        }
        if (p) p(1010, x, y, sum, grid[x][y], 1010);
        if (path[x][y] > 0) // moving to another starting point so need to reset prev cells
        {
            path[x][y] = 0;
            if (isValid(n, x+1, y)) path[x+1][y] = 0;
            if (isValid(n, x-1, y)) path[x-1][y] = 0;
            if (isValid(n, x, y+1)) path[x][y+1] = 0;
            if (isValid(n, x, y-1)) path[x][y-1] = 0;
        }
        return findSumCorrected(grid, sum, path, x, y+1);
    }
     private static boolean findPathCorrected(int[][] grid, int i, int j, int sum, 
            int[][] path, int x, int y, int level, int[] _sum)
    {
        if (p) p(1100, i, j, sum);
        if (sum == 0) return true;
        int n = grid.length;
        //if (sum < 0 || !isValid(n, i, j) || path[i][j] == 1) return false;
        if (sum < 0 || !isValid(n, i, j)) return false;
        // not to discard the starting point as part of the checking neighbours
        if (path[i][j] == 1) return false;// && !(x == i && y == j)) return false;
        // to prevent checking cells not close neighbours of the original cell
        // because we cancelled the "path[i][j] == 1" test
        if (p) p(1140, i, j, x, y);
        if (p) p(1150, Math.abs(x-i), Math.abs(y-j), (Math.abs(x-i) + Math.abs(y-j)));
        if (Math.abs(x-i) > 1 || Math.abs(y-j) > 1 || 
                (Math.abs(x-i) + Math.abs(y-j)) > 1) return false;
        path[i][j] = 1;//10 * path[i][j] + 1;
        if (p) p(1200, i, j, sum, grid[i][j], path[i][j]);
        if (findPathCorrected(grid, i+1, j, sum-grid[i][j], path, x, y, 1, _sum) ||
            findPathCorrected(grid, i-1, j, sum-grid[i][j], path, x, y, 2, _sum) ||
            findPathCorrected(grid, i, j+1, sum-grid[i][j], path, x, y, 3, _sum) ||
            findPathCorrected(grid, i, j-1, sum-grid[i][j], path, x, y, 4, _sum))
        {
            return true;
        }
        // not to clear a valid cell if did not finished all recorsive calls
        if (p) p(1240, i, j, sum, grid[i][j], level);
        if (level == 4 || sum - grid[i][j] < 0)
        {
            if (p) p(1250, _sum[0], _sum[1], _sum[2], sum, grid[_sum[1]][_sum[2]]);
            if (p) p(1260, grid[i][j], _sum[0] - grid[i][j]); 
            if (_sum[0] - grid[i][j] == 0)
            {
            // in case need to reset current cell because with it the sum is -ve
                if (sum - grid[i][j] < 0)
                    resetCell(_sum[1], _sum[2], path, null);
                return true;
            }
            resetCell(i, j, path, null);
            //path[i][j] = (path[i][j] > 1 ? path[i][j]/10 : 0);
        }
        else if (sum - grid[i][j] > 0)
        {
            if (p) p(1270, _sum[0], _sum[1], _sum[2], sum, grid[_sum[1]][_sum[2]]);
            _sum[0] = Math.min(_sum[0], sum) - grid[i][j];
            _sum[1] = i;
            _sum[2] = j;
            if (_sum[0] == 0) return true;
        }
        if (p) p(1300, i, j, sum, path[i][j], level);
        return false;
    }
    private static void resetCell(int i, int j, int[][] path, String[] pathArr)
    {
        path[i][j] = (path[i][j] > 1 ? path[i][j]/10 : 0);
        if (pathArr != null)
        {
            String curPath = pathArr[1];
            if (curPath.length() > 0)
            {
                String pt = makePt(i,j);
                if (p) p("in resetCell ["+curPath+"],["+pt+"],"+
                        curPath.indexOf(pt)+", "+(curPath.length() - pt.length()));
                if (curPath.indexOf(pt) == curPath.length() - pt.length())
                {
                    curPath = curPath.substring(0, curPath.length() - pt.length());
                    pathArr[1] = curPath;
                    if (p) p("in resetCell2 ["+curPath+"]");
                }
            }
        }
        if (p) p("in resetCell3 "+i+", "+j+", "+path[i][j]);
    }
    // school solution - search for one path only without the parameter "allowMultiplePaths"
    public static boolean findSum(int[][]grid, int sum, int[][]path,int x, int y)
    {
        //p = true;
        int n = grid.length;
        if (x == n) return false;   // end of matrix
        if (y == n) // end of a row
            return findSum(grid, sum, path, x+1, 0);
        if (p) p(1000, x, y, sum, grid[x][y], 100000);
        if (sum >= grid[x][y])
        {
            if (findPathSchool(grid, x, y, sum, path))
                return true;
        }
        return findSum(grid, sum, path, x, y+1);
    }
    private static boolean findPathSchool(int[][] grid, int i, int j, int sum, 
            int[][] path)
    {
        if (p) p(1100, i, j, sum);
        if (sum == 0) return true;
        int n = grid.length;
        //if (sum < 0 || !isValid(n, i, j) || path[i][j] == 1) return false;
        if (sum < 0 || !isValid(n, i, j)) return false;
        if (path[i][j] == 1) return false;
        path[i][j] = 10 * path[i][j] + 1;
        if (p) p(1200, i, j, sum, grid[i][j], path[i][j]);
        if (findPathSchool(grid, i+1, j, sum-grid[i][j], path) ||
            findPathSchool(grid, i-1, j, sum-grid[i][j], path) ||
            findPathSchool(grid, i, j+1, sum-grid[i][j], path) ||
            findPathSchool(grid, i, j-1, sum-grid[i][j], path))
        {
            return true;
        }
        resetCell(i, j, path, null);
        //path[i][j] = (path[i][j] > 1 ? path[i][j]/10 : 0);
        if (p) p(1300, i, j, sum, path[i][j], 99999);
        return false;
    }
    public static boolean findSumInMatrix(int[][]grid, int sum, int[][]path, 
            int x, int y, boolean allowMultiplePaths, String[] pathArr)
    {
        //p = true;
        int n = grid.length;
        if (x == n) return false;   // end of matrix
        if (y == n) // end of a row
            return findSumInMatrix(grid, sum, path, x+1, 0, allowMultiplePaths, pathArr);
        if (p) p(1000, x, y, sum, grid[x][y], 100000);
        if (sum >= grid[x][y])
        {
            boolean exist = (allowMultiplePaths ? checkExist(path, x, y) : false);
            if (p) p(exist);
            int[] _sum = new int[]{sum, x, y};
            if (findPathInMatrix(grid, x, y, sum, path, allowMultiplePaths, exist, 
                        x, y, path[x][y], pathArr, 0, _sum))
            {
                if (!allowMultiplePaths)
                    return true;
                String curPath = pathArr[1];
                // check if wrong solution if (x,y) not included which means
                // other cells sum is the target and we let the other cells to be
                // the start of the solution (eg. a row has 2,4 we do not want the
                // 4 to be marked as a soultion from the cell of 2 but from the
                // cell of 4 (the target is 4)
                String pt = makePt(x,y);
                if (curPath.indexOf(pt) < 0)
                    clearCurPath(path, pathArr);

                    // check for duplicates
                pathArr[1] = "";
                if (pathArr[0].indexOf(curPath) > -1)  //exact path already exists
                {
                    if (p) p("need to delete duplicates paths ["+pathArr[0]+"], ["+curPath+"]");
                    //findPathInMatrix(grid, x, y, sum, path, allowMultiplePaths, exist, 
                    //    x, y, path[x][y], "D", pathArr, 0, _sum); // remove the duplicate path
                }
                else
                {
                    p("found a solution starting at " + makePt(x,y));
                    if (pathArr[0].length() > 0)
                        pathArr[0] += ",";
                    pathArr[0] += "["+curPath+"]";
                    if (p) p(pathArr[0]);
                    p(path);
                    //p = true;
                }
            }
            else
            {
                    // remove partial result
                String curPath = pathArr[1];
                if (p) p(1008, x, y, sum, grid[x][y], _sum[0]);
                if (p) p("1009 ,"+curPath);
                clearCurPath(path, pathArr);
            }
        }
        if (p) p(1010, x, y, sum, grid[x][y], sum-grid[x][y]);
        return findSumInMatrix(grid, sum, path, x, y+1, allowMultiplePaths, pathArr);
    }
    private static void clearCurPath(int[][] path, String[] pathArr)
    {
        String curPath = pathArr[1];
        while (curPath.length() > 0)
        {
            int k=curPath.length()-1;
            for (; k>=0 && (curPath.charAt(k) != '('); k--);
            if (k >= 0)                {
                int j = curPath.indexOf(',', k+1);
                int i = Integer.parseInt(curPath.substring(k+1, j));
                k = curPath.indexOf(')', k+1);
                j = Integer.parseInt(curPath.substring(j+1, k));
                resetCell(i, j, path, pathArr);
            }
            curPath = pathArr[1];
        }

    }
    private static boolean checkExist(int[][]path, int x, int y)
    {
        if (!isValid(path.length, x, y)) return false;
        if (path[x][y] > 0) return true;
        if (checkExist(path, x+1, y) && checkExist(path, x-1, y) &&
                checkExist(path, x, y+1) && checkExist(path, x, y-1))
            return true;
        return false;
    }
    private static boolean findPathInMatrix(int[][] grid, int i, int j, int sum, 
            int[][] path, boolean allowMultiplePaths, boolean exist, int x, 
            int y, int pathXY, String[] pathArr, int level, int[] _sum)
    {
        if (p) p(1100, i, j, sum);
        if (sum == 0)
        {
            _sum[0] = sum;
            return true;
        }
        int n = grid.length;
        //if (sum < 0 || !isValid(n, i, j) || path[i][j] == 1) return false;
        if (sum < 0 || !isValid(n, i, j)) return false;
        if (!allowMultiplePaths && path[i][j] == 1) return false;
        // to prevent checking cells not close neighbours of the original cell
        // because we cancelled the "path[i][j] == 1" test
        if (Math.abs(x-i) > 1 || Math.abs(y-j) > 1 || 
                (Math.abs(x-i) + Math.abs(y-j)) > 1) return false;
        if (!exist && path[i][j] > 0 && (i == x && j == y)) return false;  // startin cell
        //p(1100, i, j, sum, grid[i][j]);
        /*        
        if (path[i][j] == 0 || exist)
        {
            path[i][j] = 10 * path[i][j] + 1;
            exist = false;
        }
        */
        exist = path[i][j] > 0;
        // to prevent a cell from added twice in the same path
        String pt = makePt(i,j);
        String curPath = pathArr[1];
        if (exist)
        {
            if (p) p("["+curPath+"]");
            if (curPath.indexOf(pt) < 0)
                exist = false;  // allow to add
        }
        if (!exist)
        {
            path[i][j] = 10 * path[i][j] + 1;
            curPath += pt;  // creates a new string but the original string maintains it's original value
            pathArr[1] = curPath; // to keep it's new value between recursive calls
            if (p) p("1195 [" + pathArr[1] + "], ["+curPath+"]");
        }
        if (p) p(1200, i, j, sum, grid[i][j], path[i][j]);
        if (findPathInMatrix(grid, i+1, j, sum-grid[i][j], path, allowMultiplePaths, exist, x, y, pathXY, pathArr, 1, _sum) ||
            findPathInMatrix(grid, i-1, j, sum-grid[i][j], path, allowMultiplePaths, exist, x, y, pathXY, pathArr, 2, _sum) ||
            findPathInMatrix(grid, i, j+1, sum-grid[i][j], path, allowMultiplePaths, exist, x, y, pathXY, pathArr, 3, _sum) ||
            findPathInMatrix(grid, i, j-1, sum-grid[i][j], path, allowMultiplePaths, exist, x, y, pathXY, pathArr, 4, _sum))
        {
            if (p) p("1205 [" + pathArr[1] + "], ["+curPath+"]");
            if (pathArr[1].length() == 0) // not to add from returns below when clearing the stack with partial curPath
            {
                if (p) p("1210 " + exist);
                pathArr[1] = curPath;
            }
            return true;
        }
        // not to clear a valid cell if did not finished all recorsive calls
        if (p) p(1240, i, j, sum, grid[i][j], level);
        if (level == 4 || sum - grid[i][j] < 0)
        {
            if (p) p(1250, _sum[0], _sum[1], _sum[2], sum, grid[_sum[1]][_sum[2]]);
            if (p) p(1260, grid[i][j], _sum[0] - grid[i][j]); 
            if (_sum[0] - grid[i][j] == 0)
            {
            // in case need to reset current cell because with it the sum is -ve
                if (sum - grid[i][j] < 0)
                {
                    if (_sum[1] == x && _sum[2] == y) // if removing origianl point then it is a wrong solution
                    {
                        sum = _sum[0];
                        clearCurPath(path, pathArr);
                        if (p) p(1265, x, y, sum, path[x][y]); 
                        return false;
                    }
                    resetCell(_sum[1], _sum[2], path, pathArr);
                }
                _sum[0] = sum;
                return true;
            }
            resetCell(i, j, path, pathArr);
            //path[i][j] = (path[i][j] > 1 ? path[i][j]/10 : 0);
        }
        else if (sum - grid[i][j] > 0)
        {
            if (p) p(1270, _sum[0], _sum[1], _sum[2], sum, grid[_sum[1]][_sum[2]]);
            _sum[0] = Math.min(_sum[0], sum) - grid[i][j];
            _sum[1] = i;
            _sum[2] = j;
            if (_sum[0] == 0) return true;
        }
        if (p) p(1290, i, j, sum, path[i][j], level);
        /*
        resetCell(i, j, path);
        //path[i][j] = (path[i][j] > 1 ? path[i][j]/10 : 0);
        if (p) p("["+curPath+"]");
        curPath = curPath.substring(0, curPath.length() - pt.length());
        if (p) p("["+curPath+"]");
        */
        if (p) p(1300, i, j, sum, path[i][j], 99999);
        return false;
    }
    
    /**
     * Given a 2-dim square matrix with +ve whole numbers > 0.
     * The method will find all "path"s of 4 or less close neighbours of a 
     * cell such that the sum of those cells equal a supplied +ve whole target.
     * The method returns true or false to indicate if a path was found or not.
     * The supplied matrix, named path, should hold 1 at the cells which
     * belong to the path, 0 otherwise. If there are more than one path, any
     * of them is a valid solution, and will also show with 1 at the proper
     * cells. If a cell belongs to 2 different paths (at least 1 cell is new)
     * then it will have 11 (if it belongs to 2 paths, 111 belongs to 3 paths
     * and so on).
     * Example: for target 4 and the matrix
     *          {2, 41, 3, 14}, // line 0
                {2, 1, 24, 7}, // line 1
                {2, 15, 10, 54}, // line 2
                {63, 22, 2, 4}}; // line 3
        possible solutions are: (0,0)+(0,1), (0,1)+(0,2), (3,3)
     */
    public static boolean findSumsInMatrix(int[][]grid, int sum, int[][]path)
    {
        int solutions = findSumsInMatrix2(grid, sum, path, 0, 0, 0);
        p("Found "+solutions+" paths with sum = "+sum);
        return solutions > 0;
    }
    // no recursion method to find path
    public static int findSumsInMatrix2(int[][]grid, int sum, int[][]path, int x, int y, int solutions)
    {
        //p = true;
        int n = grid.length;
        if (p) p(1000, x, y, sum);
        if (x == n) return solutions;   // end of matrix
        if (y == n) // end of a row
            return findSumsInMatrix2(grid, sum, path, x+1, 0, solutions);
        //if (x < 0 || y < 0 || x >= n || y >= n) return solutions;// verify cell in boundries
        int newSum = sum-grid[x][y];
        if (p) p(1100, x, y, newSum, grid[x][y]);
        boolean exist = (path[x][y] > 0);
        if (newSum < 0)
            newSum = sum;
        else if (newSum > 0) // look for neighbour cells
        {
            int[] _newSum = new int[]{newSum};
            exist = findPathInMatrix2(grid, n, x, y, exist, _newSum, path);
            newSum = _newSum[0];
        }
        if (p) p(1800, x, y, newSum, grid[x][y]);
        if (newSum == 0 && !exist)   // found a new solution
        {
            path[x][y] = 10 * path[x][y] + 1;
            p("1900, Found path starting at "+makePt(x,y)+" with sum "+sum+": true");
            p(path);
            solutions++;
        }
        if (p) p(2000, y, newSum, solutions);
        return findSumsInMatrix2(grid, sum, path, x, y+1, solutions);
    }        
    private static boolean findPathInMatrix2(int[][] grid, int n, int x, int y, 
            boolean exist, int[] _newSum, int[][] path)
    {
        int newSum = _newSum[0];
        int savSum = newSum;
        //if (p) p(1200, x, y, newSum, grid[x][y], x+1);
        exist = setPath(grid, n, x+1, y, exist, _newSum, path);
        exist = setPath(grid, n, x-1, y, exist, _newSum, path);
        exist = setPath(grid, n, x, y+1, exist, _newSum, path);
        exist = setPath(grid, n, x, y-1, exist, _newSum, path);
        newSum = _newSum[0];
        if (false && newSum > 0 && savSum != newSum) // not found, restore in reverse order
        {
            if (p) p(1700, x, y, newSum, grid[x][y]);
            //p(path);
            newSum = resetPath(grid, n, x, y-1, exist, newSum, path);
            newSum = resetPath(grid, n, x, y+1, exist, newSum, path);
            newSum = resetPath(grid, n, x-1, y, exist, newSum, path);
            newSum = resetPath(grid, n, x+1, y, exist, newSum, path);
            //p(path);                    
        }
        return exist;        
    }
    private static boolean setPath(int[][] grid, int n, int i, int j, boolean exist, int[] _newSum, int[][] path) 
    {
        int newSum = _newSum[0];
        if (isValid(n, i, j) && newSum >= grid[i][j])
        {
            if (p) p(1300+10*i, i, j, newSum, grid[i][j]);
            newSum -= grid[i][j];
            if (path[i][j] == 0 || !exist)
            {
                path[i][j] = 10 * path[i][j] + 1;
                exist = false;
            }
        }
        _newSum[0] = newSum;
        return exist;
    }
    private static int resetPath(int[][] grid, int n, int i, int j, boolean exist, int newSum, int[][] path) 
    {
        if (isValid(n, i, j) && newSum + grid[i][j] > 0)
        {
            newSum += grid[i][j];
            if (!exist)
                resetCell(i, j, path, null); //? what about curPath
                //path[i][j] = (path[i][j] > 1? path[i][j]/10 : 0);
        }
        return newSum;
    }
    // 1 call to the recursion method
    public static int findSumsInMatrix(int[][]grid, int sum, int[][]path, int x, int y, int solutions)
    {
        //p = true;
        int n = grid.length;
        if (p) p(1000, x, y, sum);
        //if (x < 0 || y < 0 || x >= n || y >= n) return solutions;// verify cell in boundries
        int newSum = sum-grid[x][y];
        if (p) p(1100, x, y, newSum, grid[x][y]);
        boolean exist = (path[x][y] > 0);
        if (newSum < 0)
            newSum = sum;
        else if (newSum > 0) // look for neighbour cells
        {
            int[] _newSum = new int[]{newSum};
            exist = findPathInMatrix2(grid, n, x, y, exist, _newSum, path);
            newSum = _newSum[0];
        }
        if (p) p(1800, x, y, newSum, grid[x][y]);
        if (newSum == 0 && !exist)   // found a new solution
        {
            path[x][y] = 10 * path[x][y] + 1;
            p("1900, Found path starting at "+makePt(x,y)+" with sum "+sum+": true");
            p(path);
            solutions++;
        }
        if (p) p(2000, y, newSum, solutions);
        if (++y == n && x < n-1) // finished the row
        {
            if (p) p(2100, y, newSum, solutions);
            y = 0;
            x++;
        }
        else if (x == n-1 && y == n)
            return solutions;   // finished the matrix
        if (p) p(2200, x, y, sum);
            // continue in the matrix
        return findSumsInMatrix(grid, sum, path, x, y, solutions);
    }        

    /**
     * Given a 2-dim matrix with cells marked with 'x' or '1' as occupied.
     * A region of connected occupied cells, horizontally, vertically or 
     * diagonlly (total of possible 8 neighbours to inner cell of the matrix)
     * is called a 'Stain'.
     * Write a method that calculate the size of a stain at a given cell x,y.
     * If that cell is empty, it returns 0.
     */
    private static final int STAIN_FREE = 0;  // the value of a cell marking empty
    public static int stains(int[][] grid, int x, int y)
    {
        boolean[][] visited = new boolean[grid.length][grid[0].length];// assuming rectangulr grid
        int stains = stains(grid, x, y, visited);
        print(visited);
        return stains;
    }
    private static void print(boolean[][] arr)
    {
        // not using Arrays.deepToString(arr)) because print all lines in one row
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    }
    private static int stains(int[][] grid, int x, int y, boolean [][] visited)
    {
        int n = grid.length;
        if (x < 0 || y < 0 || x >= n) return 0;// verify cell in boundries
        int m = grid[x].length;
        if (y >= m || visited[x][y]) return 0; // in case matrix not square or rectangular
        int gxy = grid[x][y];
        if (gxy == STAIN_FREE)  // not counting empty cells
            return 0;
              // alrady visited or not occupied 
        if (p) p(100, x, y, gxy);
        visited[x][y] = true;
        if (p) p(1000, x, y, gxy);
        return 1 + 
            stains(grid, x, y-1, visited)+
                stains(grid, x+1, y, visited)+
                stains(grid, x, y+1, visited)+
                stains(grid, x-1, y, visited)+
            stains(grid, x-1, y-1, visited)+
                stains(grid, x+1, y+1, visited)+
                stains(grid, x+1, y-1, visited)+
                stains(grid, x-1, y+1, visited);
    }
    /**
     * Given a 2-dim matrix with cells marked with 'x' or '1' as occupied.
     * A region of connected occupied cells, horizontally, vertically or 
     * diagonlly (total of possible 8 neighbour to inner cell of the matrix)
     * is called a 'Stain'.
     * Write a method that calculate the number of dis-connected stains in a
     * given matrix.
     */
    private static final int STAIN_OCCUPIED = 1;  // the value of a cell marking occupied
    private static final int STAIN_VISITED = -10;
    public static int findStains(int[][] grid)
    {
        boolean[][] visited = new boolean[grid.length][grid[0].length];// assuming rectangulr grid        //p = true;
        return findStains(grid, 0, 0, 0, visited);
    }
    private static int findStains(int[][] grid, int x, int y, int numOfStains, boolean[][] visited)
    {
        int n = grid.length;
        if (x < 0 || y < 0 || x >= n) return 0;// verify cell in boundries
        int m = grid[x].length;
        if (y >= m) return 0;   // in case matrix not square or rectangular
        int gxy = grid[x][y];
        //if (x == n-1 && y == m-1) return 0;// end of matrix
              // alrady visited or not occupied 
        if (p) p(100, x, y, gxy); 
        if (gxy > STAIN_OCCUPIED || gxy == STAIN_VISITED) return 0;
        // verify current cell has at least one more neighbour, otherwise
        // finished the stain.
        // In order not to count grid twice we mark it as visited
        // find if it is part of stain we already started
        if (p) p(1000, x, y, gxy);
        if (gxy == STAIN_OCCUPIED) // check if a new stain or part of an existing one
        {
            numOfStains++;
            if (p) 
            {
                p(1100, numOfStains);
                p(grid);
                p("----------------------");
            }
            markSstains(grid, x, y, visited, numOfStains + STAIN_OCCUPIED + 10);
            if (p) p(grid);
            /*
            int[] _numOfStains = new int[]{numOfStains};
            int stainId = STAIN_FREE;
            stainId = stainValue(grid, x-1, y, stainId, _numOfStains);
            stainId = stainValue(grid, x-1, y-1, stainId, _numOfStains);
            stainId = stainValue(grid, x-1, y+1, stainId, _numOfStains);
            stainId = stainValue(grid, x+1, y, stainId, _numOfStains);
            stainId = stainValue(grid, x+1, y-1, stainId, _numOfStains);
            stainId = stainValue(grid, x+1, y+1, stainId, _numOfStains);
            stainId = stainValue(grid, x, y-1, stainId, _numOfStains);
            stainId = stainValue(grid, x, y+1, stainId, _numOfStains);
            if (stainId <= STAIN_OCCUPIED) // new stain
            {
                numOfStains = _numOfStains[0];
                grid[x][y] = numOfStains + STAIN_OCCUPIED + 10;
                numOfStains++;
                _numOfStains[0]++;
            }
            else 
                grid[x][y] = stainId;   // part of an existing stain
            numOfStains = _numOfStains[0];
            */
        }
        else
            grid[x][y] = STAIN_VISITED;
        if (p) p(2000, x, y, grid[x][y]); 
        int numOfStains1 = maxOf4(findStains(grid, x, y-1, numOfStains, visited),
                findStains(grid, x+1, y, numOfStains, visited),
                findStains(grid, x, y+1, numOfStains, visited),
                findStains(grid, x-1, y, numOfStains, visited));
        int numOfStains2 = maxOf4(findStains(grid, x-1, y-1, numOfStains, visited),
                findStains(grid, x+1, y+1, numOfStains, visited),
                findStains(grid, x+1, y-1, numOfStains, visited),
                findStains(grid, x-1, y+1, numOfStains, visited));
        return Math.max(numOfStains, Math.max(numOfStains1,numOfStains2));
    }
    private static int markSstains(int[][] grid, int x, int y, boolean [][] visited, int mark)
    {
        int n = grid.length;
        if (x < 0 || y < 0 || x >= n) return 0;// verify cell in boundries
        int m = grid[x].length;
        if (y >= m || visited[x][y]) return 0; // in case matrix not square or rectangular
        int gxy = grid[x][y];
        if (gxy == STAIN_FREE || gxy == STAIN_VISITED)  // not counting empty cells
            return 0;
              // alrady visited or not occupied 
        if (p) p(100, x, y, gxy);
        visited[x][y] = true;
        if (p) p(1000, x, y, gxy);
        if (gxy == STAIN_OCCUPIED) grid[x][y] = mark;
        return 1 + // count size of stain
            markSstains(grid, x, y-1, visited, mark)+
                markSstains(grid, x+1, y, visited, mark)+
                markSstains(grid, x, y+1, visited, mark)+
                markSstains(grid, x-1, y, visited, mark)+
            markSstains(grid, x-1, y-1, visited, mark)+
                markSstains(grid, x+1, y+1, visited, mark)+
                markSstains(grid, x+1, y-1, visited, mark)+
                markSstains(grid, x-1, y+1, visited, mark);
    }
    private static int stainValue(int[][] grid, int x, int y, int stainId, int[] numOfStains)
    {
        int n = grid.length;
        if (x < 0 || y < 0 || x >= n) return stainId;// verify cell in boundries
        int m = grid[x].length;
        if (y >= m) return stainId;   // in case matrix not square or rectangular
            // correct wrong stainId that was set because that cell is too 
            // far from the cell set already (the stain span more than 2 rows
            // or column, and we are checking only close neighbours so
            // we thought it is a new stain, but it is not
        if (stainId > STAIN_OCCUPIED && grid[x][y] > stainId)
        {
           p("fixing cell"+makePt(x,y)+" cur "+grid[x][y]+" but stain belongs to " + stainId);
           grid[x][y] = stainId;
           numOfStains[0]--;
           return stainId;
        }
        if (stainId <= STAIN_OCCUPIED && grid[x][y] > stainId)
            stainId = grid[x][y];
        return stainId;
    }
    private static int maxOf4(int num1, int num2, int num3, int num4)
    {   // since we now return Integer.MAX_VALUE and not -1 no need to worry about it
        return Math.max(Math.max(num1, num2), Math.max(num3, num4));
    }

    /**
     * Given a 2-dim matrix with whole non negative numbers, except the vilan's one.
     * A valid path, starting from a given (i,j) to a cell which has the value
     * -1, marking the place of the vilan. The prince moves based on the allowed
     * step, up, down, left or right. A +ve number in a cell mark the height
     * of a roof, where the prince is jumping between the city roofs to reach
     * the vilan, in order to save the princess (the game is also called the 
     * "jumping prince"). if the neighbour cell has the same +ve value as the 
     * current it means the roof are of the same height and the prince can move
     * to that cell. In addition, the prince can go up one level, which means
     * only if tha +ve value of that cell (roof) is 1 more than the current cell.
     * He can also jump down 1 or 2 levels, if the height of the roof allows it.
     * If the prince reaches a cell which is a neighbour of the vilan he is allowed
     * to jump, no matter what height he is now.
     * Need to find the shortest valid path from the starting cell to the vilan
     * cell. If no valid path, return -1, the original array must return to it's
     * original state, if it was changed.
     */
    private static int princeToVilan(int[][] m, int i, int j, int prev, int steps, String path)
    {
        if (i >= m.length || i < 0 || j < 0 || j >= m[i].length) return Integer.MAX_VALUE;
        String point = makePt(i, j);
        //if (path.indexOf(point) >= 0) return Integer.MAX_VALUE; 
        int mij = m[i][j];
        if (mij <= -10) return Integer.MAX_VALUE;   // already visited
        if (mij == -1) // found the vilan
        {
            path += point;
            System.out.println(path);
            return steps;  // valid path
        }
        if (!(prev == mij ||  // same height
                Math.abs(prev - mij) == 1 || // can go up or down 1 level
                prev - mij == 2))   // can go down 2 levels
            return Integer.MAX_VALUE;
        path += point;
        m[i][j] = -mij - 10;    // mark as used
        int min = minOf4(princeToVilan(m, i, j + 1, mij, steps+1, path),// move right
            princeToVilan(m, i, j - 1, mij, steps+1, path), // move left
            princeToVilan(m, i + 1, j, mij, steps+1, path), // move down
            princeToVilan(m, i - 1, j, mij, steps+1, path)); // move up
        m[i][j] = -m[i][j] - 10;
        return min;
    }
    public static int princeToVilan(int[][] m, int i, int j)
    {
        //p = true;
        //int result = princeToVilanOLD(m, i, j, m[i][j], 0, "");
        int result = princeToVilan(m, i, j, m[i][j], 0, "");
        if (result == Integer.MAX_VALUE) result = -1;
        return result;
    }
    private static int princeToVilanOLD(int[][] m, int i, int j, int prev, int steps, String path)
    {
        if (p) p(100, i, j, m.length);
        if (p) if (i >= 0 && i < m.length) p(m[i].length);
        if (i >= m.length || i < 0 || j < 0 || j >= m[i].length) return Integer.MAX_VALUE;
        int mij = m[i][j];
        if (mij <= -10) return Integer.MAX_VALUE;   // already visited
        if (p) p(1000, i, j, mij);
        String point = makePt(i, j);
        if (mij == -1) 
        {
            path += point;
            p(path);
            if (p) p(1500, steps);
            return steps;  // valid path
        }
        if (p) p(2000, prev, mij);
        if (!(prev == mij ||  // same height
                Math.abs(prev - mij) == 1 || // can go up or down 1 level
                prev - mij == 2))
                return Integer.MAX_VALUE;
        path += point;
        m[i][j] = -mij - 10;    // mark as used
        if (p) p(3000, i, j, m[i][j]);
        int min = minOf4(princeToVilanOLD(m, i, j + 1, mij, steps+1, path),// move right
            princeToVilanOLD(m, i, j - 1, mij, steps+1, path), // move left
            princeToVilanOLD(m, i + 1, j, mij, steps+1, path), // move down
            princeToVilanOLD(m, i - 1, j, mij, steps+1, path)); // move up
        m[i][j] = -m[i][j] - 10;
        if (p) p(4000, i, j, m[i][j]);
        if (p) p(5000, min);
        return min;
    }
    private static int minOf4(int num1, int num2, int num3, int num4)
    {   // since we now return Integer.MAX_VALUE and not -1 no need to worry about it
        return Math.min(Math.min(num1, num2), Math.min(num3, num4));
    }
    public static int minOf4Old(int n1, int n2, int n3, int n4)
    {   // need to ignore -1 which it returns if reached vilan
        if (p) p(6000, n1, n2, n3);//, n4);
        int min = n1;
        min = (n2 == -1 ? min : min == -1 ? n2 : Math.min(min, n2));
        min = (n3 == -1 ? min : min == -1 ? n3 : Math.min(min, n3));
        min = (n4 == -1 ? min : min == -1 ? n4 : Math.min(min, n4));
        return min;
    }

    /**
     * Given a 2-dim matrix with whole numbers, non negative, less than 100.
     * A valid path, starting from 0,0 to n,n to the next cell based on the
     * value in the current cell such that can move right or down based on the
     * value of the last digit in the number = d or move right/down based on the
     * value of the tenth digit = t. That is x+=d, y+=t or x+=t, y+=d.
     * Return the number of possible paths.
     * The signature of the original question is cntPaths(int[][] m).
     */
    public static int countPathsInMatrix(int[][] m)
    {
        return countPathsInMatrix(m, 0, 0, 1); // code is used just to know which recursive call are we processing
    }
    private static int countPathsInMatrix(int[][] m, int x, int y, int code0)
    {
        int n = m.length;
        if (x >= n || x < 0 || y < 0 || y >= m[x].length)
        {
            if (p) p(x, y);//, code);
            return 0;
        }
        int mxy = m[x][y];
        if (x == n-1 && y == m[x].length-1) // last cell
        {
            if (p) p(x, y, mxy);//, code);
            return 1;
        }
        if (mxy == 0) return 0;
        int d = mxy % 10;
        int t = mxy / 10;
        if (p) p(""+x+", "+y+", "+mxy+", "+d+", "+t);//+", "+code);
        return (countPathsInMatrix(m, x+d, y+t, 1) +
                    countPathsInMatrix(m, x+t, y+d, 2));
    }
    
        // can not have -ve mumbers otherwise do not know when to stop
        // the repetition, thus if find -ve number do not use it
    public static boolean areThereNumbersEqualSumWithRepeatition(int[] a, int sum)
    {
        boolean addToGetToTarget = true;
        //if (addToGetToTarget)
                // adding from 0 to reach target
            return areThereNumbersEqualSumWithRepeatition(a, 0, 0, sum);
        //return areThereNumbersEqualSumWithRepeatition(a, sum, 0);
    }
    private static boolean areThereNumbersEqualSumWithRepeatition(int[] a, int sum, int i, int target)
    {
        int n = a.length;
        if (sum == target) return true; // must be before out of boundries, in case sum=0 at the last item
        if (i >= n || sum > target || a[i] <= 0) return false; // only +ve numbers
        if (p) p(i, sum, a[i], target);
        if (areThereNumbersEqualSumWithRepeatition(a, sum+a[i], i+1, target) || // use this number
            areThereNumbersEqualSumWithRepeatition(a, sum, i+1, target) ||  // do not use this number
            areThereNumbersEqualSumWithRepeatition(a, sum+a[i], i, target)) // add the same number again
            return true;
        return false;
    }
    // same as cover() learned in class if subtracting from target
    public static boolean areThereNumbersEqualSum(int[] a, int sum)
    {
        pN(sum+", ");
        p(a);
        p = true;
        boolean addToGetToTarget = true;
        if (addToGetToTarget)
            return areThereNumbersEqualSumAdd(a, 0, 0, sum);
        return areThereNumbersEqualSumSub(a, sum, 0);
    }
    // adding from 0 to reach target
    private static boolean areThereNumbersEqualSumAdd(int[] a, int sum, int i, int target)
    {
        int n = a.length;
        if (sum == target) return true; // must be before out of boundries, in case sum=0 at the last item
        if (i >= n) return false;
        if (p) p(i, sum, a[i]);
        if (areThereNumbersEqualSumAdd(a, sum+a[i], i+1, target) || // use this number
            areThereNumbersEqualSumAdd(a, sum, i+1, target))  // do not use this number
            return true;
        return false;
    }
    // subtracting from target
    private static boolean areThereNumbersEqualSumSub(int[] a, int sum, int i)
    {
        int n = a.length;
        if (sum == 0) return true; // must be before out of boundries, in case sum=0 at the last item
        if (i >= n) return false;
        if (p) p(i, sum, a[i]);
        if (areThereNumbersEqualSumSub(a, sum-a[i], i+1) || // use this number
            areThereNumbersEqualSumSub(a, sum, i+1))  // do not use this number
            return true;
        return false;
    }
    
    public static boolean areThere2NumbersEqualSum(int[] a, int sum)
    {
        return areThere2NumbersEqualSum(a, sum, 0, 1);
    }
    private static boolean areThere2NumbersEqualSum(int[] a, int sum, int pivot, int i)
    {
        int n = a.length;
        if (pivot >= n || i >= n) return false;
        if (sum == a[pivot]+a[i]) return true;
        //p(pivot, i, sum);
        if (i == n - 1)
            return areThere2NumbersEqualSum(a, sum, pivot + 1, pivot+2);
        return areThere2NumbersEqualSum(a, sum, pivot, i+1);
        /*
            //areThere2NumbersEqualSum(a, sum, pivot+1, i));  // using extra redundant calls
            areThere2NumbersEqualSum(a, sum, pivot+1, pivot+2));  // using extra redundant calls
        */
    }
    
    public static int ladderSoccer(int n, int m)
    {
        if (n < 0 || m < 0) return -1;
        if (n == 0 && m == 0) return 0;
        return ladderSoccerCount(n, m);
    }
    private static int ladderSoccerCount(int n, int m)
    {
        //p(n, m);
        if (n == 0 && m == 0)
            return 1;
        if (n < 0 || m < 0) return 0;
        return ladderSoccerCount(n - 1, m) + 
            ladderSoccerCount(n, m - 1);
    }
    /**
     * A method to find a path from starting point (0,0) of a grid size nXn
     *  to the end point (b-1, n-1)
     */
    private static final int MAZE_WALL = 0;  // the value of a cell marking a wall
    private static final int MAZE_FREE = 1;  // the value of a cell marking a possible path
    private static final int MAZE_VISITED = 2;  // the value of a cell marking already visited
    public static boolean maze(int[][] grid)
    {
        // verify grid is square
        int n = grid.length;
        if (n < 2)
        {
            grid = new int[][] {};
            return false;
        }
        else
        {
            for (int i=0; i<n;i++)
            {
                //p(i, grid[i].length, n);
                if (grid[i].length != n)
                {
                    grid = new int[][] {};
                    return false;
                }
                
            }
        }
        /*
        int [][] solution = new int[n][n];
        p("solution");
        boolean solved = maze(grid, 0, 0, solution);
        p(solution);
        return solved;
        */
       return maze(grid, 0, 0);
    }
    // without the 'solution array'
    private static boolean maze(int[][] grid, int x, int y)
    {
        int n = grid.length;
        if (x < 0 || y < 0 || x >= n || y >= n)// verify cell in boundries
            return false;
        if (grid[x][y] != MAZE_FREE)    // verify not visited yet
            return false;
        grid[x][y] = MAZE_VISITED; // mark as used
        if (x == n-1 && y == x)  return true; // last cell
        if (maze(grid, x, y-1) ||
                maze(grid, x+1, y) ||
                maze(grid, x, y+1) ||
                maze(grid, x-1, y))
            return true;
        grid[x][y] = MAZE_FREE; // restore value
        return false;
    }
    // method using 'solution array'
    private static boolean maze(int[][] grid, int x, int y, int solution[][])
    {
        int n = grid.length;
        if (x == n-1 && y == x)
        {
            grid[x][y] = MAZE_VISITED; // mark as used
            return true;
        }
        grid[x][y] = MAZE_VISITED; // mark as used
        solution[x][y] = MAZE_VISITED;
        if (y > 0 && grid[x][y-1] == MAZE_FREE)    // move up
            if (maze(grid, x, y-1, solution)) return true;
        if (x < n-1 && grid[x+1][y] == MAZE_FREE)    // move right
            if (maze(grid, x+1, y, solution)) return true;
        if (y < n-1 && grid[x][y+1] == MAZE_FREE)    // move down
            if (maze(grid, x, y+1, solution)) return true;
        if (x > 0 && grid[x-1][y] == MAZE_FREE)    // move left
            if (maze(grid, x-1, y, solution)) return true;
        grid[x][y] = MAZE_FREE; // restore value
        solution[x][y] = 0;
        return false;
    }

    /**
     * Find the number of possible ways to climb a ladder of n steps,
     * where at each step one can go up 1 or 2 steps at once
     * 
     * Example: a ladder with 5 steps has 5 possible ways:
     *  1111,112,121,211,22
     */
    public static int ladder(int n)
    {
        if (n < 1) return 1;
        String[] path = new String[]{""};
        int steps;
        boolean paths = false;
        if (paths)
        {
            steps = ladder(n, 0, 0, "", path);
            p(path[0].substring(0, path[0].length()-1));
        }
        else
            steps = ladder(n, 0); // without keeping the paths
        return steps;
    }
    private static int ladder(int n, int index)
    {
        if (index == n - 1)
            return 1;
        if (index > n - 1)
            return 0;
        return ladder(n, index + 1) + ladder(n, index + 2);
    }
    // keep all the possible paths 
    private static int ladder(int n, int index, int step, String s, String[] path)
    {
        if (index == n - 1)
        {
            path[0] += s + ",";
            return step + 1;
        }
        if (index > n - 1)
            return 0;
        return ladder(n, index + 1, step, s+"1", path)+
            ladder(n, index + 2, step, s+"2", path);
    }
    /**
     * Given 2 arrays of integers of same size n.
     * Find the path with smallest sum of n numbers, from both arrays, such
     * that it starts at one array and it is allowed one move from that array
     * to the other, diagonlly to the next index, and then continue to the end
     * of that array.
     * 
     * Example: array1={1,2,5}, array2={2,-1,6}
     * The path is 1,-1,6 which gives 6
     */
    public static int smallestSumIn2Arrays(int[] a, int[] b)
    {
        if (a.length != b.length) return Integer.MAX_VALUE;
        if (a.length == 1) return Math.min(a[0], b[0]);
        int sumA = sumArray(a, 0, 0);
        int sumB = sumArray(b, 0, 0);
        if (p) p(sumA, sumB);
        // start at array a
        int minA = smallestSum(a, b, 0, sumB, 0, Integer.MAX_VALUE);
        int minB = smallestSum(b, a, 0, sumA, 0, Integer.MAX_VALUE);
        //p(sumA, sumB, minA, minB);
        return minOf4(sumA, sumB, minA, minB);
    }
    private static int smallestSum(int[] a, int[] b, int i, int sumB, 
                        int sumA, int min)
    {
        if (i == a.length) return min;
        sumA += a[i];
        sumB -= b[i];
        int sum = sumA + sumB;
        if (min > sum) min = sum;
        if (p) p(i, sum, sumA, sumB, min);
        min = smallestSum(a, b, i + 1, sumB, sumA, min);
        return min;
        
    }
    private static int sumArray(int[] a, int i, int sum)
    {
        if (i == a.length) return sum;
        sum = sumArray(a, i + 1, sum + a[i]);
        return sum;
    }
    public static int smallestSumIn2Arrays1(int[] a, int[] b)
    {
        if (a.length != b.length) return Integer.MAX_VALUE;
        if (a.length == 1) return (int)Math.min(a[0], b[0]);
        int[][] m = new int[2][a.length];
        m[0] = a;
        m[1] = b;
        int[] minSum = new int []{Integer.MAX_VALUE};  // to store the min sim 
        String[] minPath = new String[]{""};
        int temp00 = m[0][0];   // using m[0][0] as global var to keep min
            // not really needed - we can make the method return min which
            // is then a global var (also pass it as a var so can compare
            // inside the method
        smallestSumIn2Arrays(m, 0, 0, 0, "", 1, minPath, m[0][0]); // start in 1st array
        smallestSumIn2Arrays(m, 0, 1, 0, "", 2, minPath, m[0][0]); // start in 2nd array
        p(minPath[0], m[0][0]);//, minSum[0]);
        int result = m[0][0];
        m[0][0] = temp00;
        return result;
    }
    private static void smallestSumIn2Arrays(int[][] m, int sum, int x, int y, 
        String path, int step, String[] minPath, int temp00)
    {
        String point = makePt(x, y);
        path += point;
        if (p) p(x, y, sum, temp00);
        if (p) p(path, m[x][y]);
        int xy = (x==0 && y==0 ? temp00 : m[x][y]);
        if (y == m[0].length - 1)
        {
            sum += xy;
            if (y == m[0].length - 1 && m[0][0] > sum)
            {
                m[0][0] = sum;
                minPath[0] = path;
            }
            if (p) p(1000, m[0][0], sum);
            return;
        }
        //sum = smallestSumIn2Arrays(a, b, sum + a[i], i+1, step);
        if (y < m[0].length)
        {
            if (p) p("calling R " + point, sum);
            smallestSumIn2Arrays(m, sum + xy, x, y+1, path, step, minPath, temp00);
            if (p) p("returning R " + point, sum);
        }
        if (step == 1 && x < m.length-1)//1st array moves to the 2nd array
        {
            if (p) p("calling D " + point, sum);
            smallestSumIn2Arrays(m, sum + xy, x+1, y+1, path, step, minPath, temp00);
            if (p) p("returning D " + point, sum);
        }
        if (step == 2 && x == m.length-1)//2nd array moves to the 1st array
        {
            if (p) p("calling U " + point, sum);
            smallestSumIn2Arrays(m, sum + xy, x-1, y+1, path, step, minPath, temp00);
            if (p) p("returning U " + point, sum);
        }
        return;
    }
    public static String makePt(int x, int y) // public because Tester calls it too
    {
        return "(" + x + "," + y + ")";
    }
    // to find smallest number in array of int, using recursion and no global variable
    public static int smallest(int[] a)
    {
        p(a);
        p( smallest(a, 0, Integer.MAX_VALUE));
        return 0;
    }
    private static int smallest(int[] a, int i, int min)
    {
        if (i == a.length) return min;
        if (min > a[i]) min = a[i];
        min = smallest(a, i + 1, min);
        return min;
    }
    private static int smallest1(int[] a, int i)
    {
        if (i == a.length - 1) return i;
        int smallest = smallest1(a, i + 1);
        if (a[smallest] < a[i]) return smallest;
        return i;
    }
    // does not use global variable and returns index pointing to smallest value
    public static int findSmallestIndex(int[] arr, int i)
    {
        //p = true;
        if (arr.length == 0) return -1;
        int index = 0; // first item in array
        if (p) p(1000, i, arr.length);
        if (i < arr.length)
        {
            index = findSmallestIndex(arr, i + 1);
            if (p) p(2000, i, index, arr.length);
            if (arr[index] > arr[i])
                index = i;
            if (p) p(2100, i, index, arr[i]);
        }
        return index;
    }
    // use global variable and returns smallest value
    static int val = 100;
    public static int findSmallestVal(int[] arr, int i)
    {
        //p = true;
        if (arr.length == 0) return 0;
        if (p) p(1000, i, val, arr.length);
        if (i < arr.length)
        {
            if (p) p(1500, i, val, arr.length);
            val = findSmallestVal(arr, i + 1);
            if (val > arr[i])
                val = arr[i];
            if (p) p(2000, i, val, arr[i]);
        }
        if (p) p(3000, i, val);
        return val;
    }
    /* To find all combinations of numbers from 1 to `n` having sum 'n' 
    // but not including the digit '0' and only one permutation per number
    // that is '41' is not allowed if '14' is already in the list by 
    // allowing only numbers with increasing values of the digits, thus '41'
    // has decreasing digits: starts with 4 then 1
    Example: 
        For n = 5, the following combinations are possible:
        { 5 }{ 1, 4 }{ 2, 3 }{ 1, 1, 3 }{ 1, 2, 2 }
    The idea is to consider every integer i from 1 to n and add it to the 
    output and recur for remaining elements [i…n] with reduced sum n-i. 
    To avoid printing permutations, each combination will be constructed in 
    non-decreasing order. If a combination with the given sum is reached, 
    print it.        
    */
    public static String findAllNumsEqualN(int n)
    {
        return findAllNumsEqualN(n, n, "");
    }
    private static String findAllNumsEqualN(int nDigits, int sum, String set)
    {
        if (nDigits > sum) return set;
        set += findNumbersEqualSum(nDigits, sum, set);
        return findAllNumsEqualN(nDigits + 1, sum, set);
    }
    public static String findNumbersEqualSum(int n, int sum, String set)
    {
        return findNdigitNums("", 0, n, sum, 0, 0, set);
    }
    private static String findNdigitNums(String curr, int index, int n, 
            int sum, int value, int highest, String set)
    {
        // if the number is less than n–digit and its sum of digits is
        // less than the given sum
        if (index < n && sum >= 0)
        {
            int d = (index == 0 ? 1 : 0);  // special case: number cannot start from 0
            // consider every valid digit and put it in the current
            // index and recur for the next index
            if (index + 1 == n)
                d = sum - value;
            if (d == 0) d = 1;
            while (d <= 9)
            {
                if (sum - d < 0) break;
                if (d < highest) 
                    return set;
                highest = d;
                set = findNdigitNums(curr + d, index + 1, n, sum - d, value, 
                    highest, set);
                d++;
            }
        }
        // if the number becomes n–digit and its sum of digits is
        // equal to the given sum, print it
        else if (index == n && sum == 0)
            set += curr + ",";
        return set;
    }
    
    static String used = "";    // to prevent duplicates
    private static String findAllNumsEqualN(int nDigits, int n)
    {
        if (nDigits > n) return used.substring(0, used.length()-1);
        used += findNumbersEqualSum(nDigits, n, false).substring(1);
        if (p) p("910," + used);
        return findAllNumsEqualN(nDigits + 1, n);
    }
    public static String findAllNumsEqualNLoop(int n)
    {
        for (int i=1; i<=n;i++)
        {
            used += findNumbersEqualSum(i, n, false).substring(1);
            if (p) p("900," + used);
        }
        p(count);
        return used.substring(0, used.length() - 1);
    }
    // Find all n–digit numbers with a given sum of digits equal
    //  to '_sum` in a bottom-up manner using recursion
    public static String findNumbersEqualSum(int n, int _sum, boolean allowZero)
    {
        used = " ";
        //count = 0;
        findNdigitNums("", 0, n, _sum, 0, allowZero, 0);
        if (allowZero) p(count);
        return used;
    }
    private static void findNdigitNums(String result, int index, int n, 
            int _sum, int value, boolean allowZero,int highest)
    {
        // if the number is less than n–digit and its sum of digits is
        // less than the given sum
        if (p) p(1000,index, n, _sum);
        if (p) p("1500,[" + result + "]");
        count++;
        if (index < n && _sum >= 0)
        {
            int d = (index == 0 ? 1 : 0);  // special case: number cannot start from 0
            // consider every valid digit and put it in the current
            // index and recur for the next index
            if (p) p("1800," + (index + 1) + ","+ d + ",[" + value + "]");
            if (index + 1 == n)
                d = _sum - value;
            if (!allowZero && d == 0) d = 1;
            while (d <= 9)
            {
                //if (index + 1 == n)
                //result = "" + d + result;
                if (p) p("Calling 2000," + index + ","+ d + ",[" + result);
                if (_sum - d < 0) break;
                if (!allowZero)
                {
                    //if (p) p("1900," + highest + ","+ d );                
                    if (d < highest) 
                        return;
                    highest = d;
                    if (p) p("1950," + highest + ","+ d );                
                }
                findNdigitNums(result + d, index + 1, n, _sum - d, value, 
                    allowZero, highest);
                if (p) p("Returning 2000," + index + ","+d + ",[" + result);
                d++;
            }
        }
        // if the number becomes n–digit and its sum of digits is
        // equal to the given sum, print it
        else if (index == n && _sum == 0)
                used += result + ",";
    }
    //Find all n-digit numbers with a given sum of digits not using recursion
    public static String findNumbersEqualSumLoop(int n, int _sum, boolean stam)
    {
        used = " ";
        count = 0;
        p = false;        
        int maxSum = 9;
        for (int j=1; j<n; j++) 
            maxSum += 9;
        //p(max, _sum);
        if (_sum > maxSum) return "";
        int start = pow(10,n-1);//(int)Math.pow(10,n-1);
        int max = pow(10,n)-1;//(int)Math.pow(10,n)-1;
        int sum = 0;
        int tensDig, digit;
        int lastCalledSumToTen = -1;
        for (int i=start; i<=max; i++) // go over all values of sum of digits
        {
            count++;
            if (p) p(1000, i, n, _sum);
            int sumToTens = 0;
             // to save calls to getSumUpToTenDigit()
            if (lastCalledSumToTen < 0 || i-lastCalledSumToTen > 1)
                sumToTens = getSumUpToTenDigit(i, n);
            else
            {
                lastCalledSumToTen = i;
                sumToTens++;
            }
            if (p) p(1503, i, _sum, sumToTens);
            if (sumToTens + 9 < _sum)
            {
                i += 10 - 1;
                continue;
            }
            if (p) p(1504,_sum, sumToTens);
            if (_sum - sumToTens <= 9)
            {
                boolean exit = false;
                for (int j=9; j >= 0; j--)
                {
                    count++;
                    if (sumToTens + j == _sum)
                    {
                        used += "," + (i + j);
                        if (p) p(used);
                        //p(i, j, 10-j, i+9);
                        i += 9;
                        exit = true;
                        break;
                    }
                }
                if (exit) continue;
            }
            // finished all possible values with tens now move to hundreds
            if (p) p(2003, i, sumToTens, _sum);
            i = goTo99(i, n);
            if (p) p(2004, i, sumToTens, _sum);
        }
        p(count);
        return (used.length() > 2 ? used.substring(1) + " " : "  "); // allow print with skipping space and comma
    }
    private static int goTo99(int i, int n)
    {
        count++;
        // get the digits to the ten digit
        int power = 100;//(int) Math.pow(10, 2);
        return (i / power)*power + 99;
    }
    private static int getSumUpToTenDigit(int i, int n)
    {
        int sum = 0;
        while (n > 0)
        {
            int power = pow(10, n);//(int) Math.pow(10, n);
            int digit = (i / power) % 10;
            sum += digit;
            //p(i, n, digit);
            n--;
            count++;
        }
        return sum; // The first digit remains
    }
    private static int pow(int num, int n)
    {
        int r = num;
        while (--n > 0)
            r *= num;
        return r;
    }
    private static int getTensDigit(int i, int n)
    {
        count++;
        return (i / pow(10, n-2) % 10); //(int) Math.pow(10, n-2) % 10);
    }
    
    public static String permutation(String X)
    {
        return permutation(X, "", "");
    }
    private static String permutation(String X, String curr, String set)
    {
        if (X.length() == 0) // finished a permutation
        {
            if (set.length() > 0) set += ",";
            return set + curr; 
        }
        return permutation(X, curr, 0, set); // Start the recursive loop
    }
    private static String permutation(String X, String curr, int i, String set)
    {
        if (i == X.length()) return set;
            // Take out current char and recursive with the remaining X
        char a = X.charAt(i);
        String remainingX = X.substring(0,i) + X.substring(i+1);
             // add the char to the current String
        set = permutation(remainingX, curr + a, set);
        return permutation(X, curr, i + 1, set); // Continue with the next value of i
    }
    // the following my solution using for-loop
    private static void myPermutationWithLoop(String X, String curr)
    {
        if (p) p(X + ", curr=[" + curr + "]");
        if (X.length() == 0)
        {
            used +=  "," + curr;
            return;
        }
        for (int i=0; i<X.length(); i++)
        {
            char a = X.charAt(i);
            if (p) p("100,"+i+","+X);
            if (p) p("1000,"+i+","+X.substring(0,i));
            if (p) p("2000,"+i+","+X.substring(i+1));
            String remainingX = X.substring(0,i) + X.substring(i+1);
            myPermutationWithLoop(remainingX, curr + a);
        }
    }
    // the following chatGPT solution using only recursive functions
    private static void permutationWithOutLoop(char[] str, int index)
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
            permutationWithOutLoop(str, index + 1); // Recurse for the next index
            swap(str, index, i); // Backtrack by swapping back
        
            recursiveLoop(str, index, i + 1); // Continue with the next value of i
        }
    }
    // the following chatGPT solution using for-loop but avoiding an extra recursive function
    private static void permutationWithLoop(char[] str, int index)
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
            permutationWithLoop(str, index + 1);  // Recurse for the next index
            swap(str, index, i);  // Backtrack by swapping the characters back
        }
    }
    
    /*  Not working, keeping code for the usage of a TREE
     * need to do "head = tail = null;" before calling the method
    static IntNodeMat head, tail;
    private static String permutation(String curr, String X, String Y, int index, int level)
    {
        // head = tail = null;
        if (index < X.length()) Y = X.substring(index, index + 1);
        if (p) p("index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        if (index >= X.length())
        {
            if (false && X.length() > 0)
            {
                if (p) p("Calling 3, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
                String newX = X.substring(1);
                index = 0;
                if (p) p("Calling 3A, index=[" + index + "], X=["+newX+ "], Y=["+Y+"], curr=["+curr+"]");
                permutation(curr, newX, Y, 0, 0);
                if (p) p("Returning 3A, index=[" + index + "], X=["+newX+ "], Y=["+Y+"], curr=["+curr+"]");
                return used;
            }
            // Base case: We've considered all elements
            //used += "," + Y;
            //p(used);
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
        p(toString(head));
        if (p) p("Calling 1, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        //Y = X.substring(index, index + 1); // Add the element to the current subset
        p("1000," + permutation(curr, X, Y, index + 1, level));
        level++;
        p(level);
        if (p) p("Returning 1, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        if (X.length() > 0)
        {
            //if (p) p("Calling 4, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
            String newX = X.substring(0, index) + X.substring(index + 1);
            index = 0;
            //Y += X.substring(index, index + 1);
            if (p) p("Calling 4A, index=[" + index + "], X=["+newX+ "], Y=["+Y+"], curr=["+curr+"]");
            permutation(curr, newX, Y, 0, level);
            if (p) p("Returning 4A, index=[" + index + "], X=["+newX+ "], Y=["+Y+"], curr=["+curr+"]");
            curr += Y;
            p(curr);
        }
        if (true) return used;
        // Recursive case: Include the current element
        Y += X.substring(index, index + 1); // Add the element to the current subset
        if (p) p("Calling 2, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        permutation(curr, X.substring(1), Y, index + 1, level);
        if (p) p("Returning 2, index=[" + index + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        return used;
    }
    */
    /*
    private static String toString(IntNodeMat head)
    {
        IntNodeMat cell = head;
        String s = "";
        while (cell != null)
        {
            //if (p) System.out.println(cell);
            s += cell.toString();
            //p(s);
            cell = cell.getDown();
            s += ",";
        }
        return s;
    }
    */
   
    public static String powerSet(String X)
    {
        return powerSet(X, "", 0, "");
    }
    private static String powerSet(String X, String curr, int index, String Set)
    {
        if (index == X.length())
            return Set + "," + curr;
        // Recursive case: Exclude the current element
        Set = powerSet(X, curr, index + 1, Set);
        // Recursive case: Include the current element
        curr += X.substring(index, index + 1); // Add the element to the current subset
        return powerSet(X, curr, index + 1, Set);
    }
    
    public static String powerSet(int[] inputSet)
    {
        used = "";
        //inputSet = new int[]{1,2,3};//"12";//234";
        int[] currentSet = new int[inputSet.length];
        powerSet(inputSet, currentSet, 0, 0);
        return used;
    }
    private static String powerSet(int[] inputSet, int[] currentSet, int index, int currentSize)
    {
        if (index == inputSet.length)
        {
            // Base case: We've considered all elements
            if (used.length() > 0) used += ",";
            used += makeSet(currentSet, currentSize);
            //p(used);
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
    
    public static int factorial(int n)
    {
        //p(1000, n);
        if (n < 0) return 0;
        if (n < 2) return 1;
        int newN = n * factorial(n-1);
        //p(2000, newN);
        return newN;
    }
    // Function to find all interleaving of string `X` and `Y`
    public static String findInterleavings(String X, String Y)
    {
        p = false;
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
            if (p) p(used);
            return "";//used;
        }
        // if the string `X` is not empty, append its first character in the
        // result and recur for the remaining substring
        if (X.length() > 0) {
            //if (p) p("1000," + curr + " ,["+X.substring(1)+"]");
            //if (p) p("1100," + used);
            if (p) p("Calling 1, curr=[" + curr + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
            findInterleavings(curr + X.charAt(0), X.substring(1), Y);
            //if (p) p("1200," + X);
            if (p) p("Returning 1, curr=[" + curr + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        }
        // if the string `Y` is not empty, append its first character in the
        // result and recur for the remaining substring
        if (Y.length() > 0) {
            //if (p) p("2000, " + curr + " [" + Y);
            //if (p) p("2100," + used);
            if (p) p("Calling 2, curr=[" + curr + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
            findInterleavings(curr + Y.charAt(0), X, Y.substring(1));
            //if (p) p("2200," + Y);
            if (p) p("Returning 2, curr=[" + curr + "], X=["+X+ "], Y=["+Y+"], curr=["+curr+"]");
        }
        if (p) p("3000 " +used);
        return used;
    }
    static String DA[][] = null, DB[][] = null;
    private static void initD(String S, int i, int j, String[][] D)
    {
        boolean p = false;
        if (p) p(1000, i, j);
        int lenj = S.length() - i;
        if (p) p(2000, j, lenj);
        if (j + lenj > S.length()) lenj = 0;
        String subj = S.substring(j, j + lenj); 
        if (p) p(subj);
        D[i][j] = subj;
        if (p) p(Arrays.deepToString(D));
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
