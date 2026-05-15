package basic;

import java.util.Scanner;

/*
 * 課題 0215
問題
キーボードから複数の数字を入力し、足して 10 になる 2 つの数値をペアとして出力する。

作成クラス名
Ex0215.java

実行例
>Java Ex0215
input number：
1 3 5 7
3 と 7 は足して 10 となるペアです

>Java Ex0215
input number：
5 6
ペアとなる数字はありません

>Java Ex0215
input number：
1 2 3 4 5 6 7 8 9
1 と 9、2 と 8、3 と 7、4 と 6 は足して 10 となるペアです
 */
public class Ex0215 {

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

        int cnt=0,ans1=0,ans2=0;

        for (int i = 0 ; i < str2.length ; i++){
        	ans1 = Integer.parseInt(str2[i]);
       		for (int j = i+1; j < str2.length; j++) {
				ans2 = Integer.parseInt(str2[j]);
				if (ans1+ans2 == 10) {
					if (cnt > 0) {
						System.out.print(",");
					}
					System.out.print(str2[i] + " と " + str2[j]);
					cnt++;
				}
			}
        }

        if (cnt > 0) {
        	System.out.println(" は足して 10 となるペアです");
        } else {
        	System.out.println("ペアとなる数字はありません");
        }

        scanner.close();
	}

}
