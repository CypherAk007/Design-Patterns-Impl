package snakeAndLadder.models;

import snakeAndLadder.Exceptions.DuplicateSymbolException;
import snakeAndLadder.Exceptions.MoreThanOneBotException;
import snakeAndLadder.Exceptions.ObstacleOutOfBoundsException;
import snakeAndLadder.Exceptions.PlayersAndDimensionsMismatchException;
import snakeAndLadder.Strategies.WinningStrategy;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;
    private List<Obstacles> snakes;
    private List<Obstacles> ladders;

    public Game(int size, List<Player> players, List<WinningStrategy> winningStrategies, List<Obstacles> snakes, List<Obstacles> ladders) {
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public List<Obstacles> getSnakes() {
        return snakes;
    }

    public List<Obstacles> getLadders() {
        return ladders;
    }

    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public void makeMove() {

    }

    public void display() {
        board.display();
    }

    public static class GameBuilder{
        private int size;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private List<Obstacles> snakeLocations;
        private List<Obstacles> ladderLocations;
        
        public GameBuilder setSize(int size) {
            this.size = size;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public GameBuilder setSnakeLocations(List<Obstacles> snakeLocations) {
            this.snakeLocations = snakeLocations;
            return this;
        }

        public GameBuilder setLadderLocations(List<Obstacles> ladderLocations) {
            this.ladderLocations = ladderLocations;
            return this;
        }

        public Game build() throws DuplicateSymbolException, MoreThanOneBotException, PlayersAndDimensionsMismatchException, ObstacleOutOfBoundsException {
//            Validations
            validateSymbols();
            validatePlayerAndDimension();
            validateBot();
            validateSnakeAndLadderLocations();
            return new Game(size,players,winningStrategies,snakeLocations,ladderLocations);
        }

        private void validateSymbols() throws DuplicateSymbolException {
            long count = players.stream()
                    .map(Player::getSymbol)
                    .map(Symbol::getCharacter)
                    .distinct()
                    .count();
            
            if(players.size()!=count){
                throw new DuplicateSymbolException("Duplicate Symbols found for Players!!");
            }
            
        }

        private void validateBot() throws MoreThanOneBotException {
            long count = players.stream()
                    .filter(player -> player.getPlayerType()==PlayerType.BOT)
                    .count();
            if (count>1){
                throw new MoreThanOneBotException(String.format("Found %s Bots. ",count));
            }
        }

        private void validateSnakeAndLadderLocations() throws ObstacleOutOfBoundsException {
            int boardNumbers = this.size*this.size;
            for(Obstacles obstacle:this.ladderLocations){
                if(!(obstacle.getHead()>=0 && obstacle.getTail()<=boardNumbers)){
                    throw new ObstacleOutOfBoundsException(String.format("Found Head: %d Tail: %d. Enter a valid Head and Tail for this Ladder Location!!",obstacle.getHead(),obstacle.getTail()));
                }
            }

            for(Obstacles obstacle:this.snakeLocations){
                if(!(obstacle.getHead()>=0 && obstacle.getTail()<=boardNumbers)){
                    throw new ObstacleOutOfBoundsException(String.format("Found Head: %d Tail: %d. Enter a valid Head and Tail for this Snake Location!!",obstacle.getHead(),obstacle.getTail()));
                }
            }

        }

        private void validatePlayerAndDimension() throws PlayersAndDimensionsMismatchException {
            if(this.players.size()>5){
                throw new PlayersAndDimensionsMismatchException("Enter Players between the range 1-5");
            }

            if(this.size<=0 || this.size>10 || this.size%2!=0){
                throw new PlayersAndDimensionsMismatchException("Enter Board size between the range 2-10 and even board size!!");
            }
        }

    }
}
