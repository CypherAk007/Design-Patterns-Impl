package chess.models;

import chess.strategies.botPlayingStrategy.BotPlayingStrategy;
import chess.strategies.specialCases.SpecialCaseStrategy;
import chess.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Board> moves;
    private Player winner;
    private int nextPlayerMoveIndex;
    private List<WinningStrategy> winningStrategies;
    private List<SpecialCaseStrategy> specialCaseStrategies;

}
