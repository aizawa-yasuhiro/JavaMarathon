package advance;

import java.util.Scanner;

public class ExAd084A {

	/*
	 *課題 084-A
問題
12 月 30 日の M 時から次の年になるまでは何時間か、求めてください。

制約
・1 ≤ M ≤ 23
・M は整数である

入力
入力は以下の形式で標準入力から与えられる。
> M

出力
12 月 30 日の M 時から次の年になるまでが x 時間のとき、x を出力せよ。

実行例 1
> 21
27
12 月 30 日の 21 時から次の年になるまでは 27 時間です。

実行例 2
> 12
36

作成クラス名
ExAd084A.java

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
		
		if (!(1 <= M && M <= 23)) {
			System.out.println("エラー： Mは1以上23以下の整数を入力してください。");
			scan.close();
			return;
		}
		
		// 12月30日のM時から次の年になるまでの時間は、(24 - M) + 24 = 48 - M 時間です。
		int hours = 48 - M;
		System.out.println(hours);
		
		scan.close();

	}

}
