package advance;

import java.util.Scanner;

public class ExAd090B {

/*
 * 課題 090-B
問題
A 以上 B 以下の整数のうち、回文数となるものの個数を求めてください。
但し、回文数とは先頭に 0 をつけない 10 進表記を文字列として見たとき、前から読んでも後ろから
読んでも同じ文字列となるような正の整数のことを指します。
制約
・10000 ≤ A, B ≤ 99999
・入力はすべて整数である
入力
入力は以下の形式で標準入力から与えられる。
> A B
出力
A 以上 B 以下の整数のうち、回文数となるものの個数を出力せよ。

実行例 1
> 11009 11332
4
11011, 11111, 11211, 11311 の 4 つが条件を満たします。

実行例 2
> 31415 92653
612

作成クラス名
ExAd090B.java
 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		
		System.out.print("> ");
		String input = scan.nextLine();
		if (input.isEmpty()) {
			System.out.println("エラー： 未入力です。");
			scan.close();
			return;
		}
		
		String[] sinput = input.split(" ");
		if (sinput.length < 2) {
			System.out.println("エラー: ２つの整数を入力してください。");
			scan.close();
			return;
		}
		
		int A = 0;
		int B = 0;
		try {
			A = Integer.parseInt(sinput[0]);
			B = Integer.parseInt(sinput[1]);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}
		
		if (!(10000 <= A && A <= 99999 && 10000 <= B && B <= 99999)) {
			System.out.println("エラー： [A, B]は10000以上99999以下の整数を入力してください。");
			scan.close();
			return;
		}
		
		int count = 0;
		for (int i = A; i <= B; i++) {
			String s = Integer.toString(i);
			if (s.equals(new StringBuilder(s).reverse().toString())) {
				count++;
			}
		}
		
		System.out.println(count);
		scan.close();

	}

}
