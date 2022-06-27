package semester2.homework.hw04;
/* SELF ASSESSMENT
Connect4Game class (35 marks):35
My class creates references to the Connect 4 Grid and two Connect 4 Players.
It asks the user whether he/she would like to play/quit inside a loop.
If the user decides to play then:
1. Connect4Grid2DArray is created using the Connect4Grid interface,
2. the two players are initialised - must specify the type to be ConnectPlayer,
3. the game starts. In the game, I ask the user where he/she would like to drop the piece.
I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win.
Comment:Yes, the program works well for me. The player can quit the program whenever he want and the program performs
messages when someone won the game. The program created a interface as asked and the two player are specified by the connect player

Connect4Grid interface (10 marks):10
I define all 7 methods within this interface.
Comment:Yes, I defined all 7 methods just under the main program with this interface

Connect4Grid2DArray class (25 marks):25
My class implements the Connect4Grid interface.
It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid.
It provides as implementation of the method to check whether the column to drop the piece is full.
It provides as implementation of the method to drop the piece.
It provides as implementation of the method to check whether there is a win.
Comment:Yes, I created a 2D array to check whether the column what the user wants to drop is full or not and check whether
the input number is in the range of the maximum column number. After dropping every single one piece, the program will check
all the pieces in order to determine whether there is a result or not

ConnectPlayer abstract class (10 marks):10
My class provides at lest one non-abstract method and at least one abstract method.
Comment:Yes my program have one abstract method using ConnectPlayer and a couple of non-abstract method

C4HumanPlayer class (10 marks):10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment:Yes, I used inheritance in this program several times and overides both the abstract methods and non-methods

C4RandomAIPlayer class (10 marks):10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality.
Comment:Yes, I used inheritance in this program several times and overides both the abstract methods and non-methods

Total Marks out of 100:100

*/
import java.util.Scanner;

public class Connect4Games {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        C4HumanPlayer humanPlayer = new C4HumanPlayer(1);
        C4RandomAIPlayer computerPlayer = new C4RandomAIPlayer(2);
        Connect4Grid mainGame = new Connect4Grid2DArray(humanPlayer, computerPlayer);
        System.out.println("Welcome to Connect 4 Discs System");

        boolean gameover = false;
        boolean boardFull = false;
        while (!gameover) {
            System.out.print("Please enter an integer as the column that you want to put the disc in(or enter quit): ");
            try {
                String input = scanner.nextLine();
                if (!input.equals("quit"))
                {
                    int column0 = Integer.parseInt(input);
                    int column = column0 - 1;
                    if (!mainGame.isValidColumn(column)) throw new Exception();
                    if (!mainGame.isColumnFull(column))
                    {
                        mainGame.dropPiece(humanPlayer, column);
                        System.out.println(mainGame.toString());
                        if (mainGame.didLastPieceConnect4())
                            {
                                System.out.println("Congratulations you won the connect 4 games!");
                                System.out.println("PROGRAM TERMINATED.");
                                mainGame.emptyGrid();
                                gameover = true;
                            }
                        else
                            {
                            int temp = computerPlayer.getNextStep((Connect4Grid2DArray) mainGame);
                            mainGame.dropPiece(computerPlayer, temp);
                            System.out.println("Computer Player's move:");
                            System.out.println(mainGame.toString());
                                if (mainGame.didLastPieceConnect4()) {
                                    System.out.println("The computer player won the game!");
                                    System.out.println("PROGRAM TERMINATED.");
                                    mainGame.emptyGrid();
                                    gameover = true;
                                }
                                else if (mainGame.isGridFull()) {
                                    boardFull = true;
                                    gameover = true;
                                    System.out.println("PROGRAM TERMINATED.");
                            }
                        }
                    }
                    else {
                        System.out.println("The column you chose is full now, please try another one");
                    }
                }
                else {
                    gameover = true;
                    System.out.println("PROGRAM TERMINATED.");
                }
                if(boardFull){
                    System.out.println("Game drawn! Both you and the computer player did not win!");
                }
            } catch (Exception e) {
                System.out.println("Invalid number!! Please try again");
            }
        }
        scanner.close();
    }
}

interface Connect4Grid {
    public void emptyGrid();
    public String toString();
    public boolean isValidColumn(int column);
    public boolean isColumnFull(int column);
    public void dropPiece(ConnectPlayer player, int column);
    public boolean didLastPieceConnect4();
    public boolean isGridFull();
}
