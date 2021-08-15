package com.ssafy.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 210815 1608~
public class prof_두더지굴 {
	static int N;
	static Queue<Point> q;
	static ArrayList<Point> arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		N = sc.nextInt();
//		arr = new int[N][N];
		arr = new ArrayList<Point>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (sc.nextInt() == 1)
					arr.add(new Point(r, c));
			}
		}
		q = new LinkedList<Point>();
		q.offer(arr.get(0));
		arr.get(0).size += 1;
		arr.get(0).isVisited = true;
		while (!q.isEmpty()) {
			Point dq = q.poll();
			for (int i = 1; i < arr.size(); i++) {
				if (!arr.get(i).isVisited && Math.abs(arr.get(i).c - dq.c) <= 1 && Math.abs(arr.get(i).r - dq.r) <= 1) {
					arr.get(i).size = dq.size + 1;
					arr.get(i).isVisited = true;
					q.offer(arr.get(i));
					break;
				}
			}
		}
		arr.forEach(a -> System.out.println(a.size));
	}

//	static void bfs(Point p) {
//		Queue<Point> q = new LinkedList<Point>();
//
//		q.offer(p);
//		p.size += 1;
//		while (!q.isEmpty()) {
//			Point dq = q.poll();
//			if (Math.abs(arr.get(i).c - dq.c) <= 1 && Math.abs(arr.get(i).r - dq.r) <= 1) {
//				q.offer(arr.get(i));
//				arr.get(i).size = dq.size + 1;
//				arr.get(i).isVisited = true;
//				pq.add(arr.get(i).size);
//			}
//			}
//		}
//	}

	static class Point {
		int r, c;
		int size;
		boolean isVisited;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.size = 0;
			this.isVisited = false;
		}
	}

}
