package tictactoe_redo1.models;

import tictactoe_redo1.strategies.botPlayingStrategy.BotPlayingStrategy;

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
}