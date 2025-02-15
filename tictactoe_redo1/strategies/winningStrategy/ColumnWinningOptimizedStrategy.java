package tictactoe_redo1.strategies.winningStrategy;

import tictactoe_redo1.models.Board;
import tictactoe_redo1.models.Move;
import tictactoe_redo1.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningOptimizedStrategy implements WinningStrategy {

    private Map<Integer,Map<Symbol,Integer>> countOfSymbols;
    public ColumnWinningOptimizedStrategy(){
        this.countOfSymbols = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int col = lastMove.getCell().getCol();
        Symbol symbol = lastMove.getPlayer().getSymbol();
        if(!countOfSymbols.containsKey(col)){
            countOfSymbols.put(col,new HashMap<>());
        }

        Map<Symbol,Integer> symbolCounts = countOfSymbols.get(col);

        if(!symbolCounts.containsKey(symbol)){
            symbolCounts.put(symbol,0);
        }

        symbolCounts.put(symbol,symbolCounts.get(symbol)+1);

        if(symbolCounts.get(symbol)==board.getSize()){
            return true;
        }

        return false;
    }
}
