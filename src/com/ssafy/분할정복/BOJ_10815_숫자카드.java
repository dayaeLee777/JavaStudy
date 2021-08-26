package com.ssafy.분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10815
public class BOJ_10815_숫자카드 {

	static int N, M, arrayN[];
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arrayN = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arrayN[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrayN);
		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int input = Integer.parseInt(st.nextToken());
			find(input, 0,N);
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	static void find(int m, int start, int n) {
		if (n <= 1) {
			if (arrayN[start] == m)
				sb.append("1 ");
			else
				sb.append("0 ");
			return;
		}
		int nn = (n+1) / 2;
		if (m >= arrayN[start] && m < arrayN[start + nn]) {
			find(m, start, nn);
		} else if (m >= arrayN[start + nn] && m <= arrayN[start+n-1]) {
			find(m, start + nn, n-nn);
		} else {
			sb.append("0 ");
		}
	}
}
