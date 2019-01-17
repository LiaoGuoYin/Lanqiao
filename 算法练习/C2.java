package practice;

import java.util.Scanner;

public class Main {
	static long max = 1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		scanner.close();
		isok(n);
		System.out.println(max);
	}

	public static void isok(long n) {
		if (n <= 2) {
			max = n;
		} else if (n % 2 == 1) {
			max = n * (n-1) * (n-2);
		} else {
			if (n % 3 == 0) {
				max = (n - 1) * (n - 2) * (n - 3);
			} else {
				max = n * (n - 1) * (n - 3);
			}
		}
	}
}
// 要用到数论的结论：若三个数互为质数,那么这三个数的乘积便为它们的最小公倍数。
// 有以下二种情况。
// (1)、当N为奇数时,那么N,N-1,N-2互为质数,很明显N*N-1*N-2是1~N最小公倍数的最大值。
// (2)、当N为偶数时,且能被3整除时,N-1,N-2,N-3互质,此时N-1*N-2*N-3是1~N最小公倍数的最大值；当N为偶数时,但不能被3整除时,N,N-1,N-3互质,此时N*N-1*N-3是1~N最小公倍数的最大值。
