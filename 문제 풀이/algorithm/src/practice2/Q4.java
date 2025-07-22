package practice2;

public class Q4 {

    public static int[] copy(int[] a, int[] b) {

        for(int i=0; i<a.length; i++) {
            b[i] = a[i];
        }

        return b;
    }
}
