package com.ssafy.수학.copy;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		arr[1] = 0;
		for(int n=2;n<=N;n++) {
			arr[n] = arr[n-1] + 1;
			if(n%2==0)
				arr[n] = Math.min(arr[n], arr[n/2]+1);
			if(n%3==0)
				arr[n] = Math.min(arr[n], arr[n/3]+1);
		}
		System.out.println(arr[N]);
		sc.close();
		sc = null;
	}

}
