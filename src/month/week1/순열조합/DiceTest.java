package month.week1.순열조합;

import java.util.Arrays;

public class DiceTest {
	static int numbers[], N, totalCnt;
	static boolean isSelected[];

	public static void main(String[] args) {
		N = 2;
		numbers = new int[N];

//		dice1(0);
		isSelected = new boolean[7];
//		dice2(0);
//		dice3(1, 0);
		dice4(1, 0);

	}

	private static void dice1(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt + 1);
		}
	}

	private static void dice2(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (isSelected[i])
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;

			dice2(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static void dice3(int start, int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(i, cnt + 1);
		}
	}

	private static void dice4(int start, int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(i+1, cnt + 1);
		}
	}

}
