package chess.models.chessPieces;

import chess.models.*;

public class Pawn extends ChessPiece{
    public Pawn(ChessPieceColor chessPieceColor, Player player, Symbol symbol) {
        super(ChessPieceType.PAWN, chessPieceColor, player, symbol);
    }

    @Override
    public boolean validateMove(Board board) {
        return true;
    }
}
