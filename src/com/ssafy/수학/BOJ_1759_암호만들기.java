package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {

	static int L, C;
	static char[] input, res;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		isSelected = new boolean[C];

		input = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(input);
		res = new char[L];

		comb(0, 0, 0, 0);

		bw.write(sb.toString());

		bw.flush();
		bw.close();
		bw.close();
	}

	// 암호 조합을 찾는 함수
	// 자음모음을 더하여 연산하는 것보다 totalcnt 변수를 따로 두는 것이 시간이 더 빠름
	static void comb(int idx, int totalCnt, int cntA, int cntB) {	// cntA : 모음, cntB : 자음
		if (cntA > L - 2 || cntB > L - 1)	// 자음, 모음의 갯수 조건
			return;

		if (totalCnt == L) {
			sb.append(res).append("\n");
			return;
		}

		for (int i = idx; i < C; i++) {
			res[totalCnt] = input[i];
			if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u')
				comb(i + 1, totalCnt + 1, cntA + 1, cntB);
			else
				comb(i + 1, totalCnt + 1, cntA, cntB + 1);
		}
	}
}
