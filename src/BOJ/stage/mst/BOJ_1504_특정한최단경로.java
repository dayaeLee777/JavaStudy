package BOJ.stage.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {

	static int N, E, go[], distance[];
	static StringTokenizer st;
	static ArrayList<Edge>[] list;
	static final int INFINITY = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		go = new int[2];

		for (int n = 0; n < N + 1; n++)
			list[n] = new ArrayList<Edge>();

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Edge(en, w));
			list[en].add(new Edge(s, w));

		}

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 2; i++)
			go[i] = Integer.parseInt(st.nextToken());

		int mid = move(go[0], go[1]);
		int a = move(1, go[0]) + move(go[1], N);
		a = a < 0 ? INFINITY : a;
		int b = move(1, go[1]) + move(go[0], N);
		b = b < 0 ? INFINITY : b;
		int res = Math.min(a, b);
		if (res == INFINITY || mid == INFINITY)
			System.out.println(-1);
		else
			System.out.println(res + mid);
	}

	private static int move(int start, int end) {
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;

		int min = 0, current = 0;

		for (int i = 1; i < N + 1; i++) {
			min = INFINITY;
			for (int j = 1; j < N + 1; ++j) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true; 
			if (current == end)
				break;

			for (Edge e : list[current]) {
				if (!visited[e.end] && distance[e.end] > min + e.weight)
					distance[e.end] = min + e.weight;
			}
		}
		return distance[end];
	}

	private static class Edge {
		int end;
		int weight;

		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
	}

}
