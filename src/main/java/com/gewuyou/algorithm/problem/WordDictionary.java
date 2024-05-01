package com.gewuyou.algorithm.problem;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 *
 * @author gewuyou
 * @since 2024-05-21 下午8:04:12
 */
public class WordDictionary {
    private final TrieNode root;

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

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        if(node==null){
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != node && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                node = node.children[index];
                if (node == null) {
                    return false;
                }
            }
        }
        return node.isEnd;
    }
}
