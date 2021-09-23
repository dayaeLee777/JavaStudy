package stage.backtracking;

import java.util.Scanner;

public class BOJ_9663_NQueen {

	static int N, map[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		queen(0, 0, 0);

		System.out.println(sb.toString());
	}

	private static void queen(int x, int y, int cnt) {
		if (cnt == N) {

			return;
		}
	}
}
