import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static int arrayListToInteger( ArrayList<Integer> myArrayList ) {
        int sizeOfArrayList = myArrayList.size();
        double result = 0;
        int index = 0;
        while (index < sizeOfArrayList) {
            result += (myArrayList.get(index) * Math.pow(10, sizeOfArrayList - index - 1));
            index ++;
        }
        return (int)result;
    }

    public static ArrayList<Integer> quickSort (ArrayList<Integer> myArrayList) {
        ArrayList<Element> preNorthArray = new ArrayList<Element>();
        ArrayList<Element> preSouthArray = new ArrayList<Element>();
        SuperArray northArray = new SuperArray(preNorthArray, true);
        SuperArray southArray = new SuperArray(preSouthArray, false);

        for (int i : myArrayList) {
            Element newElement = new Element(i, false, false);
            northArray.add(newElement);
        }

        while ((!northArray.isSorted() && northArray.isCurrent()) || (!southArray.isSorted() && southArray.isCurrent())) {
            if (northArray.isCurrent()) {
                northArray.bubbleGenerator2();
                int counter3 = 0;
                for (int counter1 = 0; counter1 < myArrayList.size(); counter1++) {
                    if (northArray.getElement(counter1).isBubble()) {
                        int counter2 = counter3;
                        while (counter2 <= counter1) {
                            if (northArray.getInt(counter2) <= northArray.getInt(counter1) && !northArray.getElement(counter2).isBubble()) {
                                southArray.add(northArray.getElement(counter2));
                            }
                            counter2++;
                        }
                        counter2 = counter3;
                        while (counter2 <= counter1) {
                            if (northArray.getElement(counter2).isBubble()) {
                                northArray.getElement(counter2).setSquare(true);
                                northArray.getElement(counter2).setBubble(false);
                                southArray.add(northArray.getElement(counter2));
                            }
                            counter2++;
                        }
                        counter2 = counter3;
                        while (counter2 <= counter1) {
                            if (northArray.getInt(counter2) > northArray.getInt(counter1)) {
                                southArray.add(northArray.getElement(counter2));
                            }
                            counter2++;
                        }
                        counter3 = counter1 + 1;
                    } else if (northArray.getElement(counter1).isSquare()) {
                        southArray.add(northArray.getElement(counter1));
                        counter3 = counter1 + 1;
                    }
                }
                northArray.clear();
                northArray.setCurrent(false);
                southArray.setCurrent(true);
            } else if (southArray.isCurrent()) {
                southArray.bubbleGenerator2();
                int counter3 = 0;
                for (int counter1 = 0; counter1 < myArrayList.size(); counter1++) {
                    if (southArray.getElement(counter1).isBubble()) {
                        int counter2 = counter3;
                        while (counter2 <= counter1) {
                            if (southArray.getInt(counter2) <= southArray.getInt(counter1) && !southArray.getElement(counter2).isBubble()) {
                                northArray.add(southArray.getElement(counter2));
                            }
                            counter2++;
                        }
                        counter2 = counter3;
                        while (counter2 <= counter1) {
                            if (southArray.getElement(counter2).isBubble()) {
                                southArray.getElement(counter2).setSquare(true);
                                southArray.getElement(counter2).setBubble(false);
                                northArray.add(southArray.getElement(counter2));
                            }
                            counter2++;
                        }
                        counter2 = counter3;
                        while (counter2 <= counter1) {
                            if (southArray.getInt(counter2) > southArray.getInt(counter1)) {
                                northArray.add(southArray.getElement(counter2));
                            }
                            counter2++;
                        }
                        counter3 = counter1 + 1;
                    } else if (southArray.getElement(counter1).isSquare()) {
                        northArray.add(southArray.getElement(counter1));
                        counter3 = counter1 + 1;
                    }
                }
                southArray.clear();
                southArray.setCurrent(false);
                northArray.setCurrent(true);
            }

        }

        if (northArray.isCurrent()) {
            return northArray.toArrayListInteger();
        } else {
            return southArray.toArrayListInteger();
        }

    }

    public static double findMedian(ArrayList<Integer> myArrayList) {
        if (myArrayList.size() % 2 == 1) {
            return myArrayList.get(((myArrayList.size() + 1) / 2) - 1).doubleValue();
        } else {
            double a = myArrayList.get((myArrayList.size() / 2) - 1);
            double b = myArrayList.get(myArrayList.size() / 2);
            return (a+b)/2;
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> rawData = new ArrayList<Integer>();
        ArrayList<Integer> numGenerator = new ArrayList<Integer>();

        String path = "data.txt";
        FileInputStream input = new FileInputStream(path);
        int counter;
        char a;
        String b;
        Integer c;
        while ((counter = input.read()) != -1) {
            a = (char)counter;
            if (a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8' || a == '9' ) {
                b = Character.toString(a);
                c = Integer.parseInt(b);
                numGenerator.add(c);

            } else {
                if (!numGenerator.isEmpty()) {
                    rawData.add(Main.arrayListToInteger(numGenerator));
                    numGenerator.clear();
                }
            }

        }
        input.close();

        System.out.println(rawData);

        ArrayList<Integer> sortedData;
        long start = System.currentTimeMillis();
        sortedData = Main.quickSort(rawData);
        long end = System.currentTimeMillis();

        System.out.println(sortedData);

        long elapsedTime = end - start;
        System.out.println(elapsedTime);

        double median;
        median = Main.findMedian(sortedData);
        System.out.println(median);


    }
}