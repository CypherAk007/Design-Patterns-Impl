package chess.factories;

import chess.models.ChessPieceColor;
import chess.models.ChessPieceType;
import chess.models.Player;
import chess.models.chessPieces.*;

public class ChessPieceSelectionFactory {
    public static ChessPiece getChessPieceBasedOnInput(ChessPieceType chessPieceType, ChessPieceColor chessPieceColor, Player player){
            return switch (chessPieceType){
                case KING -> new King(chessPieceColor,player);
                case QUEEN -> new Queen(chessPieceColor,player);
                case KNIGHT -> new Knight(chessPieceColor,player);
                case ROOK -> new Rook(chessPieceColor,player);
                case BISHOP -> new Bishop(chessPieceColor,player);
                case PAWN -> new Pawn(chessPieceColor,player);
            };
    }
}
