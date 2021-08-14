package com.ssafy.week1.재귀;

import java.util.Scanner;

public class BOJ_10872_팩토리얼 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(fac(N));
	}
	
	private static int fac(int i) {
		if(i <= 1) {
			return 1; 
		}
		return fac(i-1) * i;
	}
}
