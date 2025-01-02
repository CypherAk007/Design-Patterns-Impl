package tictactoe.strategies.winningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move lastMove);
}
