package BOJ.stage.dp;

import java.util.Scanner;

public class BOJ_2011_암호코드 {
	static String input;
	static StringBuilder sb = new StringBuilder();
	static int code[], length;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		code = new int[input.length() + 1];
		length = code.length + 1;
		int res = 0;
		code[0] = 1;
		code[1] = 1;
		if (length > 1 && input.charAt(0) != '0') {
			dp(2);
			res = code[length - 2];
		}
		System.out.println(res);

	}

	private static void dp(int idx) {
		if (idx == length - 1)
			return;

		int two = Integer.parseInt(input.substring(idx - 2, idx));
		if (two == 0) {
			return;
		}
		if (two <= 26 && two > 10 && two != 20) {
			code[idx] = (code[idx - 1] + code[idx - 2]) % 1000000;
		} else if (two == 10 || two == 20) {
			code[idx] = code[idx - 2] % 1000000;
		} else if (two % 10 == 0) {
			return;
		} else {
			code[idx] = code[idx - 1] % 1000000;
		}
		dp(idx + 1);
	}

}
