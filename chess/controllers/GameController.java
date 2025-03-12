package chess.controllers;

import chess.models.Game;
import chess.models.GameState;
import chess.models.Player;
import chess.strategies.specialCases.SpecialCaseStrategy;
import chess.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(List<Player> players, List<WinningStrategy> winningStrategies, List<SpecialCaseStrategy> specialCaseStrategies){

    }

    public GameState getGameState(Game game){

    }

    public void makeMove(Game game){

    }

    public void displayBoard(Game game){

    }

    public Player getWinner(Game game){

    }
}
