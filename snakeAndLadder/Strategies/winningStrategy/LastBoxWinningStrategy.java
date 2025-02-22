package snakeAndLadder.Strategies.winningStrategy;

import snakeAndLadder.models.Board;
import snakeAndLadder.models.Move;

public class LastBoxWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        if(lastMove.getCell().getCellNo()==board.getSizeOfBoard()* board.getSizeOfBoard()){
            return true;
        }
        return false;
    }
}
