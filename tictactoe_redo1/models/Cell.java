package tictactoe_redo1.models;



public class Cell {
    private int row;
    private int col;
    private CellStatus cellState;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellStatus.EMPTY;
        this.player = null;
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

    public CellStatus getCellState() {
        return cellState;
    }

    public void setCellState(CellStatus cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void reset() {
        this.cellState = CellStatus.EMPTY;
        this.player = null;
    }
}

