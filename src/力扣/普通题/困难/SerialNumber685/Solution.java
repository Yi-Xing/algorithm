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
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
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
            return new int[]{edges[cycle][0], edges[cycle][1]};
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
}



