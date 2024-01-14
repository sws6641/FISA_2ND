import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        sc.close();

        long[] arr = {4, 7};
        fucn(A,B,0,arr);

        System.out.println(count);
    }
    public static int count = 0;

    static void fucn(long A , long B, long sum, long[] arr) {
        if (sum >= A && sum <= B ){
            count++;
        }

        if (sum > B){
            return;
        }
            for (int i = 0; i < 2; i++) {
                long newSum =(sum * 10)+ arr[i];
                fucn(A,B,newSum,arr);

        }

    }

}
