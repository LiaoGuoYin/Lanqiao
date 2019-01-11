import java.util.Scanner;

public class B5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr1 = new int[n];

		for (int i = 0; i < n; i++) {
			arr1[i] = scanner.nextInt();
		}

		scanner.nextLine();
		int a = scanner.nextInt();
		int location_a = -1;

		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == a) {
				location_a = i + 1;
				break;
			}
		}
		System.out.print(location_a);
	}
}

// 这里有个坑:输入第二行数据之后,要先nextLine()以换行符截断一下,不然最后输入的待查数a获取不到