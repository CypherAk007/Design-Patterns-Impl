package tictactoe_redo1.models;

public class Move {
    private Player player;
    private Cell cell;

    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public tictactoe.models.Player getPlayer() {
        return player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setPlayer(Player player){
        this.player = player;
    }
}

