package assignment2;
import java.util.Scanner;

public class NumberOfSquare {
	public static void main(String[] args) {
		int n;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("가로의 길이가 n 세로의 길이가 2인 사각형을 도미노로채우는 방법의 수를 계산하는 프로그램 입니다.");
		System.out.print("사각형의 가로 길이를 입력하십시오>> ");
		n = scan.nextInt();
		
		System.out.println("가로의 길이 " + n + ", 세로의 길이 2인 사각형이 생성 되었습니다.");
		
		System.out.println("이 사각형을 도미노로채우는 방법의 수는 " 
							+ numOfSquare(n) + "개 입니다.");
	}
	
	static int numOfSquare(int n) {
		if (n == 1) {
			return 1;
		}else if(n == 2) {
			return 2;
		}else {
			int[] fib = new int[n];
			fib[0] = 1;
			fib[1] = 2;
			
			for(int i = 2; i < n; i++) {
				fib[i] = fib[i-1] + fib[i-2];
			}
			
			return fib[n-1];
		}
	}
}
