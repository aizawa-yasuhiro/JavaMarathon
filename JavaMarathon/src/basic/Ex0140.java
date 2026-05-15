package basic;

import java.util.Scanner;

/*
 * 課題 0140
問題
キーボードから 2 つの整数値とコマンドを入力し、計算結果を出力する。
コマンドの意味は以下の通りとする。
0：足し算
1：引き算
2：掛け算
その他：割り算
 
作成クラス名
Ex0140.java

実行例
>Java Ex0140
input number1：
200
input number2：
50
input command：
0
計算結果 = 250

>Java Ex0140
input number1：
200
input number2：
60
input command：
8
計算結果 = 3
 */
public class Ex0140 {

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

        System.out.println("input command:");
        String str3 = scanner.nextLine();
        System.out.println(str3);
        if (str3.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }
        in[2] = Integer.parseInt(str3);

        int ans;
        switch (in[2]) {
		case 0:
			ans = in[0] + in[1];
			break;
		case 1:
			ans = in[0] - in[1];
			break;
		case 2:
			ans = in[0] * in[1];
			break;
		default:
			ans = in[0] / in[1];
			break;
		}
        System.out.println("計算結果 = " + ans);

        scanner.close();
	}

}
