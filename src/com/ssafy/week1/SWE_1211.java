package com.ssafy.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_1211 {

	static int N = 100;
	static int pos[][] = { { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static StringBuilder sb = new StringBuilder();
	static int[][] radder;

	static int row, col;
	static int result;
	static int nr, nc, res, min, temp;
	static int[] cnt;
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input/week1/input_1211.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 0; T < 10; T++) {
			int t = Integer.parseInt(br.readLine());
			radder = new int[N][N];
			for (int r = 0; r < N; r++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s, " ");
				for (int c = 0; c < N; c++) {
					radder[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = new int[N];
			go: for (int i = 0; i < N; i++) {
				isVisited = new boolean[N][N];
				row = 0;
				col = i;
				while (radder[row][col] == 1) {
					for (int p = 0; p < pos.length; p++) {
						nr = row + pos[p][0];
						nc = col + pos[p][1];
						if (nr >= 0 && nc >= 0 && nr < N && nc < N && isVisited[nr][nc] == false
								&& (radder[nr][nc] == 1)) {
							if (nr >= N - 1) {
								continue go;
							} else {
								isVisited[nr][nc] = true;
								row = nr;
								col = nc;
								cnt[i]++;
								break;

							}
						}
					}
					min = 10000;
					for (int c = 0; c < cnt.length; c++) {
						if (cnt[c] < min && cnt[c] != 0) {
							min = cnt[c];
							res = c;
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
