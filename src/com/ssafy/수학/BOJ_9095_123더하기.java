package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9095_123더하기 {

	static int T, N, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			res = find(N);
			System.out.println(res);
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static int find(int sum) {
		if (sum == 0) 
			return 1;
		
		if (sum < 0)
			return 0;

		return find(sum-1) + find(sum-2) + find(sum-3);
	}
	
}
