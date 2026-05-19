package advance;

import java.util.Scanner;

public class ExAd077D {

/*
 * 課題 077-D
問題
N の正の倍数の 10 進法における各桁の和としてありうる最少の値を求めてください。

制約
・2 ≤ N ≤ 105
・入力は整数である

入力
入力は以下の形式で標準入力から与えられる。
> N

出力
N の正の倍数の 10 進法における各桁の和としてありうる最少の値を出力せよ。

実行例 1
> 6
3
12=6×2 が最小値を達成します。

実行例 2
> 41
5
11111=41×271 が最小値を達成します。

作成クラス名
ExAd077D.java

 */
	public static void main(String[] args) {
		//キーボード入力
		int N;
		Scanner scan = new Scanner(System.in);
		try {
			N = scan.nextInt();
		} catch (Exception e) {
			System.out.println("引数が数字ではありません");
			return;
		} finally {
			scan.close();
		}

		if(N < 2 || 100000 < N) {
			System.out.println("引数が不正です。");
			return;
		}

		//仮の最小値をint型の最大値にする
		int min = Integer.MAX_VALUE;

		//N^2まで計算できるようにする
		for(int i = 1; i <= 100000; i++) {
			int sum = 0;
			for(int j = 0; j < 11; j++) {
				//10^10のメモリを確保したい
				sum += (int)(((long)N * i) % (long)Math.pow(10, j + 1)) / (long)Math.pow(10, j);
			}

			if(sum < min) {
				min = sum;
			}
		}

		System.out.println(min);

	}

}
