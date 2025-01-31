package תרגילים_נוספים;

import static Library.Print.p;
import static Library.MyLibrary.*;

import java.util.Random;
import java.util.Arrays;
//import java.util.*;
/**
 * Write a description of class ConwayGameOfLife here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ConwayGameOfLife
{
    private static final char OCCUPIED = '*', EMPTY = ' ';
    public static char[][] createRandomGrid(int size)
    {
        Random random = new Random();
        char[][] grid = new char[size][size];
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                grid[i][j] = (random.nextBoolean() ? OCCUPIED : EMPTY);
            }
        }
        return grid;
    }
    public static void run(char[][] grid, int runs)
    {
        char[][] newGrid;
        char[][] originalGrid = deepCopy(grid);
        int maxRuns = runs;
        while (runs-- > 0)
        {
            newGrid = newGeneration(grid);
            p("-------new Grid " + (maxRuns - runs) + "----------");
            p(newGrid);
            if (Arrays.deepEquals(grid, newGrid))
            {
                p("identical");
                break;
            }
            if (Arrays.deepEquals(originalGrid, newGrid))
            {
                p("Oscillator = same as original");
                break;
            }
            grid = newGrid;
        }
        if (runs < 1) p("exhausted runs");
    }
    private static char[][] deepCopy(char[][] original)
    {
                // Deep copy using manual copying
        char[][] deepCopy = new char[original.length][];
        for (int i = 0; i < original.length; i++)
            deepCopy[i] = original[i].clone(); // Copy each row
        return deepCopy;
    }
    private static char[][] newGeneration(char[][] grid)
    {
        int count;
        char[][] newGrid = deepCopy(grid);
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                count = countliveNeighbour(grid, i, j);
                if (grid[i][j] == OCCUPIED && (count < 2 || count > 3)) newGrid[i][j] = EMPTY;
                else if (grid[i][j] != OCCUPIED && count == 3) newGrid[i][j] = OCCUPIED;
            }
        }
        return newGrid;
    }
    /*
    private static int countliveNeighbour(char[][] grid, int i, int j)
    {
        int count = 0;
        for (int k = 0; k < 8; k++)
        {
            switch (k)
            {
                case 0: count += (i > 0 && j > 0 && grid[i-1][j-1] == OCCUPIED?1:0); break;
                case 1: count += (i > 0 && grid[i-1][j] == OCCUPIED?1:0); break;
                case 2: count += (i > 0 && j < grid.length-1 && grid[i-1][j+1] == OCCUPIED?1:0); break;
                case 3: count += (j > 0 && grid[i][j-1] == OCCUPIED?1:0); break;
                case 4: count += (j < grid.length-1 && grid[i][j+1] == OCCUPIED?1:0); break;
                case 5: count += (i < grid.length-1 && j > 0 && grid[i+1][j-1] == OCCUPIED?1:0); break;
                case 6: count += (i < grid.length-1 && grid[i+1][j] == OCCUPIED?1:0); break;
                case 7: count += (i < grid.length-1 && j < grid.length-1 && grid[i+1][j+1] == OCCUPIED?1:0); break;
            }
            //Print.p(i, j, k, count);
        }
        return count;
    }
    */
    private static int countliveNeighbour(char[][] grid, int row, int col)
    {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++)
        {
            if (i < 0 || i >= grid.length) continue;
            for (int j = col - 1; j <= col + 1; j++)
            {
                if (j < 0 || j >= grid[0].length) continue;
                if (i == row && j == col) continue;
                if (grid[i][j] == OCCUPIED)
                    count++;
            }
        }
        return count;
    }
}
