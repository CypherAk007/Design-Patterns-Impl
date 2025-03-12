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
//        TBI: Castling

        int toRow  = move.getToCell().getRow();
        int toCol = move.getToCell().getCol();
        int curRow = move.getFromCell().getRow();
        int curCol = move.getFromCell().getCol();
//        System.out.println(toRow+" "+toCol+" "+curRow+" "+curCol);

//        move in row/col only no diagonal / random loc
        if(!(toRow==curRow || toCol==curCol)){
            return false;
        }
        //cannot cross over any one
        if(toRow==curRow){
            int start = curCol;
            int end = toCol;
//            for loop in one dir
            if(start>end) {
                start = toCol;
                end = curCol;
            }
            for(int j = start+1;j<end;j++){
                if(isValid(toRow,j) ) {
                    if (board.getBoard().get(toRow).get(j).getCellStatus().equals(CellStatus.FILLED)) {
                        return false;
                    }
                }
            }
        }else{
            int start = curRow;
            int end = toRow;
//            for loop in one dir
            if(start>end) {
                start = toRow;
                end = curRow;
            }
            for(int i = start+1;i<end;i++){
                if(isValid(i,toCol)) {
                    if (board.getBoard().get(i).get(toCol).getCellStatus().equals(CellStatus.FILLED)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValid(int row,int col){
        if(row>=0 && row<8 && col>=0 && col<8){
            return true;
        }
        return false;
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

