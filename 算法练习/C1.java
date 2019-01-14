package practice;

import java.util.Scanner;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 获取序列数n
		int n = scanner.nextInt();
		int[] arr = new int[n];

		// 获取n个序列
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}

		// 获取操作数的个数m
		int m = scanner.nextInt();

		// 获取m行操作数
		int[] ll = new int[m];
		int[] rr = new int[m];
		int[] kk = new int[m];
		for (int z = 0; z < m; z++) {
			ll[z] = scanner.nextInt();
			rr[z] = scanner.nextInt();
			kk[z] = scanner.nextInt() - 1;
		}

		// 操作每一行,截取子数组
		for (int i = 0; i < m; i++) {
			int[] SubArr = split_arr(ll[i], rr[i], arr);
			System.out.println(SubArr[kk[i]]);
		}
	}

	public static int[] split_arr(int i, int j, int[] arr) {
		int count = 0;
		int[] SubArr = new int[j - i + 1];
		for (; i <= j; i++) {
			SubArr[count] = arr[i - 1];
			count++;
		}
		Arrays.sort(SubArr);
		int[] new_Arr = new int[SubArr.length];
		for(int k = 0;k<SubArr.length;k++) {
			new_Arr[SubArr.length-k-1] = SubArr[k]; 
		}
		return new_Arr;
	}
}

// 数组越界的问题用arr.length来严格把控可以很好解决
// Arrays库好用得一匹= =！
// 今天这个题有点顶不住，要做的小模块有点多，看来低估题目难度了，明天得加一把劲
// 有时候思路太乱，直接删干净写过的题目也是个办法