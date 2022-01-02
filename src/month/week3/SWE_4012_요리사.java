package month.week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo&categoryId=AWXRDL1aeugDFAUo&categoryType=CODE&problemTitle=5644&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

public class SWE_4012_요리사 {

	static String s;
	static StringBuilder sb = new StringBuilder();
	static int T, N, A, res, synergy[][], sumA, sumB;
	static StringTokenizer st;
	static PriorityQueue<Integer> pq;
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			synergy = new int[N][N];

			for (int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < N; y++) {
					synergy[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			isSelected = new boolean[N];
			pq = new PriorityQueue<Integer>();
			sumA = 0;
			sumB = 0;
			
			comb(0, 0);
			sb.append("#").append(t).append(" ").append(pq.poll()).append("\n");
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		bw.close();
	}

	static void comb(int start, int cnt) {
		if (cnt == N/2) {
			sumA=0;
			sumB=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!isSelected[i] && !isSelected[j])
						sumA += synergy[i][j];
					if(isSelected[i] && isSelected[j])
						sumB += synergy[i][j];
				}
			}
			pq.offer(Math.abs(sumA-sumB));
			return;
		}
		for (int i = start; i < N; i++) {
			isSelected[i]=true;
			comb(i+1, cnt+1);
			isSelected[i]=false;
		}
	}
}
