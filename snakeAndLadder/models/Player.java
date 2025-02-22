package snakeAndLadder.models;




import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private long id;
    private String name;
    private PlayerType playerType;
    private Scanner scanner;
    private Cell cell;

    public Player(long id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
        this.cell = null;
    }


    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Move makeMove(Board board) {
        System.out.println("Please Type 'y' to Roll the Dice!!");
        String userInput = scanner.nextLine();
        int diceValue = 0;
        if(userInput.equalsIgnoreCase("y")){
            diceValue = rollTheDice();
        }
        System.out.println(String.format("%s's Rolled Dice Value is : %d",this.getName(),diceValue));

        int[] rowColOfCell = board.findRowAndColGivenCellNumber(this.getCell().getCellNo()+diceValue);
        int row = rowColOfCell[0];
        int col = rowColOfCell[1];
        System.out.println(row+" "+col+" "+diceValue+" "+this.getCell().getCellNo());
        Move move = new Move(this,new Cell(row,col,board.getSizeOfBoard()));
        return move;

    }

    public int rollTheDice(){
        int randomNumber = (int) (Math.random() *6)+1;//(0 to 5)+1
        return randomNumber;
    }

    @Override
    public String toString() {
        return "Player{" +
                "symbol=" + symbol +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", playerType=" + playerType +
                ", scanner=" + scanner +
                ", cell=" + cell +
                '}';
    }
}
