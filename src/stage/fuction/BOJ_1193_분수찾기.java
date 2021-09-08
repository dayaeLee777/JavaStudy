package stage.fuction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1193_분수찾기 {
	static StringBuilder sb = new StringBuilder();

	static void find(int n) {
		int cnt = 1;
		while (n > cnt) {
			n -= cnt++;
		}
		if (cnt % 2 == 1)
			sb.append(cnt - n + 1).append("/").append(n);
		else
			sb.append(n).append("/").append(cnt - n + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		find(N);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
