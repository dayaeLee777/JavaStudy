package com.ssafy.week1.copy;

import java.util.Scanner;

public class BOJ_8393 {

	static int total = 0;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int n=1; n<=N;n++) {
			total+=n;
		}
		System.out.println(total);
//		sum(N);
//		System.out.println(total);
	}
	
	private static void sum(int n) {
		if(n==1) {
			total+=1;
			return;
		}
		
		total+=n;
		sum(n-1);
	}

}
