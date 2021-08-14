package com.ssafy.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_10799_쇠막대기 {

	static StringBuilder sb = new StringBuilder();
	static char[] s;
	static int T, res;
	static Stack<Character> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		res = 0;
		
		stack = new Stack<>();
		s = br.readLine().toCharArray();
		for(int i =0; i<s.length;i++) {
			switch (s[i]) {
			case '(':
				stack.push(s[i]);
				break;
			case ')':
				if (stack.size() == 0) {
					break;
				}
				if(s[i-1]=='(') {
					res += stack.size()-1;
				}else {
					res+=1;
				}
				stack.pop();
				break;
			}
		}
		sb.append(res);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}


/* 참고용
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] charArray = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        int answer = 0;
        for (char charInput : charArray) {
            if (charInput == '(') {
                stack.push(count++);
            } else {
                if (count - stack.peek() == 1) {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }
        
        br.close();
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
*/