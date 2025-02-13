package tictactoe_redo1.models;



import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private List<List<Cell>> board;
    public Board(int size){
        this.size = size;
        this.board = initialize(size);
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public List<List<Cell>> getGrid() {
        return board;
    }
    public void setGrid(List<List<Cell>> board) {
        this.board = board;
    }
    public void display(){
        System.out.println();
        for(int i=0;i<size;i++){
            System.out.println();
            for(int j=0;j<size;j++){
                Cell cell = board.get(i).get(j);
                char ch = cell.getCellState()== CellStatus.EMPTY?' ':cell.getPlayer().getSymbol().getCharacter();
                System.out.print(String.format(" %s ",ch));
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
    public List<List<Cell>> initialize(int size){
        List<List<Cell>> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            List<Cell> temp = new ArrayList<>();
            for(int j=0;j<size;j++){
                temp.add(new Cell(i,j));
            }
            list.add(temp);
        }
        return list;
    }
}
