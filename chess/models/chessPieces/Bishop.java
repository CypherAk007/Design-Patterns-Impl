package chess.models.chessPieces;

import chess.models.*;

public class Bishop extends ChessPiece{
    private Symbol whiteSymbol;
    private Symbol blackSymbol;

    public Bishop(ChessPieceColor chessPieceColor, Player player) {
        super(ChessPieceType.BISHOP, chessPieceColor, player);
        this.whiteSymbol = new Symbol('♗');
        this.blackSymbol = new Symbol('♝');
    }

    @Override
    public boolean validateMove(Move move,Board board) {
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

