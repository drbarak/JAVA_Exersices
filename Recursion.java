import java.util.Arrays;
/**
 * Write a description of class Recursion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recursion
{
    static boolean p = false;
    static int count = 0;
    public static int ladderSoccer(int n, int m)
    {
        if (n < 0 || m < 0) return -1;
        if (n == 0 && m == 0) return 0;
        return ladderSoccer1(n, m);
    }
    private static int ladderSoccer1(int n, int m)
    {
        //Print.p(n, m);
        if (n == 0 && m == 0)
            return 1;
        if (n < 0 || m < 0) return 0;
        return ladderSoccer1(n - 1, m) + 
            ladderSoccer1(n, m - 1);
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
                //Print.p(i, grid[i].length, n);
                if (grid[i].length != n)
                {
                    grid = new int[][] {};
                    return false;
                }
                
            }
        }
        /*
        int [][] solution = new int[n][n];
        Print.p("solution");
        boolean solved = maze(grid, 0, 0, solution);
        Print.p(solution);
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
        if (x == n-1 && y == x)
            return true;
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
     * where at each step one can go up 2 or 2 steps at once
     * 
     * Example: a ladder with 5 steps has 5 possible ways:
     *  1111,112,121,211,22
     */
    public static int ladder(int n)
    {
        if (n < 1) return 1;
        String[] path = new String[]{""};
        int steps;
        boolean paths = true;
        if (paths)
        {
            steps = ladder(n, 0, 0, "", path);
            Print.p(path[0].substring(0, path[0].length()-1));
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
        Print.p(minPath[0], m[0][0]);//, minSum[0]);
        int result = m[0][0];
        m[0][0] = temp00;
        return result;
    }
    private static void smallestSumIn2Arrays(int[][] m, int sum, int x, int y, 
        String path, int step, String[] minPath, int temp00)
    {
        String point = makePt(x, y);
        path += point;
        if (p) Print.p(x, y, sum, temp00);
        if (p) Print.p(path, m[x][y]);
        int xy = (x==0 && y==0 ? temp00 : m[x][y]);
        if (y == m[0].length - 1)
        {
            sum += xy;
            if (y == m[0].length - 1 && m[0][0] > sum)
            {
                m[0][0] = sum;
                minPath[0] = path;
            }
            if (p) Print.p(1000, m[0][0], sum);
            return;
        }
        //sum = smallestSumIn2Arrays(a, b, sum + a[i], i+1, step);
        if (y < m[0].length)
        {
            if (p) Print.p("calling R " + point, sum);
            smallestSumIn2Arrays(m, sum + xy, x, y+1, path, step, minPath, temp00);
            if (p) Print.p("returning R " + point, sum);
        }
        if (step == 1 && x < m.length-1)//1st array moves to the 2nd array
        {
            if (p) Print.p("calling D " + point, sum);
            smallestSumIn2Arrays(m, sum + xy, x+1, y+1, path, step, minPath, temp00);
            if (p) Print.p("returning D " + point, sum);
        }
        if (step == 2 && x == m.length-1)//2nd array moves to the 1st array
        {
            if (p) Print.p("calling U " + point, sum);
            smallestSumIn2Arrays(m, sum + xy, x-1, y+1, path, step, minPath, temp00);
            if (p) Print.p("returning U " + point, sum);
        }
        return;
    }
    private static String makePt(int x, int y)
    {
        return "(" + x + "," + y + ")";
    }
    // to find smallest number in array of int, using recursion and noglobal variable
    public static int smallest(int[] a, int i)
    {
        //p = false;
        if (p) Print.p(1000, i, a.length);        
        if (i == a.length - 1)
            return i;
        int val = smallest(a, i + 1);
        if (p) Print.p(2000, i, a[val], a[i]);
        if (a[val] < a[i])
            return val;
        return i;
    }
    // does not use global variable and returns index pointing to smallest value
    public static int findSmallestIndex(int[] arr, int i)
    {
        //p = true;
        if (arr.length == 0) return -1;
        int index = 0; // first item in array
        if (p) Print.p(1000, i, arr.length);
        if (i < arr.length)
        {
            index = findSmallestIndex(arr, i + 1);
            if (p) Print.p(2000, i, index, arr.length);
            if (arr[index] > arr[i])
                index = i;
            if (p) Print.p(2100, i, index, arr[i]);
        }
        return index;
    }
    // use global variable and returns smallest value
    static int val = 100;
    public static int findSmallestVal(int[] arr, int i)
    {
        //p = true;
        if (arr.length == 0) return 0;
        if (p) Print.p(1000, i, val, arr.length);
        if (i < arr.length)
        {
            if (p) Print.p(1500, i, val, arr.length);
            val = findSmallestVal(arr, i + 1);
            if (val > arr[i])
                val = arr[i];
            if (p) Print.p(2000, i, val, arr[i]);
        }
        if (p) Print.p(3000, i, val);
        return val;
    }
    // To find all combinations of numbers from 1 to `n` having sum 'n' 
    // but not including the digit '0' and only one permutation per number
    // that is '41' is not allowed if '14' is already in the list by 
    // allowing only numbers with increasing values of the digits, thus '41'
    // has decreasing digits: start with 4 then 1
    static String used = "";    // to prevent duplicates
    public static String findAllNumsEqualN(int n)
    {
        return findAllNumsEqualN(1, n);
    }
    public static String findAllNumsEqualN(int nDigits, int n)
    {
        if (nDigits > n) return used.substring(0, used.length()-1);
        used += findNumbersEqualSum(nDigits, n, false).substring(1);
        if (p) Print.p("910," + used);
        return findAllNumsEqualN(nDigits + 1, n);
    }
    public static String findAllNumsEqualNLoop(int n)
    {
        for (int i=1; i<=n;i++)
        {
            used += findNumbersEqualSum(i, n, false).substring(1);
            if (p) Print.p("900," + used);
        }
        Print.p(count);
        return used.substring(0, used.length() - 1);
    }
    // Find all n–digit numbers with a given sum of digits equal
    //  to '_sum` in a bottom-up manner using recursion
    public static String findNumbersEqualSum(int n, int _sum, boolean allowZero)
    {
        used = " ";
        //count = 0;
        findNdigitNums("", 0, n, _sum, 0, allowZero, 0);
        if (allowZero) Print.p(count);
        return used;
    }
    private static void findNdigitNums(String result, int index, int n, 
            int _sum, int value, boolean allowZero,int highest)
    {
        // if the number is less than n–digit and its sum of digits is
        // less than the given sum
        if (p) Print.p(1000,index, n, _sum);
        if (p) Print.p("1500,[" + result + "]");
        count++;
        if (index < n && _sum >= 0)
        {
            int d = (index == 0 ? 1 : 0);  // special case: number cannot start from 0
            // consider every valid digit and put it in the current
            // index and recur for the next index
            if (p) Print.p("1800," + (index + 1) + ","+ d + ",[" + value + "]");
            if (index + 1 == n)
                d = _sum - value;
            if (!allowZero && d == 0) d = 1;
            while (d <= 9)
            {
                //if (index + 1 == n)
                //result = "" + d + result;
                if (p) Print.p("Calling 2000," + index + ","+ d + ",[" + result);
                if (_sum - d < 0) break;
                if (!allowZero)
                {
                    //if (p) Print.p("1900," + highest + ","+ d );                
                    if (d < highest) 
                        return;
                    highest = d;
                    if (p) Print.p("1950," + highest + ","+ d );                
                }
                findNdigitNums(result + d, index + 1, n, _sum - d, value, 
                    allowZero, highest);
                if (p) Print.p("Returning 2000," + index + ","+d + ",[" + result);
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
        p = true;        
        int maxSum = 9;
        for (int j=1; j<n; j++) 
            maxSum += 9;
        //Print.p(max, _sum);
        if (_sum > maxSum) return "";
        int start = pow(10,n-1);//(int)Math.pow(10,n-1);
        int max = pow(10,n)-1;//(int)Math.pow(10,n)-1;
        int sum = 0;
        int tensDig, digit;
        int lastCalledSumToTen = -1;
        for (int i=start; i<=max; i++) // go over all values of sum of digits
        {
            count++;
            if (p) Print.p(1000, i, n, _sum);
            int sumToTens = 0;
             // to save calls to getSumUpToTenDigit()
            if (lastCalledSumToTen < 0 || i-lastCalledSumToTen > 1)
                sumToTens = getSumUpToTenDigit(i, n);
            else
            {
                lastCalledSumToTen = i;
                sumToTens++;
            }
            if (p) Print.p(1503, i, _sum, sumToTens);
            if (sumToTens + 9 < _sum)
            {
                i += 10 - 1;
                continue;
            }
            if (p) Print.p(1504,_sum, sumToTens);
            if (_sum - sumToTens <= 9)
            {
                boolean exit = false;
                for (int j=9; j >= 0; j--)
                {
                    count++;
                    if (sumToTens + j == _sum)
                    {
                        used += "," + (i + j);
                        if (p) Print.p(used);
                        //Print.p(i, j, 10-j, i+9);
                        i += 9;
                        exit = true;
                        break;
                    }
                }
                if (exit) continue;
            }
            // finished all possible values with tens now move to hundreds
            if (p) Print.p(2003, i, sumToTens, _sum);
            i = goTo99(i, n);
            if (p) Print.p(2004, i, sumToTens, _sum);
        }
        Print.p(count);
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
            //Print.p(i, n, digit);
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
        used = "";
        p = false;
        //permutationWithOutLoop(X.toCharArray(), 0);
        //permutationWithLoop(X.toCharArray(), 0); // s
        X = "123";
        Print.p("myPermutationWithLoop");
        myPermutationWithLoop(X, "");
        Print.p(used);
        used = "";
        Print.p("myPermutationWithOutLoop");
        myPermutationWithOutLoop(X, "");
        //Print.p(used.length()/(1 + X.length()));
        return used.substring(1);
    }
    private static void myPermutationWithOutLoop(String X, String curr)
    {
        //char a = (char)0;
        if (p) Print.p(X + ", curr=[" + curr + "]");
        if (X.length() == 0)
        {
            used +=  "," + curr;
            return;
        }
        myRecursiveLoop(X, curr, 0); // Start the recursive loop
        /*
        for (int i=0; i<X.length(); i++)
        {
            a = X.charAt(i);
            String remainingX = X.substring(0,i) + X.substring(i+1);
            myPermutationWithOutLoop(remainingX, curr + a);
        }
        */
    }
    private static void myRecursiveLoop(String X, String curr, int i)
    {
        if (i < X.length())
        {
            char a = X.charAt(i);
            if (p) Print.p("100,"+i+","+X);
            if (p) Print.p("1000,"+i+","+X.substring(0,i));
            if (p) Print.p("2000,"+i+","+X.substring(i+1));
            String remainingX = X.substring(0,i) + X.substring(i+1);
            myPermutationWithOutLoop(remainingX, curr + a);
            
            myRecursiveLoop(X, curr, i + 1); // Continue with the next value of i
        }
    }
    // the following my solution using for-loop
    private static void myPermutationWithLoop(String X, String curr)
    {
        if (p) Print.p(X + ", curr=[" + curr + "]");
        if (X.length() == 0)
        {
            used +=  "," + curr;
            return;
        }
        for (int i=0; i<X.length(); i++)
        {
            char a = X.charAt(i);
            if (p) Print.p("100,"+i+","+X);
            if (p) Print.p("1000,"+i+","+X.substring(0,i));
            if (p) Print.p("2000,"+i+","+X.substring(i+1));
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
            MyLibrary.swap(str, index, i); // Swap the characters at index and i
            permutationWithOutLoop(str, index + 1); // Recurse for the next index
            MyLibrary.swap(str, index, i); // Backtrack by swapping back
        
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
            MyLibrary.swap(str, index, i);  // Swap the characters at index and i
            permutationWithLoop(str, index + 1);  // Recurse for the next index
            MyLibrary.swap(str, index, i);  // Backtrack by swapping the characters back
        }
    }
    /*  Not working, keeping code for the usage of a TREE
     * need to do "head = tail = null;" before calling the method
    static IntNodeMat head, tail;
    private static String permutation(String curr, String X, String Y, int index, int level)
    {
        // head = tail = null;
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
