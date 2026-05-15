package basic;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ex0256 {

/*
 * 課題 0256
問題
キーボードから文字列を入力し、その文字列が指定した日付形式か否か出力する。
日付形式は「YYYY/MM/DD」とする。

作成クラス名
Ex0256.java

実行例
>Java Ex0256
input date：
2018/06/13
指定した形式です

>Java Ex0256
input date：
2018/6/3
指定した形式ではありません
 */
	public static void main(String[] args) throws ParseException {
		// TODO 自動生成されたメソッド・スタブ
		// DateTimeFormatterの作成
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd");

		Scanner scan = new Scanner(System.in);

		// 入力を受け取る
		System.out.println("input date１：");
		String input1 = scan.nextLine().trim();
		if (input1.isEmpty()) {
			System.out.println("エラー： 未入力です。");
			scan.close();
			return;
		}

		try {
			LocalDate.parse(input1, formatter);
			System.out.println("指定した形式です。");
		} catch (DateTimeParseException e) {
			// TODO: handle exception
			System.out.println("指定した形式ではありません。");
		}

		scan.close();
	}

}
