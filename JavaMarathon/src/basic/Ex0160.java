package basic;

import java.util.Scanner;

/*
 * 課題 0160
問題
キーボードから入力された 0~5 の範囲の 2 つの数字を元に、占いの結果を出力する。
占いの結果は以下のルールに従う。
2 つ目の数字
0 1 2 3 4 5
1 つ目の
数字
0 吉 吉 凶 凶 凶 吉
1 吉 吉 凶 吉 凶 吉
2 凶 凶 吉 吉 吉 吉
3 凶 吉 吉 吉 凶 凶
4 凶 凶 凶 吉 吉 凶
5 凶 吉 吉 凶 凶 凶

作成クラス名
Ex0160.java

実行例
>Java Ex0160
1 つ目の数字（0~5）：
2
2 つ目の数字（0~5）：
4
占いの結果は吉です

>Java Ex0160
1 つ目の数字（0~5）：
5
2 つ目の数字（0~5）：
5
占いの結果は凶です
 */
public class Ex0160 {

	public static void main(String[] args) {

		final char[][] DISISION_TABLE =
			{{'吉','吉','凶','凶','凶','吉'},
			 {'吉','吉','凶','吉','凶','吉'},
			 {'凶','凶','吉','吉','吉','吉'},
			 {'凶','吉','吉','吉','凶','凶'},
			 {'凶','凶','凶','吉','吉','凶'},
			 {'凶','吉','吉','凶','凶','凶'}};

		Scanner scanner = new Scanner(System.in);
        System.out.println("1つ目の数字（ 0~5");
        String str = scanner.nextLine();
        System.out.println(str);
        if (str.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        int in;
        in = Integer.parseInt(str);

        System.out.println("2つ目の数字（ 0~5");
        String str2 = scanner.nextLine();
        System.out.println(str2);
        if (str2.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        int in2;
        in2 = Integer.parseInt(str2);

        System.out.println("占いの結果は" + DISISION_TABLE[in][in2] + "です");

        scanner.close();
	}
}
