package chess.models;

import java.util.Scanner;

public class Player {
    private long id;
    private Symbol symbol;
    private String name;
    private PlayerType playerType;
    private ChessPieceColor playerChessPieceColor;//if white -> move only white pieces
    private Scanner scanner;

    public Player(long id, Symbol symbol, String name, PlayerType playerType, ChessPieceColor playerChessPieceColor) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
        this.playerChessPieceColor = playerChessPieceColor;
        this.scanner = new Scanner(System.in);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public ChessPieceColor getPlayerChessPieceColor() {
        return playerChessPieceColor;
    }

    public void setPlayerChessPieceColor(ChessPieceColor playerChessPieceColor) {
        this.playerChessPieceColor = playerChessPieceColor;
    }

    public Scanner getScanner() {
        return scanner;
    }

}
