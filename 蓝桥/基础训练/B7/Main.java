

/**
 * 这里对取余数和作除法要有一定的理解,a对b取余:即a有x个b剩余下来多少,剩下来的部分即是余数
 * 而a除以b反应得是a是b的多少倍
 * 也可以 无脑暴力解法...
 * <pre>
 *  for(int i = 1;i<=9;i++) {
 *      for(int j = 0;j<=9;j++) {
 *   		for(int k =0;k<=9;k++) {
 *  			if(i*i*i+j*j*j+k*k*k == i*100+j*10+k) {
 *   				System.out.println(i*100+j*10+k);
 *              }
 *          }
 *      }
 *  }
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        int g, s, b;
        for (int i = 100; i < 1000; i++) {
            g = i % 10;
            s = (i % 100) / 10;
            b = i / 100;
            if (i == g * g * g + s * s * s + b * b * b) {
                System.out.println(i);
            }
        }
    }
}
