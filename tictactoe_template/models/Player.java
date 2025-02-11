package tictactoe_template.models;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private long id;
    private String name;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(long id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
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

    @Override
    public String toString() {
        return "Player{" +
                "symbol=" + symbol +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", playerType=" + playerType +
                '}';
    }

}
