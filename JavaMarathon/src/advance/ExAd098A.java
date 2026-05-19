package advance;

import java.text.ParseException;
import java.util.Scanner;

public class ExAd098A {

/*
 * 課題 098-A
問題
2 つの整数 A, B が与えられます。A+B, A-B, A×B の中で最大の値を求めてください。
制約
・-1000 ≤ A, B ≤ 1000
・入力はすべて整数である
入力
入力は以下の形式で標準入力から与えられる。
> A B
出力
A+B, A-B, A×B の中で最大の値を出力せよ。

実行例 1
> 3 1
4

3+1=4, 3-1=2, 3×1=3 なので、この中で最大値である 4 が答えになります。

実行例 2
> 4 -2
6

4-(-2)=6 が最大値となります。

作成クラス名
ExAd098A.java
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
		if (sinput.length < 2) {
			System.out.println("エラー: ２つの整数を入力してください。");
			scan.close();
			return;
		}

		int A = 0;
		int B = 0;
		try {
			A = Integer.parseInt(sinput[0]);
			B = Integer.parseInt(sinput[1]);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}

		if (!(-1000 <= A && A <= 1000 && -1000 <= B && B <= 1000)) {
			System.out.println("エラー： [A, B]は-1000以上1000以下の整数を入力してください。");
			scan.close();
			return;
		}

		// A+B, A-B, A×B の中で最大の値を求める
		System.out.println(Math.max(A + B, Math.max(A - B, A * B)));

		scan.close();
	}

}
