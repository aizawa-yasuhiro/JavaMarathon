package basic;

import java.util.Scanner;

/*
 * 課題 0114
問題
キーボードから文字列を入力し、文字列内の半角空白で単語に分解する。
分解後、単語を逆順で出力する。半角空白が連続で入力された場合は無視する。

作成クラス名
Ex0114.java

実行例
>Java Ex0114
文字列：
one two three
結果：three two one

>Java Ex0114
文字列：
one two three four
結果：four three two one
 */
public class Ex0114 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

        System.out.println("文字列：");
        String str = scanner.nextLine();
        System.out.println(str);
        if (str.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        String[] str2 = str.split(" +", 0);

        System.out.print("結果：");
        for (int i = str2.length-1 ; i >= 0 ; i--){
       		System.out.print(str2[i] + " ");
        }

        scanner.close();
	}

}
