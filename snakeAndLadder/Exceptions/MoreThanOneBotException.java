package snakeAndLadder.Exceptions;

public class MoreThanOneBotException extends Exception{
    // checked exceptions not runtime

    public MoreThanOneBotException(String message){
        super(message);
    }
}
