package BOJ.stage.fuction;

public class BOJ_4673_셀프넘버 {
	static boolean[] notSelfNum = new boolean[10001];
	
	static void d(int n) {
		int res = n;
		while(n>0) {
			res += n%10;
			n /= 10;
		}
		
		if(res>10000)
			return;
		
		notSelfNum[res] = true;
		d(res);
	}
	
	public static void main(String[] args) {
		
		for(int i=1; i<10001;i++)
			d(i);
		for(int i=1; i<10001;i++)
			if(!notSelfNum[i])	System.out.println(i);
	}

}
