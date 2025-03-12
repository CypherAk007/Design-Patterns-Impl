package chess.strategies.winningStrategy;

import chess.models.Board;
import chess.models.Move;

public class ThreeCheckMateStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        if(lastMove.getPlayer().getCheckMateCounter()>=3){
            return true;
        }
        return false;
    }
}
