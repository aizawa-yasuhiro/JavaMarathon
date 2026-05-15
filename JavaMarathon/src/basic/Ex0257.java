package basic;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ex0257 {

/*
 * 課題 0257
問題
キーボードから日付を 2 つ入力し、大きい日付から小さい日付の差を秒で出力する。
日付形式は「YYYY/MM/DD」とする。日付が等しい場合はゼロを出力する。

作成クラス名
Ex0257.java

実行例
>Java Ex0257
input date1：
2018/06/13
input date2：
2018/06/11
日数の差は 2 日で 172800 秒です

>Java Ex0257
input date1：
2018/06/11
input date2：
2018/06/13
日数の差は 2 日で 172800 秒です

>Java Ex0256
input date1：
2018/06/13
input date2：
2018/06/13
日数の差は 0 日です
 */
	public static void main(String[] args) throws ParseException {
		// TODO 自動生成されたメソッド・スタブ
		// DateTimeFormatterの作成
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		// LocalDateの作成
		LocalDate day1, day2 = LocalDate.now();

		Scanner scan = new Scanner(System.in);

		try {
			// 入力を受け取る
			System.out.println("input date１：");
			String input1 = scan.nextLine().trim();
			if (input1.isEmpty()) {
				System.out.println("エラー： 未入力です。");
				scan.close();
				return;
			}
			day1 = LocalDate.parse(input1, formatter);

			// 入力を受け取る
			System.out.println("input date２：");
			String input2 = scan.nextLine().trim();
			if (input2.isEmpty()) {
				System.out.println("エラー： 未入力です。");
				scan.close();
				return;
			}
			day2 = LocalDate.parse(input2, formatter);

		} catch (DateTimeParseException e) {
			// TODO: handle exception
			System.out.println("指定した形式ではありません。");
			scan.close();
			return;
		}

		if (day1.equals(day2)) {
			System.out.println("日数の差は0日です。");
		} else {
			// 日付の差・秒数の差
			Duration timeBtween = Duration.between(day1.atStartOfDay(), day2.atStartOfDay());
			// Durationの.toSecondはJDK1.9から導入されたため無い
			System.out.println("日数の差は" +
					timeBtween.abs().toDays() + "日で" +
					timeBtween.abs().toMinutes() * 60 + "秒です。");
		}

		scan.close();
	}

}
