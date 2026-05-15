package basic;

import java.util.Scanner;

/*
 * 問題
キーボードから 2 つの文字列を入力し、辞書順で小さい方から値を出力する。
同じ値の場合は、「2 つの文字列は同じです」と出力する。

作成クラス名
Ex0110.java

実行例
>Java Ex0110
文字列１：
ABCE
文字列２：
ABCD
ABCD ABCE

>Java Ex0110
文字列１：
ABCD
文字列２：
ABCD
２つの文字列は同じです -> ABCD

 */
public class Ex0110 {

	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("文字列１：");
        String text1 = scanner.nextLine();
        if (text1.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        System.out.println("文字列２：");
        String text2 = scanner.nextLine();
        if (text2.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

		int ret;
		if ((ret = text1.compareTo(text2)) == 0) {
			System.out.println("２つの文字列は同じです ->" + text1);
		} else {
			if (ret > 0) {
				System.out.println(text2 + " " + text1);
			} else {
				System.out.println(text1 + " " + text2);
			}
		}

        scanner.close();
	}
}

