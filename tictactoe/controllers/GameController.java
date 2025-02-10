package tictactoe.controllers;

import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.MoreThanOneBotException;
import tictactoe.exceptions.PlayersAndDimensionsMismatchException;
import tictactoe.models.Game;
import tictactoe.models.GameState;
import tictactoe.models.Player;
import tictactoe.strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int sizeOfBoard, List<Player> players, List<WinningStrategy> winningStrategies) throws PlayersAndDimensionsMismatchException, DuplicateSymbolException, MoreThanOneBotException {
        return Game.builder()
                .setSizeOfBoard(sizeOfBoard)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                // instead of above winningStrategies we can add it manually by iterating the list
//                .addWinningStrategies(winningStrategies.get(0))
//                .addWinningStrategies(winningStrategies.get(1))
                .build();
    }
    public GameState getGameState(Game game){
        return game.getState();
    }
    public void displayBoard(Game game){
        game.display();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}
