package stage.dp;

import java.util.Scanner;

public class BOJ_2579_계단오르기 {

	static int[] stair;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		stair = new int[N + 1];
		for (int n = 1; n < N + 1; n++)
			stair[n] = sc.nextInt();
		
		System.out.println(calStair(N));

	}

	private static int calStair(int n) {
		int sum[][] = new int[3][n + 1];

		sum[0][1] = stair[1];
		sum[1][1] = stair[1];
		sum[0][2] = stair[1];
		sum[1][2] = stair[1] + stair[2];
		sum[2][2] = stair[2];

		int tmp = n % 3;

		for (int i = 3; i < n+1; i++) {
			sum[0][i] = sum[0][i - 1];
			sum[1][i] = sum[1][i - 1];
			sum[2][i] = sum[2][i - 1];
			if (i % 3 != 2)
				sum[0][i] += stair[i];
			if (i % 3 != 0)
				sum[1][i] += stair[i];
			if (i % 3 != 1)
				sum[2][i] += stair[i];
		}
		int res = Integer.MIN_VALUE;
		for(int i=0;i<3;i++) {
			if(tmp!=i%3 && res < sum[i][n])
				res = sum[i][n];
		}
		return res;
	}

}
