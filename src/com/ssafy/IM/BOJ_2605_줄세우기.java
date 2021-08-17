package com.ssafy.IM;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2605
public class BOJ_2605_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		// 입력된 수는 ArrayList 형태로 student 변수에 저장
		ArrayList<Integer> student = new ArrayList<>();
		// pos를 받아서 바로 해당 위치에 저장
		for (int n = 0; n < N; n++) {
			int pos = sc.nextInt();
				student.add(n-pos, n+1);
		}
		
		StringBuilder sb = new StringBuilder();
		student.forEach(i->sb.append(i).append(" "));
		sb.setLength(sb.length()-1);
		
		System.out.println(sb.toString());
		
		sc.close();
		sc=null;
	}

}
