package snakeAndLadder.models;

public class Obstacles {
    private int head;
    private int tail;
    public Obstacles(int head,int tail) {
        this.head = head;
        this.tail = tail;
    }
    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Obstacles{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
