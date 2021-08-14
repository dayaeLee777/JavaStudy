package com.ssafy.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_9012_괄호 {

	static StringBuilder sb = new StringBuilder();
	static String s;
	static int T;
	static Stack<Character> stack;
	static boolean isVPS;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			stack = new Stack<>();
			isVPS = true;
			s = br.readLine();
			for (char a : s.toCharArray()) {
				switch (a) {
				case '(':
					stack.push(a);
					break;
				case ')':
					if (stack.size() == 0) {
						isVPS = false;
						break;
					}
					stack.pop();
					break;
				}
			}
			if (stack.size() != 0)
				isVPS = false;

			if (isVPS)
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
