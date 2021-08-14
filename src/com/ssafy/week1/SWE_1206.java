package com.ssafy.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWE_1206 {
	// 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] apart;
	static int i, sum, a1, a2, a3, a4, T;
	static String s;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/week1/input_1206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int n = 1; n <= 10; n++) {
			T = Integer.parseInt(br.readLine());
			apart = new int[T];
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int t = 0; t < T; t++) {
				apart[t] = Integer.parseInt(st.nextToken());
			}
			i = 2;
			sum = 0;
			while (i < T - 2) {
				a1 = apart[i] - apart[i - 2];
				a2 = apart[i] - apart[i - 1];
				a3 = apart[i] - apart[i + 1];
				a4 = apart[i] - apart[i + 2];
				if (a1 >= 1 && a2 >= 1 && a3 >= 1 && a4 >= 1) {
					sum += Math.min(a1, Math.min(a2, Math.min(a3, a4)));
					i = i + 2;
				}
				i++;
			}
			sb.append("#").append(n).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
