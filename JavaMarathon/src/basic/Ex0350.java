package basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

// グラフ構築と最短経路計算の起点
public class Ex0350 {

/*
 * 課題 0350
問題
下図のように、円で表したノードとノード間の線で表したエッジがある。ノードは 7 つあり、0～6
の番号が振られている。また、隣接するノード間の距離は図のように決まっている。
このとき、ノード 0 からノード 6 までの最短経路の長さを求めよ。

NoteのEx0350の図.pngを参照

実行例
作成クラス名
Ex0350.java
>Java Ex0350
頂点 0 確定。 距離=0
頂点 4 確定。 距離=2
頂点 3 確定。 距離=8
頂点 5 確定。 距離=10
頂点 6 確定。 距離=13	
 */
	public static void main(String[] args) {
		// ノード定義
		String[] nodeNames = { "0", "1", "2", "3", "4", "5", "6" };
		NodeCollection graph = new NodeCollection(nodeNames);
		
		// 距離設定
		graph.setDistance("0", "1", 4);
		graph.setDistance("0", "2", 5);
		graph.setDistance("0", "4", 2);
		graph.setDistance("1", "2", 6);
		graph.setDistance("1", "3", 4);
		graph.setDistance("1", "4", 3);
		graph.setDistance("2", "3", 6);
		graph.setDistance("2", "6", 10);
		graph.setDistance("3", "4", 6);
		graph.setDistance("3", "5", 2);
		graph.setDistance("3", "6", 6);
		graph.setDistance("4", "5", 9);
		graph.setDistance("5", "6", 3);
		
		// 始点0から終点6までの最短経路を計算・表示
		graph.solveAndPrintShortestPath("0", "6");
	}
}

// ノードを表すクラス
class Node implements Comparable<Node> {

	// ノード名
	private final String name;
	// 始点からの最短距離
	private int distance;
	// 最短経路での直前のノード
	Node previous;
	// 隣接ノードと距離
	private final Map<Node, Integer> neighbors = new HashMap<>();

	public Node(String name) {
		this.name = name;

		// 初期値は大きい数
		this.distance = Integer.MAX_VALUE / 2;
	}

	// 指定ノードとの接続
	public void connect(Node other, int dist) {
		neighbors.put(other, dist);
	}

	// 隣接ノードの取得
	public Map<Node, Integer> getNeighbors() {
		return neighbors;
	}

	// 最短距離・直前ノードの初期化
	public void reset() {
		distance = Integer.MAX_VALUE / 2;
		previous = null;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int dist) {
		distance = dist;
	}

	public String getName() {
		return name;
	}

	// ノード名で比較
	@Override
	public int compareTo(Node other) {
		return this.name.compareTo(other.name);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Node))
			return false;
		Node other = (Node) obj;
		return Objects.equals(name, other.name);
	}
}

// グラフ全体を扱うクラス
class NodeCollection {
	private final Map<String, Node> nodes = new HashMap<>();

	// ノード名の配列からノード生成
	public NodeCollection(String[] names) {
		for (String name : names) {
			nodes.put(name, new Node(name));
		}
	}

	// 2つのノード間に距離を設定
	public void setDistance(String a, String b, int dist) {
		Node n1 = nodes.get(a);
		Node n2 = nodes.get(b);
		n1.connect(n2, dist);
		n2.connect(n1, dist);
	}

	// 最短経路を計算し、通過ノードを距離確定順に出力
	public void solveAndPrintShortestPath(String startName, String goalName) {
		// すべてのノードを初期化
		for (Node node : nodes.values()) {
			node.reset();
		}

		Node start = nodes.get(startName);
		start.setDistance(0);

		// 距離が小さい順にノードを並べる
		TreeSet<Node> queue = new TreeSet<>(Comparator
				.comparingInt(Node::getDistance)
				.thenComparing(Node::getName));
		queue.addAll(nodes.values());

		// 距離確定順に格納
		List<Node> confirmedOrder = new ArrayList<>();

		// 未確定ノードがなくなるまで繰り返す
		while (!queue.isEmpty()) {
			// 最も距離が短いノードを取り出し
			Node current = queue.pollFirst();
			confirmedOrder.add(current);

			// 隣接ノードに対して距離の再計算
			for (Map.Entry<Node, Integer> entry : current.getNeighbors().entrySet()) {
				Node neighbor = entry.getKey();
				// 現在ノードまでの距離 + 接続距離
				int alt = current.getDistance() + entry.getValue();

				// より短い距離が見つかればその距離に更新
				if (alt < neighbor.getDistance()) {
					// TreeSetの順序を更新するため一旦削除
					queue.remove(neighbor);
					// 最短距離を更新
					neighbor.setDistance(alt);
					 // 経路上の前ノードを記録
					neighbor.previous = current;
					// 再度追加して順序更新
					queue.add(neighbor);
				}
			}
		}

		// 最短経路に含まれるノードをセットに登録
		Set<Node> path = new HashSet<>();
		for (Node n = nodes.get(goalName); n != null; n = n.previous) {
			path.add(n);
		}

		// 確定順で最短経路に含まれるノードのみ出力
		for (Node node : confirmedOrder) {
			if (path.contains(node)) {
				System.out.println("頂点 " + node.getName() + " 確定。 距離 =" + node.getDistance());
			}
		}
	}
}

