package basic;

import java.util.Scanner;

/*
 * 課題 0241
問題
整数値を入力し、その行数分の実行例のように直角三角形を出力する。

作成クラス名
Ex0241.java

実行例
>Java Ex0241
input number：
5
＊
＊＊
＊＊＊
＊＊＊＊
＊＊＊＊＊

>Java Ex0241
input number：
3
＊
＊＊
＊＊＊
 */
public class Ex0241 {

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

        int ans = Integer.parseInt(str);

		for (int i = 1; i <= ans; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

        scanner.close();
	}

}
