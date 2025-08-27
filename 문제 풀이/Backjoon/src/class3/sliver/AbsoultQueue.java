package class3.sliver;

public class AbsoultQueue {
    int[] que;
    int num;

    AbsoultQueue(int capacity) {
        que = new int[capacity];
        num = 0;
    }

    public void add(int data) {
        if (num >= que.length) {
            return;
        }
        que[num] = data;
        addMove(num++);
    }

    void addMove(int index) {
        while(index > 0) {
            int pt = (index-1)/2;
            if (Math.abs(que[pt]) > Math.abs(que[index]) || (Math.abs(que[pt]) == Math.abs(que[index]) && que[pt] > que[index])) {
                swap(pt, index);
                index = pt;
            } else {
                return;
            }
        }
    }

    public int pop() {
        if (num <= 0) {
            return 0;
        }

        num--;
        int result = que[0];
        que[0] = que[num];
        popMove(0);
        return result;
    }

    void popMove(int index) {
        while (true) {
            int left = index*2+1;
            int right = index*2+2;
            int min = index;

            if (left < num && (Math.abs(que[left]) < Math.abs(que[index]) ||
                    (Math.abs(que[left]) == Math.abs(que[index]) && que[left] < que[index]))) {
                min = left;
            }

            if (right < num && (Math.abs(que[right]) < Math.abs(que[min]) ||
                    (Math.abs(que[right]) == Math.abs(que[min]) && que[right] < que[min]))) {
                min = right;
            }

            if (min == index) {
                break;
            }

            swap(min, index);
            index = min;
        }
    }

    void swap(int a, int b) {
        int temp = que[a];
        que[a] = que[b];
        que[b] = temp;
    }
}
