import java.util.Scanner;

public class B6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] arr = new int[n + 1][n + 1];
		arr[1][1] = 1;

		System.out.println(arr[1][1]);
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				System.out.printf("%d ", arr[i][j]);
			}
			System.out.println();
		}

	}
}

// 刚才被数组搞得头大..
// 还有一点,仅输出!=修改过值