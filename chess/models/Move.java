package chess.models;

public class Move {
    private Player player;
    private Cell fromCell;
    private Cell toCell;

    public Move(Player player, Cell fromCell, Cell toCell) {
        this.player = player;
        this.fromCell = fromCell;
        this.toCell = toCell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getFromCell() {
        return fromCell;
    }

    public void setFromCell(Cell fromCell) {
        this.fromCell = fromCell;
    }

    public Cell getToCell() {
        return toCell;
    }

    public void setToCell(Cell toCell) {
        this.toCell = toCell;
    }
}
