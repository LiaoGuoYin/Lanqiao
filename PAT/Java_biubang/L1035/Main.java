

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 因为输入的数据不固定，用ArrayList
 * 注意情况节点要考虑完整
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();

        //译者注: 空 for 不应该出现. 此处应当使用 while(scanner.hasNext())
        // input data
        for (; ; ) {
            String str = scanner.nextLine();
            if (str.equals("."))
                break;
            else
                arr.add(str);
        }

        //译者注: 从代码美观度上考虑, 任何 block 不与 if 在同一行的代码, block 都应该拥有花括号. 详见 阿里巴巴Java代码规范
        // output
        if (arr.size() <= 1)
            System.out.print("Momo... No one is for you ...");
        else if (arr.size() <= 13)
            System.out.format("%s is the only one for you...", arr.get(1));
        else
            System.out.format("%s and %s are inviting you to dinner...", arr.get(1), arr.get(13));
    }
}
