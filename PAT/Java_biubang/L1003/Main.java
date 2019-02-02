

import java.util.Scanner;

/**
 * L1-003 个位数统计
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        char[] nn = n.toCharArray();

        int[] a = new int[10];
        //译者注: 一旦出现类似以下的这种需要写很多重复代码的情况, 一定是不必要的. 例如以下情况可以将字符转为数字再作为数组下标
        for (int i = 0; i < nn.length; i++) {
            switch (nn[i]) {
                case '0':
                    a[0]++;
                    break;
                case '1':
                    a[1]++;
                    break;
                case '2':
                    a[2]++;
                    break;
                case '3':
                    a[3]++;
                    break;
                case '4':
                    a[4]++;
                    break;
                case '5':
                    a[5]++;
                    break;
                case '6':
                    a[6]++;
                    break;
                case '7':
                    a[7]++;
                    break;
                case '8':
                    a[8]++;
                    break;
                case '9':
                    a[9]++;
            }
        }
        for (int j = 0; j < 10; j++) {
            if (a[j] != 0) {
                System.out.println(j + ":" + a[j]); //译者注: 如果输出混合了数字, 符号, 推荐用格式化输出以提升代码可读性
            }
        }
    }
}
