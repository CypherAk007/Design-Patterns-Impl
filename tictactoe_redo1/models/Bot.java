package tictactoe_redo1.models;

import tictactoe_redo1.factories.BotPlayingStrategyFactory;
import tictactoe_redo1.strategies.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel level;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(long id, String name, Symbol symbol,BotDifficultyLevel level) {
        super(id, name, symbol, PlayerType.BOT);
        this.level = level;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyBasedOnDifficultyLevel(level);
    }
    public BotDifficultyLevel getLevel() {
        return level;
    }
    public void setLevel(BotDifficultyLevel level) {
        this.level = level;
    }

    public Move makeMove(Board board){
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}