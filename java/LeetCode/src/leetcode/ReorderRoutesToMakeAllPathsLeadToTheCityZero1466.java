package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there
 * is only one way to travel between two different cities (this network form a
 * tree). Last year, The ministry of transport decided to orient the roads in
 * one direction because they are too narrow.
 * 
 * Roads are represented by connections where connections[i] = [ai, bi]
 * represents a road from city ai to city bi.
 * 
 * This year, there will be a big event in the capital (city 0), and many people
 * want to travel to this city.
 * 
 * Your task consists of reorienting some roads such that each city can visit
 * the city 0. Return the minimum number of edges changed.
 * 
 * It's guaranteed that each city can reach city 0 after reorder.
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero1466 {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> nodeConn = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeConn.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            int ai = connections[i][0];
            int bi = connections[i][1];
            
            // nodeConn.get取得該城市所連接的城市，[0]連接位置 [1]連接方向
            nodeConn.get(ai).add(new int[] { bi, 0 });
            nodeConn.get(bi).add(new int[] { ai, 1 });
        }

        //從0開始出發，如果方向是0代表需要轉換方向，訪問過的城市不重複做
        boolean[] isVisted = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < nodeConn.get(node).size(); i++) {
                int[] connStatus = nodeConn.get(node).get(i);

                if (isVisted[connStatus[0]]) {
                    continue;
                }

                queue.add(connStatus[0]);

                if (connStatus[1] == 0) {
                    cnt++;
                }
            }

            isVisted[node] = true;
        }

        return cnt;
    }

}
