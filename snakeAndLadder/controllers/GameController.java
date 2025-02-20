package snakeAndLadder.controllers;

import snakeAndLadder.Exceptions.DuplicateSymbolException;
import snakeAndLadder.Exceptions.MoreThanOneBotException;
import snakeAndLadder.Exceptions.ObstacleOutOfBoundsException;
import snakeAndLadder.Exceptions.PlayersAndDimensionsMismatchException;
import snakeAndLadder.Strategies.WinningStrategy;
import snakeAndLadder.models.Game;
import snakeAndLadder.models.GameState;
import snakeAndLadder.models.Obstacles;
import snakeAndLadder.models.Player;

import java.util.List;

public class GameController {

    public Game startGame(int sizeOfBoard, List<Player> players, List<WinningStrategy> winningStrategies, List<Obstacles> snakeLocations, List<Obstacles> ladderLocations) throws PlayersAndDimensionsMismatchException, DuplicateSymbolException, ObstacleOutOfBoundsException, MoreThanOneBotException {
        return Game.builder()
                .setSize(sizeOfBoard)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .setLadderLocations(ladderLocations)
                .setSnakeLocations(snakeLocations)
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


}
