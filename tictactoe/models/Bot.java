package tictactoe.models;

import tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel level;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(long id, String name, Symbol symbol,BotDifficultyLevel level) {
        super(id, name, symbol, PlayerType.BOT);
        this.level = level;
    }

    public BotDifficultyLevel getLevel() {
        return level;
    }

    public void setLevel(BotDifficultyLevel level) {
        this.level = level;
    }

    public Move makeMove(Board board){
        System.out.println("Please tell the row index where you want to make a move:(Starting from 0)");
        int row = scanner.nextInt();

        System.out.println("Please tell the col index where you want to make a move:(Starting from 0)");
        int col = scanner.nextInt();

        return new Move(this,new Cell(row,col));

    }
}
