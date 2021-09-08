package stage.fuction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292_벌집 {
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

		int N = Integer.parseInt(br.readLine());
		System.out.println(find(N));

		br.close();
	}
}
