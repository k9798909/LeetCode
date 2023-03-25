package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRoutestoMakeAll_1466 {
	int cnt = 0;

	public void dfs(Map<Integer, List<Node>> map, boolean[] isVisit, int node) {
		isVisit[node] = true;
		if (!map.containsKey(node)) {
			return;
		}

		for (Node connNode : map.get(node)) {
			//避免回跑
			if (isVisit[connNode.connNode]) {
				continue;
			}
			//如果連結對象則需計次 例: 0 -> 1
			if (connNode.isConn == 1) {
				cnt++;
			}
			dfs(map, isVisit, connNode.connNode);
		}
	}

	public int minReorder(int n, int[][] connections) {
		Map<Integer, List<Node>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int i = 0; i < connections.length; i++) {
			//key=點 value=點 isConn=是否被連結 例:0 -> 1  key = 0 value = 1 1  key = 1 value = 0 0 
			map.get(connections[i][0]).add(new Node(connections[i][1], 1));
			map.get(connections[i][1]).add(new Node(connections[i][0], 0));
		}
		boolean[] isVisit = new boolean[connections.length + 1];
		dfs(map, isVisit, 0);
		return cnt;
	}

	public class Node {
		private int connNode;
		private int isConn;// 1連結0被連結

		public Node(int connNode, int isConn) {
			super();
			this.connNode = connNode;
			this.isConn = isConn;
		}
	}
}
