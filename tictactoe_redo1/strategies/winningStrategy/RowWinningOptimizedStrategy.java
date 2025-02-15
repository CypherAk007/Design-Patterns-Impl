package tictactoe_redo1.strategies.winningStrategy;

import tictactoe_redo1.models.Board;
import tictactoe_redo1.models.Move;
import tictactoe_redo1.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningOptimizedStrategy  implements WinningStrategy {

    private Map<Integer, Map<Symbol,Integer>> countOfSymbols;
    public RowWinningOptimizedStrategy(){
        this.countOfSymbols = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        Symbol symbol = lastMove.getPlayer().getSymbol();
        if(!countOfSymbols.containsKey(row)){
            countOfSymbols.put(row,new HashMap<>());
        }

        Map<Symbol,Integer> symbolCounts = countOfSymbols.get(row);

        if(!symbolCounts.containsKey(symbol)){
            symbolCounts.put(symbol,0);
        }

        symbolCounts.put(symbol,symbolCounts.get(symbol)+1);

        if(symbolCounts.get(symbol)==board.getSize()){
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move undoMove) {
        int row = undoMove.getCell().getRow();
        Symbol symbol = undoMove.getPlayer().getSymbol();

        Map<Symbol,Integer> symbolCounts = countOfSymbols.get(row);

        symbolCounts.put(symbol,symbolCounts.get(symbol)-1);
//        System.out.println(countOfSymbols);

    }
}
