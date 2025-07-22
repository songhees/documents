package practice2;

public class Q11 {
    public int y;
    public int m;
    public int d;

    public Q11(int y, int m ,int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    static int isLeap(int year) {
        return (year %4==0 && year%100 !=0 || year % 400 == 0) ? 1 : 0;
    }

    public Q11 after(int n) {
        Q11 temp = new Q11(this.y, this.m, this.d);

        temp.d += n;

        while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
            temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
            if (++temp.m > 12) {
                temp.y++;
                temp.m = 1;
            }
        }
        return temp;
    }

    public Q11 before(int n) {
        Q11 temp = new Q11(this.y, this.m, this.d);

        temp.d -= n;

        while (temp.d <= 0) {
            if (--temp.m < 0) {
                --temp.y;
                temp.m = 12;
            }
            temp.d = mdays[isLeap(temp.y)][temp.m - 1];
        }
        return temp;
    }


    static int[][] mdays = {
            {31,28,31,30,31,30,31,31,30,31,30,31}, // 평년 // 365
            {31,29,31,30,31,30,31,31,30,31,30,31}  // 윤년 // 366
    };
}
