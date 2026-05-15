package basic;

import java.util.Scanner;

/*
 * 課題 0113
問題
キーボードから文字列を入力し、文字列内に全角数字が含まれる場合は半角数字に置換して出力す
る。

作成クラス名
Ex0113.java

実行例
>Java Ex0113
文字列：
昨日の円相場は１２０．５０でした。
結果：昨日の円相場は 120．50 でした。

>Java Ex0113
文字列：
昨日の円相場は 120.50 でした。
結果：昨日の円相場は 120.50 でした。
 */
public class Ex0113 {

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

        StringBuffer sb = new StringBuffer(str);
        for (int i = 0; i < sb.length(); i++) {
          char c = sb.charAt(i);
          if (c >= '０' && c <= '９') {
            sb.setCharAt(i, (char)(c - '０' + '0'));
          }
        }
        System.out.println("結果：" + sb.toString());

        scanner.close();
	}

}
