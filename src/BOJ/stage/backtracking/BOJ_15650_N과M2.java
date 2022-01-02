package BOJ.stage.backtracking;

import java.util.Scanner;

public class BOJ_15650_N과M2 {

	static int N, M, num[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[M];
		bt(0,0);
		
		System.out.println(sb.toString());
	}

	private static void bt(int idx, int cnt) {
		if (cnt == M) {
			for (int a : num)
				sb.append(a).append(" ");
			sb.append("\n");
			
			return;
		}
		
		for (int i = idx; i < N; i++) {
			num[cnt] = i+1;
			bt(i+1, cnt+1);
		}
	}
}
