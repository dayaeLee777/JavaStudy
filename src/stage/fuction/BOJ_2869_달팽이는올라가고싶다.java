package stage.fuction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869_달팽이는올라가고싶다 {

	static StringTokenizer st;

	static int snail(int a, int b, int v) {
		int res = (v - a) / (a - b) + 1;
		if((v-a)%(a-b)!=0)
			res++;
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		System.out.println(snail(A, B, V));

		br.close();
	}
}
