package com.ssafy.그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 210815 1608~
public class prof_두더지굴 {
	static int N, map[][];
	static ArrayList<Point> arr;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					cnt++;
					bfs(r, c, cnt + 1);
				}
			}
		}

		int[] size = new int[cnt];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 1)
					size[map[i][j] - 2]++;
			}
		}
		Arrays.sort(size);
		System.out.println(size.length);
		for (int i = size.length - 1; i >= 0; i--)
			System.out.println(size[i]);
		
		sc.close();
		sc = null;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static void bfs(int x, int y, int no) {
		Queue<Point> q = new LinkedList<>();
		map[x][y] = no;
		q.offer(new Point(x, y));

		while (!q.isEmpty()) {
			Point tmp = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = tmp.r + dx[d];
				int nc = tmp.c + dy[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1) {
					map[nr][nc] = no;
					q.offer(new Point(nr, nc));
				}
			}
		}
	}
}
