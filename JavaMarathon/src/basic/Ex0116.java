package basic;

import java.util.Scanner;

/*
 * 課題 0116
問題
2 つの整数値 i1、i2 を入力する。
i1 が偶数であり、かつ i2 が偶数の場合、「2 つの値ともに偶数です」と表示する。
i1 が奇数であり、かつ i2 が偶数の場合、「i1 は奇数です。i2 は偶数です」と表示する。
i1 が偶数であり、かつ i2 が奇数の場合、「i1 は偶数です。i2 は奇数です」と表示する。
i1 が奇数であり、かつ i2 が奇数の場合、「2 つの値ともに奇数です」と表示する。

作成クラス名
Ex0116.java

実行例
>Java Ex0116
input number1：
3
input number2：
6
i1 は奇数です。i2 は偶数です

>Java Ex0116
input number1：
6
input number2：
12
2 つの値ともに偶数です
 */
public class Ex0116 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        System.out.println("input number1");
        String str = scanner.nextLine();
        System.out.println(str);
        if (str.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        int in;
        in = Integer.parseInt(str);

        System.out.println("input number2");
        String str2 = scanner.nextLine();
        System.out.println(str2);
        if (str2.isEmpty()) {
        	System.out.println("入力がありません。");
            scanner.close();
        	return;
        }

        int in2;
        in2 = Integer.parseInt(str2);

        if(in%2==0 && in2%2==0){
            System.out.println("2 つの値ともに偶数です");
        }else if(in%2!=0 && in2%2==0){
            System.out.println("i1 は奇数です。 i2 は偶数です");
        }else if(in%2==0 && in2%2!=0){
            System.out.println("i1 は偶数です。 i2 は奇数です");
        }else {
        	System.out.println("2 つの値ともに奇数です");
        }

        scanner.close();
	}

}
