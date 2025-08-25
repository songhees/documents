package class3.sliver;

public class PriorQueue {
    private int num;
    private int[] que;

    public PriorQueue(int capacity) {
        num = 0;
        que = new int[capacity];
    }

    public void add(int data) {
        if (num >= que.length) {
            return;
        }

        que[num] = data;
        addMove(num++);
    }

    public void addMove(int index) {
        if (index <= 0) {
            return;
        }

        int pt = (index-1)/2;

        if (que[index] < que[pt]) {
            int temp = que[pt];
            que[pt] = que[index];
            que[index] = temp;
            addMove(pt);
        }
    }

    public int poll() {
        if (num <= 0) {
            return 0;
        }
        int data = que[0];
        que[0] = que[--num];
        pollMove(0);

        return data;
    }

    public void pollMove(int index) {
        if (index > num) {
            return;
        }

        while(true) {
            int left = index*2 + 1;
            int right = index*2 + 2;
            int min = index;

            if (left < num && que[min] > que[left]) {
                min = left;
            }

            if (right < num && que[min] > que[right]) {
                min = right;
            }

            if (min == index) {
                break;
            }

            int temp = que[index];
            que[index] = que[min];
            que[min] = temp;

            index = min;
        }
    }
}
