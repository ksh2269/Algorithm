package assignment2;
import java.util.Scanner;

public class NumberOfSquare {
	public static void main(String[] args) {
		int n;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ ���̰� n ������ ���̰� 2�� �簢���� ���̳��ä��� ����� ���� ����ϴ� ���α׷� �Դϴ�.");
		System.out.print("�簢���� ���� ���̸� �Է��Ͻʽÿ�>> ");
		n = scan.nextInt();
		
		System.out.println("������ ���� " + n + ", ������ ���� 2�� �簢���� ���� �Ǿ����ϴ�.");
		
		System.out.println("�� �簢���� ���̳��ä��� ����� ���� " 
							+ numOfSquare(n) + "�� �Դϴ�.");
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
