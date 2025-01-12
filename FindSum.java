import java.util.Arrays;
/**
 * Write a description of class FindSum here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FindSum
{
    public static void main()
    {
        int[][] grid = new int[][]{  // 4 solutions for sum = 4
                {4, 41, 2, 1}, // line 0
                {2, 1, 1, 1}, // line 1
                {2, 15, 10, 54}, // line 2
                {63, 22, 2, 4}}; // line 3
        int sum = 4;
        int[][] path = new int[grid.length][grid.length];
        print("Matrix: ");
        print(grid);
        print("Found path with sum "+sum+": "+findSum(grid, sum, path));
        print(path);
    }
    
    public static boolean findSum(int[][]grid, int sum, int[][]path)
    {
        int x = 0, y = 0, i = 0;
        boolean res = false;
        while (x >= 0)
        {
            clearArray(path);
            res = findSum(grid, sum, path, x, y);  // find at 0,0
            if (res)
                Print.p("found a solution starting at " + "(" + x + "," + y + ")");
            print(path);
            switch (i++){
                case 0: x = 0; y = 2; break;
                case 1: x = y = 3; break;
                case 2: x = 2; y = 1; break;
                case 3: x = 0; y = 3; break;
                case 4: x = 1; y = 1; break;
                case 5: x = 1; y = 2; break;
                case 6: x = 1; y = 3; break;
                default: x = -1;
            }
        }
        return res;
    }
    // school solution - search for one path only without the parameter "allowMultiplePaths"
    public static boolean findSum(int[][]grid, int sum, int[][]path, 
            int x, int y)
    {
        int n = grid.length;
        if (x == n) return false;   // end of matrix
        if (y == n) // end of a row
            return findSum(grid, sum, path, x+1, 0);
        if (findPath(grid, x, y, sum, path))
                return true;
        return findSum(grid, sum, path, x, y+1);
    }
    private static boolean findPath(int[][] grid, int i, int j, int sum, int[][] path)
    {
        if (sum == 0) return true;
        if (sum < 0 || !isValid(grid.length, i, j)) return false;
        if (path[i][j] == 1) return false;
        path[i][j] =  1;
        if (findPath(grid, i+1, j, sum-grid[i][j], path) ||
                findPath(grid, i-1, j, sum-grid[i][j], path) ||
                findPath(grid, i, j+1, sum-grid[i][j], path) ||
                findPath(grid, i, j-1, sum-grid[i][j], path))
            return true;
        path[i][j] = 0;
        return false;
    }
    private static boolean isValid(int n, int x, int y)
    {
        return !(x < 0 || y < 0 || x >= n || y >= n);
    }
    private static void clearArray(int[][] path)
    {
        for (int i=0; i<path.length; i++)
            for (int j=0; j<path.length; j++)
                path[i][j] = 0;
    }
    public static void print(String s)
    {
        System.out.println(s);
    }
    public static void print(int[][] arr)
    {
        // not using Arrays.deepToString(arr)) because print all lines in one row
        for (int i = 0; i < arr.length; i++)
            print(Arrays.toString(arr[i]));
    }
}
