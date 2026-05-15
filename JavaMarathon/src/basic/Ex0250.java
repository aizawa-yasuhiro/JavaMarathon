package basic;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 課題 0250
問題
キーボードから 2 桁の数値を入力し、その数値が 100 以下の素数か判断し出力する。
数値が素数か否かの判断は、100 以下の素数を要素に持つ配列の中から二分探索を使用して行う。

作成クラス名
Ex0250.java

実行例
>Java Ex0250
input number：
34
素数ではありません

>Java Ex0250
input number：
17
素数です
 */
public class Ex0250 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("input number:");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		if (str.isEmpty()) {
			System.out.println("エラー： 未入力です。");
			scan.close();
			return;
		}
		int number = Integer.parseInt(str);
		if (number < 10 || number > 99) {
			System.out.println("エラー： ２桁の数字を入力してください。");
			scan.close();
			return;
		}

		// 100以下の素数を格納するリスト
		int[] iPrimeArray = { 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97 };

		if (Arrays.binarySearch(iPrimeArray, number) >= 0) {
			System.out.println("素数です");
		} else {
			System.out.println("素数ではありません");
		}

		scan.close();
	}
}
