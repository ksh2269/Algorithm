package assignment1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		List<String> line = new ArrayList<>();
		int size[][] = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			String a = sc.nextLine();
			for (int j = 0; j < line.size(); j++) {
				if (a.equals(line.get(j))) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				line.add(a);
			}
		}

		Collections.sort(line);
		for (int i = 0; i < line.size(); i++) {
			size[i][0] = i;
			size[i][1] = line.get(i).length();
		}

		for (int i = 0; i < line.size() - 1; i++) {
			for (int j = i + 1; j < line.size(); j++) {
				if (size[i][1] > size[j][1]) {
					int temp = size[i][1];
					size[i][1] = size[j][1];
					size[j][1] = temp;

					temp = size[i][0];
					size[i][0] = size[j][0];
					size[j][0] = temp;
				}else if(size[i][1]==size[j][1]) {
					if(size[i][0]>size[j][0]) {
						int temp = size[i][1];
						size[i][1] = size[j][1];
						size[j][1] = temp;

						temp = size[i][0];
						size[i][0] = size[j][0];
						size[j][0] = temp;
					}
				}
			}
		}

		for (int i = 0; i < line.size(); i++) {
			System.out.println(line.get(size[i][0]));
		}
	}
	private static String src = "13\r\n" + "but\r\n" + "i\r\n" + "wont\r\n" + "hesitate\r\n" + "no\r\n" + "more\r\n"
			+ "no\r\n" + "more\r\n" + "it\r\n" + "cannot\r\n" + "wait\r\n" + "im\r\n" + "yours";
}