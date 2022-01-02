package algo.그래프;

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

public class BOJ_1753_최단경로2 {

	static private class Edge implements Comparable<Edge> {
		int end, weight;

		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E, K, distance[];
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static final int INFINITY = Integer.MAX_VALUE;
	static boolean visited[];
	// 입력 사이즈때문에 인접리스트 활용
	static List<Edge>[] edgelist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine());
		
		edgelist = new ArrayList[V+1];
		// 인접리스트 초기화
		for(int i=1; i<=V; i++) {
			edgelist[i] = new ArrayList<>();
        }

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 각 정점에 해당하는 간선 추가
			edgelist[start].add(new Edge(end, weight));
		}
		distance = new int[V + 1];	// start 지점에서 각 정점까지의 최단거리가 입력될 배열
		visited = new boolean[V + 1];	// 각 정점이 방문되었는지 확인할 배열
		
		Dijkstra(K);

		for (int i = 1; i <= V; i++) {
			int a = distance[i];
			if (a != INFINITY)
				sb.append(a).append("\n");
			else
				sb.append("INF\n");
		}
		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	/*
	 * 데이크스트라의 원래 알고리즘은 우선순위 큐를 사용하지 않았기 때문에 시간 복잡도가 O(V^2)(V:정점 수)
	 * 최소 우선 큐에 기반한 알고리즘은 피보나치 힙으로 수행되며 시간복잡도는 Fredman & Tarjan 1984 때문에 O(E+ VlogV)(E: 간선수)
	 */
	static void Dijkstra(int start) {
		// 속도향상을 위해 우선순위큐 활용
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();

		Arrays.fill(distance, INFINITY);	//distance 배열을 무한대로 초기화(아직 길이를 모르기때문)
		
		distance[start] = 0;	// start 정점은 0으로 초기화(나자신에서 나자신으로 가는 거리=0)
		
		q.add(new Edge(start, 0));	// 우선순위큐에 start,0 값 추가

		while (!q.isEmpty()) {
			Edge u = q.poll();	// 가중치가 가장 작은 간선 꺼냄
			
			if(visited[u.end]) continue;	// 이미 방문했던 정점이면 다음으로 넘어감
			
			visited[u.end] = true;		// 이미 방문했던 정점이 아니면 방문처리
			
			// 경로 완화
			for (Edge ed : edgelist[u.end]) {	// u 정점과 연결된 정점들 탐색
				if (distance[u.end] + ed.weight < distance[ed.end]) {	// ed까지의 더 짧은 정점을 찾으면
					distance[ed.end] = distance[u.end] + ed.weight;
					q.offer(new Edge(ed.end, distance[ed.end]));	// 해당 정점과 distance[]값을 큐에 추가
				}
			}

		}
	}

}
