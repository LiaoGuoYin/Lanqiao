

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 理解java.text.SimpleDateFormat 的 parse 和 format 方法
 * 一个转换，一个格式化输出
 * 当然也可以自己写 split 字符串处理：
 * <pre>
 *  Scanner scanner = new Scanner(System.in);
 *  String string = scanner.next();
 *  String[] stringarr = string.split("-");
 *  System.out.printf("%s-%s-%s",stringarr[2],stringarr[0],stringarr[1]);
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");  //译者注: 求求你用自动命名吧, 看得头皮发麻
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            date = sdf.parse(string);
        } catch (ParseException e) {
            //译者注: 在 IDEA 中, 写完一个可能会抛出异常的操作, 继续写入 ".try" 再按 enter 即可生成 try-catch 语句块
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(sdf2.format(date));
    }
}
