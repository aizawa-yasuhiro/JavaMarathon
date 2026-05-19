package advance;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ExAd096A {

/*
 * 課題 096-A
問題
王国では、5 月 5 日のような月の数と日の数が同じ日を「高橋」と言う。
2018 年 1 月 1 日から 2018 年 a 月 b 日までに、「高橋」は何日あるか。
但し、王国ではグレゴリオ暦を利用しているものとする。
制約
・a は 1 以上 12 以下の整数
・b は 1 以上 31 以下の整数
・2018 年 a 月 b 日はグレゴリオ暦において正しい日付である
入力
入力は以下の形式で標準入力から与えられる。
> a b
出力
2018 年 1 月 1 日から 2018 年 a 月 b 日までに「高橋」は何日あるか、出力しなさい。

実行例 1
> 5 5
5

1 月 1 日、2 月 2 日、3 月 3 日、4 月 4 日、5 月 5 日。合計 5 日が「高橋」です。

実行例 2
>2 1
1

1 月 1 日のみが「高橋」です。

作成クラス名
ExAd096A.java
 */
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		int iMonth, iDay = 0;

		System.out.println("input number：");
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

		try {
			iMonth = Integer.parseInt(sinput[0]);
			iDay = Integer.parseInt(sinput[1]);
			LocalDate.of(2018, iMonth, iDay);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		} catch (DateTimeException e) {
			System.out.println("エラー: 正しい日付けを入力してください。");
			scan.close();
			return;
		}

		if (iMonth - iDay < 1) {
			System.out.println(iMonth);
		} else {
			System.out.println(iMonth-1);
		}

		scan.close();
	}

}
