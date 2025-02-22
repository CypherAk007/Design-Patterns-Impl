package snakeAndLadder.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Board {
    private List<List<Cell>> board;
    private int sizeOfBoard;
    private List<Obstacles> snakes;
    private List<Obstacles> ladders;
    private List<Player> players;

    public Board(int size,List<Obstacles> snakes,List<Obstacles> ladders,List<Player> players){
        this.sizeOfBoard = size;
        this.board = initializeBoard(size);
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        updateWithSnakes(snakes);
        updateWithLadders(ladders);
        initializePlayers(players);
    }

    private void initializePlayers(List<Player> players) {
        int cellno = 1;//initially all players are at this pos
        int[] rowColOfCell = findRowAndColGivenCellNumber(cellno);
        int row = rowColOfCell[0];
        int col = rowColOfCell[1];
        Cell cell = board.get(row).get(col);
        cell.setCellState(CellState.FILLED);
        for(Player player:players){
            player.setCell(cell);
        }

        Set<Player> playerSet = players.stream()
                        .collect(Collectors.toSet());
        cell.setPlayers(playerSet);
    }

    private void updateWithSnakes(List<Obstacles> obstacles) {
        for(Obstacles obstacle:obstacles){
            int[] rowColOfCell = findRowAndColGivenCellNumber(obstacle.getHead());
            int row = rowColOfCell[0];
            int col = rowColOfCell[1];
            Cell cell = board.get(row).get(col);
            cell.setCellState(CellState.SNAKE);
            cell.setObstacleValue(obstacle.getTail());
        }
    }

    private void updateWithLadders(List<Obstacles> obstacles) {
        for(Obstacles obstacle:obstacles){
            int[] rowColOfCell = findRowAndColGivenCellNumber(obstacle.getHead());
            int row = rowColOfCell[0];
            int col = rowColOfCell[1];
            Cell cell = board.get(row).get(col);
            cell.setCellState(CellState.LADDER);
            cell.setObstacleValue(obstacle.getTail());
        }
    }

    public int[] findRowAndColGivenCellNumber(int boardNo) {
        boardNo = boardNo-1;//ZERO BASED
        int row = sizeOfBoard -1 + -1*(((boardNo) / (sizeOfBoard)));
        int col;
        if (row % 2 == 0) { // Even row
            col = sizeOfBoard-1-(boardNo% sizeOfBoard) ;
        } else { // Odd row
            col = (boardNo% sizeOfBoard);
        }
//        System.out.println(sizeOfBoard+" "+row+" "+col);
        return new int[]{row,col};
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
//        if(cell.getCellNo()==sizeOfBoard*sizeOfBoard){
//            return  String.format("%-5s"," 🇮🇳  "); // Ensures fixed width
//        }
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

    public int getSizeOfBoard() {
        return sizeOfBoard;
    }

    public void setSizeOfBoard(int sizeOfBoard) {
        this.sizeOfBoard = sizeOfBoard;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
