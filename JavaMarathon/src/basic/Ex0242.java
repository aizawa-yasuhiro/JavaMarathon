package basic;

import java.util.Scanner;

/*
 * 課題 0242
問題
整数値を入力し、その行数分の実行例のように二等辺三角形を出力する。

実行例
作成クラス名
Ex0242.java

>Java Ex0242
input number：
5
        ＊
      ＊＊＊
    ＊＊＊＊＊
  ＊＊＊＊＊＊＊
＊＊＊＊＊＊＊＊＊

>Java Ex0242
input number：
3
    ＊
  ＊＊＊
＊＊＊＊＊
 */
public class Ex0242 {

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
//        int ans2 = ans;
//
//		// 2025/06/05 originalは✕
//		for (int i = 1; i <= ans; i++) {
//			for (int j = 0; j < ans2-1; j++) {
//				System.out.print(" ");
//			}
//			ans2--;
//			for (int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}

		// 2025/06/05 こちらが正解
		for (int i = 1; i <= ans; i++) {
			for (int j = 1; j <= ans - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

        scanner.close();
	}

}
