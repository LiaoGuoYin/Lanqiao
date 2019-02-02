

import java.util.Scanner;

/**
 * 注意要吸收换行符，做这种题的时候没头绪很乱的时候一步一步的分块做，边做边调试，还得看获取到的数组一样与否
 * 注意字符串数组和整型数组的值永远不可能相同，这点很细微，语法乍一看没毛病，但是很容易出错
 * <p>
 * 上面是方法二，是暴力解法（因为输入的数据肯定是正确的，可以存储在一个字符串里面，然后比对，查找)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        StringBuffer sb = new StringBuffer();
        // 录入信息到数组

        scanner.nextLine();
        for (int i = 1; i <= N; i++) {
            String str = scanner.nextLine();
            sb.append(str + " ");
        }
        String info = sb.toString();
        String[] all_info = info.split(" ");
        // System.out.println("录入的信息为:"+Arrays.toString(all_info));

        // 输入查询信息(试机座位号码)
        scanner.next();
        scanner.nextLine();// 吸收换行符
        String str = scanner.nextLine();
        String[] chaxun = str.split(" ");

        for (int i = 0; i < chaxun.length; i++) {
            int ls_id = Integer.parseInt(chaxun[i]);
            for (int j = 0; j < all_info.length; j++) {
                if (all_info[j].equals(chaxun[i]) && Long.parseLong(all_info[j - 1]) > N) {
                    System.out.println(all_info[j - 1] + " " + all_info[j + 1]);
                }
            }
        }

    }
}
