package chess.models.chessPieces;

import chess.models.*;

public class Rook extends ChessPiece {
    private Symbol whiteSymbol;
    private Symbol blackSymbol;

    public Rook(ChessPieceColor chessPieceColor, Player player) {
        super(ChessPieceType.ROOK, chessPieceColor, player);
        this.whiteSymbol = new Symbol('♖');
        this.blackSymbol = new Symbol('♜');
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

