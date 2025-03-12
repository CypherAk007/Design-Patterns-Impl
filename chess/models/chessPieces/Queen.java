package chess.models.chessPieces;

import chess.models.*;

public class Queen extends ChessPiece{
    public Queen(ChessPieceType chessPieceType, ChessPieceColor chessPieceColor, Player player, Symbol symbol) {
        super(chessPieceType, chessPieceColor, player, symbol);
    }

    @Override
    public boolean validateMove(Board board) {
        return true;
    }
}
