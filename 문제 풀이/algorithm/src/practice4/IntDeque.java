package practice4;

public class IntDeque {
    private int max;
    private int frontA;
    private int frontB;
    private int rearA;
    private int rearB;
    private int num;
    private int[] que;

    private enum Que{QUEA, QUEB}

    public IntDeque(int capacity) {
        max = capacity;
        num = 0;
        frontA = frontB = rearB = rearA = 0;

        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enque(Que type, int data) throws Gstack.OverflowIntStackException {
        if (num >= max) {
            throw new Gstack.OverflowIntStackException();
        }

        switch (type) {
            case QUEA :
                que[rearA] = data;
                rearA = frontB = ++rearA % 12;
                break;
            case QUEB :
                rearB = frontA = (12+(--rearB))%12;
                que[rearB] = data;
                break;
        }
        num++;
        return data;
    }

    public int deque(Que type) throws Gstack.EmptyIntStackException {
        if (num <= 0) {
            throw new Gstack.EmptyIntStackException();
        }
        int target = 0;
        switch (type) {
            case QUEA :
                target = que[frontA];
                rearB = frontA = ++frontA % 12;
                break;
            case QUEB :
                rearA = frontB = (12+(--frontB))%12;
                target = que[frontB];
                break;
        }
        num--;
        return target;
    }



    public int peak(Que type) throws Gstack.EmptyIntStackException {
        if (num <= 0) {
            throw new Gstack.OverflowIntStackException();
        }

        int target = 0;
        switch (type) {
            case QUEA :
                target = que[frontA];
                break;
            case QUEB:
                target = que[frontB];
        }
        return target;
    }

    public void clear() {
        num = rearA = frontA = rearB = frontB = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }
}
