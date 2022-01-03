package programmers.mc1;

import java.util.Arrays;

public class 이진변환반복하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("0111010")));
		System.out.println(Arrays.toString(solution1("0111010")));
	}


	//첫번째 풀이
	private static int[] solution(String s) {
		int[] answer = new int [2];
		int cnt = 0;
		int change = 0;
		while (!s.equals("1")) {
			StringBuffer tmp = new StringBuffer(s);
			for (int i = s.length()-1; i >= 0; i--) {
				if (tmp.charAt(i) == '0') {
					tmp.deleteCharAt(i);
					cnt++;
				}
			}
			change++;
			s = Integer.toBinaryString(tmp.length());
		}
		answer[0] = change;
		answer[1] = cnt;
		
		return answer;
	}
	
	// 두번째 풀이 
	private static int[] solution1(String s) {
		int[] answer = new int [2];
		while (!s.equals("1")) {
			int size = s.length();
			s = s.replaceAll("0", "");
			answer[0]++;
			answer[1] += (size-s.length());
			s = Integer.toBinaryString(s.length());
		}
		return answer;
	}

}
