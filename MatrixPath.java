package assignment2;
import java.util.Scanner;

public class MatrixPath {
	public static void main(String[] args) {
		int arrSize;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("n x n ����� �»�ܺ��� ���ϴܱ��� �̵��� �湮�� ĭ�� ���� �ִ��� ����ϴ� ���α׷��Դϴ�");
		System.out.print("����� ũ�⸦ �����ϴ� n�� �����ֽʽÿ� >> ");
		arrSize = scan.nextInt();
		int[][] inputArr = new int[arrSize][arrSize];
		
		System.out.println(arrSize + " x " + arrSize + " ����� ����� �ٹٲ����� ������ �Է��� �ֽʽÿ�");
		
		for (int i = 0; i < arrSize; i++) {
			for (int j = 0; j < arrSize; j++) {
				inputArr[i][j] = scan.nextInt();;
			}
		}
		
		System.out.println("\t" + "<<�Է¹��� ���>>" + "\t");
		
		for (int i = 0; i < arrSize; i++) {
			for (int j = 0; j < arrSize; j++) {    	
	        	System.out.print(inputArr[i][j] + "\t");	        	
	        }
	    	System.out.println();	        
	        }
		
		System.out.println("�Է¹��� ����� �»�ܺ��� ���ϴܱ��� �̵��� �湮�� ĭ�� ���� �ִ��� " + pathSearch(inputArr) + "�Դϴ�.");
	}
	
	static int pathSearch(int[][] mat) {
		int n = mat.length;
		int[][] totalSum = new int[n+1][n+1];
		
		for(int i = 0; i < n+1; i++) {
			totalSum[i][0] = 0;
		}
		
		for(int j = 1; j < n+1; j++) {
			totalSum[0][j] = 0;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				totalSum[i][j] = mat[i-1][j-1] + Math.max(Math.max(totalSum[i-1][j], totalSum[i][j-1]), totalSum[i-1][j-1]);
			}
		}
		return totalSum[n][n];
	}
}