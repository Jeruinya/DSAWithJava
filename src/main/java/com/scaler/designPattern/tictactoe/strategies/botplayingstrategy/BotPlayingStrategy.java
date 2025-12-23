package com.scaler.designPattern.tictactoe.strategies.botplayingstrategy;

import com.scaler.designPattern.tictactoe.models.Board;
import com.scaler.designPattern.tictactoe.models.Move;
import com.scaler.designPattern.tictactoe.models.Player;

public interface BotPlayingStrategy {

    Move decideMove(Player player, Board board);
}
