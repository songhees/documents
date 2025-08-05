package practice4;

public class DoubleStack {
    private int ptr1;
    private int ptr2;
    private int max;
    private int[] stk;

    private enum Stk {
        Stack1,
        Stack2
    }
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException(){}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    public DoubleStack(int max) {
        this.ptr1 = 0;
        this.ptr2 = max-1;

        try {
            this.stk = new int[max];
        } catch (OutOfMemoryError e) {
            this.max = 0;
        }
    }

    public int push(Stk type,int data) throws OverflowIntStackException {
        if (ptr2+1 <= ptr1) {
            throw new OverflowIntStackException();
        }
        switch (type) {
            case Stack1 : stk[ptr1++] = data; break;
            case Stack2 : stk[ptr2--] = data; break;
        }
        return data;
    }

    public int pop(Stk type) throws EmptyIntStackException {
        int target = 0;
        switch (type) {
            case Stack1 -> {
                if (ptr1 <= 0) {
                    throw new EmptyIntStackException();
                }
                target = stk[--ptr1];
                break;
            }
            case Stack2 -> {
                if (ptr2+1 >= max) {
                    throw new EmptyIntStackException();
                }
                target = stk[++ptr2];
                break;
            }
        }
        return target;
    }


    public int peak(Stk type) throws EmptyIntStackException {
        int target = 0;
        switch (type) {
            case Stack1 -> {
                if (ptr1 <= 0) {
                    throw new EmptyIntStackException();
                }
                target = stk[ptr1-1];
                break;
            }
            case Stack2 -> {
                if (ptr2+1 >= max) {
                    throw new EmptyIntStackException();
                }
                target = stk[ptr2+1];
                break;
            }
        }
        return target;
    }

    public int indexOf(Stk type, int data) throws EmptyIntStackException {
        int target = -1;
        switch (type) {
            case Stack1 -> {
                for (int i=ptr1-1; i>=0; i--) {
                    if (stk[i] == data) {
                        target = i;
                    }
                }
                break;
            }
            case Stack2 -> {
                for (int i=ptr2+1; i<max; i++) {
                    if (stk[i] == data) {
                        target = i;
                    }
                }
                break;
            }
        }
        return target;
    }

    public void clear(Stk type) {
        switch (type) {
            case Stack1 : ptr1 = 0; break;
            case Stack2 : ptr2 = max-1; break;
        }
    }

    public int capacity() {
        return max;
    }

    public int size(Stk type) {
        int target = 0;
        switch (type) {
            case Stack1 : target = ptr1; break;
            case Stack2 : target = max - (ptr2+1); break;
        }
        return target;
    }

    public boolean isEmpty(Stk type) {
        int target = 0;
        switch (type) {
            case Stack1 : return ptr1 <= 0;
            case Stack2 : return ptr2 >= max-1;
        }
        return true;
    }

    public boolean isFull(Stk type) {
        return ptr2+1 <= ptr1;
    }
}
