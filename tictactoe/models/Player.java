package tictactoe.models;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private long id;
    private String name;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(long id,String name,Symbol symbol,PlayerType playerType){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType =playerType;
        this.scanner  = new Scanner(System.in);
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Move makeMove(Board board){
        System.out.println("Please tell the row index where you want to make a move:(Starting from 0)");
        int row = scanner.nextInt();

        System.out.println("Please tell the col index where you want to make a move:(Starting from 0)");
        int col = scanner.nextInt();

        return new Move(this,new Cell(row,col));

    }
}
