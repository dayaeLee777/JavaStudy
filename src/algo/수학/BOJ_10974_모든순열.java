package algo.수학;

import java.util.Scanner;

// 비트연산 사용
public class BOJ_10974_모든순열 {
	static int N, input[], numbers[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		input = new int[N];
		numbers = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i] = i+1;
		}
		
		permutation(0, 0);
		
		System.out.println(sb.toString());
		sc.close();
		sc = null;
	}

	static void permutation(int cnt, int flag) {
		if (cnt == N) {
			for(int a : numbers)
				sb.append(a).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			numbers[cnt]= input[i];
			permutation(cnt+1, flag | (1<<i));
		}
	}
}
