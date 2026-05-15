package basic;

import java.text.ParseException;
import java.util.Scanner;

public class Ex0255 {

/*
 * 課題 0255
問題
キーボードから「月の始まりの曜日の番号」と「月末の日の数字」を入力し、カレンダーを出力す
る。
「月の始まりの曜日の番号」は以下の通りとする。
日曜：0 月曜：1 火曜：2 水曜：3 木曜：4 金曜：5 土曜：6

作成クラス名
Ex0255.java

実行例
>Java Ex0255
月の始まりの曜日を数字で入力してください：
6
月末の日を数字で入力してください：
31
日 月 火 水 木 金 土
-----------------------
                  01
02 03 04 05 06 07 08
09 10 11 12 13 14 15
16 17 18 19 20 21 22
23 24 25 26 27 28 29
30 31
-----------------------
 */
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		int startDay = -1;
		int endDay = -1;

		// 始まりの曜日の入力
		System.out.print("月の始まりの曜日を入力してください : ");
		String input1 = scan.nextLine();
		if (input1.isEmpty()) {
			System.out.println("エラー： 未入力です。");
			scan.close();
			return;
		}
		try {
			startDay = Integer.parseInt(input1);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}
		if (startDay < 0 || startDay > 6) {
			System.out.println("エラー: 0〜6の整数で入力してください。");
			scan.close();
			return;
		}

		// 月末日付の入力
		System.out.print("月末の日を入力してください : ");
		String input2 = scan.nextLine();
		try {
			endDay = Integer.parseInt(input2);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}
		if (endDay < 28 || endDay > 31) {
			System.out.println("エラー: 28〜31の整数で入力してください。");
			scan.close();
			return;
		}

		// カレンダー表示
		printCalendar(startDay, endDay);
		scan.close();
	}

	// カレンダーを出力するメソッド
	public static void printCalendar(int startDay, int endDay) {
		System.out.println();
		System.out.println(" 日 月 火 水 木 金 土");
		System.out.println("---------------------");

		// 初日の空白処理
		for (int i = 0; i < startDay; i++) {
			System.out.printf("%3s", "");
		}

		int weekDay = startDay;

		// 各日付を表示
		for (int day = 1; day <= endDay; day++) {
			System.out.printf("%3s", String.format("%02d", day));
			weekDay++;
			if (weekDay % 7 == 0) {
				System.out.println();
			}
		}

		// 改行と罫線で締め
		System.out.println();
		System.out.println("---------------------");
	}

}
