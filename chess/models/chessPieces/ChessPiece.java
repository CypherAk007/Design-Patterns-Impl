package chess.models.chessPieces;

import chess.models.*;

public abstract class ChessPiece {
    private ChessPieceType chessPieceType;
    private ChessPieceColor chessPieceColor;
    private Player player;

    public ChessPiece(ChessPieceType chessPieceType, ChessPieceColor chessPieceColor, Player player) {
        this.chessPieceType = chessPieceType;
        this.chessPieceColor = chessPieceColor;
        this.player = player;

    }

    public ChessPieceType getChessPieceType() {
        return chessPieceType;
    }

    public void setChessPieceType(ChessPieceType chessPieceType) {
        this.chessPieceType = chessPieceType;
    }

    public ChessPieceColor getChessPieceColor() {
        return chessPieceColor;
    }

    public void setChessPieceColor(ChessPieceColor chessPieceColor) {
        this.chessPieceColor = chessPieceColor;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public abstract boolean validateMove(Board board);

    public abstract Symbol getSymbol();
}
