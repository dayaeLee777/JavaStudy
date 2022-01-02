package algo.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	static int N, map[][], cnt, no;
	static PriorityQueue<Integer> pq;
	static String s;
	static ArrayList<Vertex> house;
	static ArrayList<Integer> count;
	static boolean isVisited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N][N];
		house = new ArrayList<Vertex>();
		pq = new PriorityQueue<>();

		for (int r = 0; r < N; r++) {
			s = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = s.charAt(c) - '0';
				if (map[r][c] == 1)
					house.add(new Vertex(r, c));
			}
		}
		no=1;
		bfs(house.get(0));
		System.out.println(pq.size());
		while(!pq.isEmpty())
			System.out.println(pq.poll());
		br.close();
	}

	static void dfs(Vertex v) {
		isVisited[v.x][v.y] = true;
		for(Vertex a : house) {
			if(!isVisited[a.x][a.y])
				
				dfs(a);
		}
	}

	static void bfs(Vertex v) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.offer(v);
		cnt = 1;
		map[v.x][v.y] = no;
		isVisited[v.x][v.y] = true;
		while (!q.isEmpty()) {
			Vertex tmp = q.poll();
			for (int i = 0; i < house.size(); i++) {
				Vertex a = house.get(i);
				if (Math.abs(a.x - tmp.x) <= 1 && Math.abs(a.y - tmp.y) <= 1 &&  !isVisited[a.x][a.y]) {
					if(Math.abs(a.x - tmp.x) == 1 && Math.abs(a.y - tmp.y) == 1)
						continue;
					map[a.x][a.y] = no;
					++cnt;
					q.offer(new Vertex(a.x, a.y));
					isVisited[a.x][a.y] = true;
					continue;
				}
			}
		}
		pq.offer(cnt);
		no++;
		
		for (Vertex t : house) {
			if (!isVisited[t.x][t.y]) {
				bfs(t);
				break;
			}
		}
	}

	static class Vertex {
		int x, y;

		public Vertex(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}