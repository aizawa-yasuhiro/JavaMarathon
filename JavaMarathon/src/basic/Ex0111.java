package basic;

import java.util.Scanner;

/*
 * 問題
キーボードから文字列を入力し、文字列内に「①,③,⑤,⑦,⑨」が含まれるか判定する。
含まれる場合は「許可しない文字(文字：XX YY 桁目)が含まれます」、
含まれない場合は「許可する文字列です」と出力する。

作成クラス名
Ex0111.java

実行例
>Java Ex0111
文字列：
この文字列（１）は許可されますか。
許可する文字列です

>Java Ex0111
文字列：
この文字列①は許可されますか。
許可しない文字(文字：① 6 桁目)が含まれます

 */
public class Ex0111 {

    /**
     * @param args
     */
    public static void main (String[] args){

    	final String[] PROHIBITED_CHARACTERS = {"①", "③", "⑤", "⑦", "⑨"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("文字列：");
        String text = scanner.nextLine();
        System.out.println(text);
        if (text.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        for (String str2 : PROHIBITED_CHARACTERS) {
			if (text.contains(str2)) {
				System.out.println("許可しない文字(文字：" + str2 + " " + (text.indexOf(str2)+1) + "桁目)が含まれます");
	            scanner.close();
				return;
			}
		}

        System.out.println("許可する文字列です");
        scanner.close();

    }
}
