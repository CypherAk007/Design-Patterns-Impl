package chess.models;

import chess.exceptions.DuplicateChessColorPieceException;
import chess.exceptions.DuplicateSymbolException;
import chess.exceptions.MoreThanOneBotException;
import chess.exceptions.PlayersMismatchException;
import chess.strategies.botPlayingStrategy.BotPlayingStrategy;
import chess.strategies.specialCases.SpecialCaseStrategy;
import chess.strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Board> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerMoveIndex;
    private List<WinningStrategy> winningStrategies;
    private List<SpecialCaseStrategy> specialCaseStrategies;

    public Game(List<Player> players, List<WinningStrategy> winningStrategies, List<SpecialCaseStrategy> specialCaseStrategies) {
        this.board = new Board(players);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerMoveIndex = 0;
        this.winningStrategies = winningStrategies;
        this.specialCaseStrategies = specialCaseStrategies;
    }

    public GameState getGameState(){
        return this.gameState;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Board> getMoves() {
        return moves;
    }

    public Player getWinner() {
        return winner;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public List<SpecialCaseStrategy> getSpecialCaseStrategies() {
        return specialCaseStrategies;
    }

    public void display(){
        board.display();
    }


    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public static class GameBuilder{
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private List<SpecialCaseStrategy> specialCaseStrategies;

        public GameBuilder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies){
            this.winningStrategies = winningStrategies;
            return this;
        }


        public GameBuilder setSpecialCaseStrategies(List<SpecialCaseStrategy> specialCaseStrategies){
            this.specialCaseStrategies = specialCaseStrategies;
            return this;
        }

        public Game build() throws DuplicateSymbolException, PlayersMismatchException, DuplicateChessColorPieceException, MoreThanOneBotException {
            validatePlayers(); //Atmax 2players or 1bot-1player
            validateBot();//only one bot
            return new Game(players,winningStrategies,specialCaseStrategies);
        }

        private void validatePlayers() throws DuplicateSymbolException, DuplicateChessColorPieceException, PlayersMismatchException {
//            traditional way
//            if(players.size()!=2){
//                throw new PlayersMismatchException(" Invalid Number of Players Entered!!");
//            }
//            if(players.get(0).getPlayerChessPieceColor().equals(players.get(1).getPlayerChessPieceColor())){
//                throw new DuplicateChessColorPieceException("Both Players Cant have same chess Piece color!!");
//            }
//            if(players.get(0).getSymbol().getCharacter()==players.get(1).getSymbol().getCharacter()){
//                throw new DuplicateSymbolException("Both Players Cant have same Symbol!!");
//            }

//            using streams
            long playersCount = players.stream().count();
            if(playersCount!=2){
                throw new PlayersMismatchException(" Invalid Number of Players Entered!!");
            }


            long chessColorCount = players.stream()
                    .map(Player::getPlayerChessPieceColor)
                    .distinct()
                    .count();
            if(chessColorCount!=2){
                throw new DuplicateChessColorPieceException("Both Players Cant have same chess Piece color!!");
            }

            long playerSymbol = players.stream()
                    .map(Player::getSymbol)
                    .map(Symbol::getCharacter)
                    .distinct()
                    .count();
            if(playerSymbol!=2){
                throw new DuplicateSymbolException("Both Players Cant have same Symbol!!");
            }

        }


        private void validateBot() throws MoreThanOneBotException {

            long botCount = players.stream()
                    .filter((player)->player.getPlayerType()==PlayerType.BOT)
                    .count();

            if(botCount>1){
                throw new MoreThanOneBotException("You Can only have One Bot in the game!!");
            }
        }

    }

}
