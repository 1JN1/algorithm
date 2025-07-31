package day_179;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/31 9:30
 */
public class Problem01 {

    @Test
    public void test() {

        int[] parents = {3, 7, -1, 2, 0, 7, 0, 2};
        int[][] queries = {
                {4, 6}, {1, 15}, {0, 5}
        };

        System.out.println(Arrays.toString(maxGeneticDifference(parents, queries)));
    }


    static class Trie {

        private static final int MAX_BIT = 17;

        private TrieNode root = new TrieNode();

        public void insert(int node) {

            TrieNode current = root;

            for (int i = MAX_BIT; i >= 0; i--) {
                int bit = (node >> i) & 1;
                if (current.children[bit] == null) {
                    current.children[bit] = new TrieNode();
                }
                current = current.children[bit];
                current.count++;
            }

        }

        public void remove(int node) {

            TrieNode current = root;
            for (int i = MAX_BIT; i >= 0; i--) {
                int bit = (node >> i) & 1;
                current = current.children[bit];
                current.count--;
            }
        }

        public int maxXor(int val) {

            TrieNode current = root;

            int maxXor = 0;

            for (int i = MAX_BIT; i >= 0; i--) {
                int bit = (val >> i) & 1;
                int oppositeBit = 1 - bit;
                if (current.children[oppositeBit] != null && current.children[oppositeBit].count > 0) {
                    maxXor |= (1 << i);
                    current = current.children[oppositeBit];
                } else {
                    current = current.children[bit];
                }
            }

            return maxXor;
        }

        static class TrieNode {

            private TrieNode[] children = new TrieNode[2];

            private int count = 0;
        }

    }


    public int[] maxGeneticDifference(int[] parents, int[][] queries) {

        int n = parents.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int root = -1;

        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                root = i;
            } else {
                adj.get(parents[i]).add(i);
            }
        }

        int q = queries.length;
        Map<Integer, List<int[]>> queriesByNode = new HashMap<>();
        for (int i = 0; i < q; i++) {
            int node = queries[i][0];
            int val = queries[i][1];

            queriesByNode.computeIfAbsent(node, k -> new ArrayList<>())
                    .add(new int[]{val, i});
        }

        int[] ans = new int[q];
        Trie trie = new Trie();

        dfs(root, adj, queriesByNode, trie, ans);

        return ans;
    }

    private void dfs(
            int node, List<List<Integer>> adj,
            Map<Integer, List<int[]>> queriesByNode,
            Trie trie, int[] ans
    ) {

        trie.insert(node);

        if (queriesByNode.containsKey(node)) {
            for (int[] query : queriesByNode.get(node)) {
                int val = query[0];
                int idx = query[1];

                ans[idx] = trie.maxXor(val);
            }
        }

        for (int child : adj.get(node)) {
            dfs(child, adj, queriesByNode, trie, ans);
        }

        trie.remove(node);
    }

}
