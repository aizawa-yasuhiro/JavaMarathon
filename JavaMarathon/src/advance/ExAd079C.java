package advance;

import java.util.Scanner;

public class ExAd079C {

	/*
	 *課題 079-C
問題
切符には 4 つの 0 以上 9 以下の整数 A,B,C,D が整理番号としてこの順に書かれています。
A op1 B op2 C op3 D = 7 となるように op1,op2,op3 に「＋」か「－」を入れて式を作っ
て下さい。
なお、答えが存在しない入力は与えられず、また答えが複数存在する場合はどれを出力してもよい
ものとします。

制約
・0 ≤ A, B, C, D ≤ 9
・入力は整数である
・答えが存在しない入力は Error とする

入力
入力は以下の形式で標準入力から与えられる。
> ABCD

出力
作った式を「=7」の部分も含めて出力せよ。

実行例 1
> 0290
0-2+9+0=7
この他に「0-2+9-0=7」も条件を満たします。

作成クラス名
ExAd079C.java
	
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
			System.out.println("エラー： 入力は4桁の整数でなければなりません。");
			scan.close();
			return;
		}
		
		if (!input.matches("\\d{4}")) {
			System.out.println("エラー： 入力は4桁の整数でなければなりません。");
			scan.close();
			return;
		}
		
		int A = Character.getNumericValue(input.charAt(0));
		int B = Character.getNumericValue(input.charAt(1));
		int C = Character.getNumericValue(input.charAt(2));
		int D = Character.getNumericValue(input.charAt(3));
		
		String[] operators = { "+", "-" };
		boolean found = false;
		
		for (String op1 : operators) {
			for (String op2 : operators) {
				for (String op3 : operators) {
					int result = 0;
					if (op1.equals("+")) {
						result += A + B;
					} else {
						result += A - B;
					}
					if (op2.equals("+")) {
						result += C;
					} else {
						result -= C;
					}
					if (op3.equals("+")) {
						result += D;
					} else {
						result -= D;
					}
					
					if (result == 7) {
						System.out.println(A + op1 + B + op2 + C + op3 + D + "=7");
						found = true;
						break;
					}
				}
				if (found) break;
			}
			if (found) break;
		}
		
		scan.close();

	}

}
