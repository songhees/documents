package practice4;

public class IntAryQuere {
    private int max;
    private int num;
    private int[] que;

    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
            super();
        }
    }

    public static class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    public IntAryQuere(int max) {
        this.max = max;
        this.num = 0;
        try {
            this.que = new int[max];

        } catch (OutOfMemoryError e) {
            this.max = 0;
        }
    }

    public int enqueue(int data) throws OverflowIntStackException {
        if (num >= max) {
            throw new OverflowIntStackException();
        }

        return que[num++] = data;
    }

    public int dequeue() throws EmptyIntStackException {
        int target = 0;
        if (num <= 0) {
            throw new EmptyIntStackException();
        }

        target = que[0];
        num--;
        for (int i=1; i<= num; i++) {
            que[i-1] = que[i];
        }
        return target;
    }
}
