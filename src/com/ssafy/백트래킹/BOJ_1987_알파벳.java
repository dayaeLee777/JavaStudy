package com.ssafy.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {

	static int R, C, res;
	static StringTokenizer st;
	static char[][] board;
	static String s;
	// 상하좌우를 찾아갈 배열(좌상단에서 출발하기 때문에 배열에 하, 우를 먼저 작성)
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	// (초기) 방문했던 알파벳을 저장할 ArrayList 생성 => 실행시간 : 3396ms 
	static ArrayList<Character> visited;
	// (보완) 알파벳숫자만큼 boolean 배열 생성
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];

		for (int r = 0; r < R; r++) {
			s = br.readLine();
			for (int c = 0; c < C; c++) {
				board[r][c] = s.charAt(c);
			}
		}
//		visited = new ArrayList<>();
		// 알파벳 갯수만큼 배열 생성
		isSelected = new boolean[26];
		
		res = Integer.MIN_VALUE;
//		visited.add(board[0][0]);
		// 좌상단에 있는 알파벳은 선택되었다고 배열에 true 값 입력
		isSelected[board[0][0]-65] = true;

//		move(0, 0, 1);
		// 좌상단은 이미 선택되었으므로, sum = 1
		move2(0, 0, 1);
		System.out.println(res);
		br.close();
	}

//	static boolean isPossible(int x, int y) {
//		if (!visited.contains(board[x][y])) {
//			return true;
//		}
//		return false;
//	}
//
//	static void move(int r, int c, int sum) {
//		if (res < sum)
//			res = sum;
//		for (int i = 0; i < 4; i++) {
//			int nx = r + dx[i];
//			int ny = c + dy[i];
//
//			if (nx >= 0 && nx < R && ny >= 0 && ny < C && isPossible(nx, ny)) {
//				visited.add(board[nx][ny]);
//				move(nx, ny, sum + 1);
//				continue;
//			} 
//		}
//		visited.remove(visited.size() - 1);
//	}
	
	static boolean isPossible2(int x, int y) {
		// 해당 알파벳이 선택되어 있지 않으면 true 반환
		if (!isSelected[board[x][y]-65]) {
			return true;
		}
		return false;
	}
	
	static void move2(int r, int c, int sum) {
		// res(최종결과값) 보다 sum(현재 계산하고 있는값)이 크면 res에 sum값 대입
		if (res < sum)
			res = sum;
		// 하 우 상 좌 순차적으로 루프 돌기
		for (int i = 0; i < 4; i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			
			// 새로운 nx, ny값이 배열 범위 내에 있고, 해당 위치의 알파벳이 이전에 선택되었던 알파벳이 아니면
			if (nx >= 0 && nx < R && ny >= 0 && ny < C && isPossible2(nx, ny)) {
				// 해당 위치의 알파벳은 선택되었다고 true 값을 대입해주고
				isSelected[board[nx][ny]-65] = true;
				// 다음 알파벳을 찾아가기 위해 재귀함수 호출(새로운 위치값과 sum+1을 매개변수로 전달)
				move2(nx, ny, sum + 1);
				continue;
			} 
		}
		// 더 이상 이동할 곳이 없으면 해당 위치의 알파벳은 선택되지 않은 것(false) 처리
		isSelected[board[r][c]-65] = false;
	}
}
