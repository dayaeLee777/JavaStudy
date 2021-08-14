package com.ssafy.week1.순열조합;

import java.util.Scanner;

public class BOJ_1010_다리놓기 {
	static int T, N, M, nArr[], mArr[];
	static int sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			sum = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			mArr = new int[M];
			for(int n=0; n<N;n++) {
				bridge(0);
			}System.out.println(sum);
			}
	}
	private static void bridge(int s) {
		sum++;
		if(s==N) return;

		for(int i=0; i<M;i++) {
			if(mArr[i]==1) {
				continue;
			}else {
				mArr[i] =1;
				bridge(s+1);
				mArr[i] =0;
			}
		}
	}

}
