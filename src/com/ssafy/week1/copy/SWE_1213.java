package com.ssafy.week1.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWE_1213 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, cnt;
	static String total;
	static String find;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input/week1/input_1213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int t=1; t<=10; t++) {
			cnt=0;
			N = Integer.parseInt(br.readLine());
			find = br.readLine();
			total = br.readLine();
			for(int s=0; s<total.length()-find.length()+1; s++) {
				if(find.equals(total.substring(s, s+find.length()))) {
					cnt++;
				}

			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
