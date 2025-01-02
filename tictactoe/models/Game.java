package tictactoe.models;

import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.MoreThanOneBotException;
import tictactoe.exceptions.PlayersAndDimensionsMismatchException;
import tictactoe.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState state;
    private int nextPlayerMoveIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(){}

    private Game(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.state = GameState.IN_PROGRESS;
        this.nextPlayerMoveIndex = 0;
        this.winningStrategies = winningStrategies;
    }

    public static GameBuilder builder(){
        return new GameBuilder();
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



    public GameState getState() {
        return state;
    }



    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }



    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void display(){
        board.display();
    }

    public void makeMove(){
        Player currentPlayer = this.players.get(nextPlayerMoveIndex);
        System.out.println(String.format("It's %s's turn. Please make your Move!!",currentPlayer.getName()));

        Move move = currentPlayer.makeMove(board);
        System.out.println(String.format("%s has made a move at row: %s and column: %s",currentPlayer.getName(),move.getCell().getRow(),move.getCell().getCol()));

        if(!isValidMove(move)){
            System.out.println("Invalid Move! Please Try Again...");
            return;
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setPlayer(move.getPlayer());

        Move finalMove = new Move(currentPlayer,cellToChange);
        moves.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex+1)%players.size();

        if(checkWinner(board,finalMove)){
            state = GameState.WIN;
            winner = currentPlayer;
        }else if(moves.size()==this.board.getSize() *this.board.getSize()){
            state = GameState.DRAW;
        }

    }

    private boolean checkWinner(Board board,Move lastMove){
        for(WinningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.checkWinner(board,lastMove)){
                return  true;
            }
        }
        return true;

    }

    public boolean isValidMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(move.getCell().getRow()>=board.getSize()){
            return false;
        }
        if(move.getCell().getCol()>=board.getSize()){
            return false;
        }
        if(board.getBoard().get(row).get(col).getCellState()!=CellState.EMPTY){
            return false;
        }
        return true;


    }

    public static class GameBuilder{
//        private Board board;
        private int size;
        private List<Player> players;
//        private List<Move> moves;
//        private Player winner;
//        private GameState state;
//        private int nextPlayerMoveIndex;
        private List<WinningStrategy> winningStrategies;

        public GameBuilder(){
//            to avoid null ptr exception for  this
//                        "// instead of above winningStrategies we can add it manually by iterating the list\n" +
//                                "//                .addWinningStrategies(winningStrategies.get(0))\n" +
//                                "//                .addWinningStrategies(winningStrategies.get(1))"
//            we need to init the values
            this.size = 0;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }


//        public GameBuilder setBoard(Board board) {
//            this.board = board;
//            return this;
//        }

        public GameBuilder setSizeOfBoard(int size) {
            this.size = size;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

//        public GameBuilder setMoves(List<Move> moves) {
//            this.moves = moves;
//            return this;
//        }
//
//        public GameBuilder setWinner(Player winner) {
//            this.winner = winner;
//            return this;
//        }
//
//        public GameBuilder setState(GameState state) {
//            this.state = state;
//            return this;
//        }
//
//        public GameBuilder setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
//            this.nextPlayerMoveIndex = nextPlayerMoveIndex;
//            return this;
//        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

//        For multivalued attributes //Additional INFO
        public GameBuilder addPlayer(Player player){
            this.players.add(player);
            return this;
        }


        public GameBuilder addWinningStrategies(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }


        public Game build() throws MoreThanOneBotException, DuplicateSymbolException, PlayersAndDimensionsMismatchException {
            //            validations
            validate();
            return new Game(size,players,winningStrategies);
        }

        public void validate() throws MoreThanOneBotException, DuplicateSymbolException, PlayersAndDimensionsMismatchException {
            //            validations
            validateBot();
            validatePlayerAndDimension();
            validateSymbols();
        }

        private void validateSymbols() throws DuplicateSymbolException {
            long count = this.players.stream()
                    .map(Player::getSymbol)
                    .map(Symbol::getCharacter)
                    .distinct()
                    .count();
            if(this.players.size()!=count){
                throw new DuplicateSymbolException();
            }
        }

        private void validatePlayerAndDimension() throws PlayersAndDimensionsMismatchException {
            if(this.players.size()!=size-1){
                throw new PlayersAndDimensionsMismatchException();
            }
        }

        private void validateBot() throws MoreThanOneBotException {
            long count = this.players.stream()
                    .filter(player -> player.getPlayerType()==PlayerType.BOT)
                    .count();

            if(count>1){
//                NEVER THROW GENERIC EXCEPTION
//                throw new Exception("Invalid Game!!")
//                CREATE CUSTOM EXCEPTION
                throw new MoreThanOneBotException(String.format("Found %s bots",count));

            }
        }
    }
}
