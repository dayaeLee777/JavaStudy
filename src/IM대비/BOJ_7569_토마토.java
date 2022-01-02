package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7569
// BFS 문제
public class BOJ_7569_토마토 {
	// res : 결과값 => 토마토가 익는 시간
	// tomato : 현재 토마토 상태를 넣을 2차원 배열
	static int M, N, H, res, tomato[][][];
	static StringTokenizer st;
	static int dx[] = { -1, 1, 0, 0, 0, 0}; // 토마토가 익을 때 탐색을 위한 배열
	static int dy[] = { 0, 0, -1, 1, 0,0 };
	static int dz[] = { 0, 0, 0, 0, -1, 1 };
	static ArrayList<Point> tl; // 익은 토마토를 저장할 ArrayList
	static boolean isFull; // 초기에 토마토 꽉 차있는지 확인하기 위함

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		tomato = new int[H][M][N];
		tl = new ArrayList<>();
		isFull = true;
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < M; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					tomato[h][r][c] = Integer.parseInt(st.nextToken());
					if (isFull && tomato[h][r][c] == 0) // 입력된 값에 안익은 토마토가 없는지 확인
						isFull = false;
					if (tomato[h][r][c] == 1) { // 익은 토마토가 있으면 tl에 저장
						tl.add(new Point(h, r, c));
					}

				}
			}
		}
		res = 0;

		if (!isFull) {
			ripe(tl);
			res = res == 0 ? -1 : res;
		}

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (tomato[h][r][c] == 0) {
						res = -1;
						break;
					}
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
				for (int d = 0; d < 6; d++) {
					int nx = tmp.r + dx[d];
					int ny = tmp.c +dy[d];
					int nh = tmp.h +dz[d];

					if (nx >= 0 && nx < M && ny >= 0 && ny < N && nh >=0 && nh<H) {
						if (tomato[nh][nx][ny] == 0) {
							tomato[nh][nx][ny] = 1;
							isChanged = true;
							a.offer(new Point(nh, nx, ny));
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
		int r, c, h;

		public Point(int h, int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", h=" + h + "]";
		}
	}
}
