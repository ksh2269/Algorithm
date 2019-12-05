package assignment2;
import java.util.Scanner;

class LCSAnswer{
	int LCSLen;
	String LCSStr;
	
	LCSAnswer(int LCSLen, String LCSStr){
		this.LCSLen = LCSLen;
		this.LCSStr = LCSStr;
	}
	
	int getLCSLen() {
		return LCSLen;
	}
	
	String getLCSStr() {
		return LCSStr;
	}
}

public class LongestComSub {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("LCS를 계산하는 프로그램 입니다.");
		
		System.out.print("첫번째 문자열을 입력하십시오>> ");
		String a = scan.next();
		
		System.out.print("두번째 문자열을 입력하십시오>> ");
		String b = scan.next();

		System.out.println(a + "와 " + b + "의 LCS길이는 " + LCS(a, b).getLCSLen() 
				+ " LCS문자열은 " + LCS(a, b).getLCSStr() + "입니다.");
	}
	
	static LCSAnswer LCS(String a, String b){
		char[] aChars = a.toCharArray();
		char[] bChars = b.toCharArray();
		int m = aChars.length;
		int n = bChars.length;
		int[][] C = new int[m + 1][n + 1];
		String[][] B = new String[m + 1][n + 1];
		
		for(int i = 0; i <= m; i++) {
			C[i][0] = 0;
		}
		
		for(int j = 0; j <= n; j++) {
			C[0][j] = 0;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(aChars[i-1] == bChars[j-1]) {
					C[i][j] = C[i-1][j-1] + 1;
					B[i][j] = "D"; //D: diagonal
				}else if(C[i-1][j] >= C[i][j-1]){
					C[i][j] = C[i-1][j];
					B[i][j] = "U"; //U: Up
				}else {
					C[i][j] = C[i][j-1];
					B[i][j] = "L"; //L: Left
				}
			}
		}
		
		int p = m; 
		int q = n;
		StringBuffer r = new StringBuffer("");

		while(B[p][q] != null) {
		    if (B[p][q].equals("D")) {
		        r.append(aChars[p-1]);
		        p--;
		        q--;
		    } else if (B[p][q].equals("U")) {
		        p--;
		    } else if (B[p][q].equals("L")) {
		        q--;
		    }
		}
		String ans = r.reverse().toString(); // 최장 공통 부분 수열 리스트
		
		LCSAnswer LCSA = new LCSAnswer(C[m][n], ans);
		
		return LCSA;
	}
}
