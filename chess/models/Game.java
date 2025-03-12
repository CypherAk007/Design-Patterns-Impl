package chess.models;

import chess.exceptions.*;
import chess.factories.ChessPieceSelectionFactory;
import chess.models.chessPieces.ChessPiece;
import chess.strategies.botPlayingStrategy.BotPlayingStrategy;
import chess.strategies.specialCases.SpecialCaseStrategy;
import chess.strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
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

    public List<Move> getMoves() {
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

    public void makeMove() throws OutOfBoundsException {
        //get player
        Player currentPlayer = this.players.get(nextPlayerMoveIndex);
        System.out.println(String.format("Its %s turn to play, Please Make your Move!!",currentPlayer.getName()));

        //        get input from respective player
        Move currentMove = currentPlayer.makeMove(board);
        System.out.println(String.format(" %s wants to move %s of %s to %s...",currentPlayer.getName(),
                currentMove.getFromCell().getChessPiece().getSymbol().getCharacter(),
                currentMove.getFromCell().getLocation(),
                currentMove.getToCell().getLocation()));

        //        validity: check the inputs from and to
        if(!isValidMove(currentMove)){
            System.out.println("Invalid Move! Please Try Again...");
            return;
        }

//        get row col -> cell and make move and  erase old cell
        Cell curCell = currentMove.getFromCell();
        Cell destCell = currentMove.getToCell();
        System.out.println("Cell Cur To Details: ");
        System.out.println(curCell+" "+destCell);
//        if destCell contains opponent chess piece remove it
        ChessPiece newChessPiece = ChessPieceSelectionFactory.getChessPieceBasedOnInput(curCell.getChessPiece().getChessPieceType(), curCell.getChessPiece().getPlayer().getPlayerChessPieceColor(),currentMove.getPlayer());
        System.out.println(newChessPiece);
        destCell.setChessPiece(newChessPiece);
        destCell.setCellStatus(CellStatus.FILLED);

        curCell.setChessPiece(null);
        curCell.setCellStatus(CellStatus.EMPTY);
        System.out.println("Cell Cur To Details Future: ");
        System.out.println(curCell+" "+destCell);
//        add to moves list
        Move finalMove = new Move(currentMove.getPlayer(),curCell,destCell);
        moves.add(finalMove);

//        check winner
        if(checkWinner(board,finalMove)){
            this.gameState = GameState.WIN;
            this.winner = currentPlayer;
        }

//        update the next move index
        this.nextPlayerMoveIndex = (this.nextPlayerMoveIndex+1)%players.size();

    }

    private boolean checkWinner(Board board, Move finalMove) {
//        TBI
        return false;
    }

    public boolean isValidMove(Move move) {
//        out of bounds exception

//        correct player -> correct from location chess piece
        if(move.getFromCell().getCellStatus().equals(CellStatus.EMPTY)){
            System.out.println(String.format("%s has Selected an Empty Cell!!",move.getPlayer().getName()));
            return false;
        }

        if(move.getFromCell().getCellStatus().equals(CellStatus.FILLED) && !move.getFromCell().getChessPiece().getChessPieceColor().equals(move.getPlayer().getPlayerChessPieceColor())){
            System.out.println(String.format("Player: %s .Do not move Opponents Chess Pieces !! ",move.getPlayer().getName()));
            return false;
        }

        if(move.getToCell().getCellStatus().equals(CellStatus.FILLED) && move.getFromCell().getChessPiece().getChessPieceColor().equals(move.getToCell().getChessPiece().getChessPieceColor())){
            System.out.println(String.format("Player: %s .Do not move Opponents Chess Pieces !! ",move.getPlayer().getName()));
            return false;
        }

//  //        TBI :respective chess piece validation -> trajectory, path and destination
        if(!move.getFromCell().getChessPiece().validateMove(move,board)){
            System.out.println(String.format("Player: %s .You are trying to make Illegal Move!! ",move.getPlayer().getName()));
            return false;
        }


        return true;
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
