package snakeAndLadder.models;


public class Bot extends Player{
    private BotDifficultyLevel level;
    public Bot(long id, String name, Symbol symbol ,BotDifficultyLevel level) {
        super(id, name, symbol, PlayerType.BOT);
        this.level = level;
    }


}
