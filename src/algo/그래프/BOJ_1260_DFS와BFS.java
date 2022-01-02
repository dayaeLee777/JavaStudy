package algo.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static StringBuilder sb = new StringBuilder();
	static int N, M, V, start, end, map[][];
	static StringTokenizer st;
	static boolean[] isVisited;

	// 인접행렬 활용 -> 꼭지점(vertex)가 적은 경우에만 사용
	// => v 갯수가 많아지는 만큼 탐색시간이 오래걸림
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		isVisited = new boolean[N+1];
				
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
 			map[start][end] = 1;
 			map[end][start] = 1;
		}
		dfs(V);
		System.out.println();
		
		Arrays.fill(isVisited, false);
		bfs(V);
		
		br.close();
	}

	static void dfs(int v) {
		isVisited[v] = true;
		System.out.print(v + " ");
		
		for(int n=1; n<N+1;n++) {
			if(map[v][n] == 1 && isVisited[n] == false)
				dfs(n);
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(v);
		isVisited[v]=true;
		
		while (!q.isEmpty()) {
			int current = q.poll();
			for (int n = 0; n < N+1; n++) {
				if (map[current][n]==1 && isVisited[n]==false) {
					q.offer(n);
					isVisited[n] = true;
				}
			}
			System.out.print(current + " ");
		}
	}
}

