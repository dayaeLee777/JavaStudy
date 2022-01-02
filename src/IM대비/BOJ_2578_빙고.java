package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2578
public class BOJ_2578_빙고 {
	static int res, bingo[][], mc[];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		bingo = new int[5][5];	// 빙고 2차원 배열
		mc = new int[25];		// 사회자가 부르는 숫자 -> 1차원 배열

		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < 5; c++) {
				bingo[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < 5; c++) {
				mc[r * 5 + c] = Integer.parseInt(st.nextToken());
			}
		}

		res = 0;
		
		go: for (int m = 0; m < 25; m++) {
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (bingo[r][c] == mc[m]) {
						bingo[r][c] = 0;

						check(r, c);	// 빙고가 됐는지 확인
						
						if (res >= 3) {	// 3 빙고가 완성됐으면 결과값 출력 및 return
							System.out.println(m+1);
							return;
						}
						continue go;
					}
				}
			}
		}
		br.close();
	}

	static void check(int r, int c) {
		boolean isbingo = true;
		for (int x = 0; x < 5; x++) {	// 가로 체크
			if (bingo[x][c] != 0) {
				isbingo = false;
				break;
			}
		}
		if (isbingo)
			res++;

		isbingo = true;
		for (int y = 0; y < 5; y++) {	// 세로 체크
			if (bingo[r][y] != 0) {
				isbingo = false;
				break;
			}
		}
		if (isbingo)
			res++;

		if (r == c) {					// 대각선(좌상단->우하단) 체크
			isbingo = true;
			for (int y = 0; y < 5; y++) {
				if (bingo[y][y] != 0) {
					isbingo = false;
					break;
				}
			}
			if (isbingo)
				res++;
		}
		
		if (r +c == 4) {					// 대각선(우상단->좌하단) 체크
			isbingo = true;
			for (int y = 0; y < 5; y++) {
				if (bingo[y][4-y] != 0) {
					isbingo = false;
					break;
				}
			}
			if (isbingo)
				res++;
		}
	}
}
