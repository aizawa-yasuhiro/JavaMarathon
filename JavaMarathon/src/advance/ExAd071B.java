package advance;

import java.util.Scanner;

public class ExAd071B {

/*
 *課題 071-B
問題
英小文字からなる文字列 S が与えられます。S に現れない英小文字であって、最も辞書順(アルファ
ベット順)で小さいものを求めてください。但し、S にすべての英小文字が現れる場合は、代わりに
「None」を出力してください。

制約
・1 ≤ |S| ≤ 105
(|S|は文字列 S の長さ)
・S は英小文字からなり、それ以外の文字は無視する

入力
入力は以下の形式で標準入力から与えられる。
> S

出力
S に現れない英小文字であって、最も辞書順で小さいものを出力せよ。
但し、S にすべての英小文字が現れる場合は、代わりに「None」を出力せよ。

実行例 1
> atcoderregularcontest
b
「atcoderregularcontest」という文字列には「a」は現れますが「b」は現れません。

実行例 2
> abcdefghijklmnopqrstuvwxyz
None
この文字列にはすべての英小文字が現れます。

作成クラス名
ExAd071B.java

 */
	public static void main(String[] args) {
		//キーボード入力
		String S;
		Scanner scan = new Scanner(System.in);
		try {
			S = scan.nextLine();
		} catch (Exception e) {
			System.out.println("引数が文字列ではありません");
			return;
		} finally {
			scan.close();
		}
		
		if(S.length() < 1 || 100000 < S.length()) {
			System.out.println("引数が不正です。");
			return;
		}
		
		//アルファベットの出現を記録する配列
		boolean[] alphabet = new boolean[26];
		
		//Sに現れる英小文字を記録する
		for(int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if(c >= 'a' && c <= 'z') {
				alphabet[c - 'a'] = true;
			}
		}
		
		//最も辞書順で小さい英小文字を探す
		for(int i = 0; i < 26; i++) {
			if(!alphabet[i]) {
				System.out.println((char)(i + 'a'));
				return;
			}
		}
		
		System.out.println("None");
	}

}
