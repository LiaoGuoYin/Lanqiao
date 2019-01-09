import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] F = new long[n+2];
		
		F[1] = 1;
		F[2] = 1;
		
		for(int i=3;i<=n;i++) {
			F[i] = (F[i-1]+F[i-2])%10007;
		}
		System.out.println(F[n]);
		
	}
}

//错了好几次，全在数组越界上..
//看了下lichuo，才发现，可以暴力先迭代出所有F[100000]然后直接对F[n]操作

















//public class Main{
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int r = sc.nextInt();
//		String Area = Double.toString(Math.PI*r*r);
//		//java.text.DecimalFormat df = new java.text.DecimalFormat("0.0000000");
//		//String result = df.format(Area);
//		String result = Area.format("%.7d");
//		System.out.println(result);
//	}
//}





//public class Main{
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		long n = sc.nextLong();
//		long sum = 0;
//		for(long i=1;i<=n;i++) {
//			sum = sum+i;
//		}
//		System.out.println(sum);
//	}
//}








//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		int A = 0,B = 0;
//		
//		Scanner s1 = new Scanner(System.in);
//		
//		while (s1.hasNextInt()) {
//			A = s1.nextInt();
//			B = s1.nextInt();
//		}
//		
//		System.out.println(A+B);
//		
//	}
//}
