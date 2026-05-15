package basic;

import java.util.Scanner;

/*
 * 課題 0245
問題
キーボードから 2 つの整数値を入力し、最大公約数を出力する。

作成クラス名
Ex0245.java

実行例
>Java Ex0245
input number1：
252
input number2：
105
最大公約数 = 21

>Java Ex0245
input number1：
1368
input number2：
456
最大公約数 = 456
 */
public class Ex0245 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);

		System.out.println("input number１:");
		String input1 = scan.nextLine();
		if (input1.isEmpty()) {
			System.out.println("エラー： 未入力です。");
			scan.close();
			return;
		}
		int number1 = Integer.parseInt(input1);

		System.out.println("input number２:");
		String input2 = scan.nextLine();
		if (input2.isEmpty()) {
			System.out.println("エラー： 未入力です。");
			scan.close();
			return;
		}
		int number2 = Integer.parseInt(input2);

		System.out.println("最大公約数 = " + gcd(number1, number2));

		scan.close();

	}

	// ユークリッドの互助法
	private static int gcd(int number1, int number2) {
		if (number2 == 0) {
			return number1;
		} else {
			return gcd(number2, number1 % number2);
		}
	}

}
