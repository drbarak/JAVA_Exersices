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
        int[] run = new int[100];
        int[] arr;
        int ar[][] = new int[117][];
        
        int runMethod = 36;
        run[runMethod] = 1;
        
        if (run[35] == 1)
        {
            Print.p("------ Recursion 21 - LongestWorm(int[][]) ------");
            int[][] grid = new int[][]{  // 4 solutions for sum = 4
                {4, 41, 2, 1}, // line 0
                {2, 1, 1, 1}, // line 1
                {2, 15, 10, 54}, // line 2
                {63, 22, 2, 4}}; // line 3
            int sum = 4;    // 3 solutions
            Print.p("Matrix: ");
            Print.p(grid);
            Print.p("Found worm of length "+Recursion.longestWorm(grid));
        }
        if (run[35] == 1)
        {
            Print.p("------ Recursion 20 - findSumInMatrix ------");
            int[][] grid = new int[][]{  // 4 solutions for sum = 4
                {4, 41, 2, 1}, // line 0
                {2, 1, 1, 1}, // line 1
                {2, 15, 10, 54}, // line 2
                {63, 22, 2, 4}}; // line 3
                /*
            grid = new int[][]{   // 2 solutions for sum = 4
                {2, 41, 3, 14}, // line 0
                {2, 1, 24, 7}, // line 1
                {3, 15, 1, 54}, // line 2
                {63, 22, 2, 4}}; // line 3
                /*
            grid = new int[][]{ 
                {1, 1, 3, 14}, // line 0
                {2, 1, 24, 7}, // line 1
                {3, 15, 1, 54}, // line 2
                {63, 22, 2, 4}}; // line 3
                */
            int sum = 4;    // 3 solutions
            //sum = 9;  // no solutions
            Print.p("Matrix: ");
            Print.p(grid);
            int[][] path = new int[grid.length][grid.length];
            Print.p("Found path with sum "+sum+": "+Recursion.findSumInMatrix(grid, sum, path));
            Print.p(path);
        }
        if (run[34] == 1)
        {
            Print.p("------ Recursion 19 - findSumsInMatrix ------");
            int[][] grid = new int[][]{ // 6 solutions
                {4, 41, 2, 1}, // line 0
                {2, 1, 1, 1}, // line 1
                {2, 15, 10, 54}, // line 2
                {63, 22, 2, 4}}; // line 3
            grid = new int[][]{ 
                {2, 41, 3, 14}, // line 0
                {2, 1, 24, 7}, // line 1
                {3, 15, 10, 54}, // line 2
                {63, 22, 2, 4}}; // line 3
            int sum = 4;    // 3 solutions
            //sum = 9;  // no solutions
            Print.p("Matrix: ");
            Print.p(grid);
            int[][] path = new int[grid.length][grid.length];
            Print.p("Found path with sum "+sum+": "+Recursion.findSumsInMatrix(grid, sum, path));
            Print.p(path);
        }
        if (run[33] == 1)
        {
            Print.p("------ Recursion 18 - findStains ------");
            int[][] grid = {
                {0, 1, 0, 0, 0, 0, 0, 1}, // line 0
                {1, 0, 0, 0, 0, 0, 1, 1}, // line 1
                {0, 0, 0, 0, 0, 1, 1, 0}, // line 2
                {0, 1, 1, 0, 0, 0, 0, 0}, // line 3
                {0, 0, 0, 1, 0, 0, 0, 0}, // line 4
                {0, 0, 0, 0, 1, 1, 0, 0}, // line 5
                {1, 0, 0, 0, 0, 0, 1, 0}, // line 6
                {1, 1, 1, 0, 0, 0, 1, 0}};  // line 7
            Print.p("Matrix: ");
            Print.p(grid);
            Print.p("number of stains is: " + Recursion.findStains(grid));
            Print.p(grid);
            grid = new int[][]{
                {0,1,0,0,1}, // line 0
                {1,0,0,1,1}, // line 1
                {0,0,1,1,0}, // line 2
                {1,0,0,0,0}, // line 3
                {1,1,1,0,0}};// line 4
            Print.p(grid);
            Print.p("number of stains is: " + Recursion.findStains(grid));
            Print.p(grid);
            grid = new int[][]{
                {0,1,0,0,1}, // line 0
                {1,0,0,0,1}, // line 1
                {0,0,1,0,0}, // line 2
                {1,0,0,0,1}, // line 3
                {1,1,1,0,0}};// line 4
            Print.p(grid);
            Print.p("number of stains is: " + Recursion.findStains(grid));
            Print.p(grid);
        }
        if (run[32] == 1)
        {
            Print.p("------ Recursion 17 - findStainSizeAtXY ------");
            int[][] grid = {
                {0, 1, 0, 0, 0, 0, 0, 1}, // line 0
                {1, 0, 0, 0, 0, 0, 1, 1}, // line 1
                {0, 0, 0, 0, 0, 1, 1, 0}, // line 2
                {0, 1, 1, 0, 0, 0, 0, 0}, // line 3
                {0, 0, 0, 1, 0, 0, 0, 0}, // line 4
                {0, 0, 0, 0, 1, 1, 0, 0}, // line 5
                {1, 0, 0, 0, 0, 0, 1, 0}, // line 6
                {1, 1, 1, 0, 0, 0, 1, 0}};  // line 7
            Print.p("Matrix: ");
            Print.p(grid);
            int x = 4, y = 3;
            Print.p("Size of stain at "+Recursion.makePt(x,y)+" is: " + Recursion.stains(grid, x, y));
            grid = new int[][]{
                {0,1,0,0,1}, // line 0
                {1,0,0,1,1}, // line 1
                {0,0,1,1,0}, // line 2
                {1,0,0,0,0}, // line 3
                {1,1,1,0,0}};// line 4
            Print.p(grid);
            x = 2; y = 2;
            Print.p("Size of stain at "+Recursion.makePt(x,y)+" is: " + Recursion.stains(grid, x, y));
            grid = new int[][]{
                {0,1,0,0,1}, // line 0
                {1,0,0,0,1}, // line 1
                {0,0,1,0,0}, // line 2
                {1,0,0,0,1}, // line 3
                {1,1,1,0,0}};// line 4
            Print.p(grid);
            x = 0; y = 0;
            Print.p("Size of stain at "+Recursion.makePt(x,y)+" is: " + Recursion.stains(grid, x, y));
        }
        if (run[31] == 1)
        {
            Print.p("------ Recursion 16 - princeToVilan(int[][] m) ------");
            int[][] grid = {
                {2, 0, 1, 2, 3}, // line 0
                {2, 3, 5, 5, 4}, // line 1
                {8, -1, 6, 8, 7}, // line 2
                {3, 4, 7, 2, 4}, // line 3
                {2, 4, 3, 1, 2}, // line 4
                }; // line 5
            Print.p("Matrix: ");
            Print.p(grid);
            Print.p("princeToVilan: "+Recursion.princeToVilan(grid, 0, 0));
            Print.p(grid);
            grid = new int[][] { // no solution
                {12, 0, 1, 2, 3}, // line 0
                {2, 3, 5, 5, 4}, // line 1
                {8, -1, 6, 8, 7}, // line 2
                {3, 4, 7, 2, 4}, // line 3
                {2, 4, 3, 1, 2}, // line 4
                }; // line 5
            Print.p("Matrix: ");
            Print.p(grid);
            Print.p("princeToVilan: "+Recursion.princeToVilan(grid, 0, 0));
            Print.p(grid);
        }
        if (run[30] == 1)
        {
            Print.p("------ Recursion 15 - countPathsInMatrix(int[][] m) ------");
            int[][] grid = { // no solution
                {12, 22, 23, 54}, // line 0
                {43, 35, 21, 20}, // line 1
                {34, 21, 43, 21}, // line 2
                {25, 30, 0, 20}, // line 3
                {0, 22, 10, 10}, // line 4
                {20, 13, 3, 45}}; // line 5
            Print.p("Matrix: ");
            Print.p(grid);
            Print.p("countPathsInMatrix: "+Recursion.countPathsInMatrix(grid));
        }
        if (run[29] == 1)
        {
            Print.p("------ Recursion 14 - areThereNumbersEqualSumWithRepeatition(int[] a, int sum) ------");
            int i = 0;
            int[] target = new int[20];
            ar[i]  = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
            target[i++] = 92;
            ar[i]  = new int[]{-1, 2, 75, 90, 802, 24, 2, 66};
            target[i++] = 93;
            ar[i]  = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
            target[i++] = 91;
            ar[i]  = new int[]{101, 12, 5};
            target[i++] = 118;
            ar[i]  = new int[]{92,-1};
            target[i++] = 91;
            ar[i]  = new int[]{92,-1};
            target[i++] = 80;
            ar[i]  = new int[]{91};
            target[i++] = 91;
            ar[i]  = new int[]{-1};
            target[i++] = 91;
            ar[i]  = new int[]{};
            target[i++] = 0;
            for (int j=0; j<i; j++)
                Print.p("areThereNumbersEqualSumWithRepeatition: "+target[j]+" ["+
                Recursion.areThereNumbersEqualSumWithRepeatition(ar[j], target[j])+
                "]", ar[j]);
        }
        if (run[28] == 1)
        {
            Print.p("------ Recursion 13 - areThereNumbersEqualSum(int[] a, int sum) ------");
            int i = 0;
            int[] target = new int[20];
            ar[i]  = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
            target[i++] = 92;
            ar[i]  = new int[]{-1, 2, 75, 90, 802, 24, 2, 66};
            target[i++] = 93;
            ar[i]  = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
            target[i++] = 91;
            ar[i]  = new int[]{101, 12, 5};
            target[i++] = 118;
            ar[i]  = new int[]{92,-1};
            target[i++] = 91;
            ar[i]  = new int[]{91};
            target[i++] = 91;
            ar[i]  = new int[]{-1};
            target[i++] = 91;
            ar[i]  = new int[]{};
            for (int j=0; j<i; j++)
                Print.p("areThereNumbersEqualSum: "+target[j]+" ["+
                Recursion.areThereNumbersEqualSum(ar[j], target[j])+
                //Recursion.cover(ar[j], target[j])+
                "]", ar[j]);
        }
        if (run[27] == 1)
        {
            Print.p("------ Recursion 12 - areThere2NumbersEqualSum(int[] a, int sum) ------");
            int i = 0;
            int[] target = new int[20];
            ar[i]  = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
            target[i++] = 92;
            ar[i]  = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
            target[i++] = 91;
            ar[i]  = new int[]{101, 12, 5};
            target[i++] = 118;
            ar[i]  = new int[]{119,-1};
            target[i++] = 118;
            ar[i]  = new int[]{target[i-1]};
            target[i++] = 91;
            ar[i]  = new int[]{-1};
            target[i++] = 91;
            ar[i]  = new int[]{};
            for (int j=0; j<i; j++)
                Print.p("areThere2NumbersEqualSum: "+target[j]+" ["+
                Recursion.areThere2NumbersEqualSum(ar[j], target[j])+
                "]", ar[j]);
        }
        if (run[26] == 1)
        {
            Print.p("------ Recursion 11 - selectioSort(int[] n) ------");
            arr  = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
            //arr  = new int[]{101, 12, 5};
            //arr  = new int[]{3,-1};
            //arr  = new int[]{-1};
            //arr  = new int[]{};
            Print.p("Original array: ", arr);
            Sort.selectioSort(arr);
            Print.p("Sorted array: ", arr);
        }
        if (run[25] == 1)
        {
            Print.p("------ Recursion 10 - ladderSoccer(int n, int m) G1:G2 ------");
            int G1 = 2, G2 = 1, test = 3;
            //G1 = 3; G2 = 1; test = 4;
            //G1 = G2 = test = 0;
            //G1 = -1; G2 = 0; test = -1;
            Print.p("Steps to to get to score ["+G1+":"+G2+"] is: "+Recursion.ladderSoccer(G1, G2)+", test="+test);
        }
        if (run[24] == 1)
        {
            Print.p("------ Recursion 9 - Maze מבוך ------");
            int[][] grid = { // no solution
                {1, 0, 0, 0, 0, 0, 0, 0}, // line 0
                {1, 1, 0, 0, 0, 0, 0, 0}, // line 1
                {0, 1, 0, 0, 0, 0, 0, 0}, // line 2
                {0, 1, 1, 1, 0, 0, 0, 0}, // line 3
                {0, 0, 0, 1, 0, 0, 0, 0}, // line 4
                {0, 0, 0, 1, 1, 1, 1, 0}, // line 5
                {0, 0, 0, 0, 0, 0, 1, 0}, // line 6
                {0, 0, 0, 0, 0, 0, 1, 0}};  // line 7
            grid = new int[][] {    // with solution
                {1, 0, 0, 0, 0, 0, 0, 0}, // line 0
                {1, 1, 0, 0, 0, 0, 0, 0}, // line 1
                {0, 1, 1, 0, 0, 0, 0, 0}, // line 2
                {0, 0, 1, 1, 1, 0, 0, 0}, // line 3
                {0, 0, 0, 0, 1, 0, 0, 0}, // line 4
                {0, 0, 0, 0, 1, 1, 1, 0}, // line 5
                {0, 0, 0, 0, 0, 0, 1, 0}, // line 6
                {0, 0, 0, 0, 0, 0, 1, 1}};  // line 7
            grid = new int[][] { // with solution but on the way hit a wall and must go back
                {1, 0, 0, 1, 1, 0, 0, 0}, // line 0
                {1, 1, 1, 1, 0, 0, 0, 0}, // line 1
                {0, 0, 0, 1, 0, 0, 0, 0}, // line 2
                {0, 0, 1, 1, 1, 0, 0, 0}, // line 3
                {0, 0, 0, 0, 1, 0, 0, 0}, // line 4
                {0, 0, 0, 0, 1, 1, 1, 0}, // line 5
                {0, 0, 0, 0, 0, 0, 1, 0}, // line 6
                {0, 0, 0, 0, 0, 0, 1, 1}};  // line 7
            Print.p("Original maze: ");
            Print.p(grid);
            boolean solution = Recursion.maze(grid);
            if (grid.length == 0)
                Print.p("invalid grid - must be square matrix ");
            else
            {
                if (!solution)
                    Print.p("No solution found!!!");
                else
                Print.p("Solution maze (the '2' show the path out): ");
            }
            Print.p(grid);
        }
        if (run[23] == 1)
        {
            Print.p("------ radixSort Loop ------");
            arr  = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
            arr  = new int[]{101, 12, 5};
            Print.p("Original array: ", arr);
            Sort.radixSort(arr);
            Print.p("Sorted array: ", arr);
        }
        if (run[22] == 1)
        {
            Print.p("------ quickSort Recursion ------");
            arr = new int[]{3, 8, 15, 1, 7};
            arr = new int[]{-10,-3,-7,-1,9,8};
            arr = new int[]{45,33,69,97,82,36,73,91,40,88,32};
            arr = new int[]{45,44,43,42,41,40,39,38,37,36,35};
            arr = new int[]{45,37,44,40,42,36,43,41,40,38,35};
            int n=50;
            arr = new int[n];
            for (int i=0; i<n; i++)
                arr[i] = i;
            //arr = new int[] {3, 8, 15, 1, 7};    
            Print.p("Original array:", arr);
            Sort.quickSort(arr, false);
            Print.p("Sorted array: ", arr);
        }
        if (run[21] == 1)
        {
            Print.p("------ quickSortLoop ------");
            arr = new int[]{3, 8, 15, 1, 7};
            arr = new int[]{-10,-3,-7,-1,9,8};
            arr = new int[]{45,33,69,97,82,36,73,91,40,88,32};
            //arr = new int[]{45,44,43,42,41,40,39,38,37,36,35};
            arr = new int[]{45,37,44,40,42,36,43,41,40,38,35};
            Print.p("Original array:", arr);
            Sort.quickSortLoop(arr, false);
            Print.p("Sorted array: ", arr);
        }
        if (run[20] == 1)
        {
            Print.p("------ My sort ------");
            arr = new int[]{3, 8, 15, 1, 7};
            //arr = new int[]{-10,-3,-7,-1,9,8};
            //arr = new int[]{-10,-3,-1,-1,9,8};
            //arr = new int[]{45,33,69,97,82,36,73,91,40,88,32};
            //arr = new int[]{45,44,43,42,41,40,39,38,37,36,35};
            arr = new int[]{45,37,44,40,42,36,43,41,40,38,35};
            int n=50;
            arr = new int[n];
            for (int i=0; i<n; i++)
                arr[i] = i;
            Print.p("Original array:", arr);
            Print.p("Sorted array: ", Sort.mySort(arr, false));
        }
        if (run[19] == 1)
        {
            Print.p("------ Recursion 8 - ladder(int n) ------");
            int n = 5;
            n = 6;
            Print.p("steps to climb a ladder of "+n+" steps is: "+Recursion.ladder(n));
        }
        if (run[18] == 1)
        {
            Print.p("------ Recursion 7 - smallestSumIn2Arrays ------");
            int[] a = new int[]{2,6,1,9,7,3,1,4};//{1,2,5};
            int[] b = new int[]{3,3,-7,-1,3,3,1,-4};//{2,-1,6};
            Print.p(a);
            Print.p(b);
            Print.p("smallest="+Recursion.smallestSumIn2Arrays(a, b));
        }
        if (run[17] == 1)
        {
            Print.p("------ Efficiancy 4- findSubarray ------");
            arr  = new int[]{2,6,1,9,7,3,1,4,1,2,8};
            arr = new int[]{3,3,-7,-1,3,3,1,-4};
            int[] result = Efficiancy.findSubarraySumTarget(arr, 7);
            Print.p(Arrays.toString(arr)+",findSubarray="+Arrays.toString(result));
            result = Efficiancy.findSubarrayAlsoNegative(arr, 100);
            Print.p(Arrays.toString(arr)+",findSubarrayAlsoNegative="+Arrays.toString(result));
        }
        if (run[16] == 1)
        {
            Print.p("------ Efficiancy 3 - findLargestAverageDiff ------");
            arr  = new int[]{5,7,-2,10};
            int index = Efficiancy.findLargestAverageDiff(arr);
            Print.p(Arrays.toString(arr)+",findLargestAverageDiff="+index);
        }
        if (run[15] == 1)
        {
            Print.p("------ Efficiancy 2 - findDuplicateNumInArray ------");
            arr  = new int[]{2,3,1,4,3,5};
            int num = Efficiancy.findDuplicateNumInArray(arr);
            Print.p(Arrays.toString(arr)+",findDuplicateNumInArray="+num);
        }
        if (run[14] == 1)
        {
            Print.p("------ Efficiancy 1 - SuperIncreasing ------");
            arr  = new int[]{1, 2, 4, 8, 16};
            boolean ok = Efficiancy.isSuperIncreasing(arr);
            Print.p(Arrays.toString(arr)+",isSuperIncreasing="+ok);
            if (ok)
                Print.p("superIncreasingRepresentation="+ 
                    Arrays.toString(Efficiancy.superIncreasingRepresentation(arr, 32)));//16,20,15,32
            arr = new int[]{1, 2, 3, 8, 16};
            ok = Efficiancy.isSuperIncreasing(arr);
            Print.p(Arrays.toString(arr)+",isSuperIncreasing="+ok);
            if (ok)
                Print.p("superIncreasingRepresentation="+ 
                    Efficiancy.superIncreasingRepresentation(arr, 16));
        }
        if (run[13] == 1)
        {
            Print.p("------ Recursion 6 - smallest ------");
            arr  = new int[]{10, 10, 3, 2};
            Print.p(Arrays.toString(arr) + ",smallest=[" + 
                    arr[Recursion.smallest(arr, 0)]);
                    //Recursion.findSmallestIndex(arr, 0));
                    //Recursion.findSmallestVal(arr, 0));
        }
        if (run[12] == 1)
        {
            Print.p("------ Recursion 5 - findAllarrEqualN ------");
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
            start = 9;
            last = start + 1;
            for (int i=start; i < last; i++)
            {
                n = nArr[i][0];
                sum = nArr[i][1];
                    long startTime = System.currentTimeMillis();
                String result = Recursion.findNumbersEqualSumLoop(n, sum, true).substring(1);
                if (result == "") result = " ";
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
            Print.p("------ LevenshteinDistance ------");
            String[] dict = {"applet","lake","banana","rice","mouse","bottle","apple",
                "ape","applets","appel"};
            //dict = new String[]{"A","b","aP"};//"APPLETS","APPLES"
            int indexWord = LevenshteinDistance.approximatedStringMatching(dict, true);
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
            Print.p("\n------Recursion 0 - factorial ------");
            arr  = new int[]{-2, 0, 1, 2, 3, 5, 6};
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
