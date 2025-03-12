package chess.strategies.winningStrategy;

import chess.models.Board;
import chess.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move lastMove);
}
