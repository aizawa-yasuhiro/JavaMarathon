package basic;

import java.util.Scanner;

/*
 * 課題 0200
問題
キーボードから 1 つの整数値 n を入力し、1 から n までの和を求め、結果を出力する。

作成クラス名
Ex0200.java

実行例
>Java Ex0200
input number：
5
合計値 = 15

>Java Ex0200
input number：
10
合計値 = 55
 */
public class Ex0200 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        System.out.println("input number：");
        String str = scanner.nextLine();
        System.out.println(str);
        if (str.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        int in;
        in = Integer.parseInt(str);

        int ans=0;
        for (int i = 1; i <= in; i++) {
			ans = ans + i;
		}
        System.out.println("合計値 = " + ans);

        scanner.close();
	}
}
