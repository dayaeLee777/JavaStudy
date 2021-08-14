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

public class SWE_1204 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static String s;
	static int[] jumsu;
	static int student = 1000;
	static int T, C;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/week1/input_1204.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			C = Integer.parseInt(br.readLine());
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			jumsu = new int[101];
			for (int std = 0; std < student; std++) {
				jumsu[Integer.parseInt(st.nextToken())]++;
			}
			int max = jumsu[0];
			int maxIndex = 0;
			for (int c = 0; c < jumsu.length; c++) {
				if (jumsu[c] >= max) {
					max = jumsu[c];
					maxIndex = c;
				}
			}
			sb.append("#").append(C).append(" ").append(maxIndex).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
