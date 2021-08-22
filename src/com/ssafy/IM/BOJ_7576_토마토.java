package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2605
// BFS 문제
public class BOJ_7576_토마토 {
	// res : 결과값 => 토마토가 익는 시간
	// tomato : 현재 토마토 상태를 넣을 2차원 배열
	static int R, C, res, tomato[][];
	static StringTokenizer st;
	static int dx[] = { -1, 1, 0, 0 };	// 토마토가 익을 때 탐색한 4방
	static int dy[] = { 0, 0, -1, 1 };
	static ArrayList<Point> tl;		// 익은 토마토를 저장할 ArrayList
	static boolean isFull;		// 초기에 토마토 꽉 차있는지 확인하기 위함

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		tomato = new int[R][C];
		tl = new ArrayList<>();
		isFull = true;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				tomato[r][c] = Integer.parseInt(st.nextToken());
				if (isFull && tomato[r][c] == 0)	// 입력된 값에 안익은 토마토가 없는지 확인
					isFull = false;
				if (tomato[r][c] == 1) {	// 익은 토마토가 있으면 tl에 저장
					tl.add(new Point(r, c));
				}

			}
		}
		res = 0;

		if (!isFull) {
			ripe(tl);
			res = res == 0 ? -1 : res;
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(tomato[r][c] == 0) {
					res = -1;
					break;
				}
			}
		}
		System.out.println(res);
		br.close();
	}

	// 토마토를 익히는 과정 : BFS
	static void ripe(ArrayList<Point> t) {

		Queue<Point> a = new LinkedList<>();
		t.forEach(i -> a.offer(i));
		
		// 너비우선탐색 반복
		while (!a.isEmpty()) {
			boolean isChanged = false;
			int size = a.size();
			for (int c = 0; c < size; c++) {
				Point tmp = a.poll();
				for (int d = 0; d < 4; d++) {
					int nx = tmp.r + dx[d];
					int ny = tmp.c + dy[d];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
						if (tomato[nx][ny] == 0) {
							tomato[nx][ny] = 1;
							isChanged = true;
							a.offer(new Point(nx, ny));
						}
					}
				}
			}
			// 원한는 연산이 들어가는 부분
			if (isChanged)
				res++;
		}
	}

	static private class Point {
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
