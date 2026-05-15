package basic;

import java.util.Scanner;

/*
 * 課題 0115
問題
キーボードから文字列を入力し、文字列内の半角空白で単語に分解する。
分解後、単語の出力順序が偶数と奇数でそれぞれ結合して出力する。

作成クラス名
Ex0115.java

実行例
>Java Ex0115
文字列：
数学 80 英語 100 理科 75 国語 0 歴史 60
奇数番目：数学 英語 理科 国語 歴史
偶数番目：80 100 75 0 60
 */
public class Ex0115 {

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

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        String[] str2 = str.split(" +", 0);

        for (int i = 0 ; i < str2.length ; i=i+2){
        	sb1.append(str2[i] + " ");
        	sb2.append(str2[i+1] + " ");
        }

        System.out.println("奇数番目" + new String(sb1));
        System.out.println("偶数番目" + new String(sb2));

        scanner.close();
	}

}
