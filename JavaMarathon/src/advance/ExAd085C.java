package advance;

import java.util.Scanner;

public class ExAd085C {

	/*
	 *課題 085-C
問題
日本でよく使われる紙幣は 10000 円札、5000 円札、1000 円札です。以下、「お札」とはこの 3 種を
指します。
田中くんが言うには、彼が祖父から受け取ったお年玉袋にはお札が N 枚入っていて、合計 Y 円だっ
たそうですが、ウソかもしれません。このような状況がありうるか判定し、ありうる場合はお年玉
袋の中身の候補を一つ見つけてください。
なお、彼の祖父は十分裕福であり、お年玉袋は十分大きかったものとします。

制約
・1 ≤ N ≤ 2000
・1000 ≤ Y ≤ 2×107
・N は整数であり、Y は 1000 の倍数である。

入力
入力は以下の形式で標準入力から与えられる。
> N Y

出力
N 枚のお札の合計金額が Y 円となることがあり得ない場合は「-1 -1 -1」と出力せよ。
あり得る場合、そのような N 枚のお札の組み合わせの一例を「10000 円札 x 枚、5000 円札 y 枚、
1000 円札 z 枚」として x,y,z を空白区切りで出力せよ。複数の可能性が考えられる場合は、そのう
ちどれを出力してもよい。

実行例 1
> 9 45000
4 0 5
10000 円札 4 枚と 1000円札 5 枚で満たせます。5000 円 9 枚という可能性も考えられるため、「0 9 0」
も正しい出力です。

実行例 2
> 20 196000
-1 -1 -1
合計枚数が 20 枚の場合、全てが 10000 円札であれば合計金額が 200000 円になり、そうでなければ
195000 円となるため、196000 円という合計金額はありえません。

実行例 3
> 1000 1234000
14 27 959
この他にも多くの候補があります。

作成クラス名
ExAd085C.java

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

		String[] sinput = input.split(" ");
		if (sinput.length < 2) {
			System.out.println("エラー: ２つの整数を入力してください。");
			scan.close();
			return;
		}
		
		int N = 0;
		int A = 0;
		try {
			N = Integer.parseInt(sinput[0]);
			A = Integer.parseInt(sinput[1]);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字で入力してください。");
			scan.close();
			return;
		}

		if (!(1 <= N && N <= 2000 && 1000 <= A && A <= 20000000 && A % 1000 == 0)) {
			System.out.println("エラー： [N, Y]は1以上2000以下の整数を入力してください。");
			scan.close();
			return;
		}
		
		// 10000 円札の枚数を x、5000 円札の枚数を y、1000 円札の枚数を z とすると、
		// x + y + z = N
		// 10000x + 5000y + 1000z = A
		// これらの式を満たす整数解 (x, y, z) を見つける必要があります。
		// まず、x を 0
		// から N までループして、y を 0 から N-x までループし、z を N-x-y として計算します。
		boolean found = false;
		for (int x = 0; x <= N; x++) {
			for (int y = 0; y <= N - x; y++) {
				int z = N - x - y;
				found = (10000 * x + 5000 * y + 1000 * z == A);
				if (found) {
					System.out.println(x + " " + y + " " + z);
					break;
				}
			}
			if (found) {
				break;
			}
		}

		
		if (!found) {
			System.out.println("-1 -1 -1");
		}
		
		scan.close();

	}

}
