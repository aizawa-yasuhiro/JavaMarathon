package advance;

import java.text.ParseException;
import java.util.Scanner;

public class ExAd097A {

/*
 * 課題 097-A
問題
数直線上にいる A さんと B さんと C さんがトランシーバーで会話しようとしています。
A さんは a[m]地点、B さんは b[m]地点、C さんは c[m]地点にいます。二人の人間は、距離が d[m]
以内のとき直接会話が出来ます。
A さんと C さんが直接または間接的に会話出来るか判定して下さい。但し、A さんと C さんが間接
的に会話出来るとは、A さんと B さんが直接会話でき、かつ B さんと C さんが直接会話できること
を指します。
制約
・1 ≤ a, b, c ≤ 100
・1 ≤ d ≤ 100
・入力は全て整数
入力
入力は以下の形式で標準入力から与えられる。
> a b c d
出力
会話できるなら「Yes」を、できないなら「No」を出力しなさい。

実行例 1
> 4 7 9 3
Yes
A さんと B さんは直接会話可能です。また、B さんと C さんも直接会話可能です。

実行例 2
> 100 10 1 2
No
この場合は不可能です。

実行例 3
> 10 10 10 2
Yes
複数人が同じ場所にいることもあります。

作成クラス名
ExAd097A.java
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

		String[] sinput = input.split(" ");
		if (sinput.length < 4) {
			System.out.println("エラー: ４つの整数を入力してください。");
			scan.close();
			return;
		}

		int a, b, c, d;
		try {
			a = Integer.parseInt(sinput[0]);
			b = Integer.parseInt(sinput[1]);
			c = Integer.parseInt(sinput[2]);
			d = Integer.parseInt(sinput[3]);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}

		if (!(1 <= a && a <= 100 && 1 <= b && b <= 100 && 1 <= c && c <= 100 && 1 <= d && d <= 100)) {
			System.out.println("エラー： [a, b, c, d]は1以上100以下の整数で入力して下さい。");
			scan.close();
			return;
		}

		// 条件にしたがってYes, Noを表示する
		if (Math.abs(a - c) <= d || (Math.abs(a - b) <= d && Math.abs(b - c) <= d)) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

		scan.close();
	}

}
