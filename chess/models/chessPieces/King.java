package chess.models.chessPieces;

import chess.models.*;

public class King extends ChessPiece{
    public King(ChessPieceType chessPieceType, ChessPieceColor chessPieceColor, Player player, Symbol symbol) {
        super(chessPieceType, chessPieceColor, player, symbol);
    }

    @Override
    public boolean validateMove(Board board) {
        return true;
    }
}
