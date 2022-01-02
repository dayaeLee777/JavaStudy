package IM대비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17136

public class BOJ_17136_색종이붙이기 {

	static String s;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, paper[][], res;
	static int[] papercnt = { 5, 5, 5, 5, 5 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		paper = new int[10][10];
		for (int n = 0; n < 10; n++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int m = 0; m < 10; m++) {
				paper[n][m] = Integer.parseInt(st.nextToken());
				if (paper[n][m] == 1) {
				}
			}

		}
		res = Integer.MAX_VALUE;
		dfs(0,0,0);
		if(res==Integer.MAX_VALUE)
			res=-1;
		sb.append(res);
		bw.write(sb.toString());

		bw.flush();
		bw.close();
		bw.close();
	}

	static boolean check(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (i < 0 || i >= 10 || j <0 || j>=10 || paper[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	// 색종이를 떼고 붙여가며 붙인 갯수를 구하기
	static void dfs(int r, int c, int sum) {
		if (r >= 9 && c > 9) {
			res = Math.min(res, sum);
			return;}
		if (res <= sum) {
			return;
		}
		if (c > 9) {
			dfs(r + 1, 0, sum);
			return;
		}

		if (paper[r][c] == 1) {
			for (int i = 4; i >= 0; i--) {
				if (papercnt[i] > 0 && check(r, c, i+1)) {
					attack(r, c, i+1);
					papercnt[i]--;
					dfs(r, c+1, sum+1);
					cut(r,c,i+1);
					papercnt[i]++;
				}

			}
		}
		else
			dfs(r, c+1, sum);

	}

	// 색종이 붙이기
	static void attack(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = 0;
			}
		}
	}

	// 색종이 떼기
	static void cut(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = 1;
			}
		}
	}

}
