

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();// 字段截取
        scanner.close();
        char[] charstring = string.toCharArray();

        for (int i = 0; i < charstring.length - 1; i++) {
            outChar(charstring[i]);
            System.out.print(" ");
        }
        outChar(charstring[charstring.length - 1]);

    }

    //译者注: 这种情况称为编码问题, 通常用数组或者 Map 解决, 否则会带来大量重复编码
    public static void outChar(char a) {
        switch (a) {
            case '-':
                System.out.print("fu");
                break;
            case '0':
                System.out.print("ling");
                break;
            case '1':
                System.out.print("yi");
                break;
            case '2':
                System.out.print("er");
                break;
            case '3':
                System.out.print("san");
                break;
            case '4':
                System.out.print("si");
                break;
            case '5':
                System.out.print("wu");
                break;
            case '6':
                System.out.print("liu");
                break;
            case '7':
                System.out.print("qi");
                break;
            case '8':
                System.out.print("ba");
                break;
            case '9':
                System.out.print("jiu");
                break;
        }
    }
}
