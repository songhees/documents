package practice2;

public class Q6 {

    public static int cardConv(int x, int r, char[] d) {
        String num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int index = 0;
        do {
            d[index++] = num.charAt(x % r);
            x/=r;
        } while (x!=0);

        for(int i=0; i<index/2; i++) {
            char temp = d[i];
            d[i] = d[index-i-1];
            d[index-i-1] = temp;
        }

        System.out.println(index);
        return index;
    }
}
