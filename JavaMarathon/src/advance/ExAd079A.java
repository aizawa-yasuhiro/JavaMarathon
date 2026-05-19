package advance;

import java.util.Scanner;

public class ExAd079A {

	/*
	 *課題 079-B
問題
今、日本は 11 月 18 日ですが、11 と 18 は隣り合うリュカ数です。
整数 N が与えられるので、N 番目のリュカ数を求めてください。
但し、リュカ数は i 番目のリュカ数を Liとすると、
・L0 = 2
・L1 = 1
・Li = Li-1 + Li-2 (i ≧ 2)
と定義される数とします。

制約
・1 ≤ N ≤ 86
・N は整数である
・答えは 10の18乗より小さいことが保証される

入力
入力は以下の形式で標準入力から与えられる。
> N

出力
N 番目のリュカ数を出力せよ。

実行例 1
> 5
11
・L0 = 2
・L1 = 1
・L2 = L0 + L1 = 3
・L3 = L1 + L2 = 4
・L4 = L2 + L3 = 7
・L5 = L3 + L4 = 11
より、5 番目のリュカ数は 11 です。

実行例 2
> 86
939587134549734843

作成クラス名
ExAd079B.java
	
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
		
		int N = 0;
		try {
			N = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}
		
		if (!(1 <= N && N <= 86)) {
			System.out.println("エラー： Nは1以上86以下の整数を入力してください。");
			scan.close();
			return;
		}

		long[] lucas = new long[N + 1];
		lucas[0] = 2;
		if (N >= 1) {
			lucas[1] = 1;
		}
		for (int i = 2; i <= N; i++) {
			lucas[i] = lucas[i - 1] + lucas[i - 2];
		}
		
		System.out.println(lucas[N]);
		
		scan.close();

	}

}
