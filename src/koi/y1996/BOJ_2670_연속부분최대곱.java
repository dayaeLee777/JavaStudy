package koi.y1996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2670_연속부분최대곱 {

	static int N;
	static double input[], maxRes;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Double> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new double[N];
		for (int n = 0; n < N; n++) {
			double a = Double.parseDouble(br.readLine());
			input[n] = a;
		}
		maxRes = 0;

		for (int n = 0; n < N; n++)
			find(n, n, input[n]);
		
		System.out.printf("%.3f", maxRes);

		br.close();
	}

	static void find(int start, int end, double res) {
		if (maxRes < res)
			maxRes = res;

		if (end+1 >= N) {
			return;
		}

		find(start, end + 1, res * input[end+1]);
	}
}