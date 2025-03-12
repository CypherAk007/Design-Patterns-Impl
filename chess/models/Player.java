package chess.models;

import java.util.Scanner;

public class Player {
    private long id;
    private Symbol symbol;
    private String name;
    private PlayerType playerType;
    private ChessPieceColor playerChessPieceColor;//if white -> move only white pieces
    private Scanner scanner;
}
