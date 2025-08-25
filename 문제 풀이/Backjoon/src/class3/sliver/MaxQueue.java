package class3.sliver;

public class MaxQueue {
    int index;
    int[] que;

    public MaxQueue (int capacity) {
        que = new int[capacity];
        index = 0;
    }

    public void add(int data) {
        if (index >= que.length) {
            return;
        }

        que[index] = data;
        addMove(index++);
    }

    void addMove(int idx) {
        if (idx <= 0) {
            return;
        }
        int pt = (idx-1)/2;

        if (que[pt] < que[idx]) {
            swap(idx, pt);
            addMove(pt);
        }
    }

    public int poll() {
        if (index <= 0) {
            return 0;
        }

        int result = que[0];
        index--;
        pollMove();

        return result;
    }
    void pollMove() {
        que[0] = que[index];

        int idx = 0;
        while (idx < index) {
            int left = idx*2 + 1;
            int right = idx*2 + 2;
            int maxIdx = idx;

            if (left < index && que[left] > que[maxIdx]) {
                maxIdx = left;
            }
            if (right < index && que[right] > que[maxIdx]) {
                maxIdx = right;
            }

            if (idx == maxIdx) {
                break;
            }
            swap(idx, maxIdx);
            idx = maxIdx;
        }
    }

    void swap(int idx, int pt) {
        int temp = que[pt];

        que[pt] = que[idx];
        que[idx] = temp;
    }
}
