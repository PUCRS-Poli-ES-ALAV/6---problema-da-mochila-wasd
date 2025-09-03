package knapsack;

public class MyBackpack {
    private int capacity;
    private final int start;

    public MyBackpack (int capacity) {
        this.capacity = capacity;
        this.start = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int add(int i) {
        if (i > capacity) return -1;
        capacity -= i;
        return capacity;
    }

    public int remove(int i) {
        if (capacity+i > start) return -1;
        capacity += i;
        return capacity;
    }

    public int free () {
        capacity = start;
        return capacity;
    }
}
