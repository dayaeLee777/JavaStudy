package com.ssafy.week1.스택큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10845_큐 {

	static String com;
	static int p, T;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		MyQueue q = new MyQueue(T);

		for (int t = 0; t < T; t++) {
			com = br.readLine();
			st = new StringTokenizer(com, " ");
			switch (st.nextToken()) {
			case "push":
				p = Integer.parseInt(st.nextToken());
				q.push(p);
				break;
			case "pop":
				sb.append(q.pop()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				sb.append(q.empty()).append("\n");
				break;
			case "front":
				sb.append(q.front()).append("\n");
				break;
			case "back":
				sb.append(q.back()).append("\n");
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

class MyQueue {
	public int[] queue = new int[10];
	public int lastIdx, startIdx;

	public MyQueue(int n) {
		queue = new int[n];
		lastIdx = -1;
		startIdx = 0;
	}

	public void push(int x) {
		queue[++lastIdx] = x;
	}

	public int pop() {
		int data;
		if (empty() != 1) {
			data = queue[startIdx];
			queue[startIdx++] = 0;
		} else
			data = -1;
		return data;
	}

	public int size() {
		return lastIdx - startIdx + 1;
	}

	public int empty() {
		return this.size() == 0 ? 1 : 0;
	}

	public int front() {
		return this.empty() == 1 ? -1 : queue[startIdx];
	}

	public int back() {
		return this.empty() == 1 ? -1 : queue[lastIdx];
	}

}
