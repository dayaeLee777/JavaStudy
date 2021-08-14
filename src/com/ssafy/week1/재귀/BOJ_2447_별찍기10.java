package com.ssafy.week1.재귀;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2447_별찍기10 {
	static char[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		star(N, 0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void star(int n, int startR, int startC, boolean blank) {
		if(blank) {
			
		}
		int cnt = 1;
		
		for(int r=startR; r<n;r+=(n/3)) {
			for(int c=startC; c<n;c+=(n/3)) {
				cnt++;
				if(cnt==5) {
					star(n/3, r, c, true);
				}else {
					star(n/3, r, c, false);
				}
				
			}
		}
		
	}
}
