package com.ssafy.그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWE_7465_창용마을무리의개수 {

	static int T, N, M, res, parents[];
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean isParent[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			make();
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			res = 0;
			isParent = new boolean[N+1];
			
			for(int i=1;i<=N;i++) {
				isParent[find(i)] = true;
			}
			
			for(boolean a : isParent)
				if(a) res++;
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	static void make() {
		parents = new int[N+1];
		
		for(int i=1;i<=N;i++)
			parents[i] = i;
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		if(find(a)==find(b))
			return false;
		parents[find(a)] =find(b);
		return true;
	}
}
