package com.ssafy.그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.naming.LimitExceededException;

public class BOJ_1753_최단경로 {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E, K, parents[], distance[];
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Edge[] edgelist;
	static final int INFINITY = Integer.MAX_VALUE;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine());

		edgelist = new Edge[V + 1];
		distance = new int[V + 1];
		visited = new boolean[V + 1];

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edgelist[e] = new Edge(start, end, weight);
		}
		for (Edge edge : edgelist) {
			Dijkstra(edgelist[K].start, edge.start);
			sb.append(distance[edge.start]).append("\n");
		}
		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	static void Dijkstra(int start, int end) {
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;

		int min = 0, current = 0;
		for (int i = 0; i < V; ++i) {
			// a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			min = INFINITY;
			for (int j = 0; j < V; ++j) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true; // 선택 정점 방문 처리
			if (current == end) { // 선택 정점이 도착정점이면 탈출.
				break;
			}

			// b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for (int c = 0; c < V; ++c) {
				if (!visited[c] && distance[c] > min + edgelist[current].weight) {
					distance[c] = min + edgelist[current].weight;
				}
			}
		}
	}

}
