package basic;

import java.util.Scanner;

/*
 * 課題 0240
問題
2 桁の数字を入力すると、九九の表に値があるかどうか出力する。

作成クラス名
Ex0240.java

実行例
>Java Ex0240
input number：
64
九九の表（8 * 8）にあります

>Java Ex0240
input number：
65
九九の表にありません
 */
public class Ex0240 {

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

        int ans=0;
        boolean flg=false;
        ans = Integer.parseInt(str);

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i*j == ans) {
					System.out.println("九九の表（ " + i + " * " + j + "）にあります");
					flg = true;
				}
			}
		}

		if (!flg) {
			System.out.println("九九の表にありません");
		}

        scanner.close();
	}

}
