package koi.y1996;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {

	static int N, res, sum;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sum = 0;
		map = new boolean[101][101];
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					if (!map[i][j]) {
						map[i][j] = true;
						sum++;
					}
				}
			}
		}
//		for(int i=1;i<=100;i++) {
//			for(int j=1;j<=100;j++) {
//				if(map[i][j])
//					sum++;
//			}
//		}

		bw.write(Integer.toString(sum));

		bw.flush();
		bw.close();
		br.close();
	}
}