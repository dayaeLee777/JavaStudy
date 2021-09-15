package stage.backtracking;

import java.util.Scanner;

public class BOJ_15652_N과M4 {

	static int N, M, num[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[M];
		bt(0);

		System.out.println(sb.toString());
	}

	private static void bt(int cnt) {
		if (cnt == M) {
			for (int a : num)
				sb.append(a).append(" ");
			sb.append("\n");

			return;
		}

		for (int i = 0; i < N; i++) {
			if (cnt != 0 && num[cnt - 1] > i + 1)
				continue;
			num[cnt] = i + 1;
			bt(cnt + 1);

		}
	}
}
