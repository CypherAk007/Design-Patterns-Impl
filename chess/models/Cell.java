package chess.models;

import chess.models.chessPieces.ChessPiece;

public class Cell {
    private int row;
    private int col;
    private String location;//c7,a3
    private CellStatus cellStatus;
    private ChessPiece chessPiece;

    public Cell(int row, int col,String location) {
        this.row = row;
        this.col = col;
        this.location = location;
        this.cellStatus = CellStatus.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public ChessPiece getChessPiece() {
        return chessPiece;
    }

    public void setChessPiece(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                ", location='" + location + '\'' +
                ", cellStatus=" + cellStatus +
                ", chessPiece=" + chessPiece +
                '}';
    }
}
