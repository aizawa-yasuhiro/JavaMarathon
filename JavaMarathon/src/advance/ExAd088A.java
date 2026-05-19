package advance;

import java.util.Scanner;

public class ExAd088A {

	/*
	 * 課題 088-A
問題
佐藤さんは 1 円硬貨を A 枚と 500 円硬貨を無限枚持っています。
これらの硬貨だけを使うことによって、ちょうど N 円支払うことができるか判定してください。
制約
・1 ≤ N ≤ 10000
・0 ≤ A ≤ 1000
入力
入力は以下の形式で標準入力から与えられる。
> N A
出力
1 円硬貨と 500 円硬貨だけでちょうど支払うことができる場合は「Yes」、そうでない場合は「No」
を出力せよ。

実行例 1
> 2018 218
Yes
500 円硬貨 4 枚と 1 円硬貨 18 枚で支払うことができます。

実行例 2
1 円硬貨を 1 枚も持っていないこともあり得ます。
> 2763 0
No
作成クラス名
ExAd088A.java
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
		
		int N = 0;
		int A = 0;
		try {
			N = Integer.parseInt(sinput[0]);
			A = Integer.parseInt(sinput[1]);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}
		
		if (!(1 <= N && N <= 10000 && 0 <= A && A <= 1000)) {
			System.out.println("エラー： [N, A]は1以上10000以下の整数を入力してください。");
			scan.close();
			return;
		}
		
		if (N % 500 <= A) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
		scan.close();

	}

}
