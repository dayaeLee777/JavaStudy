package stage.fuction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2292_벌집 {
	// 1
	// 6
	// 12
	// 18
	static int find(int n) {
		
		int res = 1;
		int cnt = 1;
		while(res<n) {
			res += 6*cnt++;
			
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		System.out.println(find(N));

		bw.flush();
		bw.close();
		br.close();
	}
}
