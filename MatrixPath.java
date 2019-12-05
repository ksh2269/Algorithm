package assignment2;
import java.util.Scanner;

public class MatrixPath {
	public static void main(String[] args) {
		int arrSize;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("n x n 행렬의 좌상단부터 우하단까지 이동시 방문한 칸의 합의 최댓값을 계산하는 프로그램입니다");
		System.out.print("행렬의 크기를 결정하는 n을 정해주십시오 >> ");
		arrSize = scan.nextInt();
		int[][] inputArr = new int[arrSize][arrSize];
		
		System.out.println(arrSize + " x " + arrSize + " 행렬을 띄어쓰기와 줄바꿈으로 구분해 입력해 주십시오");
		
		for (int i = 0; i < arrSize; i++) {
			for (int j = 0; j < arrSize; j++) {
				inputArr[i][j] = scan.nextInt();;
			}
		}
		
		System.out.println("\t" + "<<입력받은 행렬>>" + "\t");
		
		for (int i = 0; i < arrSize; i++) {
			for (int j = 0; j < arrSize; j++) {    	
	        	System.out.print(inputArr[i][j] + "\t");	        	
	        }
	    	System.out.println();	        
	        }
		
		System.out.println("입력받은 행렬의 좌상단부터 우하단까지 이동시 방문한 칸의 합의 최댓값은 " + pathSearch(inputArr) + "입니다.");
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