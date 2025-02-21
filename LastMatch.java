package תרגילים_נוספים;

import static Library.Print.p;
import static Library.MyLibrary.*;
import java.util.Scanner;

/**
 * The LastMatch manages a series of games between 2 players where in each game
 * there is a given number of matches on the table and maxMatches is the maximum
 * number of matches a player can pick from the table, minimum one, as the turn
 * alternate between them.
 * The winner is the one that picked the last match/matches from the table
 * numRounds = maximum numbers of rounds allowed to play
 *
 * @author (Zvi Barak)
 * @version (a version number or a date)
 */
public class LastMatch
{
    public static void lastMatch(int numMatches, int maxMatches, int numRounds, int startPlayer)
    {
        Scanner scan = new Scanner(System.in);
        while (numRounds-- > 0)
        {
            int player = startPlayer;
            int matchesLeft = numMatches; 
            showTable(numMatches, player, maxMatches);
            int numMatchesToRemove;
            boolean validNum = true;
            do
            {
                System.out.println("Player " + player + 
                        ", please enter number of matches to remove: ");
                numMatchesToRemove = scan.nextInt();
                validNum = !(numMatchesToRemove < 1 || 
                    numMatchesToRemove > Math.min(matchesLeft, maxMatches));
                if (!validNum) System.out.println("Wrong input. Please try again");
                matchesLeft--;
            } 
            while (!validNum);
        }
    }
    private static void showTable(int numMatches, int player, int maxMatches)   // // display table with matches
    {
        System.out.print("Player " + player + " turn, *");
        for (int i = 0; i < numMatches; i++)
            System.out.print("|");
        System.out.println("*, The maximum number of matches to remove is " + Math.min(numMatches, maxMatches));
    }
}
