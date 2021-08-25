//package com.ssafy.그래프;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class BOJ_1753_최단경로 {
//
//	static private class Edge implements Comparable<Edge> {
//		int start, end, weight;
//
//		public Edge(int start, int end, int weight) {
//			super();
//			this.start = start;
//			this.end = end;
//			this.weight = weight;
//		}
//
//		public Edge(int start, int weight) {
//			super();
//			this.start = start;
//			this.weight = weight;
//		}
//
//		@Override
//		public int compareTo(Edge o) {
//			return Integer.compare(this.weight, o.weight);
//		}
//	}
//
//	static int V, E, K, distance[];
//	static StringBuilder sb = new StringBuilder();
//	static StringTokenizer st;
//	static Edge[] edgelist;
//	static final int INFINITY = Integer.MAX_VALUE;
//	static boolean visited[];
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		st = new StringTokenizer(br.readLine(), " ");
//		V = Integer.parseInt(st.nextToken());
//		E = Integer.parseInt(st.nextToken());
//
//		K = Integer.parseInt(br.readLine());
//
//		edgelist = new Edge[E];
//
//		for (int e = 0; e < E; e++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			int weight = Integer.parseInt(st.nextToken());
//
//			edgelist[e] = new Edge(start, end, weight);
//		}
//		distance = new int[V + 1];
//		visited = new boolean[V + 1];
//		Dijkstra(K);
//
//		for (int i = 1; i <= V; i++) {
//			int a = distance[i];
//			if (a != INFINITY)
//				sb.append(a).append("\n");
//			else
//				sb.append("INF\n");
//		}
////		System.out.println(Arrays.toString(distance));
////			sb.append(distance[edge.start]).append("\n");
//		bw.write(sb.toString());
//
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//
//	static void Dijkstra(int start) {
//		Arrays.fill(distance, INFINITY);
//		distance[start] = 0;
//		visited[start] = true;
//
//		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return distance[o1] - distance[o2];
//			}
//
//		});
//		for (int i = 1; i <= V; i++) {
//			q.offer(i);
//		}
//
//		while (!q.isEmpty()) {
//			int u = q.poll();
//
//			for (int i = 0; i < E; i++) {
//				Edge ed = edgelist[i];
//				if (!visited[ed.end] && u == ed.start && distance[u] + ed.weight < distance[ed.end]) {
//					distance[ed.end] = distance[u] + ed.weight;
//					visited[ed.end] = true;
//				}
//			}
//
//		}
//	}
//
//}
