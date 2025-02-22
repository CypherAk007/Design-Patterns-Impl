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
    private int nextPlayerMoveIndex;

    public Game(int size, List<Player> players, List<WinningStrategy> winningStrategies, List<Obstacles> snakes, List<Obstacles> ladders) {
        this.board = new Board(size,snakes,ladders,players);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
        this.snakes = snakes;
        this.ladders = ladders;
        this.nextPlayerMoveIndex = 0;

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
        Player currentPlayer = this.players.get(nextPlayerMoveIndex);
        System.out.println(String.format("Its %s turn to play, Please Roll the Dice...",currentPlayer.getName()));
        Move move = currentPlayer.makeMove(board);
        System.out.println(String.format("%s's New Board Location is : %d",currentPlayer.getName(),move.getCell().getCellNo()));

        if(!isValidMove(currentPlayer,move)){
            System.out.println("Invalid Move!");
        }else{
            int currentBoardLocation = currentPlayer.getCell().getCellNo();
//        change the new cell status if valid
            int row = move.getCell().getRow();
            int col = move.getCell().getCol();
            Cell cellToChange = board.getBoard().get(row).get(col);
            cellToChange.setCellState(CellState.FILLED);
            cellToChange.getPlayers().add(move.getPlayer());
//        add move to moves array
            Move finalMove = new Move(currentPlayer,cellToChange);
            moves.add(finalMove);

//        remove player from the player list of prev cell
//            board no player list of cell
            Cell currentPlayerCell = currentPlayer.getCell();
            currentPlayerCell.getPlayers().remove(currentPlayer);
            if(currentPlayerCell.getPlayers().size()==0){
                currentPlayerCell.setCellState(CellState.EMPTY);
            }

//        change the cell of player
            currentPlayer.setCell(cellToChange);


//        check winner



        }
//        update nextPlayerIndx
            //        update the next player //
            nextPlayerMoveIndex = (nextPlayerMoveIndex + 1)%players.size();

    }

    private boolean isValidMove(Player currentPlayer,Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(currentPlayer.getCell().getRow()==row && currentPlayer.getCell().getCol()==col){
            return false;
        }
        if(row<0 || row>=board.getSizeOfBoard()){
            return false;
        }

        if(col<0 || col>=board.getSizeOfBoard()){
            return false;
        }
        return true;
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
