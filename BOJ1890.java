package assignment3;
import java.io.*;

public class BOJ1890 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine().trim());
		int[][] intArr = new int[size][size];
		
		for (int i = 0; i < intArr.length; i++) {
			String line = br.readLine();
			String[] chars = line.trim().split(" ");
			
            for (int j = 0; j < intArr[i].length; j++) {
            	intArr[i][j] = Integer.parseInt(chars[j]);
            }
        }
		
		intArr[size-1][size-1] = 1;
		
		for (int i = size-1; i < 0; i--) {
            for (int j = size-1; i < 0; j--) {
            }
        }
	}
}