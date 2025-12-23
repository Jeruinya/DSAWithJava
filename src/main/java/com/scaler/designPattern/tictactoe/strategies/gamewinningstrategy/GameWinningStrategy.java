package com.scaler.designPattern.tictactoe.strategies.gamewinningstrategy;


import com.scaler.designPattern.tictactoe.models.Board;
import com.scaler.designPattern.tictactoe.models.Cell;
import com.scaler.designPattern.tictactoe.models.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board board,
                        Player lastMovePlayer,
                        Cell moveCell);
}
