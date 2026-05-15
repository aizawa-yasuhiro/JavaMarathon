package basic;

import java.text.ParseException;
import java.util.Scanner;

public class Ex0320 {

/*
 * 課題 0320
問題
キーボードから入力した整数値ｎの階乗を計算して出力する。
繰り返し文でもプログラムは作成できるが、今回は再帰呼び出しで作成すること。

作成クラス名
Ex0320.java

実行例
>Java Ex0320
input number：
10
10 の階乗は 3628800 です
 */
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		int number = 0;

		System.out.println("input number：");
		String input = scan.nextLine();
		if (input.isEmpty()) {
			System.out.println("エラー： 未入力です。");
			scan.close();
			return;
		}
		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}

		System.out.println(input + "の階乗は " + factorial(number) + "です。");
		scan.close();
	}

	// 階乗を求めるメソッド(再帰処理)
	static int factorial(int n){
        if (n > 0){
            return n * factorial(n-1);
        }else{
            return 1;
        }
    }

}
