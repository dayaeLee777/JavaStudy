package BOJ.stage.fuction;

public class BOJ_15596_정수N개의합 {
	static long sum(int[] a) {
		long res = 0;
		for(int i=0; i<a.length; i++){
			res += a[i];
		}
		return res;
	}
}
