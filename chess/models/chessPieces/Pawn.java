package chess.models.chessPieces;

import chess.models.*;

public class Pawn extends ChessPiece{
    private Symbol whiteSymbol;
    private Symbol blackSymbol;
    public Pawn(ChessPieceColor chessPieceColor, Player player) {
        super(ChessPieceType.PAWN, chessPieceColor, player);
        this.whiteSymbol = new Symbol('♙');
        this.blackSymbol = new Symbol('♟');
    }

    @Override
    public boolean validateMove(Move move,Board board) {
//        TBI: initial move pawn can move 2 steps
//        TBI: Pawn Promotion

//        cannot move more than 1 step
        if(Math.abs(move.getFromCell().getRow()-move.getToCell().getRow())!=1){
            System.out.println("Invalid Pawn Movement");
            return false;
        }

//        diagonal if capturing opponent
        if(Math.abs(move.getFromCell().getCol()-move.getToCell().getCol())==1) {
            if(!(move.getToCell().getCellStatus().equals(CellStatus.FILLED) && move.getToCell().getChessPiece().getChessPieceColor()!=move.getPlayer().getPlayerChessPieceColor())){
                System.out.println("Invalid Pawn Diagonal Movement");
                return false;
            }
        }
        if(move.getToCell().getCellStatus().equals(CellStatus.FILLED) && move.getToCell().getChessPiece().getChessPieceColor()==move.getPlayer().getPlayerChessPieceColor()){
            System.out.println("Invalid Pawn Row Movement! Cannot Go on your own Team mates!!");
            return false;
        }

//        cannot move reverse
        if(this.getChessPieceColor().equals(ChessPieceColor.WHITE)){
            if(move.getFromCell().getRow()<move.getToCell().getRow()){
                System.out.println("Pawn Cannot Travel Backwards!!");
                return false;
            }
        }else{
            if(move.getFromCell().getRow()>move.getToCell().getRow()){
                System.out.println("Pawn Cannot Travel Backwards!!");
                return false;
            }
        }
        //check if front of it no other black or white piece
        return true;
    }

    @Override
    public Symbol getSymbol() {
        if(this.getChessPieceColor().equals(ChessPieceColor.WHITE)){
            return whiteSymbol;
        }
        else {
            return blackSymbol;
        }
    }


}
