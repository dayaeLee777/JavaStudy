package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17136
public class BOJ_17136_색종이붙이기 {

	static String s;
	static StringBuilder sb = new StringBuilder();
	static int N, paper[][];
	static StringTokenizer st;
	static boolean isfilled;
	static ArrayList<Point> pArr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		pArr = new ArrayList<>();
		paper = new int[10][10];
		for (int n = 0; n < 10; n++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int m = 0; m < 10; m++) {
				paper[n][m] = Integer.parseInt(st.nextToken());
				if (paper[n][m] == 1) {
					pArr.add(new Point(n, m));
				}
			}

		}

		System.out.println(pArr.toString());

		find(0, 0);

		System.out.println(pArr.toString());
		pArr.sort(null);

		System.out.println(pArr.toString());

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		bw.close();
	}

	static boolean check(Point p, int size) {
		if (p.r + size >= 10 || p.c + size >= 10)
			return false;
		for (int i = p.r; i <= p.r + size; i++) {
			if (p.c + size < 10 && paper[i][p.c + size] != 1)
				return false;
		}
		for (int j = p.c; j <= p.c + size; j++) {
			if (p.r + size < 10 && paper[p.r + size][j] != 1)
				return false;
		}
		return true;
	}

	static void find(int i, int size) {
		if (i >= pArr.size())
			return;
		Point p = pArr.get(i);
		if (size == 5 || !check(p, size)) {
			pArr.get(i).size = size;
			return;
		} else {
			for (int a = i; a < pArr.size(); a++) {
				find(a, size + 1);
			}
		}
	}

	static class Point implements Comparable<Point> {
		int r, c;
		int size;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.size = 0;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", size=" + size + "]";
		}

		@Override
		public int compareTo(Point o) {
			int value = (this.size - o.size) * -1;
			if (value == 0)
				return this.r - o.r;
			return value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + c;
			result = prime * result + r;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
	}
}
