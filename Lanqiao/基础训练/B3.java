import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		int n = sc1.nextInt();
		int m = sc1.nextInt();//n行m列
		//String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//char[] arr2 = alphabet.toCharArray();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				int number = Math.abs(i-j);
				System.out.print((char)('A'+number));
			}
			System.out.println();
		}
	}
}


//这个题我拿起来的思路就是: 当然因为之前学过打星号，一开始我试图找行列之间的元素的关系做,但是弯路走了太多太多...还想着,一个字符串对应一个数组下标,然后通过位置坐标的关系输出;
//最后偷偷瞄了眼锦囊,他说每个数的位置和数对应了一个关系,之前的思路都是试图找行列之间的和的关系,没想到每个数和他所处的位置有直接的关系QAQ
//百度还get到一招输出ASCII对应字符的办法(char)(Math.random()*26+'A')

// 收获:不要把现有的方法往上面套,瓜皮才会干这种蠢事;太久做不出来一道题可以看看提示,时间浪费不起;
