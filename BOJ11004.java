package assignment1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11004 {
	private static int N;
	private static int K;
	private static int[] number;

	public static void main(String[] args) throws Exception {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			number = new int[N + 5];
			st = new StringTokenizer(in.readLine());
			
			for (int i = 1; i <= N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(selectionSort(1, N));
		}
	}

	public static int selectionSort(int left, int right) {
		if (left == right) {
			return number[left];
		}

		int li = left - 1;
		int ri = right + 1;
		int value = number[(left + right) / 2];

		while (true) {
			while (number[++li] < value);

			while (number[--ri] > value);

			if (li >= ri)
				break;

			int tmp = number[li];
			number[li] = number[ri];
			number[ri] = tmp;
		}

		if (li == ri && li == K) {
			return value;
		}

		if (K < li) {
			return selectionSort(left, li - 1);
		} else {
			return selectionSort(ri + 1, right);
		}
	}
}