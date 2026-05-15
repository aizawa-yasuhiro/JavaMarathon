package basic;

import java.util.Arrays;
import java.util.Scanner;

public class Ex0130 {

/*
 * 課題 0130
問題
キーボードから 3 つの整数値を入力し、最大値、中央値、平均値(小数第 3 位を四捨五入)を出力する。

作成クラス名
Ex0130.java

実行例
>Java Ex0130
input number1：
40
input number2：
20
input number3：
30
最大値 = 40 中央値 = 30 平均値=30
 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        System.out.println("input number1:");
        String str = scanner.nextLine();
        System.out.println(str);
        if (str.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        int in[] = {0,0,0};
        in[0] = Integer.parseInt(str);

        System.out.println("input number2:");
        String str2 = scanner.nextLine();
        System.out.println(str2);
        if (str2.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        in[1] = Integer.parseInt(str2);

        System.out.println("input number3:");
        String str3 = scanner.nextLine();
        System.out.println(str3);
        if (str3.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }
        in[2] = Integer.parseInt(str3);

        Arrays.parallelSort(in);
        System.out.println("最大値 = " + Math.max(in[0], Math.max(in[1], in[2])) +
        		" 中央値 = " + in[1] +
        		" 平均値 = " + ((double)Math.round(((double)(in[0] + in[1] + in[2])/3) * 100))/100);

        scanner.close();
	}

}
