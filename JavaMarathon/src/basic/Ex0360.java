package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex0360 extends Board{

/*
 * 課題 0360
問題
オセロ盤を初期表示する。黒白交互に打つ場所を入力し、打った後の盤面を表示することを繰り返
す。最後まで打ち終えたら終了する。
但し、打てる場所がなくパスする場合は位置として「9」を入力する。

作成クラス名
Ex0360.java

実行例
>Java Ex0360
１２３４５６７８
１□□□□□□□□
２□□□□□□□□
３□□□□□□□□
４□□□●○□□□
５□□□○●□□□
６□□□□□□□□
７□□□□□□□□
８□□□□□□□□
●：２ ○：２
黒の手(行、列) > 4, 6

１２３４５６７８
１□□□□□□□□
２□□□□□□□□
３□□□□□□□□
４□□□●●●□□
５□□□○●□□□
６□□□□□□□□
７□□□□□□□□
８□□□□□□□□
●：４ ○：１
白の手(行、列) > 
 */
	public static void main(String[] args) throws IOException {
		/**
		 * 初期状態を構築
		 * 初期状態のオセロ版を描写
		 */
		Board.initialize();
		Board.showBoard();

		int cnt = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * ゲーム実行中フラグがtrueのあいだループする
		 */
		while(Board.game){

			if(cnt%2 == 0) {
				System.out.print("黒の手(行、列) >");
			}else {
				System.out.print("白の手(行、列) >");
			}

			String str = br.readLine();

			/**
			 * 未入力の場合
			 */
			if(str.equals("")) {
				System.out.println("入力されていません");
			}else {
				/**
				 * 実行
				 */

				/**
				 * 9を入力するとパス
				 */
				if(str.contains("9")) {
					Pass();
					cnt ++;

				}else {
					try {
						String [] str2 = str.split(",",0);

						int x = Integer.parseInt(str2[1])-1;
						int y = Integer.parseInt(str2[0])-1;

						Board.setStone(x, y);

						cnt++;
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("正しく入力してください");
					}
				}
			}
		}

	}

}

class Board {

	/**
	 * ゲーム実行中フラグ
	 */
	static boolean game = true;

	/**
	 * オセロ版に対応した多次元配列
	 */
	static String[][] board = new String[8][8];

	static final String EMPTY = "□";
	static final String BLACK = "●";
	static final String WHITE = "○";

	static String stone;
	static String rev_stone;

	/**
	 * ゲームの初期状態作成関数
	 */
	static public void initialize() {

		/**
		 * オセロ版の要素を全てクリアする
		 */
		for (int i = 0; i < 8; i++) {

			  for (int j = 0; j < 8; j++) {

			    board[i][j] = EMPTY;

			  }

		}

		/**
		 * 初期状態の配置
		 */
	    board[3][3] = BLACK;
	    board[3][4] = WHITE;
	    board[4][3] = WHITE;
	    board[4][4] = BLACK;

	    /**
	     * 次うつ駒の色を指定
	     */
	    stone = BLACK;
	    rev_stone = WHITE;

	    /**
	     * ゲーム実行中フラグ
	     */
	    game = true;

	}

	/**
	 * オセロ版を描写
	 * および更新する関数
	 */
	static public void showBoard() {

		/**
		 * まだ空いている座標があるか
		 */
	    boolean exists = false;
	    /**
	     * 黒い駒の数集計用
	     */
	    int cnt_black = 0;
	    /**
	     * 白い駒の数集計用
	     */
	    int cnt_white = 0;

	    /**
	     * オセロ版を描写する
	     */
	    int i = 0;
	    System.out.println("　１２３４５６７８");
	    for (String[] sarr : board) {

	    	System.out.print((i+1) + " ");
	    	for (String s : sarr) {

	        System.out.print(s);

	        /**
	         * 空いている座標があるか、各駒数の集計
	         */
	        if (s.equals(EMPTY)) {
	          exists = true;
	        } else if (s.equals(BLACK)) {
	          cnt_black++;
	        } else if (s.equals(WHITE)) {
	          cnt_white++;
	        }

	    	}
	    	System.out.println();

  			i++;

	    }

	    System.out.println();
	    System.out.print(BLACK + ":" + cnt_black);
	    System.out.println(WHITE + ":" + cnt_white);

	    if (!exists){
	      System.out.println(stone + "ゲーム終了！");
	      game = false;
	    }

	}

	static public void  Pass() {
		String next_stone = stone;
		stone = rev_stone;
		rev_stone = next_stone;

	}

