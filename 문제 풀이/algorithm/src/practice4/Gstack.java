package practice4;

public class Gstack<E> {
    private int max;
    private int ptr;
    private E[] stk;

    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
            super();
        }
    }

    public static class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    public Gstack(int capacity) {
        max = capacity;

        try {
            stk = (E[]) new Object[capacity];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E push(E data) throws OverflowIntStackException {
        if (ptr >= max) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = data;
    }

    public E pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }

    public E peak() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[ptr-1];
    }

    public int indexOf(E data) throws EmptyIntStackException {
        for (int i=ptr-1; i>=0; i--) {
            if (stk[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }
}
