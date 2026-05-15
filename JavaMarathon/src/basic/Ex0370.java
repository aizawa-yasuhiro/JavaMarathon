package basic;

import java.util.Scanner;

public class Ex0370 {

/*
 * 課題 0370
問題
起動時引数として正解の 4 桁の数字を与える。
999 を入力してギブアップするか、正解を入力するまで予想数字の入力と当たり判定の結果を出力
し続ける。
ヒット：位置も数字も一致している数
ブロー：位置は一致していないが、数字が一致している数

実行例
作成クラス名
Ex0370.java

>Java Ex0370 0324
（1 回目）予測数字を入力してください：0541
ヒット：1 ブロー：1
（2 回目）予測数字を入力してください：0514
ヒット：2 ブロー：0
（3 回目）予測数字を入力してください：999
正解は 0324 でした。
 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ


		if (args.length == 0) {
			System.out.println("正解の数字が指定されていません。");
			return;
		}
		
		if (args[0].length() != 4 || !args[0].matches("\\d{4}")) {
			System.out.println("正解の数字は4桁の数字でなければなりません。");
			return;
		}
		
		String answer = args[0];
		int hit = 0;
		int blow = 0;
		int count = 0;
		
        Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("（" + ++count + "回目）予測数字を入力してください：");
//			String input = System.console().readLine();
			String input = scanner.nextLine();
			if (input.equals("999")) {
				System.out.println("正解は " + answer + " でした。");
				break;
			}
			
			if (input.length() != 4 || !input.matches("\\d{4}")) {
				System.out.println("予測数字は4桁の数字でなければなりません。");
				continue;
			}
			
			hit = 0;
			blow = 0;
			for (int i = 0; i < 4; i++) {
				if (input.charAt(i) == answer.charAt(i)) {
					hit++;
				} else if (answer.indexOf(input.charAt(i)) != -1) {
					blow++;
				}
			}
			
			System.out.println("ヒット：" + hit + " ブロー：" + blow);
			if (hit == 4) {
				System.out.println("正解です！");
				break;
			}
		}

		scanner.close();

	}

}
