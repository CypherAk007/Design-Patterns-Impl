package tictactoe_redo1.strategies.botPlayingStrategy;

import tictactoe_redo1.models.Board;
import tictactoe_redo1.models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
