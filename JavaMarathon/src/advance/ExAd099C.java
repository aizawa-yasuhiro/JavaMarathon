package advance;

import java.text.ParseException;
import java.util.Scanner;

public class ExAd099C {

/*
 * 問題
ある銀行では、お金の引き出しを難しくするために、一回の操作で引き出せる金額が以下のいずれ
かとなっています。
・1 円
・6 円、62 (=36)円、63 (=218)円、・・・
・9 円、92 (=81)円、93 (=729)円、・・・
この銀行からちょうど N 円を引き出すには少なくとも何回の操作が必要か求めてください。
ただし、一度引き出したお金を再び預け入れてはならないとします。
制約
・1 ≤ N ≤ 100000
・N は整数である
入力
入力は以下の形式で標準入力から与えられる。
> N
出力
この銀行からちょうど N 円を引き出すのに少なくとも x 回の操作が必要なとき、x を出力せよ。

実行例 1
> 127
4

1 円、9 円、36(=62)円、81(=92)円を引き出す操作をそれぞれ 1 回ずつ行うことで、合計 4 回の操作
で 127 円を引き出すことができます。

実行例 2
> 3
3

1 円を引き出す操作を 3 回行うことで、合計 3 回の操作で 3 円を引き出すことができます。
 */
	public static void main(String[] args) throws ParseException {
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
			System.out.println("エラー: 数字を入力してください。");
			scan.close();
			return;
		}

		if (N < 1 || N > 100000) {
			System.out.println("エラー： 1から100000の整数を入力してください。");
			scan.close();
			return;
		}

		//1,6,9,36,81,216,729,1296,6561,7776,46656,59049
        // 44852 18 16
		// 44846 15 15
		// 44847 13 11
		int n = N;
		int[] money = { 1, 6, 9, 36, 81, 216, 729, 1296, 6561, 7776, 46656, 59049 };
		int count = 0;
		for (int j = money.length - 1; j >= 0; j--) {
			if (N >= money[j]) {
				int x = N / money[j];
				N = N - (money[j] * x);
				count = count + x;
			}
		}

		System.out.println(count);

		int[] ar = {1,6,9,36,81,216,729,1296,6561,7776,46656,59049};

		int[] dp = new int[100005];
		dp[0] = 0;

		for (int i=1; i<=n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j=0; j<ar.length; j++) {
//System.out.println("step1 j= " + j);
				if (i >= ar[j]) {
//System.out.println("step2 " + min + " " + (dp[i-1]+1) + " " + (dp[i-ar[j]]+1) + " " + i + " " + j);
					min = Math.min(min, Math.min(dp[i-1]+1, dp[i-ar[j]]+1));
//System.out.println("step3 " + min);
				}
			}
			dp[i] = min;

		}

		System.out.println(dp[n]);

		scan.close();
	}

}
