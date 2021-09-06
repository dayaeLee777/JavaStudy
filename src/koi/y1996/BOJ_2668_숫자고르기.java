package koi.y1996;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_2668_숫자고르기 {

	static int N, input[], count[];
	static boolean isVisited[];
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		input = new int[N + 1];
		count = new int[N + 1];
		isVisited = new boolean[N + 1];
		for (int n = 1; n <= N; n++) {
			int a = Integer.parseInt(br.readLine());
			input[n] = a;
		}
		for (int n = 1; n <= N; n++) {
			find(n, n);
		}

		sb.append(pq.size());
		while (!pq.isEmpty()) {
			sb.append("\n").append(pq.poll());
		}
		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	static void find(int cur, int target) {
		if (input[cur]==target) {
			pq.offer(target);
			return;} 
		
		if(!isVisited[input[cur]]){
			isVisited[input[cur]] = true;
			find(input[cur], target);
			isVisited[input[cur]] = false;
		}
	}

}