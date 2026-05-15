package basic;

import java.util.Scanner;

/*
 * 問題
英語の試験の点数 e_score、数学の試験の点数 m_score を入力する。
両方の点数が 80 点以上の場合、「進級」と表示する。
点数のどちらかが 80 点を下回る場合、「再試験」と表示する。
両方の点数とも 80 点を下回る場合、「留年」と表示する。

作成クラス名
Ex0117.java

実行例
>Java Ex0117
input english score：
90
input math score：
85
進級

>Java Ex0117
input english score：
100
input math score：
76
再試験
 */
public class Ex0117 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        System.out.println("input english score:");
        String str = scanner.nextLine();
        System.out.println(str);
        if (str.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        int in;
        in = Integer.parseInt(str);

        System.out.println("input math score:");
        String str2 = scanner.nextLine();
        System.out.println(str2);
        if (str2.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        int in2;
        in2 = Integer.parseInt(str2);

        if(in>=80 && in2>=80){
            System.out.println("進級");
        }else if(in<80 && in2<80){
            System.out.println("留年");
        }else {
        	System.out.println("再試験");
        }

        scanner.close();
	}

}