	/**
	 * 相手の駒をひっくり返して反映させる関数
	 * @param x
	 * @param y
	 */
	static public void setStone(int x, int y) {

		/**
		 * 版外の座標を指定した場合
		 */
	    if (x > 7 || y > 7) {
	    	System.out.println("その位置に駒はおけません");
	    }

	    /**
	     *  駒を配置できる場合
	     */
	    if (board[y][x].equals(EMPTY)) {
	    	board[y][x] = stone;

	    	/**
	    	 *  ひっくり返す処理
	    	 */
	    	turnStone(x, y);

	    	/**
	    	 *  次うつ駒の設定
	    	 */
    		String next_rev_storn = stone;
    		stone = rev_stone;
    		rev_stone = next_rev_storn;

    		/**
    		 *  オセロ版の描写
    		 */
    		showBoard();

	    } else {

	    	/**
	    	 *  既に駒がおいてある位置を指定した場合
	    	 */
	    	System.out.println("その位置に駒はおけません");
	    }

	}

	/**
	 * 実際にひっくり返す関数
	 * @param x
	 * @param y
	 */
	static public void turnStone(int x, int y) {

		/**
		 *  8方向の駒の配置を確認し、ひっくり返す
		 */

	    turnLeftUp(x, y);
	    turnUp(x, y);
	    turnRightUp(x, y);
	    turnLeft(x, y);
	    turnRight(x, y);
	    turnLeftDown(x, y);
	    turnDown(x, y);
	    turnRightDown(x, y);

	}

	/**
	 * ここから以下8方向のひっくり返す関数
	 * @param x
	 * @param y
	 */

	static public void turnLeftUp(int x, int y) {
		if (y > 1 && x > 1) {

			/**
			 *  となりの駒
			 */
			String next = board[y - 1][x - 1];

			/**
			 *  となりの駒が裏駒の場合
			 */
			if (next.equals(rev_stone)) {

				/**
				 *  さらにその一つとなりから順に確認
				 */
				for (int i = 2; true; i++) {

					if (x - i < 0 || y - i < 0 || board[y - i][x - i].equals(EMPTY)) {
						/**
						 *  駒がない場合終了
						 */
						break;
					} else if (board[y - i][x - i].equals(stone)) {
						/**
						 *  自駒の場合
						 */

						/**
						 *  あいだの駒をすべて自駒にひっくりかえす
						 */
						for (int t = 1; t < i; t++) {
							/**
							 *  配列の要素を上書き
							 */
							board[y - t][x - t] = stone;
						}
						break;
					}
				}
			}

		}
	}

	  static public void turnUp(int x, int y) {
		  if (y > 1) {

			  /**
			   *  となりの駒
			   */
			  String next = board[y - 1][x];

			  /**
			   *  となりの駒が裏駒の場合
			   */
			  if (next.equals(rev_stone)) {

				  /**
				   *  さらにその一つとなりから順に確認
				   */
				  for (int i = 2; true; i++) {

					  if (y - i < 0 || board[y - i][x].equals(EMPTY)) {
						  /**
						   *  駒がない場合終了
						   */
						  break;
					  } else if (board[y - i][x].equals(stone)) {
						  /**
						   *  自駒の場合
						   */

						  /**
						   *  あいだの駒をすべて自駒にひっくりかえす
						   */
						  for (int t = 1; t < i; t++) {
							  /**
							   *  配列の要素を上書き
							   */
							  board[y - t][x] = stone;
						  }
						  break;
					  }
				  }
			  }

		  }
	  }

	  static public void turnRightUp(int x, int y) {
		  if (y > 1 && x < 6) {

			  /**
			   *  となりの駒
			   */
			  String next = board[y - 1][x + 1];

			  /**
			   *  となりの駒が裏駒の場合
			   */
			  if (next.equals(rev_stone)) {

				  /**
				   *  さらにその一つとなりから順に確認
				   */
				  for (int i = 2; true; i++) {

					  if (x + i > 7 || y - i < 0 || board[y - i][x + i].equals(EMPTY)) {
						  /**
						   *  駒がない場合終了
						   */
						  break;
					  } else if (board[y - i][x + i].equals(stone)) {
						  /**
						   *  自駒の場合
						   */

						  /**
						   *  あいだの駒をすべて自駒にひっくりかえす
						   */
						  for (int t = 1; t < i; t++) {
							  /**
							   *  配列の要素を上書き
							   */
							  board[y - t][x + t] = stone;
						  }
						  break;
					  }
				  }
			  }

		  }
	  }

