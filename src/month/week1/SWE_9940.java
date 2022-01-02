package month.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_9940 {
	static int T, N;
	static int[] cnt;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/week1/input_9940.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cnt = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int n = 0; n < N; n++) {
				cnt[n] = Integer.parseInt(st.nextToken());
			}
			boolean isP = true;
			Arrays.sort(cnt);
			sb.append("#").append(t);
			for (int n = 0; n < N - 1; n++) {
				if (cnt[n] == cnt[n + 1]) {
					isP = false;
					continue;
				}
			}
			if (isP == true) {
				sb.append(" Yes\n");
			} else
				sb.append(" No\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
