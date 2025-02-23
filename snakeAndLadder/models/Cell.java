package snakeAndLadder.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cell {
    private Set<Player> players;
    private int row;
    private int col;
    private int obstacleValue;
    private int cellNo;
    private CellState cellState;
    private int boardSize;

    public Cell(int row, int col,int boardSize) {
        this.boardSize = boardSize;
        this.row = row;
        this.col = col;
        this.cellNo = initializeValue(row,col,boardSize);

        // if snake/ladder head exist here then default obstacleValue is updated
        this.obstacleValue = initializeValue(row,col,boardSize);
        this.cellState = CellState.EMPTY;
        this.players = new HashSet<>();
    }

    private int initializeValue(int row, int col,int n) {
        int cellno = -1;
        if(row%2==0){
            //        row idx is even 0,2,4
            //        cellno = (n-r)*n-c
            cellno = (n-row)*n-col;
        }else{
            //        row idx is odd 1,3,5
            //        cellno = (n-r-1)*n+(c+1)
            cellno = (n-row-1)*n+(col+1);
        }
        return cellno;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }


    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
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

    public int getObstacleValue() {
        return obstacleValue;
    }

    public void setObstacleValue(int obstacleValue) {
        this.obstacleValue = obstacleValue;
    }

    public int getCellNo() {
        return cellNo;
    }

    public void setCellNo(int cellNo) {
        this.cellNo = cellNo;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                ", obstacleValue=" + obstacleValue +
                ", CellValue=" + cellNo +
                ", CellState=" + cellState +
                '}';
    }
}
