import java.util.ArrayList;

public class SuperArray {
    private ArrayList<Element> positionArray;
    private boolean current;

    public SuperArray(ArrayList<Element> positionArray, boolean current) {
        this.positionArray = positionArray;
        this.current = current;
    }

    public ArrayList<Element> getPositionArray() {
        return positionArray;
    }

    public void setPositionArray(ArrayList<Element> positionArray) {
        this.positionArray = positionArray;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public void add(Element addElement) {
        this.positionArray.add(addElement);
    }

    public void clear() {
        this.positionArray.clear();
    }

    public Element getElement(int i) {
        return this.positionArray.get(i);
    }

    public Integer getInt(int i) {
        return this.positionArray.get(i).getNum();
    }

    public ArrayList<Integer> toArrayListInteger() {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (Element i : this.positionArray) {
            output.add(i.getNum());
        }
        return output;
    }

    public void bubbleGenerator() {
        for (int counter = 0; counter < 11; counter++) {
            System.out.println(counter);
            if (!this.getElement(counter).isSquare()) {

                if (counter == 11 - 1) {
                    this.getElement(counter).setBubble(true);
                } else if (this.getElement(counter + 1).isSquare()) {
                    this.getElement(counter).setBubble(true);
                }
            }

        }
    }

    public void bubbleGenerator2() {
        int newCounter = 0;
        while (newCounter < this.positionArray.size()) {
            if (!this.getElement(newCounter).isBubble() && !this.getElement(newCounter).isSquare()) {
                if (newCounter == this.positionArray.size() - 1) {
                    this.getElement(newCounter).setBubble(true);
                } else if (this.getElement(newCounter + 1).isSquare()) {
                    this.getElement(newCounter).setBubble(true);
                }
            }
            newCounter++;
        }
    }

    public boolean isSorted() {
        for (int i = 0; i < this.positionArray.size() - 1; i++) {
            if (this.getInt(i) > this.getInt(i + 1)) {
                return false;
            }
        }
        return true;
    }

}
