package tictactoe_redo1.strategies.winningStrategy;

import tictactoe_redo1.models.*;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        return mainDiagonalCheck(board,lastMove) || crossDiagonalCheck(board,lastMove);
    }
    public boolean mainDiagonalCheck(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        int n = board.getSize();

        int i= 0;
        int j = 0;
        int count = 0;
        while(i<n && j<n){
            Cell cell = board.getGrid().get(i).get(j);
            if(!cell.getCellState().equals(CellStatus.EMPTY)) {

                if(cell.getPlayer().equals(lastMove.getPlayer())){
                    count++;
                }
            }
            i++;
            j++;
        }
        return count==board.getSize();
    }
    public boolean crossDiagonalCheck(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        int n = board.getSize();

        int i= 0;
        int j = n-1;
        int count = 0;
        while(i<n && j>=0){
            Cell cell = board.getGrid().get(i).get(j);
            if(!cell.getCellState().equals(CellStatus.EMPTY)) {

                if(cell.getPlayer().equals(lastMove.getPlayer())){
                    count++;
                }
            }
            i++;
            j--;
        }
        return count==board.getSize();
    }
}