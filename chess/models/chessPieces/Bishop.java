package chess.models.chessPieces;

import chess.models.*;

public class Bishop extends ChessPiece{
    private Symbol whiteSymbol;
    private Symbol blackSymbol;

    public Bishop(ChessPieceColor chessPieceColor, Player player) {
        super(ChessPieceType.BISHOP, chessPieceColor, player);
        this.whiteSymbol = new Symbol('♗');
        this.blackSymbol = new Symbol('♝');
    }

    @Override
    public boolean validateMove(Move move,Board board) {
//        TBI: Cross over logic :  now we are able to cross other pieces

        //cannot cross over any one
        int toRow  = move.getToCell().getRow();
        int toCol = move.getToCell().getCol();
        int curRow = move.getFromCell().getRow();
        int curCol = move.getFromCell().getCol();
        boolean topleft=false,topright=false,bottomleft=false,bottomright=false;
//        System.out.println(toRow+" "+toCol+" "+curRow+" "+curCol);
        if(toCol<curCol){
            if(toRow<curRow){
                topleft = true;
            }else{
                bottomleft = true;
            }
        }else{
            if(toRow<curRow){
                topright = true;
            }else{
                bottomright = true;
            }
        }
        if(topleft) {
            int row = curRow;
            int col = curCol;
            for (int i = 1; i < Math.min(row, col) - 1; i++) {
                if(isValid(row-i,col-i)){
                    if(row-i==toRow && col-i==toCol) break;
//                    System.out.println((row-i)+" "+(col-i)+" "+board.getBoard().get(row - i).get(col - i).getCellStatus().equals(CellStatus.FILLED));
                    if (board.getBoard().get(row - i).get(col - i).getCellStatus().equals(CellStatus.FILLED)) {
                        return false;

                    }
                }
            }
        }

        if(topright) {
            int row = curRow;
            int col = curCol;
            for (int i = 1; i < Math.min(row,8-col-1) - 1; i++) {
                if(isValid(row-i,col+i)) {
                    if(row-i==toRow && col+i==toCol) break;
//                    System.out.println((row-i)+" "+(col+i)+" "+board.getBoard().get(row - i).get(col + i).getCellStatus().equals(CellStatus.FILLED));
                    if (board.getBoard().get(row - i).get(col + i).getCellStatus().equals(CellStatus.FILLED)) {
                        return false;
                    }
                }
            }
        }

        if(bottomleft) {
            int row = curRow;
            int col = curCol;
            for (int i = 1; i < Math.min(8-row-1, col) - 1; i++) {
                if(isValid(row+i,col-i)) {
                    if(row+i==toRow && col-i==toCol) break;
//                    System.out.println((row+i)+" "+(col-i)+" "+board.getBoard().get(row + i).get(col - i).getCellStatus().equals(CellStatus.FILLED));
                    if (board.getBoard().get(row + i).get(col - i).getCellStatus().equals(CellStatus.FILLED)) {
                        return false;
                    }
                }
            }
        }

        if(bottomright) {
            int row = curRow;
            int col = curCol;
            for (int i = 1; i < Math.max(8-row-1,8-col-1) - 1; i++) {
                if(row+i==toRow && col+i==toCol) break;
//                System.out.println((row+i)+" "+(col+i)+" "+board.getBoard().get(row + i).get(col + i).getCellStatus().equals(CellStatus.FILLED));
                if(isValid(row+i,col+i)) {
                    if (board.getBoard().get(row + i).get(col + i).getCellStatus().equals(CellStatus.FILLED)) {
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
//        System.out.println("For loop Row Col Miss Match!!"+row+" : "+col);
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

