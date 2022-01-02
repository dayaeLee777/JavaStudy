package month.week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// https://www.acmicpc.net/problem/1406
// 제한시간 0.3초
public class BOJ_1406_에디터 {

	static String s, com;
	static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 에디터를 실행할 문자열 입력받기
		s = br.readLine();
		
		// ArrayList 시간초과로 실패
//		ArrayList<Character> arr = new ArrayList<Character>();
//		for (char a : s.toCharArray()) {
//			arr.add(a);
//		}
//		int idx = arr.size();

		// 커서를 기준으로 왼쪽은 stack, 오른쪽은 stack2에 저장
		Stack<Character> stack = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		for (int i = 0; i < s.length(); i++)
			stack.push(s.charAt(i));

		N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			com = br.readLine();

			switch (com.charAt(0)) {
			case 'L':
				if (!stack.isEmpty())
					stack2.push(stack.pop());
				break;
			case 'D':
				if (!stack2.isEmpty())
					stack.push(stack2.pop());
				break;
			case 'B':
				if (!stack.isEmpty())
					stack.pop();
				break;
			case 'P':
				stack.push(com.charAt(2));
				break;
			}
		}
		stack.forEach(a -> sb.append(a));
		while (!stack2.isEmpty())
			sb.append(stack2.pop());
		bw.write(sb.toString());

		bw.flush();
		bw.close();
		bw.close();
	}

}
