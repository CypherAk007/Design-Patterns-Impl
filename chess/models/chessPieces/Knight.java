package chess.models.chessPieces;

import chess.models.*;

public class Knight extends ChessPiece{
    private Symbol whiteSymbol;
    private Symbol blackSymbol;

    public Knight(ChessPieceColor chessPieceColor, Player player) {
        super(ChessPieceType.KNIGHT, chessPieceColor, player);
        this.whiteSymbol = new Symbol('♘');
        this.blackSymbol = new Symbol('♞');
    }

    @Override
    public boolean validateMove(Board board) {
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

