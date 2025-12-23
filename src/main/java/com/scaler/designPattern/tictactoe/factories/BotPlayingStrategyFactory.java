package com.scaler.designPattern.tictactoe.factories;

import com.scaler.designPattern.tictactoe.models.BotDifficultyLevel;
import com.scaler.designPattern.tictactoe.strategies.botplayingstrategy.BotPlayingStrategy;
import com.scaler.designPattern.tictactoe.strategies.botplayingstrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        return new RandomBotPlayingStrategy();
    }
}
