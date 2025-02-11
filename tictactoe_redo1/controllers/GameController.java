package tictactoe_redo1.controllers;


import tictactoe_redo1.models.Game;
import tictactoe_redo1.models.GameState;
import tictactoe_redo1.models.Player;
import tictactoe_redo1.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {


    public Game startGame(int sizeOfBoard, List<Player> players, List<WinningStrategy> winningStrategies){

        return null;

    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void makeMove(Game game){

    }

    public void displayBoard(Game game){

    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}
