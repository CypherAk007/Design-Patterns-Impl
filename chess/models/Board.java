package chess.models;

import chess.models.chessPieces.ChessPiece;
import chess.models.chessPieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<Player> players;
    private List<List<Cell>> board;

    public Board(List<Player> players) {
        this.size = 8;
        this.players = players;
        this.board = initialize(size);
        initializePlayers(players);
    }

    private void initializePlayers(List<Player> players) {
        for(Player player:players){
            if(player.getPlayerChessPieceColor()==ChessPieceColor.WHITE){
                placeWhitePieces(ChessPieceColor.WHITE,player);
            }else{
                placeBlackPieces(ChessPieceColor.BLACK,player);
            }
        }
    }

    private void placeBlackPieces(ChessPieceColor chessPieceColor, Player player) {
    }

    private void placeWhitePieces(ChessPieceColor chessPieceColor, Player player) {
    }


    public void display() {
        System.out.println(board + " " + board.size());

    }

    private List<List<Cell>> initialize(int size) {
        List<List<Cell>> board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                StringBuffer sb = new StringBuffer();
                sb.append((char) ('A' + j)).append(size - i);
                row.add(new Cell(i, j, sb.toString()));
            }
            board.add(row);
        }
        return board;
    }
}




