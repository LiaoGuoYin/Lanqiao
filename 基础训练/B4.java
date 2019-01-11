import java.util.Scanner;

public class B4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr1 = new int[n];

		for (int i = 0; i < n; i++) {
			arr1[i] = scanner.nextInt();
		}

		int min = arr1[0], max = arr1[0];
		int sum = 0;

		for (int i = 0; i < arr1.length; i++) {
			min = arr1[i] < min ? arr1[i] : min;
			max = arr1[i] > max ? arr1[i] : max;
			sum = sum + arr1[i];
		}

		System.out.format("%d%n%d%n%d", max, min, sum);
	}
}

// 这次看了lichuo的答案，居然感jio我自己做的比她的简洁;呲牙笑.jpg
// 和她最大的不同在获取输入的数,她的思路是nextLine得到字符串,然后strip(" ")截取之后放进数组
// 还有一个新的体会就是,昨天做题遇到了不少ArrayindexOutofBounds,今天 固定了一种边界条件的模式 这问题就没问那么容易混乱了