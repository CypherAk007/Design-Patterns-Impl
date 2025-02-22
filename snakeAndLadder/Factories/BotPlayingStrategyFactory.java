package snakeAndLadder.Factories;

import snakeAndLadder.Strategies.botPlayingStrategies.BotPlayingStrategy;
import snakeAndLadder.Strategies.botPlayingStrategies.EasyBotPlayingStrategy;
import snakeAndLadder.Strategies.botPlayingStrategies.MediumBotPlayingStrategy;
import snakeAndLadder.models.BotDifficultyLevel;


public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyBasedOnLevel(BotDifficultyLevel level){
        return switch (level){
            case EASY->new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD -> null;
        };
    }
}
