package tictactoe_redo1;


import tictactoe_redo1.exceptions.DuplicateSymbolException;
import tictactoe_redo1.exceptions.MoreThanOneBotException;
import tictactoe_redo1.exceptions.PlayersAndDimensionsMismatchException;
import tictactoe_redo1.models.*;
import tictactoe_redo1.controllers.GameController;
import tictactoe_redo1.strategies.winningStrategy.*;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws PlayersAndDimensionsMismatchException, DuplicateSymbolException, MoreThanOneBotException {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

//        FROM THE CLIENT GET:
//        Board size
        int sizeOfBoard = 3;

//        get players info,
        List<Player> players = List.of(
                new Player(1L,"Ak",new Symbol('x'), PlayerType.HUMAN),
                new Bot(2L,"GPT",new Symbol('O'), BotDifficultyLevel.EASY)
        );
//        get winningStrategies info,
        List<WinningStrategy> winningStrategies = List.of(
            new ColumnWinningOptimizedStrategy(),
                new RowWinningOptimizedStrategy(),
                new DiagonalWinningOptimizedStrategy()
        );

        Game game = gameController.startGame(sizeOfBoard,players,winningStrategies);


        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);

            System.out.println("Do you want to Undo? (y/n)");
            String undoAnswer = scanner.next();
            if(undoAnswer.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue;
            }

            gameController.makeMove(game);
        }

        gameController.displayBoard(game);

        if(gameController.getGameState(game).equals(GameState.DRAW)){
            System.out.println("Game has been drawn!!");
        }else{
            System.out.println("The winner is:- "+gameController.getWinner(game));
        }
    }
}


// Tic-Tac-Toe - Journey via Command Line

// create the players
// start a game
// make a move

/*

        Welcome to the Tic-Tac-Toe Game !

// game details
// Take inputs from the players



 X | O | X
-----------
   |   |
-----------
 O |   |
//display the board so that next player can continue

// X's turn
// take inputs from the players

// continue for the next player


 X | O | X
-----------
   |   |
-----------
   |   | X


// O's turn
// take inputs from the players


Game will end once we have winner or draw !

*/
