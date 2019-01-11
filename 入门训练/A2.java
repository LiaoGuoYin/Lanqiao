//序列求和
import java.util.Scanner;

public class A2 {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		long n = sc1.nextLong();
		sc1.close();
		System.out.println((1 + n) * n / 2);
	}
}

// Scanner用完nextxxx()获取要记得close()
// 我居然还傻fufu的用for循环求和再除以项数。。
// 瓜皮得一批,做题要专注于解决问题要用脑子，不是用惯性思维;