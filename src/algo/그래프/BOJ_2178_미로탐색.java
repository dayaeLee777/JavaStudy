package algo.그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// https://www.acmicpc.net/problem/2178

public class BOJ_2178_미로탐색 {

	static int N, M, maze[][];
	static boolean[][] isVisited;
	static String s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		maze = new int[N][M];
		isVisited = new boolean[N][M];
		for (int n = 0; n < N; n++) {
			s = sc.next();
			for (int m = 0; m < M; m++) {
				maze[n][m] = s.charAt(m) - 48;
			}
		}

		bfs(new Point(0, 0));
		System.out.println(maze[N - 1][M - 1]);
		
		sc.close();
		sc = null;
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static public void bfs(Point p) {
		Queue<Point> q = new LinkedList<Point>();

		q.offer(p);
		isVisited[p.r][p.c] = true;

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int nr, nc;
			for (int i = 0; i < 4; i++) {
				nr = tmp.r + dx[i];
				nc = tmp.c + dy[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && maze[nr][nc] == 1 && isVisited[nr][nc] == false) {
					isVisited[nr][nc] = true;
					q.offer(new Point(nr, nc));
					maze[nr][nc] = maze[tmp.r][tmp.c] + 1;
					if (nr == N - 1 && nc == M - 1) {
						return;
					}
					continue;
				}
			}
		}
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
