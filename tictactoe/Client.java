package tictactoe;

import tictactoe.controllers.GameController;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.MoreThanOneBotException;
import tictactoe.exceptions.PlayersAndDimensionsMismatchException;
import tictactoe.models.*;
import tictactoe.strategies.winningstrategies.ColWS;
import tictactoe.strategies.winningstrategies.RowWS;
import tictactoe.strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class Client {
    public static void main(String[] args) throws PlayersAndDimensionsMismatchException, DuplicateSymbolException, MoreThanOneBotException {
        GameController gameController = new GameController();

//        FROM THE CLIENT GET:
//        Board size
        int sizeOfBoard = 3;

//        get players info,
        List<Player> players = List.of(
                new Player(1L,"Ak",new Symbol('x'), PlayerType.HUMAN),
                new Bot(2L,"GPT",new Symbol('O'),BotDifficultyLevel.EASY)
        );
//        get winningStrategies info,
        List<WinningStrategy> winningStrategies = List.of(
                new RowWS(),
                new ColWS()
        );

        Game game = gameController.startGame(sizeOfBoard,players,winningStrategies);


        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }

        if(gameController.getGameState(game).equals(GameState.DRAW)){
            System.out.println("Game has been drawn!!");
        }else{
            System.out.println("The winner is:- "+gameController.getWinner(game));
        }
    }
}


// Tic-Tac-Toe

// create the players
// start a game
// make a move

/*

        Welcome to the Tic-Tac-Toe Game !

// game details



 X | O | X
-----------
   |   |
-----------
 O |   |


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
