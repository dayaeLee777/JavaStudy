package com.ssafy.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SWE_1209 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static String s;
	static int[][] arr;
	static int N = 100;
	static int T, C, rowSum, colSum, xSum, rxSum;
	static List<Integer> result;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/week1/input_1209.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= 10; t++) {
			result = new ArrayList<>();
			C = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				s = br.readLine();
				st = new StringTokenizer(s, " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				rowSum = 0;
				colSum = 0;
				xSum = 0;
				rxSum = 0;
				for (int j = 0; j < N; j++) {
					rowSum += arr[i][j];
					colSum += arr[j][i];
				}
				result.add(rowSum);
				result.add(colSum);
				xSum += arr[i][i];
				rxSum += arr[i][N - i - 1];
			}
			result.add(xSum);
			result.add(rxSum);
			result.sort(Comparator.reverseOrder());
			sb.append("#").append(C).append(" ").append(result.get(0)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
