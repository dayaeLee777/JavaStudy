package com.ssafy.수학;

import java.util.Scanner;

public class BOJ_1182_부분수열의합 {
	static int N, S, input[], tmp, res, res2;
	static int numbers[];
	static boolean isSelected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		for (int n = 0; n < N; n++) {
			input[n] = sc.nextInt();
		}
		numbers = new int[N];
		isSelected = new boolean[N];
		comb();

		res2 = 0;
		comb2(0, 0, 0);
//		System.out.println(res);
		System.out.println(res2);

		sc.close();
		sc = null;
	}

	static void comb() {
		for (int i = 0; i < (1 << N); i++) {
			tmp = 0;
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					cnt++;
					tmp += input[j];
				}
			}
			if (cnt != 0 && tmp == S) {
				res++;
			}
		}
	}

	static void comb2(int idx, int sum, int cnt) {
		if (sum == S && cnt > 0) {
			res2++;
			return;
		}
		if (idx == N)
			return;

		isSelected[idx] = true;
		comb2(idx + 1, sum + input[idx], cnt + 1);
		isSelected[idx] = false;
		comb2(idx + 1, sum, cnt);

	}

	static int count(int v) {
		int cnt = 0;
		while (v > 0) {
			if ((v & 1) == 1) {
				cnt++;
			}
			v = v >> 1;
		}
		return cnt;
	}

}
