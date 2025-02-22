package snakeAndLadder.Strategies.winningStrategy;

import snakeAndLadder.models.Board;
import snakeAndLadder.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move lastMove);
}
