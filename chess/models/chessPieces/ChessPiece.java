package chess.models.chessPieces;

import chess.models.*;

public abstract class ChessPiece {
    private ChessPieceType chessPieceType;
    private ChessPieceColor chessPieceColor;
    private Player player;
    private Symbol symbol;

    public ChessPiece(ChessPieceType chessPieceType, ChessPieceColor chessPieceColor, Player player, Symbol symbol) {
        this.chessPieceType = chessPieceType;
        this.chessPieceColor = chessPieceColor;
        this.player = player;
        this.symbol = symbol;
    }

    public abstract boolean validateMove(Board board);


}
