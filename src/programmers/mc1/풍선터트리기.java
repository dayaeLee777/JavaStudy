package programmers.mc1;

public class 풍선터트리기 {

	public static void main(String[] args) {
		int[] a = { 9, -1, -5 };
		System.out.println(solution(a));
	}

	private static int solution(int[] a) {
		int answer = 0;
		// 메모이제이션을 하기 위한 왼쪽, 오른쪽 배열
		int[] leftArr = new int[a.length];
		int[] rightArr = new int[a.length];
		int leftMin = a[0];
		int rightMin = a[a.length - 1];
		
		// 왼쪽 최소값 메모이제이션 배열 초기
		for (int l = 0; l < a.length; l++) {
			if (leftMin > a[l])
				leftMin = a[l];
			leftArr[l] = leftMin;
		}
		// 오른쪽 최소값 메모이제이션 배열 초기
		for (int r = a.length - 1; r >= 0; r--) {
			if (rightMin > a[r])
				rightMin = a[r];
			rightArr[r] = rightMin;
		}
		
		// a 배열을 순차적으로 돌면서 풍선이 마지막까지 남을 수 있는지 확인
		// a[i]가 왼쪽, 오른쪽 각각의 최소값보다 크면 터질 수 밖에 없음
		for (int i = 0; i < a.length; i++) {
			if (a[i] > leftArr[i] && a[i] > rightArr[i])
				continue;
			answer++;
		}
		answer = a.length == 1 ? 1 : answer;
		return answer;
	}

}
