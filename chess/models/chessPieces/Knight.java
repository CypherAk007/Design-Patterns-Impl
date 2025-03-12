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
    public boolean validateMove(Move move,Board board) {

//        Is it at correct location
        int toRow  = move.getToCell().getRow();
        int toCol = move.getToCell().getCol();
        int curRow = move.getFromCell().getRow();
        int curCol = move.getFromCell().getCol();
        boolean flag = false;
        int[] dr = new int[]{-2,-1,1,2,2,1,-1,-2};
        int[] dc = new int[]{1,2,2,1,-1,-2,-2,-1};
        for(int i=0;i<dr.length;i++){
            if(curRow+dr[i]==toRow && curCol+dc[i]==toCol){
                flag = true;
                break;
            }
        }
        return flag;

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

