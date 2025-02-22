package תרגילים_נוספים;

import static Library.Print.p;
//import static Library.Print.pNothing;
//import static Library.Print.pProtected;
//import static Library.Print.*;
//import Library.Print;
//import static Library.MyLibrary.*;
//import Library.MyPoint.*;
 
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
        //p("1");   // OK
        //pNothing("2");  //compilation error - undeclared
        //pProtected("3");  //compilation error - undeclared
        //Print.pProtected("4");  //compilation error - protected access
        boolean p = false;
        int[] run = new int[100];
        int[] arr;
        int ar[][] = new int[117][];
        
        int runMethod = 52;
        run[runMethod] = 1;

        if (run[52] == 1)
        {
            p("------ Recursion 31 - findLCS(String s1, String s2, String s3) ------");
            String s1 = "abcde";
            String s2 = "acebdf";
            String s3 = "acdbef";
            s1 = "abcbdab"; s2 = "bdcaba"; s3 = "abcba";
            //s1 = "a"; s2 = "2a"; s3 = "a";
            p(s1+","+s2+","+s3);
            p("Longest Common Semi-Substring: " + Recursion.findLCS(s1, s2, s3));
        }
        if (run[51] == 1)
        {
            p("------ Efficiency 9 - hasDivisor(int[] arr) ------");
            int i = 0;
            int a[];
            ar[i++] = new int[] {25,-20,-100,10,5};
            ar[i++] = new int[] {25,-20,6,-100,10};
            ar[i++] = new int[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
            ar[i++] = new int[] {100, 101, 102, 103, 104, 105, 106, 107, 108, 109};
            ar[i++] = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
            ar[i++] = new int[] {10,8,6,4,2};
            ar[i++] = new int[] {20,18,16,14,12,10,8,2,6,2,6};
            ar[i++] = new int[] {20,18,16,14,12,10,8,2,6,4,2};
            ar[i++] = new int[] {2, 3, 5, 7, 11};
            ar[i++] = new int[] {2, 4, 8, 16, 32};
            ar[i++] = new int[] {256*256, 256,16,4,2};
            //p(2%4, 4%2, 256%16); // to check if neede a>b or a<b
            for (int j=i-1; j<i; j++){
                a = ar[j];
                p("index = "+ Efficiency.hasDivisor(a) + ", ", a);
                p("index = "+ Efficiency.hasDivisorChatGPT(a) + ", ", a);
            }
            /*
            int b = 123, a1 = 77, k = 1000000;
            boolean c;
            long startTime = System.currentTimeMillis();
            for (int i=0; i < k; i++){
                c = (a1 % b != 0);
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            p("Elapsed time: " + elapsedTime + " milliseconds");
            startTime = System.currentTimeMillis();
            for (int i=0; i < k; i++){
                c = (a1 == b);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            p("Elapsed time: " + elapsedTime + " milliseconds");
            */
            //conclusion: time to calcualte % is a bit slower than < but
            // if we must check for = then to add also % does not add much time
            // thus if the array does not have duplicates, % is enough
        }
        if (run[50] == 1)
        {
            p("------ Recursion 30 - equalSum(int[] arr) ------");
            int[] a = {2,1,6,4,5};
            //a = new int[] {2,1,3,5,4};
            //a = new int[] {3,1,2};
            p("index = "+ Recursion.equalSum(a) + ", ", a);
        }
        if (run[49] == 1)
        {
            p("------ Recursion 29 - howManySorted(int n, int max) ------");
            int n = 2, max = 3;
            p("howManySorted for n = "+n+" and max = " + max + " is = " +
                        Recursion.howManySorted(n, max));
        }
        if (run[48] == 1)
        {
            p("------ Recursion 28 - one(String s1, String s2) ------");
            String s1 = "abc"; String s2 = "abcd";
            s2 = "abd";
            s2 = "dbc";
            s2 = "axc";
            p("One = "+Recursion.one(s1, s2));
        }
        if (run[47] == 1)
        {
            p("------ Recursion 27 - maxInMat(int[][]) ------");
            int[][] grid = new int[][]{
                {3, 13, 15, 28,30}, // line 0
                {50,51,52,29,30}, // line 1
                {51,10,53,54,55}, // line 2
                {53,12,14,53,111}}; // line 3
            p("max = "+Recursion.maxInMat(grid), grid);
        }
        if (run[46] == 1)
        {
            p("------ Recursion 26 - zigzag(int[] a) ------");
            int[] a = {45,3,69,97,82,16,73,81,40,88,32};
            a = new int[] {10,9,8,7,6,5,4,3,2,1,0};
            a = new int[] {4,18,2,7,4,7,0,3};
            a = new int[] {4,18,19,7,4,7,0,3};
            p("Zigzag array = " + Recursion.zigzag(a));
        }
        if (run[45] == 1)
        {
            p("------ Recursion 25 - quickSort(int[] a) ------");
            int[] a = {45,3,69,97,82,16,73,81,40,88,32};
            a = new int[] {10,9,8,7,6,5,4,3,2,1,0};
            //a = new int[] {10,9,8,0};
            p("Sorted array ", Recursion.quickSort(a));
        }
        if (run[44] == 1)
        {
            p("------ Recursion 24 - odd(int num) ------");
            p(1234, Recursion.odd(1234));
            p(120, Recursion.odd(120));
            int k = 111;//84224;
            p(k, Recursion.odd(k));
        }
        if (run[43] == 1)
        {
            p("------ Recursion 23 - necklace(int n) ------");
            int k = 6;
            for (int i=0; i<k+1;i++)
                p(i, Recursion.necklace(i));
        }
        if (run[42] == 1)
        {
            p("------ Efficiency 8 - findSubarray(int[] arr, int target) ------");
            int[] a = {-1, 1, -3, 3};
            Efficiency.findSubarray(a, -11);
            Efficiency.findSubarray(a, 1);
            Efficiency.findSubarray(a, -2);
            //Efficiency.findSubarray(a, 0);
        }
        if (run[41] == 1)
        {
            p("------ Recursion 22 - binaryNumbers(int n) ------");
            for (int i=0; i<8;i++)
                Recursion.binaryNumbers(i);
        }
        if (run[40] == 1)
        {
            p("------ Efficiency 7 - sortMod(int[] a, int k) ------");
            int[] a = {35, 17, 13, 252, 4, 128, 7, 3, 81};
            a = new int[]{39, 18, 17, 256, 5, 124, 3, 2, 81};
            int n = 20;
            a = new int[n];
            for (int i=0;i<n;i++)
                a[i] = n-i;
            int[] b = a.clone();
            int k = 10;
            //p("new array chatGPT mod = " + k + ", ", Efficiency.sortMod(a, k));
            //p("new array school mod = " + k + ", ", Efficiency.sortModSchool(a, k));
            p("new array mine mod = " + k + ", ", Efficiency.sortModOK(a, k, false));
            //need to be fixed, but looks like it is not not improving
            //p("new array mine mod = " + k + ", ", Efficiency.sortModOK(b, k, true));
        }
        if (run[39] == 1)
        {
            p("------ Efficiency 6 - orderCrossedArray(int[] a) ------");
            int i = 0;
            ar[i++] = new int[]{1, 9, 2, 8, 4};
            ar[i++] = new int[]{1, 9, 2, 8, 4, 7};
            ar[i++] = new int[]{1, 9, 2, 8, 4, 7, 7};
            ar[i++] = new int[]{1, 9, 2, 8, 4, 7, 7, 4};
            ar[i++] = new int[]{1,9,2,8,4,7,7,4,12};
            ar[i++] = new int[]{1,9,2,8,4,7,7,-4,12};
            ar[i++] = new int[]{1,9,2,8,4,3,7,-4,12};
            int n = 10;
            ar[i++] = new int[n];
            int end = (n%2 == 0 ? 1 : 2);
            for (int j=0; j < n; j+=2)
            {
                ar[i-1][j] = j;
                if (j < n-end) ar[i-1][j+1] = n - j - end;
            }
            ar[i++] = new int[]{1,19,2,17,4,15,7,-4,8};
            ar[i++] = new int[]{1,19,2,17,4,-3,7,-4,8};
            ar[i++] = new int[]{1,-1,2,-2,4,-3,7,-4,8};
            int j = --i;
            for (; i >= 0; i--)
                p("new array " + i + " = ", Efficiency.orderCrossedArray(ar[i]));
        }
        if (run[38] == 1)
        {
            p("------ Efficiency 5 - findMinAbsSum(int[] a) ------");
            arr = new int[]{1};
            arr = new int[]{-2};
            arr = new int[]{1, 100};
            arr = new int[]{-1, 100};
            arr = new int[]{-2, -1};
            arr = new int[]{1, 2, 3};
            arr = new int[]{-10, -5, -3};
            arr = new int[]{-1, 2, 3};
            arr = new int[]{-1, 2, 3, 4};
            arr = new int[]{-1, 2, 3, 4, 5};
            arr = new int[]{-3, -2, -1, 1,2,3};
            arr = new int[]{-2,-1,3,5,7,8,11,17,25,31,36};
            /*
            arr = new int[]{-13, -12, -11, 1,2,3};
            arr = new int[]{-13, -12, -11, 1,2,3,4,5,6,7};
            arr = new int[]{-13, -12, -11, 1};
            arr = new int[]{-13, -2, -1, 10};
            arr = new int[]{-3,1,2,3};
            arr = new int[]{-4,-3,1,2,3};
            arr = new int[]{-5,-4,-3,10,12,13};
            */
            p(arr);
            p("lowest sum = "+Efficiency.findMinAbsSum(arr));
        }
        if (run[37] == 1)
        {
            p("------ LinkList 1 - isPalindrom() ------");
            arr = new int[]{3, 13, 15, -28, 30, 0,1};
            arr = new int[]{10,4,2,3,4,10};
            LinkList ls = new LinkList(arr);
            p(ls.toString());
            //p(ls.countList());
            //ls.reveseList();
            p("isPalindrom = "+ls.isPalindrom());
        }
        if (run[36] == 1)
        {
            p("------ Recursion 21 - LongestWorm(int[][]) ------");
            int[][] grid = new int[][]{  // 4 solutions for sum = 4
                {3, 13, 15, 28,30}, // line 0
                {50,51,52,29,30}, // line 1
                {51,10,53,54,55}, // line 2
                {53,12,14,53,11}}; // line 3
            p("Found worm of length "+Recursion.longestWorm(grid), grid);
        }
        if (run[35] == 1)
        {
            p("------ Recursion 20 - findSumInMatrix ------");
            int[][] grid = new int[][]{  // 4 solutions for sum = 4
                {4, 41, 2, 1}, // line 0
                {2, 1, 1, 1}, // line 1
                {2, 15, 10, 54}, // line 2
                {63, 22, 2, 4}}; // line 3
            int sum = 4;
            grid = new int[][]{
                {4, 41, 20, 1}, // line 0
                {1, 10, 10, 1}, // line 1
                {2, 15, 10, 54}, // line 2
                {63, 22, 20, 40}}; // line 3
            sum = 3;
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
            //sum = 9;  // no solutions
            p("Matrix: ");
            p(grid);
            int[][] path = new int[grid.length][grid.length];
            p("Found path with sum "+sum+": "+Recursion.findSumInMatrix(grid, sum, path));
            p(path);
        }
        if (run[34] == 1)
        {
            p("------ Recursion 19 - findSumsInMatrix ------");
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
            p("Matrix: ");
            p(grid);
            int[][] path = new int[grid.length][grid.length];
            p("Found path with sum "+sum+": "+Recursion.findSumsInMatrix(grid, sum, path));
            p(path);
        }
        if (run[33] == 1)
        {
            p("------ Recursion 18 - findStains ------");
            int[][] grid = {
                {0, 1, 0, 0, 0, 0, 0, 1}, // line 0
                {1, 0, 0, 0, 0, 0, 1, 1}, // line 1
                {0, 0, 0, 0, 0, 1, 1, 0}, // line 2
                {0, 1, 1, 0, 0, 0, 0, 0}, // line 3
                {0, 0, 0, 1, 0, 0, 0, 0}, // line 4
                {0, 0, 0, 0, 1, 1, 0, 0}, // line 5
                {1, 0, 0, 0, 0, 0, 1, 0}, // line 6
                {1, 1, 1, 0, 0, 0, 1, 0}};  // line 7
            p("Matrix: ");
            p(grid);
            p("number of stains is: " + Recursion.findStains(grid));
            p(grid);
            grid = new int[][]{
                {0,1,0,0,1}, // line 0
                {1,0,0,1,1}, // line 1
                {0,0,1,1,0}, // line 2
                {1,0,0,0,0}, // line 3
                {1,1,1,0,0}};// line 4
            p(grid);
            p("number of stains is: " + Recursion.findStains(grid));
            p(grid);
            grid = new int[][]{
                {0,1,0,0,1}, // line 0
                {1,0,0,0,1}, // line 1
                {0,0,1,0,0}, // line 2
                {1,0,0,0,1}, // line 3
                {1,1,1,0,0}};// line 4
            p(grid);
            p("number of stains is: " + Recursion.findStains(grid));
            p(grid);
        }
        if (run[32] == 1)
        {
            p("------ Recursion 17 - findStainSizeAtXY ------");
            int[][] grid = {
                {0, 1, 0, 0, 0, 0, 0, 1}, // line 0
                {1, 0, 0, 0, 0, 0, 1, 1}, // line 1
                {0, 0, 0, 0, 0, 1, 1, 0}, // line 2
                {0, 1, 1, 0, 0, 0, 0, 0}, // line 3
                {0, 0, 0, 1, 0, 0, 0, 0}, // line 4
                {0, 0, 0, 0, 1, 1, 0, 0}, // line 5
                {1, 0, 0, 0, 0, 0, 1, 0}, // line 6
                {1, 1, 1, 0, 0, 0, 1, 0}};  // line 7
            p("Matrix: ");
            p(grid);
            int x = 4, y = 3;
            p("Size of stain at "+Recursion.makePt(x,y)+" is: " + Recursion.stains(grid, x, y));
            grid = new int[][]{
                {0,1,0,0,1}, // line 0
                {1,0,0,1,1}, // line 1
                {0,0,1,1,0}, // line 2
                {1,0,0,0,0}, // line 3
                {1,1,1,0,0}};// line 4
            p(grid);
            x = 2; y = 2;
            p("Size of stain at "+Recursion.makePt(x,y)+" is: " + Recursion.stains(grid, x, y));
            grid = new int[][]{
                {0,1,0,0,1}, // line 0
                {1,0,0,0,1}, // line 1
                {0,0,1,0,0}, // line 2
                {1,0,0,0,1}, // line 3
                {1,1,1,0,0}};// line 4
            p(grid);
            x = 0; y = 0;
            p("Size of stain at "+Recursion.makePt(x,y)+" is: " + Recursion.stains(grid, x, y));
        }
        if (run[31] == 1)
        {
            p("------ Recursion 16 - princeToVilan(int[][] m) ------");
            int[][] grid = {
                {2, 0, 1, 2, 3}, // line 0
                {2, 3, 5, 5, 4}, // line 1
                {8, -1, 6, 8, 7}, // line 2
                {3, 4, 7, 2, 4}, // line 3
                {2, 4, 3, 1, 2}, // line 4
                }; // line 5
            p("Matrix: ");
            p(grid);
            p("princeToVilan: "+Recursion.princeToVilan(grid, 0, 0));
            p(grid);
            grid = new int[][] { // no solution
                {12, 0, 1, 2, 3}, // line 0
                {2, 3, 5, 5, 4}, // line 1
                {8, -1, 6, 8, 7}, // line 2
                {3, 4, 7, 2, 4}, // line 3
                {2, 4, 3, 1, 2}, // line 4
                }; // line 5
            p("Matrix: ");
            p(grid);
            p("princeToVilan: "+Recursion.princeToVilan(grid, 0, 0));
            p(grid);
        }
        if (run[30] == 1)//true || 
        {
            p("------ Recursion 15 - countPathsInMatrix(int[][] m) ------");
            int[][] grid = { // no solution
                {12, 22, 23, 54}, // line 0
                {43, 35, 21, 20}, // line 1
                {34, 21, 43, 21}, // line 2
                {25, 30, 0, 20}, // line 3
                {0, 22, 10, 10}, // line 4
                {20, 13, 3, 45}}; // line 5
            p("Matrix: ");
            p(grid);
            p("countPathsInMatrix: "+Recursion.countPathsInMatrix(grid));
        }
        if (run[29] == 1)
        {
            p("------ Recursion 14 - areThereNumbersEqualSumWithRepeatition(int[] a, int sum) ------");
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
            for (int j=0; j<1; j++)
                p("areThereNumbersEqualSumWithRepeatition: "+target[j]+" ["+
                Recursion.areThereNumbersEqualSumWithRepeatition(ar[j], target[j])+
                "]", ar[j]);
        }
        if (run[28] == 1)
        {
            p("------ Recursion 13 - areThereNumbersEqualSum(int[] a, int sum) ------");
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
            for (int j=0; j<1; j++)
                p("areThereNumbersEqualSum: "+target[j]+" ["+
                Recursion.areThereNumbersEqualSum(ar[j], target[j])+
                //Recursion.cover(ar[j], target[j])+
                "]", ar[j]);
        }
        if (run[27] == 1)
        {
            p("------ Recursion 12 - areThere2NumbersEqualSum(int[] a, int sum) ------");
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
            for (int j=0; j<i+1; j++)
                p("areThere2NumbersEqualSum: "+target[j]+" ["+
                Recursion.areThere2NumbersEqualSum(ar[j], target[j])+
                "]", ar[j]);
        }
        if (run[26] == 1)
        {
            p("------ Recursion 11 - selectioSort(int[] n) ------");
            arr  = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
            //arr  = new int[]{101, 12, 5};
            //arr  = new int[]{3,-1};
            //arr  = new int[]{-1};
            //arr  = new int[]{};
            p("Original array: ", arr);
            Sort.selectionSort(arr);
            p("Sorted array: ", arr);
        }
        if (run[25] == 1)
        {
            p("------ Recursion 10 - ladderSoccer(int n, int m) G1:G2 ------");
            int G1 = 2, G2 = 1, test = 3;
            //G1 = 3; G2 = 1; test = 4;
            //G1 = G2 = test = 0;
            //G1 = -1; G2 = 0; test = -1;
            G1 = 2; G2 = 2; test = 6;
            p("Steps to to get to score ["+G1+":"+G2+"] is: "+Recursion.ladderSoccer(G1, G2)+", test="+test);
        }
        if (run[24] == 1)
        {
            p("------ Recursion 9 - Maze מבוך ------");
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
            p("Original maze: ");
            p(grid);
            boolean solution = Recursion.maze(grid);
            if (grid.length == 0)
                p("invalid grid - must be square matrix ");
            else
            {
                if (!solution)
                    p("No solution found!!!");
                else
                    p("Solution maze (the '2' show the path out): ");
            }
            p(grid);
        }
        if (run[23] == 1)
        {
            p("------ radixSort Loop ------");
            arr  = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
            arr  = new int[]{101, 12, 5};
            p("Original array: ", arr);
            Sort.radixSort(arr);
            p("Sorted array: ", arr);
        }
        if (run[22] == 1)
        {
            p("------ quickSort Recursion ------");
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
            p("Original array:", arr);
            Sort.quickSort(arr, false);
            p("Sorted array: ", arr);
        }
        if (run[21] == 1)
        {
            p("------ quickSortLoop ------");
            arr = new int[]{3, 8, 15, 1, 7};
            arr = new int[]{-10,-3,-7,-1,9,8};
            arr = new int[]{45,33,69,97,82,36,73,91,40,88,32};
            //arr = new int[]{45,44,43,42,41,40,39,38,37,36,35};
            arr = new int[]{45,37,44,40,42,36,43,41,40,38,35};
            p("Original array:", arr);
            Sort.quickSortLoop(arr, false);
            p("Sorted array: ", arr);
        }
        if (run[20] == 1)
        {
            p("------ My sort ------");
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
            p("Original array:", arr);
            p("Sorted array: ", Sort.mySort(arr, false));
        }
        if (run[19] == 1)
        {
            p("------ Recursion 8 - ladder(int n) ------");
            int n = 5;
            //n = 6;
            p("steps to climb a ladder of "+n+" steps is: "+Recursion.ladder(n));
        }
        if (run[18] == 1)
        {
            p("------ Recursion 7 - smallestSumIn2Arrays ------");
            int[] a = new int[]{2,6,1,9,7,3,1,4};
            int[] b = new int[]{3,3,-7,-1,3,3,1,-4};
            a = new int[]{3,2,8};
            b = new int[]{2,-1,6};
            p(a);
            p(b);
            p("smallest="+Recursion.smallestSumIn2Arrays(a, b));
        }
        if (run[17] == 1)
        {
            p("------ Efficiency 4 - findSubarray ------");
            arr  = new int[]{2,6,1,9,7,3,1,4,1,2,559};
            //arr = new int[]{3,3,-7,-1,3,3,1,-4};
            int[] result = Efficiency.findSubarraySumTarget(arr, 558);
            p(Arrays.toString(arr)+", target = 7,findSubarray="+Arrays.toString(result));
            //result = Efficiency.findSubarrayAlsoNegative(arr, 100);
            //p(Arrays.toString(arr)+", target = 100,findSubarrayAlsoNegative="+Arrays.toString(result));
        }
        if (run[16] == 1)
        {
            p("------ Efficiency 3 - findLargestAverageDiff ------");
            arr  = new int[]{5,7,-2,10};
            int index = Efficiency.findLargestAverageDiff(arr);
            p(Arrays.toString(arr)+",findLargestAverageDiff="+index);
        }
        if (run[15] == 1)
        {
            p("------ Efficiency 2 - findDuplicateNumInArray ------");
            arr  = new int[]{2,3,1,4,3,5};
            int num = Efficiency.findDuplicateNumInArray(arr);
            p(Arrays.toString(arr)+",findDuplicateNumInArray="+num);
        }
        if (run[14] == 1)
        {
            p("------ Efficiency 1 - SuperIncreasing ------");
            arr  = new int[]{1, 2, 4, 8, 16};
            boolean ok = Efficiency.isSuperIncreasing(arr);
            p(Arrays.toString(arr)+",isSuperIncreasing="+ok);
            if (ok)
                p("superIncreasingRepresentation="+ 
                    Arrays.toString(Efficiency.superIncreasingRepresentation(arr, 32)));//16,20,15,32
            arr = new int[]{1, 2, 3, 8, 16};
            ok = Efficiency.isSuperIncreasing(arr);
            p(Arrays.toString(arr)+",isSuperIncreasing="+ok);
            if (ok)
                p("superIncreasingRepresentation="+ 
                    Efficiency.superIncreasingRepresentation(arr, 16));
        }
        if (run[13] == 1)
        {
            p("------ Recursion 6 - smallest ------");
            arr = new int[]{10, 10, 3, 2};
            arr = new int[]{10, 10, 1, 2, 9};
            p(Arrays.toString(arr) + ",smallest=[" + 
                    arr[Recursion.smallest(arr)]);
                    //Recursion.findSmallestIndex(arr, 0));
                    //Recursion.findSmallestVal(arr, 0));
        }
        // to review for 2nd exam
        if (run[12] == 1)
        {
            p("------ Recursion 5 - findAllarrEqualN ------");
            int n = 5;
            p("n="+n+",numbers=[" + 
                    Recursion.findAllNumsEqualN(n) + "]");
        }
        if (run[11] == 1)
        {
            p("------ Recursion 4 - findNumbersEqualSum ------");
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
                String result = Recursion.findNumbersEqualSumLoop(n, sum, true).substring(1);
                if (result == "") result = " ";
                p("n="+n+",sum="+sum+",numbers=[" + 
                    result.substring(0, result.length() - 1) + "]");
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
            }
        }
        if (run[10] == 1)
        {
            p("------ Recursion 3 - permutation ------");
            //String X = "123";
            p(Recursion.permutation("123"));
        }
        if (run[9] == 1)
        {
            p("------ Recursion 2 - power set ------");
            //int[] X = {1,2,3};
            //p(Recursion.powerSet(X));
            p(Recursion.powerSet("123"));
        }
        // to review for 2nd exam without global var
        if (run[8] == 1)
        {
            p("------ Recursion 1 - interleaving ------");
            p(Recursion.findInterleavings("12", "34").substring(1));
        }
        if (run[7] == 1)
        {
            p("------ LevenshteinDistance ------");
            String[] dict = {"applet","lake","banana","rice","mouse","bottle","apple",
                "ape","applets","appel"};
            //dict = new String[]{"A","b","aP"};//"APPLETS","APPLES"
            int indexWord = LevenshteinDistance.approximatedStringMatching(dict, true);
            p(dict[indexWord]);
        }
        if (run[6] == 1)
        {
            p("------ Conway Game Of Life ------");
            char [][]grid = ConwayGameOfLife.createRandomGrid(10);
            p("Original grid");
            p(grid);
            ConwayGameOfLife.run(grid, 20);
        }
        if (run[5] == 1)
        {
            p("------ Game of Last Match ------");
            // These data need to be accepted from the user
            int[] gameData = {5, 2, 3, 1};
            int numMatches = gameData[0], maxMatches = gameData[1], 
                numGames = gameData[2], startPlayer = gameData[3];
            LastMatch.lastMatch(numMatches, maxMatches, numGames, startPlayer);
        }
        if (run[4] == 1)
        {
            p("------ array of lights ------");
            boolean[] arr1 = {false, true, false, false, true};
            boolean[] arr2 = {false, false, true, false, false};
            p("" + Disco.disco(arr1, arr2, 0));
        }
        if (run[3] == 1)
        {
            Library.MyPoint pt = new Library.MyPoint(1,2);
            System.out.println(pt);
        }
        if (run[2] == 1)
        {
            p("\n------Recursion 0 - factorial ------");
            arr  = new int[]{-2, 0, 1, 2, 3, 5, 6};
            arr = new int[]{4};
            for (int n: arr)    
                p("factorial of = " + n + " is: " + Recursion.factorial(n));
        }
        if (run[1] == 1)
        {
            p("\n------ how many ------");
            // checking number of times a subsring appears in a string
            // not using String methods to do it
            // Page 8 in file Exercises
            String string = "bccaaaab?yabcabb*caabcca";
            String[] subStringArray = {"x", "a", "ab", "abc", "abcc"};
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
                            if (p) System.out.println("100: "+i+", "+a+","+j+", "+b+","+count);
                            a = string.charAt(i++);
                            j = 0;
                            inside = true;
                        }
                        if (p) System.out.println("200: "+len+","+i+", "+a+","+j+", "+b+","+count);
                        if (inside)
                        {
                            i--;
                            continue;
                        }
                        if (p) System.out.println("300: "+len+","+i+", "+a+","+j+", "+b+","+count);
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
                if (count > 0 ) count++;    // added 19/02/2025 without checking why count was 1 less than correct
                    // did not work for "abcc" which occurs 1 time but returns 0
                System.out.println("In [" + string + "] the sub string ["+ subString +
                "]\toccurs " + count + " times");
            }
        }
        if (run[0] == 1)
        {
            p("\n------ longest arrow ------");
            p = false;
            // Page 8 in file Exercises
            // in a series of integers, an arrow is a subSeries with increasing numbers
            // and we need to fins the longest arrow
            // we do it for few possibles arrays which we put in a master array[]
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
                        len = 1;    // a new sequence starts here, its length is 1
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
                        if (p) p(2000, a, b);
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