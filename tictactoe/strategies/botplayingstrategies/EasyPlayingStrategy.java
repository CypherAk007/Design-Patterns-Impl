package tictactoe.strategies.botplayingstrategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Move;

import java.util.List;

public class EasyPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board) {
//        First empty cell make the move
        for(List<Cell> row: board.getBoard()){
            for(Cell cell: row){
                if(cell.getCellState()== CellState.EMPTY){
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
