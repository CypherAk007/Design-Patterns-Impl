package chess.models;

import chess.models.chessPieces.*;

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

    public List<List<Cell>> getBoard() {
        return board;
    }

    private void initializePlayers(List<Player> players) {
////        For testing
//        placePieces(ChessPieceColor.WHITE,null);
//        placePieces(ChessPieceColor.BLACK,null);

        for(Player player:players){
            if(player.getPlayerChessPieceColor()==ChessPieceColor.WHITE){
                placePieces(ChessPieceColor.WHITE,player);
            }else{
                placePieces(ChessPieceColor.BLACK,player);
            }
        }
    }

    private void placePieces(ChessPieceColor chessPieceColor, Player player) {
        int piecesRowIdx = 0;
        int pawnRowIdx = 0;
        if(chessPieceColor.equals(ChessPieceColor.BLACK)) {
             piecesRowIdx = 0;
             pawnRowIdx = 1;
        }
        else{
             piecesRowIdx = size-1;
             pawnRowIdx = size-2;
        }
        for(int j=0;j<size;j++){
            ChessPiece chessPiece = new Pawn(chessPieceColor,player);
            Cell cell = board.get(pawnRowIdx).get(j);
            cell.setChessPiece(chessPiece);
            cell.setCellStatus(CellStatus.FILLED);
        }
        for(int j=0;j<(size/2)+1;j++){
            if(j==0){
                ChessPiece chessPieceLeft = new Rook(chessPieceColor,player);
                Cell cellLeft = board.get(piecesRowIdx).get(j);
                cellLeft.setChessPiece(chessPieceLeft);
                cellLeft.setCellStatus(CellStatus.FILLED);

                ChessPiece chessPieceRight = new Rook(chessPieceColor,player);
                Cell cellRight = board.get(piecesRowIdx).get(size-j-1);
                cellRight.setChessPiece(chessPieceRight);
                cellRight.setCellStatus(CellStatus.FILLED);
            }else if(j==1){
                ChessPiece chessPieceLeft = new Knight(chessPieceColor,player);
                Cell cellLeft = board.get(piecesRowIdx).get(j);
                cellLeft.setChessPiece(chessPieceLeft);
                cellLeft.setCellStatus(CellStatus.FILLED);

                ChessPiece chessPieceRight = new Knight(chessPieceColor,player);
                Cell cellRight = board.get(piecesRowIdx).get(size-j-1);
                cellRight.setChessPiece(chessPieceRight);
                cellRight.setCellStatus(CellStatus.FILLED);
            }else if(j==2){
                ChessPiece chessPieceLeft = new Bishop(chessPieceColor,player);
                Cell cellLeft = board.get(piecesRowIdx).get(j);
                cellLeft.setChessPiece(chessPieceLeft);
                cellLeft.setCellStatus(CellStatus.FILLED);

                ChessPiece chessPieceRight = new Bishop(chessPieceColor,player);
                Cell cellRight = board.get(piecesRowIdx).get(size-j-1);
                cellRight.setChessPiece(chessPieceRight);
                cellRight.setCellStatus(CellStatus.FILLED);
            }else if(j==3){
                ChessPiece chessPieceLeft = new Queen(chessPieceColor,player);
                Cell cellLeft = board.get(piecesRowIdx).get(j);
                cellLeft.setChessPiece(chessPieceLeft);
                cellLeft.setCellStatus(CellStatus.FILLED);

            }else if(j==4){
                ChessPiece chessPieceLeft = new King(chessPieceColor,player);
                Cell cellLeft = board.get(piecesRowIdx).get(j);
                cellLeft.setChessPiece(chessPieceLeft);
                cellLeft.setCellStatus(CellStatus.FILLED);
            }
        }
    }

    public void display() {
        printTopBoundary();
        for(int i=0;i<size;i++){
            System.out.print("│");//left boundary
            for (int j=0;j<size;j++){
                Cell cell = board.get(i).get(j);
                String cellContent = getCellContent(cell);
                System.out.printf("%-4s│",cellContent);
            }
            System.out.println();
            if(i<size-1){
                printMiddleBoundary();
            }
        }
        printBottomBoundary();
//        System.out.println(board + " " + board.size());

    }

    private String getCellContent(Cell cell) {
        if(cell.getCellStatus().equals(CellStatus.EMPTY)){
            if((cell.getRow()+cell.getCol())%2==1){
                return "░░░░";
            }else{
                return "";
            }
        }else if(cell.getCellStatus().equals(CellStatus.FILLED)){
            return " "+String.valueOf(cell.getChessPiece().getSymbol().getCharacter());
        }
        return "░░x░";
    }

    private void printMiddleBoundary(){
        System.out.print("├");
        for (int i = 0; i < size; i++) {
            System.out.print("────");
            if (i < size - 1) System.out.print("┼");
        }
        System.out.println("┤");
    }

    private void printTopBoundary() {
        System.out.print("┌");
        for(int i=0;i<size;i++){
            System.out.print("────");
            if(i<size-1) {
                System.out.print("┬");
            }
        }
        System.out.println("┐");
    }

    private void printBottomBoundary() {
        System.out.print("└");
        for(int i=0;i<size;i++){
            System.out.print("────");
            if(i<size-1) {
                System.out.print("┴");
            }
        }
        System.out.println("┘");
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




