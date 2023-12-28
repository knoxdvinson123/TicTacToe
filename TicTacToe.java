package tictactoe;
import java.util.*;
// -------------------------------------------------------------------------
/**
 *  Creating 3x3 TicTacToe to play in command window
 * 
 *  @author knoxd
 *  @version Dec 26, 2023
 */
public class TicTacToe
{
    //fields
    static String[] moves;
    static String player; // stores which player plays next


    // ----------------------------------------------------------
    /**
     * This main method runs 3X3 TicTacToe in the command window
     * @param args
     */
    public static void main(String[] args)
    {
        //instantiate fields
        String winner = null; //stores who the winner is
        player = "O";
        
        moves = new String[10]; 
        //Discard 0, 1-9 are positions on the board (for readability)
        
        for (int i = 0; i < 10; i++)
        {
            moves[i] = String.valueOf(i); //populate moves with values 0-9
        }
        
        Scanner reader = new Scanner(System.in);  // Reading from System.in
                
        System.out.println("Hello, this is tic tac toe...");
        printOutBoard();
        System.out.println("O will play first...");
        
        while (winner == null)
        {
            System.out.println(player + "'s turn:");
            System.out.println(
                "Enter a number 1-9 correlating "
                + "to where you want to make your move: ");
            
            int input = reader.nextInt(); 
            // Scans the next token of the input as an int.
            //check to see if it is valid input
            if ((input > 0) && (input < 10))
            {
                if (moves[input].equals(String.valueOf(input)))
                {
                    moves[input] = player;
                    player = switchPlayer(player);
                    printOutBoard();
                    winner = checkForWinner();
                }
                else 
                {
                    System.out.println("Oops slot already taken...try again");
                }
            }
            else 
            {
                    System.out.println("Oops invalid input! try again...");
            }
        }      
        System.out.println(winner + " won! Congratulations!");
        reader.close();
    }
    
    
    // ----------------------------------------------------------
    /**
     * This helper method alternates the players after each move
     * @param players
     * @return String of what player is next
     */
    static String switchPlayer(String players)
    {
        if (players.equals("O")) //switches player up next
        {
            return "X";
        }
            return "O";
    }
    
    
    // ----------------------------------------------------------
    /**
     * Prints out the board, the contents of each square is stored within an 
     * array called 'moves' that is manipulated in main
     */
    static void printOutBoard()
    {
        System.out.println(" ");
        System.out.println(
            " " + moves[1] + " | " + moves[2] + " | " + moves[3] + " ");
        System.out.println(
            "---|---|---");
        System.out.println(
            " " + moves[4] + " | " + moves[5] + " | " + moves[6] + " ");
        System.out.println(
            "---|---|---");
        System.out.println(
            " " + moves[7] + " | " + moves[8] + " | " + moves[9] + " ");
        System.out.println(" ");
        }

    // ----------------------------------------------------------
    /**
     * This method gets called after each move to determine 
     * if it was a winning move
     * @return X, O, draw, or null
     */
    static String checkForWinner()
    {
        String line = null;
        
        for (int i = 0; i < 8; i++)
        {
            switch(i) {
                case 0: //check rows
                    line = moves[1] + moves[2] + moves[3];
                    break;  
                case 1: 
                    line = moves[4] + moves[5] + moves[6];
                    break;  
                case 2: 
                    line = moves[7] + moves[8] + moves[9];
                    break;  
                case 3: //check vertical
                    line = moves[1] + moves[4] + moves[7];
                    break;  
                case 4: 
                    line = moves[2] + moves[5] + moves[8];
                    break;  
                case 5: 
                    line = moves[3] + moves[6] + moves[9];
                    break;  
                case 6: //check horizontal
                    line = moves[1] + moves[5] + moves[9];
                    break;  
                case 7: 
                    line = moves[7] + moves[5] + moves[3];
                    break;  
            }
                
                if (line.equals("XXX"))
                {
                    return "X";
                }
                else if (line.equals("OOO"))
                {
                    return "O";
                }              
            }

        //check for draw
        List<String> movesList = Arrays.asList(moves);
        for (int j = 1; j < 10; j++)
        {
            if (movesList.contains(String.valueOf(j)))
            {
                break;
            }
            else if (j == 9)
            {
                return "draw";
            }
        }
        return null;
    }
        
}
