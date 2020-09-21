package 力扣.普通题.困难.SerialNumber685;

import java.util.*;

/**
 * @date 2020-09-17
 */
public class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        // 创建并查集，长度为节点关系个数+1，初始时并查集中的每个节点都是一个连通分支，该连通分支的根节点就是该节点本身。
        UnionFind uf = new UnionFind(nodesCount + 1);
        // 记录每个节点的父节点
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        // 冲突边
        int conflict = -1;
        // 导致环路出现的边
        int cycle = -1;
        // 遍历所有边
        for (int i = 0; i < nodesCount; i++) {
            // 取出当前边
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                // 更新父节点
                parent[node2] = node1;
                // 如果祖先相同，说明这条边导致环路出现
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {
//            return new int[]{edges[cycle][0], edges[cycle][1]};
            return edges[cycle];
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                return new int[]{parent[conflictEdge[1]], conflictEdge[1]};
            } else {
                return new int[]{conflictEdge[0], conflictEdge[1]};
            }
        }
    }

    class UnionFind {

        int[] ancestor;

        public UnionFind(int n) {
            ancestor = new int[n];
            for (int i = 0; i < n; i++) {
                ancestor[i] = i;
            }
        }

        /**
         * 合并父节点
         */
        public void union(int index1, int index2) {
            ancestor[find(index1)] = find(index2);
        }

        /**
         * 查找父节点
         */
        public int find(int index) {
            if (ancestor[index] != index) {
                ancestor[index] = find(ancestor[index]);
            }
            return ancestor[index];
        }
    }
    class Solution1 {

        public int[] findRedundantDirectedConnection(int[][] edges) {
            // 边的条数（在这个问题里等于结点个数）
            int len = edges.length;
            // 步骤 1：预处理入度数组（记录指向某个结点的边的条数）
            int[] inDegree = new int[len + 1];
            for (int[] edge : edges) {
                inDegree[edge[1]]++;
            }

            // 步骤 2：先尝试删除构成入度为 2 的边，看看是否形成环
            for (int i = len - 1; i >= 0; i--) {
                if (inDegree[edges[i][1]] == 2) {
                    // 如果不构成环，这条边就是要去掉的那条边
                    if (!judgeCircle(edges, len, i)) {
                        return edges[i];
                    }
                }
            }

            // 步骤 3：再尝试删除构成入度为 1 的边，看看是否形成环
            for (int i = len - 1; i >= 0; i--) {
                if (inDegree[edges[i][1]] == 1) {
                    // 如果不构成环，这条边就是要去掉的那条边
                    if (!judgeCircle(edges, len, i)) {
                        return edges[i];
                    }
                }
            }
            throw new IllegalArgumentException("输入不符合要求。");
        }

        /**
         * 将 removeEdgeIndex 去掉以后，剩下的有向边是否构成环
         *
         * @param edges
         * @param len             结点总数（从 1 开始，因此初始化的时候 + 1）
         * @param removeEdgeIndex 删除的边的下标
         * @return 构成环，返回 true
         */
        private boolean judgeCircle(int[][] edges, int len, int removeEdgeIndex) {
            UnionFind unionFind = new UnionFind(len + 1);
            for (int i = 0; i < len; i++) {
                if (i == removeEdgeIndex) {
                    continue;
                }
                if (!unionFind.union(edges[i][0], edges[i][1])) {
                    // 合并失败，表示 edges[i][0] 和 edges[i][1] 在一个连通分量里，即构成了环
                    return true;
                }
            }
            return false;
        }

        private class UnionFind {
            // 代表元法
            private int[] parent;

            public UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                while (x != parent[x]) {
                    // 路径压缩（隔代压缩）
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            /**
             * @param x
             * @param y
             * @return 如果合并成功返回 true
             */
            public boolean union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);

                if (rootX == rootY) {
                    return false;
                }
                parent[rootX] = rootY;
                return true;
            }
        }
    }
}



