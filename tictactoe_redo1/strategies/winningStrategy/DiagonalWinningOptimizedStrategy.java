package tictactoe_redo1.strategies.winningStrategy;

import tictactoe_redo1.models.Board;
import tictactoe_redo1.models.Move;
import tictactoe_redo1.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningOptimizedStrategy implements WinningStrategy{

    private  Map<Symbol,Integer> leftDiagonalSymbolCounts;
    private  Map<Symbol,Integer> rightDiagonalSymbolCounts;
    public DiagonalWinningOptimizedStrategy(){
        this.leftDiagonalSymbolCounts = new HashMap<>();
        this.rightDiagonalSymbolCounts = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        Symbol symbol = lastMove.getCell().getPlayer().getSymbol();
        //left diagonal
        if(row==col){
            leftDiagonalSymbolCounts.put(symbol,leftDiagonalSymbolCounts.getOrDefault(symbol,0)+1);
            if(leftDiagonalSymbolCounts.get(symbol)==board.getSize()){
                return true;
            }
        }
        if(row+col==board.getSize()-1) {
            rightDiagonalSymbolCounts.put(symbol, rightDiagonalSymbolCounts.getOrDefault(symbol, 0) + 1);
            if (rightDiagonalSymbolCounts.get(symbol) == board.getSize()) {
                return true;
            }
        }
        return false;
    }
}
