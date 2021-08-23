package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2477
public class BOJ_2477_참외밭 {
	static int res, bingo[][], N;
	static StringTokenizer st;
	static List<Fruit> fl;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		fl = new ArrayList<Fruit>();
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			fl.add(new Fruit(dir, size));
		}
		int maxH = 0, maxW = 0;
		int h = 0, w = 0;
		for (int i = 0; i < 6; i++) {
			Fruit f = fl.get(i);
			if (f.dir == 3 || f.dir == 4) {
				if (maxH < f.size) {
					maxH = f.size;
					h = i;
				}
				continue;
			}
			if (f.dir == 1 || f.dir == 2) {
				if (maxW < f.size) {
					maxW = f.size;
					w = i;
				}
				continue;
			}
		}

		if (w == (h + 1) % 6) {
			res = maxH * maxW - (fl.get((h + 4) % 6).size * fl.get((w + 2) % 6).size);
		} else if (h == (w + 1) % 6) {
			res = maxH * maxW - (fl.get((h + 2) % 6).size * fl.get((w + 4) % 6).size);
		}

		System.out.println(res * N);

		br.close();
	}

	private static class Fruit {
		int dir, size;

		public Fruit(int dir, int size) {
			super();
			this.dir = dir;
			this.size = size;
		}
	}
}
