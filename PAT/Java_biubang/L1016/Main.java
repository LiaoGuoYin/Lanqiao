

import java.util.Scanner;

/**
 * 注意char a = 0; (int)a结果是48，自动转为ascii码了
 * 越做越糊涂，TODO明天补，头大
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] weights = new int[]{1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int N = scanner.nextInt();
        String[] sfzs = new String[N];
        // 存储sfz
        for (int i = 0; i < sfzs.length; i++) {
            sfzs[i] = scanner.next();
        }

        int flag = 0;

        for (int i = 0; i < sfzs.length; i++) {
            String sfz = sfzs[i];
            String[] arr = sfz.split("");
            // 检验前17位是否全是数字
            for (char each : sfz.toCharArray()) {
                if (each <= '0' || each >= '9') {
                    flag = -1;
                    break;
                }
            }
            if (flag == -1) {
                System.out.println(sfz);
                break;
            }

            String lastint = arr[arr.length - 1];// 检验数
            int checkint = check(arr);// 计算出来的检验数
            String[] checklist = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

            if (checklist[checkint].equals(lastint)) {
                flag = 1;
                break;
            } else {
                System.out.println(sfz);
            }
        }
        if (flag == 1) {
            System.out.println("All passed");
        }

    }

    // 计算检验数
    static int check(String[] arr) {
        int[] coeffcient = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = Integer.parseInt(arr[i]);
            int shu = coeffcient[i] * a;
            sum += shu;
        }
        int checksum = sum % 11;    //译者注: 此处使用 alt+enter 自动简化代码
        // System.out.println(checksum);
        return checksum;
    }
}
