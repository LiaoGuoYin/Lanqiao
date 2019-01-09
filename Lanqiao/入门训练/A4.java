//Fobinacci数列

import java.util.Scanner;


public class Main{
	public static void main(String[] args){
		Scanner sc1 = new Scanner(System.in);
		int n = sc1.nextInt();
		sc1.close();

		long[] F = new long[n+2];
		F[1]=F[2]=1;
		for(int i=3;i<=n;i++){
			F[i] = (F[i-1]+F[i-2])%10007;
		}

		System.out.print(F[n]);
	}
}

//错了好几次,全在数组越界上..
//看了下lichuo,才发现,可以暴力先迭代出所有F[1000000]然后直接对F[n]操作
//TODO 这里有点没懂对每一个F[i]先取余再赋值，隐约不是Fobinacci数列的感觉 但是这里已经没有足够大的储存F[1000000]的数据类型了 先写个坑..
