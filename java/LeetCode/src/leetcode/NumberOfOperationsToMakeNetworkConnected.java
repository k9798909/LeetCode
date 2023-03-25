package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfOperationsToMakeNetworkConnected {
	// 深度優先搜尋 (DFS)
	public void dfs(int node, Map<Integer, List<Integer>> connMap, boolean[] isConn) {
		isConn[node] = true;

		// 如果這個點沒有連接下一個點 return
		if (!connMap.containsKey(node)) {
			return;
		}

		for (int endNode : connMap.get(node)) {
			//如果連接的節點已經做過別再做了，不回頭
			if (!isConn[endNode]) {
				dfs(endNode, connMap, isConn);
			} 
		}
	}
	
	public void putMap(Map<Integer, List<Integer>> connMap,int s,int e) {
		if (connMap.containsKey(s)) {
			connMap.get(s).add(e);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(e);
			connMap.put(s,list);
		}
	}
	
	public int makeConnected(int n, int[][] connections) {
		// 連線數無法連接所有電腦
		if (connections.length < n - 1) {
			return -1;
		}

		// 將連接的點跟點裝成map
		Map<Integer, List<Integer>> connMap = new HashMap<>();
		for (int[] conn : connections) {
			putMap(connMap, conn[0], conn[1]);
			putMap(connMap, conn[1], conn[0]);
		}

		// 連接的次數 最少一定會有一次所以下方需減1 每加一次代表有一台未連結
		int serchCnt = 0;
		// 已連結的點
		boolean[] isConn = new boolean[n];
		for (int node = 0; node < n; node++) {
			if (!isConn[node]) {
				serchCnt++;
				dfs(node, connMap, isConn);
			} 
		}

		return serchCnt - 1;
	}
	
	
}
