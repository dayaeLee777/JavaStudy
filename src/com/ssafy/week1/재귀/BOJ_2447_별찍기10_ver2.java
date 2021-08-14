package com.ssafy.week1.재귀;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2447_별찍기10_ver2 {
	static char[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		star(N, 0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] != ' ' ? '*' : ' ');
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void star(int n, int startR, int startC) {
		if (n == 1)
			return;
		
		for (int i = startR; i < startR + n; i++) {
			for (int j = startC; j <  startC + n; j++) {
				if (i >= startR+ n / 3 && i < startR+n / 3 * 2 && j >= startC+ n / 3 && j < startC+ n / 3 * 2) {
					arr[i][j] = ' ';
				}
			}
		}
		if (startR + n == N && startC + n == N) {
			star(n / 3, 0, 0);
			return;
		} else if (startC + n == N) {
			star(n, startR+n, 0);
			return;
		} else {
			star(n, startR, startC+n);
			return;
		}
	}
}
