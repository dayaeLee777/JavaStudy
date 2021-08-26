package com.ssafy.분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {

	static int N, M, arrayN[], arrayM[], result[];
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arrayN = new int[N];
		arrayM = new int[M];
		result = new int[N + M];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arrayN[n] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			arrayM[m] = Integer.parseInt(st.nextToken());
		}
		merge(0, 0);
		for (int i = 0; i < N + M; i++)
			sb.append(result[i]).append(" ");

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	static void merge(int n, int m) {
		if (n >= N && m >= M)
			return;

		else if (n >= N) {
			result[n + m] = arrayM[m];
			merge(n, m + 1);
		}

		else if (m >= M) {
			result[n + m] = arrayN[n];
			merge(n + 1, m);
		}

		else if (arrayN[n] < arrayM[m]) {
			result[n + m] = arrayN[n];
			merge(n + 1, m);
		} else {
			result[n + m] = arrayM[m];
			merge(n, m + 1);
		}

	}

}
