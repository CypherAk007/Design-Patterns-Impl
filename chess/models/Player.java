package chess.models;

import chess.exceptions.OutOfBoundsException;

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

    public Move makeMove(Board board) throws OutOfBoundsException {
        System.out.println("Enter the row no. of chess piece you want to move : ");
        int fromRow = scanner.nextInt();
        System.out.println("Enter the col no. of chess piece you want to move : ");
        int fromCol = scanner.nextInt();
        System.out.println("Enter the row no. of Board you want to Go To : ");
        int toRow = scanner.nextInt();
        System.out.println("Enter the col no. of Board you want to Go To : ");
        int toCol = scanner.nextInt();
        if(!(fromRow>=0 && fromRow<8 && toRow>=0 && toRow<8)){
            throw new OutOfBoundsException("Your Board location is outside the Chess Board !!");
        }
        Cell fromCell = board.getBoard().get(fromRow).get(fromCol);
        Cell toCell = board.getBoard().get(toRow).get(toCol);
        Move currentMove = new Move(this,fromCell,toCell);
        return currentMove;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", symbol=" + symbol +
                ", name='" + name + '\'' +
                ", playerType=" + playerType +
                ", playerChessPieceColor=" + playerChessPieceColor +
                '}';
    }
}
