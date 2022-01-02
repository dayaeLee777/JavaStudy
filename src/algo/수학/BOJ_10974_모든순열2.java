package algo.수학;

import java.util.Scanner;

// boolean 사용
public class BOJ_10974_모든순열2 {
	static int N, input[], numbers[];
	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		input = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0;i<N;i++) {
			input[i] = i+1;
		}
		
		permutation(0);
		
		System.out.println(sb.toString());
		sc.close();
		sc = null;
	}

	static void permutation(int cnt) {
		if (cnt == N) {
			for(int a : numbers)
				sb.append(a).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			numbers[cnt]= input[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
