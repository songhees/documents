package practice4;

public class IntQueue {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;
    
    public IntQueue(int max) {
        this.max = max;
        num = rear = front = 0;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            this.max = 0;
        }
    }
    
    public int enque(int x) throws Gstack.OverflowIntStackException {
        // front = rear 인데 꽉 차 있을때
        if (num >= max) {
            throw new Gstack.OverflowIntStackException();
        }
        
        que[rear++] = x;
        num++;
        // index가 끝을 넘길 때 다시 0으로 초기화
        if (rear == max) {
            rear = 0;
        }
        return x;
    }

    public int deque() throws Gstack.EmptyIntStackException {
        if (num <= 0) {
            throw new Gstack.OverflowIntStackException();
        }

        int target = que[front++];
        if (front >= max) {
            front = 0;
        }
        num--;
        return target;
    }

    public int peak() throws Gstack.EmptyIntStackException {
        if (num <= 0) {
            throw new Gstack.OverflowIntStackException();
        }

        return que[front];
    }

    public int indexOf(int data) throws Gstack.EmptyIntStackException {
        for (int i=0; i<max; i++) {
            int index = (i+front)%max;
            if (que[index] == data) {
                return index;
            }
        }
        return -1;
    }

    public void clear() {
        num = rear = front = 0;
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

    public int search(int data) {
        for (int i=0; i<max; i++) {
            int index = (i+front)%max;
            if (que[index] == data) {
                return i+1;
            }
        }
        return 0;
    }
}
