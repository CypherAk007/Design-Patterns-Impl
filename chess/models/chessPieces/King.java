package chess.models.chessPieces;

import chess.models.*;

public class King extends ChessPiece{
    private Symbol whiteSymbol;
    private Symbol blackSymbol;

    public King(ChessPieceColor chessPieceColor, Player player) {
        super(ChessPieceType.KING, chessPieceColor, player);
        this.whiteSymbol = new Symbol('♔');
        this.blackSymbol = new Symbol('♚');
    }

    @Override
    public boolean validateMove(Move move,Board board) {
//        TBI: Castling
        if(Math.abs(move.getFromCell().getRow()-move.getToCell().getRow())>1 || Math.abs(move.getFromCell().getCol()-move.getToCell().getCol())>1){
            return false;
        }
        return true;
    }

    @Override
    public Symbol getSymbol() {
        if (this.getChessPieceColor().equals(ChessPieceColor.WHITE)) {
            return whiteSymbol;
        } else {
            return blackSymbol;
        }
    }
}

