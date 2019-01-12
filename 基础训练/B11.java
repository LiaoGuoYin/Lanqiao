package practice;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] str = scanner.next().toCharArray();
		scanner.close();

		int sum = 0;
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] >= 'A' || str[i] <= 'F') {
				sum = sum * 16 + str[i] - 'A' + 10;
			} else {
				sum = sum * 16 + str[i] - '0';
			}
		}
		System.out.println(sum);
	}
}