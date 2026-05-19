package advance;

import java.util.Scanner;

public class ExAd086B {

	/*
	 * 課題 086-B
問題
鈴木くんは 2 つの正整数 a, b を見つけました。
a と b をこの順に繋げて読んだものが平方数かどうか判定してください。

制約
・1 ≤ a, b ≤ 100
・a,b は整数である

入力
入力は以下の形式で標準入力から与えられる。
> a b
出力
a と b をこの順に繋げて読んだものが平方数なら「Yes」、そうでない場合は「No」を出力せよ。

実行例 1
> 1 21
Yes
121=11×11 なので平方数です。

実行例 2
> 100 100
No
100100 は平方数ではありません。

作成クラス名
ExAd086B.java

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

		if (!(1 <= N && N <= 100 && 1 <= A && A <= 100)) {
			System.out.println("エラー： [N, A]は1以上100以下の整数を入力してください。");
			scan.close();
			return;
		}
		
		String str = String.valueOf(N) + String.valueOf(A);
		int num = Integer.parseInt(str);
		int sqrt = (int) Math.sqrt(num);
		if (sqrt * sqrt == num) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
		scan.close();

	}

}
