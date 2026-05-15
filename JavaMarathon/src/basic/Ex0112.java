package basic;

import java.util.Scanner;

/*
 * 問題
キーボードから文字列を入力し、文字列内に半角カナが含まれるか判定する。
含まれる場合は「半角カナが含まれます」、含まれない場合は「許可する文字列です」と出力する。

作成クラス名
Ex0112.java

実行例
>Java Ex0112
文字列：
この文字リンゴは許可されますか。
許可する文字列です

>Java Ex0112
文字列：
この文字ﾘﾝｺﾞは許可されますか。
半角カナが含まれます
 */
public class Ex0112 {

	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("文字列：");
        String str = scanner.nextLine();
        System.out.println(str);
        if (str.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        if (str.matches(".*[ｱ-ﾝ].*")) {
        	System.out.println("半角カナが含まれます");
        } else {
        	System.out.println("許可する文字列です");
        }

        scanner.close();

	}
}
