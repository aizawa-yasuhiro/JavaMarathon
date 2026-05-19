package advance;

import java.util.Scanner;

public class ExAd080B {

	/*
	 *課題 080-B
	問題
	整数 X を 10 進法で表したときの各桁の数字の和を f(X)としたとき、X が f(X)で割り切れる場合、
	X はハーシャッド数です。
	整数 N が与えられるので、ハーシャッド数かどうか判定してください。
	
	制約
	・1 ≤ N ≤ 10の8乗
	・N は整数である
	
	入力
	> N
	入力は以下の形式で標準入力から与えられる。
	
	出力
	N がハーシャッド数の場合は「Yes」、そうでない場合は「No」を出力せよ。
	
	実行例 1
	> 12
	Yes
	f(12)=1+2=3 より、12 は 3 で割り切れるので 12 はハーシャッド数です。
	
	実行例 2
	> 57
	No
	f(57)=5+7=12 より、57 は 12 で割り切れないのでハーシャッド数ではありません。
	
	作成クラス名
	ExAd080B.java
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

		int M = 0;
		try {
			M = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}

		if (!(1 <= M && M <= 100000000)) {
			System.out.println("エラー： Nは1以上10の8乗以下の整数を入力してください。");
			scan.close();
			return;
		}

		int sum = 0;
		int temp = M;
		while (temp > 0) {
			sum += temp % 10;
			temp /= 10;
		}

		if (M % sum == 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		scan.close();

	}

}
