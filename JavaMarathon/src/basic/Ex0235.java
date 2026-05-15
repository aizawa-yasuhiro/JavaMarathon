package basic;

import java.util.Scanner;

/*
 * 課題 0235
問題
キーボードから入力された 0～255の範囲の10進数整数値を2進数と16進数に変換して出力する。

作成クラス名
Ex0235.java

実行例
>Java Ex0235
0～255 の範囲の 10 進数：
255
2 進数の変換結果：11111111
16 進数の変換結果：FF

>Java Ex0235
0～255 の範囲の 10 進数：
16
2 進数の変換結果：00010000
16 進数の変換結果：10
 */
public class Ex0235 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

        System.out.println("0～255 の範囲の 10 進数：");
        String str = scanner.nextLine();
        System.out.println(str);
        if (str.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        int ans=0;
        ans = Integer.parseInt(str);

        System.out.println("2進数の変換結果：" + String.format("%8s", Integer.toBinaryString(ans)).replace(' ', '0'));
        System.out.println("16進数の変換結果：" + Integer.toHexString(ans).toUpperCase());

        scanner.close();
	}

}
