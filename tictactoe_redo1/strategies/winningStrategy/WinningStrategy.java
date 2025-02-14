package tictactoe_redo1.strategies.winningStrategy;

import tictactoe_redo1.models.Board;
import tictactoe_redo1.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move lastMove);
}
