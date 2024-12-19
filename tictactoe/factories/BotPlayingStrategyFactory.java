package tictactoe.factories;

import tictactoe.models.BotDifficultyLevel;
import tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;
import tictactoe.strategies.botplayingstrategies.EasyPlayingStrategy;
import tictactoe.strategies.botplayingstrategies.HardPlayingStrategy;
import tictactoe.strategies.botplayingstrategies.MediumPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyBasedOnDifficultyLevel(BotDifficultyLevel botDifficultyLevel){
        return switch (botDifficultyLevel){
            case EASY -> new EasyPlayingStrategy();
            case MEDIUM -> new MediumPlayingStrategy();
            case HARD -> new HardPlayingStrategy();

        };
    }
}