	  static public void turnDown(int x, int y) {
		  if (y < 6) {

			  /**
			   *  となりの駒
			   */
			  String next = board[y + 1][x];

			  /**
			   *  となりの駒が裏駒の場合
			   */
			  if (next.equals(rev_stone)) {

				  /**
				   *  さらにその一つとなりから順に確認
				   */
				  for (int i = 2; true; i++) {

					  if (y + i > 7 || board[y + i][x].equals(EMPTY)) {
						  /**
						   *  駒がない場合終了
						   */
						  break;
					  } else if (board[y + i][x].equals(stone)) {
						  /**
						   *  自駒の場合
						   */

						  /**
						   *  あいだの駒をすべて自駒にひっくりかえす
						   */
						  for (int t = 1; t < i; t++) {
							  /**
							   *  配列の要素を上書き
							   */
							  board[y + t][x] = stone;
						  }
						  break;
					  }
				  }
			  }

		  }
	  }

	  static public void turnRight(int x, int y) {
		  if (x < 6) {

			  /**
			   *  となりの駒
			   */
			  String next = board[y][x + 1];

			  /**
			   *  となりの駒が裏駒の場合
			   */
			  if (next.equals(rev_stone)) {

				  /**
				   *  さらにその一つとなりから順に確認
				   */
				  for (int i = 2; true; i++) {

					  if (x + i > 7 || board[y][x + i].equals(EMPTY)) {
						  /**
						   *  駒がない場合終了
						   */
						  break;
					  	} else if (board[y][x + i].equals(stone)) {
					  		/**
					  		 *  自駒の場合
					  		 */

					  		/**
					  		 *  あいだの駒をすべて自駒にひっくりかえす
					  		 */
					  		for (int t = 1; t < i; t++) {
					  			/**
					  			 *  配列の要素を上書き
					  			 */
					  			board[y][x + t] = stone;
					  		}
					  		break;
					  	}
				  }
			  }

		  }
	  }

	  static public void turnLeftDown(int x, int y) {
		  if (y < 6 && x > 1) {

			  /**
			   *  となりの駒
			   */
			  String next = board[y + 1][x - 1];

			  /**
			   *  となりの駒が裏駒の場合
			   */
			  if (next.equals(rev_stone)) {

				  /**
				   *  さらにその一つとなりから順に確認
				   */
				  for (int i = 2; true; i++) {

					  if (x - i < 0 || y + i > 7 || board[y + i][x - i].equals(EMPTY)) {
						  /**
						   *  駒がない場合終了
						   */
						  break;
					  } else if (board[y + i][x - i].equals(stone)) {
						  /**
						   *  自駒の場合
						   */

						  /**
						   *  あいだの駒をすべて自駒にひっくりかえす
						   */
						  for (int t = 1; t < i; t++) {
							  /**
							   *  配列の要素を上書き
							   */
							  board[y + t][x - t] = stone;
						  }
						  break;
					  }
				  }
			  }

		  }
	  }

	  static public void turnLeft(int x, int y) {
		  if (x > 1) {

			  /**
			   *  となりの駒
			   */
			  String next = board[y][x - 1];

			  /**
			   *  となりの駒が裏駒の場合
			   */
			  if (next.equals(rev_stone)) {

				  /**
				   *  さらにその一つとなりから順に確認
				   */
				  for (int i = 2; true; i++) {

					  if (x - i < 0 || board[y][x - i].equals(EMPTY)) {
						  /**
						   *  駒がない場合終了
						   */
						  break;
					  } else if (board[y][x - i].equals(stone)) {
						  /**
						   *  自駒の場合
						   */

						  /**
						   *  あいだの駒をすべて自駒にひっくりかえす
						   */
						  for (int t = 1; t < i; t++) {
							  /**
							   *  配列の要素を上書き
							   */
							  board[y][x - t] = stone;
						  }
						  break;
					  }
				  }
			  }

		  }
	  }

	  static public void turnRightDown(int x, int y) {
		  if (y < 6 && x < 6) {

			  /**
			   *  となりの駒
			   */
			  String next = board[y + 1][x + 1];

			  /**
			   *  となりの駒が裏駒の場合
			   */
			  if (next.equals(rev_stone)) {

				  /**
				   *  さらにその一つとなりから順に確認
				   */
				  for (int i = 2; true; i++) {

					  if (x + i > 7 || y + i > 7 || board[y + i][x + i].equals(EMPTY)) {
						  /**
						   *  駒がない場合終了
						   */
						  break;
					  } else if (board[y + i][x + i].equals(stone)) {
						  /**
						   *  自駒の場合
						   */

						  /**
						   *  あいだの駒をすべて自駒にひっくりかえす
						   */
						  for (int t = 1; t < i; t++) {
							  /**
							   *  配列の要素を上書き
							   */
							  board[y + t][x + t] = stone;
						  }
						  break;
					  }
				  }
			  }

		  }
	  }
}

