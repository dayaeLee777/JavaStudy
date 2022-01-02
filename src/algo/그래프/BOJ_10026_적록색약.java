package algo.그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10026
public class BOJ_10026_적록색약 { 

	static int N, result;
	static char map[][];
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean visited[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		bfs();
		sb.append(result).append(" ");
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 'R')
					map[r][c] = 'G';
			}
		}
		
		bfs();
		sb.append(result).append(" ");

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs() {
		visited = new boolean[N][N];
		result = 0;
		while (true) {
			boolean flag = true;
			Queue<Point> q = new LinkedList<Point>();
			go: for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (visited[r][c])
						continue;
					q.offer(new Point(r, c, map[r][c]));
					result++;
					flag = false;
					break go;
				}
			}

			if (flag)
				return;

			while (!q.isEmpty()) {
				Point cur = q.poll();

				if (visited[cur.x][cur.y])
					continue;
				visited[cur.x][cur.y] = true;

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (!check(nx, ny))
						continue;
					if (cur.color == map[nx][ny])
						q.offer(new Point(nx, ny, map[nx][ny]));
				}
			}
		}
	}

	static private class Point {
		int x, y;
		char color;

		public Point(int x, int y, char color) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}

	static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		else
			return false;
	}
}
