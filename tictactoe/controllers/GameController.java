package tictactoe.controllers;

import tictactoe.models.Game;
import tictactoe.models.GameState;
import tictactoe.models.Player;
import tictactoe.strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int sizeOfBoard, List<Player> players, List<WinningStrategy> winningStrategies){
        return null;
    }
    public GameState getGameState(Game game){
        return game.getState();
    }
    public void displayBoard(Game game){

    }

    public void makeMove(Game game){

    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}
