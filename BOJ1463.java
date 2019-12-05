package assignment3;
import java.util.Scanner;

public class BOJ1463 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int[] f = new int[num];
		
		f[0] = 0;
		f[1] = 1;
		f[2] = 1;
		
		for(int i = 3; i < f.length; i++) {
			if(i%2 == 0) {
				if(i%3 ==0) {
					f[i] = Math.min(Math.min(f[i-1], f[i/2]), f[i/3]) + 1;
				}else {
					f[i] = Math.min(f[i-1], f[i/2]) + 1;
				}
			}else if(i%3 == 0) {
				f[i] = Math.min(f[i-1], f[i/3]) + 1;
			}else {
				f[i] = f[i-1] + 1;
			}
		}
		System.out.println(f[num-1]);
		
		scan.close();
	}
}