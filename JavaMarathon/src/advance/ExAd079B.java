package advance;

import java.util.Scanner;

public class ExAd079B {

	/*
	 *課題 079-A
	問題
	1118 のような、3 つ以上の同じ数字が連続して並んだ 4 桁の整数を良い整数とします。
	4 桁の整数 N が与えられるので、N が良い整数かどうか判定してください。
	
	制約
	・1000 ≤ N ≤ 9999
	・N は整数である
	
	入力
	入力は以下の形式で標準入力から与えられる。
	> N
	
	出力
	N が良い整数の場合は「Yes」、そうでない場合は「No」を出力せよ。
	
	実行例 1
	> 7777
	Yes
	全ての数字が同じ場合でも良い整数になります。
	
	実行例 2
	> 1113
	Yes
	
	作成クラス名
	ExAd079A.java
	
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

		if (input.length() != 4) {
			System.out.println("エラー： 4 桁の整数を入力してください。");
			scan.close();
			return;
		}
		
		if (!input.matches("\\d{4}")) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}
		
		int N = Integer.parseInt(input);
		if (!(1000 <= N && N <= 9999)) {
			System.out.println("エラー： 1000以上9999以下の整数を入力してください。");
			scan.close();
			return;
		}
		
		if (input.charAt(0) == input.charAt(1) && input.charAt(1) == input.charAt(2) ||
				input.charAt(1) == input.charAt(2) && input.charAt(2) == input.charAt(3)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
		scan.close();

	}

}
