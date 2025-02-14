package tictactoe_redo1.models;


public class Symbol {
    private char character;

    public Symbol(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "character=" + character +
                '}';
    }
}
