package com.ssafy.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_3289_서로소집합 {
	static int T, N, M;
	static int[] parents; // 부모 원소를 관리(트리처럼 사용)
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			
			make();
			
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int com = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch (com) {
				case 0:
					union(a, b);
					break;
				case 1:
					if(find(a) == find(b))
						sb.append(1);
					else
						sb.append(0);
					break;

				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void make() {
		for (int i = 1; i <= N; i++) {
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

}
