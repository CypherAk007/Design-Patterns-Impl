package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;
    public Board(int size){
        this.size = size;
        this.board = initilizeBoard(size);
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void display(){
        System.out.println();
        for(int i=0;i<size;i++){
            System.out.println();
            for(int j=0;j<size;j++){
                Cell cell = board.get(i).get(j);
                char ch = cell.getPlayer().getSymbol().getCharacter();
                System.out.println(String.format(" %s ",ch));
                if(j<size -1){
                    System.out.print("|");
                }
            }
            if(i<size-1){
                System.out.println();
                for(int k=0;k<size;k++){
                    System.out.print("----");
                }
            }
        }
        System.out.println("\n");
    }
    private List<List<Cell>> initilizeBoard(int size) {
        List<List<Cell>> board = new ArrayList<>();
        for(int i = 0;i<size;i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0;j<size;j++){
                row.add(new Cell(i,j));
            }
            board.add(row);
        }
        return board;

    }

}
