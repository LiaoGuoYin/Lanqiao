package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

		Date date = null;
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(sdf2.format(date));
	}
}
// 理解java.text.SimpleDateFormat 的 parse 和 format 方法
// 一个转换，一个格式化输出
// 当然也可以自己写 split 字符串处理：
//		Scanner scanner = new Scanner(System.in);
//		String string = scanner.next();
//		String[] stringarr = string.split("-");	
//		System.out.printf("%s-%s-%s",stringarr[2],stringarr[0],stringarr[1]);
