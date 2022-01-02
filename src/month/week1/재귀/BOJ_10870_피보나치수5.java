package month.week1.재귀;

import java.util.Scanner;

public class BOJ_10870_피보나치수5 {
	private static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new int[N+1];
		System.out.println(fibo(N));
	}

	private static int fibo(int i) {
		if (i == 0) {
			memo[0] = 0;
		}
		if (i == 1)
			memo[1] = 1;
		if (i >= 2 && memo[i] == 0)
			memo[i] = fibo(i - 1) + fibo(i - 2);
		return memo[i];
	}
}
