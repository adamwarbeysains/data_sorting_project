public class Element {
    private Integer num;
    private boolean bubble;
    private boolean square;

    public Element(Integer num, boolean bubble, boolean square) {
        this.num = num;
        this.bubble = bubble;
        this.square = square;
    }

    public void setBubble(boolean bubble) {
        this.bubble = bubble;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setSquare(boolean square) {
        this.square = square;
    }

    public int getNum() {
        return num;
    }

    public boolean isBubble() {
        return bubble;
    }

    public boolean isSquare() {
        return square;
    }
}
