package com.gewuyou.algorithm.problem;

/**
 * 208. 实现 Trie (前缀树)
 *
 * @author gewuyou
 * @since 2024-05-20 下午2:32:01
 */
public class Trie {
    public TrieNode root;

    public static class TrieNode {
        /**
         * 子节点指针数组
         */
        TrieNode[] children;
        /**
         * 是否是单词结尾
         */
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
