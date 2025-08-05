package practice07;

public class IntSet {

    private int max;
    private int num;
    private int[] n;

    public IntSet(int capacity) {
        max = capacity;
        num = 0;

        try {
            n = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int indexOf(int data) {
        for (int i = 0; i < max; i++) {
            if (n[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public void add(int data) {
        if (num >= max || indexOf(data) != -1) {
            return;
        }

        n[num++] = data;
    }

    public void remove(int data) {
        int index = -1;
        if (num <= 0 || (index = indexOf(data)) == -1) {
            return;
        }

        n[index] = n[--num];
    }

    public boolean isEmpty() {
        return !(max == num);
    }

    public boolean isFull() {
        return max == num;
    }

    public void clear() {
        n = new int[max];
    }

    public boolean addSet(IntSet s) {
        int before = num;
        for(int i=0; i<s.num; i++) {
            add(s.n[i]);
        }

        return before != num;
    }

    // 교집합 ??
    public boolean retainSet(IntSet s) {
        int before = num;

        for(int i=0; i<num; i++) {
            if (!s.contains(n[i])) {
                remove(n[i]);
            }
        }

        return before != num;
    }

    // 차집합
    public boolean removeSet(IntSet s) {
        int before = num;
        for (int i=0; i<num; i++) {
            for(int j=0; j<s.num; j++) {
                if (n[i] == s.n[j]) {
                    remove(n[i]);
                    break;
                }
            }
        }
        return before != num;
    }

    public String toString() {
        StringBuffer str = new StringBuffer("{ ");

        for(int i=0; i<num; i++) {
            str.append(n[i] + " ");
        }
        str.append(" }");
        return str.toString();
    }

    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    public boolean isSubsetOf(IntSet s) {
        if (num > s.num) {
            return false;
        }

        for(int i=0; i<num; i++) {
            if (!s.contains(n[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isProperSubsetOf(IntSet s) {
        if (num >= s.num) {
            return false;
        }

        for(int i=0; i<num; i++) {
            if (!s.contains(n[i])) {
                return false;
            }
        }
        return true;
    }


}