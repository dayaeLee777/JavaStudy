package BOJ.stage.fuction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1065_한수 {

	static int find(int n) {
		int res = 0;
		if (n < 100)
			res = n;
		else {
			res = 99;
			if(n==1000)
				n--;
			for (int a = n; a >= 100; a--) {
				int tmp1 = a % 10 - ((a / 10) % 10);
				int tmp2 = (a / 10) % 10 - ((a / 100) % 10);
				if (tmp1 == tmp2)
					res++;
			}
		}
		return res;
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
