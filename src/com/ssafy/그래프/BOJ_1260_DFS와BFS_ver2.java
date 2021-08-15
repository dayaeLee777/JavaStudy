package com.ssafy.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_1260_DFS와BFS_ver2 {
	static StringBuilder sb = new StringBuilder();
	static int N, M, V, start, end, map[][];
	static StringTokenizer st;
	static boolean[] isVisited;
	static ArrayList<TreeMap<Integer, Integer>> arr;

	// 인접리스트 활용 -> 연결되는 지점만 가지고 있어서 메모리차지 비율이 적고 시간 복잡도가 줄어듬
	// 단점 => A와 B의 연결상태를 확인하기 위해 A, B 모두 확인해야하는 번거로움 이 있음
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		arr = new ArrayList<TreeMap<Integer, Integer>>();
		isVisited = new boolean[N + 1];

		for (int j = 0; j < N + 1; j++) {
			Arrays.fill(map[j], 0);
			arr.add(new TreeMap<Integer, Integer>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
			arr.get(start).put(end, start);
			arr.get(end).put(start, end);
		}
		dfs(V);
		
		Arrays.fill(isVisited, false);
		System.out.println();
		
		bfs(V);

		br.close();
	}

	static void dfs(int v) {
		isVisited[v] = true;
		System.out.print(v + " ");
		
		TreeMap<Integer, Integer> tmp = arr.get(v);
		
		for(int a:tmp.keySet()) {
			if(isVisited[a] == false)
				dfs(a);
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(v);
		isVisited[v] = true;

		while (!q.isEmpty()) {
			int current = q.poll();
			System.out.print(current + " ");
			
			for (int n = 1; n <= N; n++) {
				if (map[current][n]==1 && isVisited[n] == false) {
					q.offer(n);
					isVisited[n] = true;
				}
			}
		}
	}
}
