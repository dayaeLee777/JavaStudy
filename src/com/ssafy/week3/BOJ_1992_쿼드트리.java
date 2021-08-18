package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1992

public class BOJ_1992_쿼드트리 {

	static String s;
	static StringBuilder sb = new StringBuilder();
	static int N, res, map[][];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int x = 0; x < N; x++) {
			s = br.readLine();
			for (int y = 0; y < N; y++) {
				map[x][y] = s.charAt(y) - '0';
			}
		}
		
		resize(0, 0, N);

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		bw.close();
	}

	static boolean check(int x, int y, int size) {
		int v = map[x][y];

		for (int i = x; i < x+size; i++)
			for (int j = y; j < y+size; j++)
				if (map[i][j] != v)
					return false;
		return true;
	}

	static void resize(int x, int y, int size) {
		if (check(x, y, size)) {
			sb.append(map[x][y]);
			return;
		}
		sb.append("(");

		resize(x, y, size / 2);
		resize(x, y + size / 2, size / 2);
		resize(x + size / 2, y, size / 2);
		resize(x + size / 2, y + size / 2, size / 2);

		sb.append(")");
	}
}
