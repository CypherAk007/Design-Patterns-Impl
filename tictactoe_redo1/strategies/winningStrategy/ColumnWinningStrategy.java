package tictactoe_redo1.strategies.winningStrategy;

import tictactoe_redo1.models.Board;
import tictactoe_redo1.models.Cell;
import tictactoe_redo1.models.CellStatus;
import tictactoe_redo1.models.Move;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int col = lastMove.getCell().getCol();
        int count = 0;
        for(int i=0;i<board.getSize();i++){
            Cell cell = board.getGrid().get(i).get(col);
            if(cell.getCellState()== CellStatus.EMPTY){
                continue;
            }

            if(cell.getPlayer().equals(lastMove.getPlayer())){
                count++;
            }
        }
        return count==board.getSize();
    }

    @Override
    public void handleUndo(Board board, Move undoMove) {

    }
}
