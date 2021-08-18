package com.ssafy.IM;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17136
public class BOJ_17136_색종이붙이기 {

	static String s;
	static StringBuilder sb = new StringBuilder();
	static int N, paper[][];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Point> pArr = new ArrayList<>();
		for (int n = 0; n < 10; n++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int m = 0; m < 10; m++) {
				paper[n][m] = Integer.parseInt(st.nextToken());
				if (paper[n][m] == 1) {
					pArr.add(new Point(n, m));
				}
			}

		}

		find(pArr);

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		bw.close();
	}

	static void find(ArrayList<Point> pa) {
		pa.forEach(i -> {
			boolean isOne = true;
			int cnt = 0;
			while (isOne) {
				for (int x = 0; x < cnt; x++) {
					for (int y = 0; y < cnt; y++) {
						if (i.r + x < 10 && i.c + y < N) {
							if (paper[i.r + x][i.c + y] != 1) {
								isOne = false;
							}
						}
					}
				}
				cnt++;

			}

		});
	}

	class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
}
