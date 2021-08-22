package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2578
public class BOJ_2564_경비원 {

	static int res, R, C, N, posX, posY;
	static StringTokenizer st;
	static Queue<Point> q;
	static Point p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(br.readLine());

		q = new LinkedList<Point>();

		res = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.offer(setPos(x, y));
		}

		st = new StringTokenizer(br.readLine(), " ");
		p = setPos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			if ((Math.abs(p.r - tmp.r) == R || Math.abs(p.c - tmp.c) == C)) {
				int clockwise = R - p.r + R - tmp.r + C - p.c + C - tmp.c;
				int counter = p.r + tmp.r + p.c + tmp.c;
				res += Math.min(clockwise, counter);
				continue;
			} else {
				res += (Math.abs(p.r - tmp.r) + Math.abs(p.c - tmp.c));
				continue;
			}
		}
		System.out.println(res);

		br.close();
	}

	static Point setPos(int n, int x) {
		int r = 0, c = 0;
		switch (n) {
		case 1:
			r = 0;
			c = x;
			break;
		case 2:
			r = R;
			c = x;
			break;
		case 3:
			r = x;
			c = 0;
			break;
		case 4:
			r = x;
			c = C;
			break;
		}
		return new Point(r, c);
	}

	static private class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
