package tictactoe.strategies.winningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

public class DiagonalWS implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        return false;
    }
}
