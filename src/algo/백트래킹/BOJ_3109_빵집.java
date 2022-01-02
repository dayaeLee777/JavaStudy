package algo.백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3109

public class BOJ_3109_빵집 {
	// 우상, 우, 우하
	static int[] dx = { -1, 0, 1 };
	static int R, C, cnt;
	static char map[][];
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static String s;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			s = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
			}
		}

		cnt = 0;
		for (int r = 0; r < R; r++) {
			flag = false;
			move(r, 0);
		}

		System.out.println(cnt);

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		bw.close();
	}

	// 백트래킹으로 해결
	static void move(int x, int y) {
		if (y >= C - 1) {
			// 끝난것인지 확인하는 boolean이 필요함
			flag = true;
			cnt++;
			return;
		}

//		map[x][y] = '=';
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + 1;

			if (nx >= 0 && nx < R && ny < C && ny >= 0 && map[nx][ny] == '.') {
				map[nx][ny] = '=';
				move(nx, ny);
				if (flag)
					return;
// 끝났는지 확인하는 부분이 필요함
				/*
				 * 체크하는 부분이 없으면 아래 입력에 대한 출력값이 0으로 나옴..... 5 9 .x.....x. .x..x..x. .x..x..x.
				 * ....x.... .x..x..x. 1
				 */
			}
		}
	}
}
