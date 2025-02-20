package snakeAndLadder.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int sizeOfBoard;

    public Board(int size){
        this.sizeOfBoard = size;
        this.board = initializeBoard(size);
    }

    private List<List<Cell>> initializeBoard(int size) {
        List<List<Cell>> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            List<Cell> row = new ArrayList<>();
            for(int j =0;j<size;j++){
                row.add(new Cell(i,j,sizeOfBoard));
            }
            list.add(row);
        }
        return list;
    }

    public void display() {
        // Print top boundary
        int rows = sizeOfBoard,cols = sizeOfBoard;
        printTopBoundary(cols);

        // Print matrix with internal divisions
        for (int i = 0; i < rows; i++) {
            System.out.print("│"); // Left boundary
            for (int j = 0; j < cols; j++) {
                Cell cell = board.get(i).get(j);
                String cellContent = getCellContent(cell); // Get formatted content
                System.out.printf(" %-5s│", cellContent); // Print cell content with spacing
            }
            System.out.println(); // Move to next line

            if (i < rows - 1) {
                printMiddleBoundary(cols); // Print row divider
            }
        }

        // Print bottom boundary
        printBottomBoundary(cols);
    }
    // Helper method to get formatted cell content
    private String getCellContent(Cell cell) {
        if (cell.getCellState() == CellState.FILLED) {
            StringBuilder players = new StringBuilder();
            for (Player player : cell.getPlayers()) {
                players.append(player.getSymbol().getCharacter());
            }
            return String.format("%-5s", players.toString()); // Ensures fixed width
        } else {
            return String.format("%-5d", cell.getObstacleValue()); // Number centered
        }
    }

    public static void printTopBoundary(int cols) {
        System.out.print("┌");
        for (int i = 0; i < cols; i++) {
            System.out.print("──────");
            if (i < cols - 1) System.out.print("┬");
        }
        System.out.println("┐");
    }

    public static void printMiddleBoundary(int cols) {
        System.out.print("├");
        for (int i = 0; i < cols; i++) {
            System.out.print("──────");
            if (i < cols - 1) System.out.print("┼");
        }
        System.out.println("┤");
    }

    public static void printBottomBoundary(int cols) {
        System.out.print("└");
        for (int i = 0; i < cols; i++) {
            System.out.print("──────");
            if (i < cols - 1) System.out.print("┴");
        }
        System.out.println("┘");
    }
}
