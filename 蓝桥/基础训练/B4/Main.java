

import java.util.Scanner;

/**
 * 这次看了lichuo的答案，居然感jio我自己做的比她的简洁;呲牙笑.jpg   //译者注: 我明天就要告诉你什么叫做简洁
 * 和她最大的不同在获取输入的数,她的思路是nextLine得到字符串,然后strip(" ")截取之后放进数组
 * 还有一个新的体会就是,昨天做题遇到了不少ArrayindexOutofBounds,今天 固定了一种边界条件的模式 这问题就没问那么容易混乱了
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        int min = arr1[0], max = arr1[0];
        int sum = 0;

        //译者注: 大部分警告可以直接在警告位置使用 alt+enter 来进行自动修改
        for (int i = 0; i < arr1.length; i++) {
            min = arr1[i] < min ? arr1[i] : min;
            max = arr1[i] > max ? arr1[i] : max;
            sum = sum + arr1[i];
        }

        System.out.format("%d%n%d%n%d", max, min, sum);

        //译者注: Java Stream Operation, 流式数据处理 API. 详见 https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/index.html
        //译者注: 需配合 Lambda Expression 与 Method Reference 使用, 详见 https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
//        try (Scanner scanner1 = new Scanner(System.in)) {
//            scanner1.nextLine();
//            IntSummaryStatistics intSummaryStatistics = Arrays.stream(scanner1.nextLine().split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .summaryStatistics();
//            System.out.println(intSummaryStatistics.getMax());
//            System.out.println(intSummaryStatistics.getMin());
//            System.out.println(intSummaryStatistics.getSum());    //译者注: 也可以用 %n, 按照个人喜好选择
//        }
    }
}
