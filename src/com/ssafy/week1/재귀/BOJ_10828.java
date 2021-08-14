package com.ssafy.week1.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10828 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, comN;
	static String S;
	static String com;
	static List<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		stack = new ArrayList<Integer>();
		for (int n = 0; n < N; n++) {
			S = br.readLine();
			st = new StringTokenizer(S, " ");
			com = st.nextToken();
			if (st.hasMoreTokens()) {
				comN = Integer.parseInt(st.nextToken());
			}
			switch (com) {
			case "push":
				stack.add(comN);
				break;
			case "pop":
				if (stack.size() > 0) {
					System.out.println(stack.get(stack.size()-1));
					stack.remove(stack.size() - 1);
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "top":
				if (stack.size() > 0) {
					System.out.println(stack.get(stack.size()-1));
				} else {
					System.out.println(-1);
				}
				break;
			}
		}
		br.close();
	}
}
