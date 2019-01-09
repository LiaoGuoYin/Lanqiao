import java.util.Scanner;

public class A1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.print(A+B);
	}
}

//next()是以字段 截断
//nextInt()是遇到非int 截断
//nextLine()是遇到\r\n 截断
//Scanner还可以这么用 int a = new java.util.Scanner(System.in).nextInt();同引入包中类的原理

//注意复制到oj平台的话，要修改类的名字A1->Main
