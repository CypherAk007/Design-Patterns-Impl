package chess.controllers;

import chess.exceptions.*;
import chess.models.Game;
import chess.models.GameState;
import chess.models.Player;
import chess.strategies.specialCases.SpecialCaseStrategy;
import chess.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(List<Player> players, List<WinningStrategy> winningStrategies, List<SpecialCaseStrategy> specialCaseStrategies) throws DuplicateSymbolException, PlayersMismatchException, DuplicateChessColorPieceException, MoreThanOneBotException {
        return Game.builder()
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .setSpecialCaseStrategies(specialCaseStrategies)
                .build();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void makeMove(Game game) throws OutOfBoundsException {
        game.makeMove();
    }

    public void displayBoard(Game game){
        game.display();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}
