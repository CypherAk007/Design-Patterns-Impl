package tictactoe_redo1.strategies.botPlayingStrategy;

import tictactoe_redo1.models.Board;
import tictactoe_redo1.models.Cell;
import tictactoe_redo1.models.CellStatus;
import tictactoe_redo1.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row: board.getGrid()){
            for(Cell cell: row){
                if(cell.getCellState()== CellStatus.EMPTY){
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
