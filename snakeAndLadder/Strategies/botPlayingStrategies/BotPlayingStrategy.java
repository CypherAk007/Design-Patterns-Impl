package snakeAndLadder.Strategies.botPlayingStrategies;

import snakeAndLadder.models.Board;
import snakeAndLadder.models.Move;
import snakeAndLadder.models.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
