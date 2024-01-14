import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int G = sc.nextInt();
		
		sc.close();
		
		int min = Math.min(R, G);
		int gong = 0;

		for (int i = min; i >= 1; i--) {
			if ( R % i == 0 && G % i ==0 ) {
				gong = i;
				break;
			}
		}
		
		for (int i = 1; i <= gong; i++) {
			List<Integer> listB = new ArrayList<>();
				if ( R % i == 0 && G % i ==0 ) {
				System.out.println( i+ " " + R/i + " " + G/i);
				}
			listB.clear();
		}
		
	}

}
