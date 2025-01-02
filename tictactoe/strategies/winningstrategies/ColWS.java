package tictactoe.strategies.winningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Move;

public class ColWS implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int col = lastMove.getCell().getCol();
        int count=0;
        for(int i=0;i<board.getSize();i++){
            Cell cell = board.getBoard().get(i).get(col);
            if(cell.getCellState()== CellState.EMPTY){
                continue;
            }
            if(cell.getPlayer().equals(lastMove.getPlayer())){
                count++;
            }
        }
        return count==board.getSize();
    }
}
