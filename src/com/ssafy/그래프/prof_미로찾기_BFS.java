package com.ssafy.그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class prof_미로찾기_BFS {
	static int H, W, cnt, isVisited[][];
	static char[][] arr;
	static String s;
	static Point S, G;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		H = sc.nextInt();
		W = sc.nextInt();
		arr = new char[H][W];
		isVisited = new int[H][W];

		for (int h = 0; h < H; h++) {
			s = sc.next();
			for (int w = 0; w < W; w++) {
				arr[h][w] = s.charAt(w);
				if (arr[h][w] == 'S')
					S = new Point(h, w);
				if (arr[h][w] == 'G')
					G = new Point(h, w);
			}
		}
		cnt = 0;
		bfs(S);
		if (isVisited[G.x][G.y] <= 0)
			System.out.println(-1);
		
		System.out.println(isVisited[G.x][G.y]);
		sc.close();
		sc = null;
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bfs(Point p) {
		Queue<Point> q = new LinkedList<Point>();

		q.offer(p);
		isVisited[p.x][p.y] = 1;

		while (!q.isEmpty()) {
			Point tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < H && ny < W && isVisited[nx][ny] == 0) {
					if (arr[nx][ny] == '.') {
						isVisited[nx][ny] = isVisited[tmp.x][tmp.y] + 1;
						q.offer(new Point(nx, ny));
					}
					if (arr[nx][ny] == 'G') {
						isVisited[nx][ny] = isVisited[tmp.x][tmp.y];
						return;
						}
					
				}
			}
		}

	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

/*
 * 
 * 
 * 5 5
#S###
#...#
#.#.#
#....
###G#
 */