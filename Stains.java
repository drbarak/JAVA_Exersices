import java.util.Arrays;
public class Stains
{
    public static void main()
    {
        char[][] mat = {
                {' ','x',' ',' ',' ',' ',' ','x'}, // line 0
                {'x',' ',' ',' ',' ',' ','x','x'}, // line 1
                {' ',' ',' ',' ',' ','x','x',' '}, // line 2
                {' ','x','x',' ',' ',' ',' ',' '}, // line 3
                {' ',' ',' ','x',' ',' ',' ',' '}, // line 4
                {' ',' ',' ',' ','x','x',' ',' '}, // line 5
                {'x',' ',' ',' ',' ',' ','x',' '}, // line 6
                {'x','x','x',' ',' ',' ','x',' '}};  // line 7
        print(mat);
        System.out.println("Size of stain is: " + stains(mat));
        mat = new char[][]{
                {' ','x',' ',' ','x'}, // line 0
                {'x',' ',' ','x','x'}, // line 1
                {' ',' ','x','x',' '}, // line 2
                {'x',' ',' ',' ',' '}, // line 3
                {'x','x','x','x',' '}};// line 4
        print(mat);
        System.out.println("Size of stain is: " + stains(mat));
        mat = new char[][]{
                {' ','x',' ',' ','x'}, // line 0
                {'x',' ',' ',' ','x'}, // line 1
                {' ',' ','x',' ',' '}, // line 2
                {'x',' ',' ',' ','x'}, // line 3
                {'x','x','x',' ',' '}};// line 4
        print(mat);
        System.out.println("Size of stain is: " + stains(mat));
    }
    private static int stains(char[][] mat)
    {
        boolean[][] history = new boolean[mat.length][mat[0].length];// assuming rectangulr mat
        int row = 4, col = 3;
        int stains = stains(mat, row, col, history);
        print(history);
        return stains;
    }
    private static int stains(char[][] mat, int row, int col, boolean [][] history)
    {
        if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length ||
                mat[row][col] == ' ' || history[row][col]) return 0;// verify cell in boundries
        history[row][col] = true;
        return 1 +
            stains(mat, row, col-1, history)+
                stains(mat, row+1, col, history)+
                stains(mat, row, col+1, history)+
                stains(mat, row-1, col, history)+
            stains(mat, row-1, col-1, history)+
                stains(mat, row+1, col+1, history)+
                stains(mat, row+1, col-1, history)+
                stains(mat, row-1, col+1, history);
    }
    private static void print(char[][] arr)
    {
        // not using Arrays.deepToString(arr)) because print all lines in one row
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    }
    private static void print(boolean[][] arr)
    {
        // not using Arrays.deepToString(arr)) because print all lines in one row
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    }
}
