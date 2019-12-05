package assignment3;
import java.io.*;

public class BOJ1912 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine().trim());
		int[] intArr = new int[size];
		int[] max = new int[size];
		int maxVal;
		
		String line = br.readLine();
		String[] chars = line.trim().split(" ");
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(chars[i]);
        }
		
		max[0] = intArr[0];
		
		for (int i = 1; i < intArr.length; i++) {
			if(max[i-1] + intArr[i] > intArr[i]) {
				max[i] = max[i-1] + intArr[i];
			}else {
				max[i] = intArr[i];
			}
        }
		
		maxVal = intArr[0];
		
		for (int i = 1; i < intArr.length; i++) {
			if(max[i] >= maxVal) {
				maxVal = max[i];
			}
        }
		System.out.println(maxVal);
	}
}