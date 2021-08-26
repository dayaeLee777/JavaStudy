package com.ssafy.그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWE_1251_하나로2 {

	static class Edge implements Comparable<Edge> {
		int start, end;
		double weight;

		public Edge(int start, int end, double weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}

	static class Island {
		int x, y;

		public Island() {
			super();
		}

		public Island(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int[] parents; // 부모 원소를 관리(트리처럼 사용)

	private static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	// a가 속한 집합으 ㅣ대표자 찾기
	private static int find(int a) {
		if (a == parents[a])
			return a; // 자신이 대표자일 경우
		return parents[a] = find(parents[a]);
	}

	// 두 원소를 하나의 집합으로 합치기(대표자를 이용하여 합침)
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false; // 이미 같은 집합이므로 합치지 않음

		parents[bRoot] = aRoot;
		return true;
	}

	static int T, N;
	static double E;
	static Island[] islandList;
	static List<Edge> edgelist;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Edge> pd;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			islandList = new Island[N];
			pd = new PriorityQueue<>();

			for (int n = 0; n < N; n++) {
				islandList[n] = new Island();
			}

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int n = 0; n < N; n++) {
				islandList[n].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int n = 0; n < N; n++) {
				islandList[n].y = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(in.readLine());

			edgelist = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					double a = E * (Math.pow(islandList[i].x - islandList[j].x, 2)
							+ Math.pow(islandList[i].y - islandList[j].y, 2));
					pd.offer(new Edge(i, j, a));
				}
			}

			edgelist.sort(null); // 오름차순 정렬

			make(); // 모든 정점을 각각으로 집합으로 만들고 출발

			// 간선 하나씩 시도하며 트리만들어감
			int cnt = 0;
			double result = 0;
			while (!pd.isEmpty()) {
				Edge edge = pd.poll();
				if (union(edge.start, edge.end)) {
					result += edge.weight;
					if (++cnt == N - 1)
						break;
				}
			}
//			result = (result*10);
			long res = (long) (result*10) / 10;
//			sb.append("#").append(t).append(" ").append(Math.round(result)).append("\n");
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		in.close();
	}
}
