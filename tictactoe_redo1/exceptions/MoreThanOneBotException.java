package tictactoe_redo1.exceptions;

public class MoreThanOneBotException extends Exception{
    // checked exceptions not runtime

    public MoreThanOneBotException(String message){
        super(message);
    }
}
