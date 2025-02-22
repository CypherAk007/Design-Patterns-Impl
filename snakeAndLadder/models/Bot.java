package snakeAndLadder.models;


import snakeAndLadder.Factories.BotPlayingStrategyFactory;
import snakeAndLadder.Strategies.botPlayingStrategies.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel level;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(long id, String name, Symbol symbol ,BotDifficultyLevel level) {
        super(id, name, symbol, PlayerType.BOT);
        this.level = level;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyBasedOnLevel(level);
    }

    public Move makeMove(Board board){
        Move move = botPlayingStrategy.makeMove(board,this);
        move.setPlayer(this);
        return move;
    }


}
