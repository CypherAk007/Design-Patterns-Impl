package snakeAndLadder.Strategies.botPlayingStrategies;

import snakeAndLadder.models.Board;
import snakeAndLadder.models.Cell;
import snakeAndLadder.models.Move;
import snakeAndLadder.models.Player;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board,Player player) {
        int diceValue = rollTheDice();
        System.out.println(String.format("%s's Rolled Dice Value is : %d",player.getName(),diceValue));

        int[] rowColOfCell = board.findRowAndColGivenCellNumber(player.getCell().getCellNo()+diceValue);
        int row = rowColOfCell[0];
        int col = rowColOfCell[1];

        Move move = new Move(null,new Cell(row,col,board.getSizeOfBoard()));
        return move;
    }

    public int rollTheDice(){
        int randomNumber = (int) (Math.random() *6)+1;//(0 to 5)+1
        return randomNumber;
    }


}
