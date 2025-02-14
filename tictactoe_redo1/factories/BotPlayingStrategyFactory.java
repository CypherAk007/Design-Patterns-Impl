package tictactoe_redo1.factories;

import tictactoe_redo1.models.BotDifficultyLevel;
import tictactoe_redo1.strategies.botPlayingStrategy.BotPlayingStrategy;
import tictactoe_redo1.strategies.botPlayingStrategy.EasyBotPlayingStrategy;
import tictactoe_redo1.strategies.botPlayingStrategy.HardBotPlayingStrategy;
import tictactoe_redo1.strategies.botPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyBasedOnDifficultyLevel(BotDifficultyLevel botDifficultyLevel){
        return switch (botDifficultyLevel){
            case EASY -> new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD -> new HardBotPlayingStrategy();
        };
    }
}
