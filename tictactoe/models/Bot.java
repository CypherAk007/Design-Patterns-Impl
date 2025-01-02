package tictactoe.models;

import tictactoe.factories.BotPlayingStrategyFactory;
import tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;

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
