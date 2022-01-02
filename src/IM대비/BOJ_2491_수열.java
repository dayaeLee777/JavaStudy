package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2491
public class BOJ_2491_수열 {
	static int N, num[];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		num = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}

		// 우선순위큐(힙)으로 최대값 구하기 -> 람다식으로 표현
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)-> {return (o1 - o2) * -1;});
		
		int tmp = 1;

		// 증가하는 수열 확인
		for (int i = 0; i < N - 1; i++) {
			if (num[i] <= num[i + 1]) {
				tmp++;
				continue;
			}
			pq.offer(tmp);
			tmp = 1;
		}

		pq.offer(tmp);
		tmp = 1;

		// 감소하는 수열 확인
		for (int i = 0; i < N - 1; i++) {
			if (num[i] >= num[i + 1]) {
				tmp++;
				continue;
			}
			pq.offer(tmp);
			tmp = 1;
		}
		pq.offer(tmp);

		System.out.println(pq.poll());
		br.close();
	}
}
