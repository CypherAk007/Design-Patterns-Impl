package chess.exceptions;

public class PlayerChessPieceColorMismatchException extends Exception{
    public PlayerChessPieceColorMismatchException(){
        super("Do not move Opponents Chess Pieces !! ");
    }
}
