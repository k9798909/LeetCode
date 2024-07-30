package leetcode;

/**
 * There are n cities. Some of them are connected, while some are not. If city a
 * is connected directly with city b, and city b is connected directly with city
 * c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * 
 * Return the total number of provinces.
 */
public class NumberOfProvinces547 {
    public int findCircleNum(int[][] isConnected) {
        // [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        boolean[] isVisted = new boolean[isConnected.length];
        int cnt = 0;

        for (int i = 0; i < isVisted.length; i++) {
            if (isVisted[i]) {
                continue;
            }

            dfs(isConnected, isVisted, i);
            cnt++;
        }

        return cnt;
    }

    private void dfs(int[][] isConnected, boolean[] isVisted, int i) {
        if (isVisted[i]) {
            return;
        }

        isVisted[i] = true;
        for (int j = 0; j < isVisted.length; j++) {
            if(isConnected[i][j] == 1) {
                dfs(isConnected, isVisted, j);
            }
        }
    }
}
