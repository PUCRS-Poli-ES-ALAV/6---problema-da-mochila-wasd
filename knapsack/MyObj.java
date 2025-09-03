package knapsack;

public class MyObj {
    private int weight;
    private int value;

    public MyObj (int w, int v) {
        this.weight = w;
        this.value = v;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getValue() {
        return value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setValue(int value) {
        this.value = value;
    }
}