package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2477
public class BOJ_2527_직사각형 {
	static StringTokenizer st;
	static char res;
	static List<Point> square;
	static StringBuilder sb = new StringBuilder();
	static int x1,x2,y1,y2,tx1,tx2,ty1,ty2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
//			square = new ArrayList<>();
//			st = new StringTokenizer(br.readLine());
//
//			for (int j = 0; j < 2; j++) {
//				int x = Integer.parseInt(st.nextToken());
//				int y = Integer.parseInt(st.nextToken());
//				int x2 = Integer.parseInt(st.nextToken());
//				int y2 = Integer.parseInt(st.nextToken());
//
//				square.add(new Point(x, y, x2, y2));
//			}
//
//			square.sort(null);
////			square.forEach(a->System.out.println(a));
//			int preX = square.get(0).x1;
//			int preY = square.get(0).y1;
//			int postX = square.get(1).x2;
//			int postY = square.get(1).y2;
//			if (preX < postX && preY < postY)
//				res = 'a';
//			else if (preX > postX || preY > postY)
//				res = 'd';
//			else if (preX == postX && preY == postY)
//				res = 'c';
//			else
//				res = 'b';
//
//			sb.append(res).append("\n");
			

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            tx1 = Integer.parseInt(st.nextToken());
            ty1 = Integer.parseInt(st.nextToken());
            tx2 = Integer.parseInt(st.nextToken());
            ty2 = Integer.parseInt(st.nextToken());

            sb.append(check(x1, y1, x2, y2, tx1, ty1, tx2, ty2) + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
		br.close();
	}
	
	 static private String check(int x1, int y1, int x2, int y2, int tx1, int ty1, int tx2, int ty2) {
	        if ((x2 == tx1 && y2 == ty1) || (x1 == tx2 && y2 == ty1) || (x2 == tx1 && y1 == ty2) || (x1 == tx2 && y1 == ty2)) {
	            return "c";
	        } else if ((x2 == tx1 && y2 != ty1) || (x1 == tx2 && y2 != ty1) || (x2 != tx1 && y1 == ty2) || (x1 != tx2 && y1 == ty2)) {
	            return "b";
	        } else if (x2 < tx1 || tx2 < x1 || y2 < ty1 || ty2 < y1) {
	            return "d";
	        } else {
	            return "a";
	        }
	    }

	private static class Point implements Comparable<Point> {
		int x1, y1, x2, y2;

		public Point(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		@Override
		public int compareTo(Point o) {
			int val = o.x1 - this.x1;
			if (val == 0)
				return (o.y1 - this.y1);
			return val;
		}

		@Override
		public String toString() {
			return "Point [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
		}

	}
}
