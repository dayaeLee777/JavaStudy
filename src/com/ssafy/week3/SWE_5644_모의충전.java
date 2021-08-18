package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo&categoryId=AWXRDL1aeugDFAUo&categoryType=CODE&problemTitle=5644&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

public class SWE_5644_모의충전 {

	static String s;
	static StringBuilder sb = new StringBuilder();
	static int T, M, A, Amap[], Bmap[], sum, moveIdx;
	static StringTokenizer st;
	static BC[] bcs;
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };
	static Point Apos, Bpos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			Amap = new int[M + 1];
			Bmap = new int[M + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				Amap[m] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				Bmap[m] = Integer.parseInt(st.nextToken());
			}
			Apos = new Point(0, 0);
			Bpos = new Point(9, 9);

			sum = 0;
			moveIdx = 0;

			bcs = new BC[A];
			for (int a = 0; a < A; a++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcs[a] = new BC(new Point(y - 1, x - 1), c, p);
			}
			check();
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		bw.close();
	}

	static void move(int idx) {
		Apos.x += dx[Amap[idx]];
		Apos.y += dy[Amap[idx]];
		Bpos.x += dx[Bmap[idx]];
		Bpos.y += dy[Bmap[idx]];
	}

	static boolean dist(Point p, BC b) {
		int dist = Math.abs(p.x - b.p.x) + Math.abs(p.y - b.p.y);
		if (dist <= b.C) {
			return true;
		}
		return false;
	}

	static void check() {
		if (moveIdx > M)
			return;

		int[] sumA = new int[bcs.length];
		int[] sumB = new int[bcs.length];

		for (int i = 0; i < bcs.length; i++) {
			// A가 BC 범위안에 있을때
			if (dist(Apos, bcs[i])) {
				sumA[i] = bcs[i].P;
			}
			// B가 BC 범위안에 있을때
			if (dist(Bpos, bcs[i])) {
				sumB[i] = bcs[i].P;
			}
		}

		int max = 0;
		for (int a : sumA) {
			for (int b : sumB) {
				if (a == 0 && b == 0)
					continue;
				int tmp = a + b;
				if (a == b) {
					tmp /= 2;
				}
				max = Math.max(max, tmp);
			}
		}

		for (int a = 0; a < sumA.length; a++) {
			for (int b = 0; b < sumB.length; b++) {
				if (sumA[a] == 0 && sumB[b] == 0)
					continue;
				int tmp = sumA[a] + sumB[b];
				if (a == b) {
					tmp /= 2;
				}
				max = Math.max(max, tmp);
			}
		}
		sum += max;

		move(moveIdx++);
		check();
	}
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}

	static class BC implements Comparable<BC> {
		Point p;
		int C, P;

		public BC() {
			super();
		}

		public BC(Point po, int c, int p) {
			super();
			this.p = po;
			C = c;
			P = p;
		}

		@Override
		public int compareTo(BC o) {
			return this.P - o.P;
		}
	}
}
