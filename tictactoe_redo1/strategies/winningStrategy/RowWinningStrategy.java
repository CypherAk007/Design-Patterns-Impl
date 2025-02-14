package tictactoe_redo1.strategies.winningStrategy;

import tictactoe_redo1.models.Board;
import tictactoe_redo1.models.Cell;
import tictactoe_redo1.models.CellStatus;
import tictactoe_redo1.models.Move;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        int count = 0;
        for(int j=0;j<board.getSize();j++){
            Cell cell = board.getGrid().get(row).get(j);
            if(cell.getCellState().equals(CellStatus.EMPTY)){
                continue;
            }

            if(cell.getPlayer().equals(lastMove.getPlayer())){
                count++;
            }
        }
        return count==board.getSize();
    }
}
