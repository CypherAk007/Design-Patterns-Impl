package tictactoe_redo1.controllers;


import tictactoe_redo1.exceptions.DuplicateSymbolException;
import tictactoe_redo1.exceptions.MoreThanOneBotException;
import tictactoe_redo1.exceptions.PlayersAndDimensionsMismatchException;
import tictactoe_redo1.models.Game;
import tictactoe_redo1.models.GameState;
import tictactoe_redo1.models.Move;
import tictactoe_redo1.models.Player;
import tictactoe_redo1.strategies.winningStrategy.WinningStrategy;

import java.util.List;
import java.util.Optional;

public class GameController {


    public Game startGame(int sizeOfBoard, List<Player> players, List<WinningStrategy> winningStrategies) throws PlayersAndDimensionsMismatchException, DuplicateSymbolException, MoreThanOneBotException {

        return Game.builder()
                .setSizeOfBoard(sizeOfBoard)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                //Additional INFO
                // Setting Multivalued Attributes - Not req for this proj
                // instead of above winningStrategies we can add it manually by iterating the list
//                .addWinningStrategies(winningStrategies.get(0))
//                .addWinningStrategies(winningStrategies.get(1))
                .build();

    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void displayBoard(Game game){
        game.display();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public Optional<Move> undo(Game game) {
        return game.undo();
    }
}
