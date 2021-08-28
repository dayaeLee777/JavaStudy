package com.ssafy.수학;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_10972_다음순열 {
	static int N, input[], numbers[], result[];
	static boolean isSelected[];
	static List<int[]> res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		input = new int[N];
		numbers = new int[N];
		result = new int[N];
		isSelected = new boolean[N];
		for (int n = 0; n < N; n++) {
			input[n] = sc.nextInt();
			numbers[n] = n + 1;
		}
		if(permutation(input)) {
			for(int a : input)
				sb.append(a).append(" ");
			sb.setLength(sb.length()-1);
		}
		else
			sb.append(-1);
			
		System.out.println(sb.toString());
		sc.close();
		sc = null;
	}

	static boolean permutation(int[] array) {
		int j = 0, k = 0;
		for (int a = N - 1; a >= 1; a--) {
			if (input[a - 1] < input[a]) {
				j = a;
				break;
			}
		}
		
		if(j==0)
			return false;
		
		for (int b = N - 1; b >= 1; b--) {
			if (input[j-1] < input[b]) {
				k = b;
				break;
			}
		}
		
		swap(input, j-1, k);
		int i=N-1;
		while(j < i) {
			swap(input, j++, i--);
		}
		
		return true;
	}
	
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
