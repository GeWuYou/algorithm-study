package com.gewuyou.algorithm.dailyquestion;

import java.util.*;

/**
 * 721. 账户合并
 *
 * @author gewuyou
 * @since 2024-07-15 上午11:04:06
 */
public class AccountMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        var emailToName = new HashMap<String, String>();
        var parent = new HashMap<String, String>();
        // 初始化并查集
        for (List<String> account : accounts) {
            var name = account.getFirst();
            for (int i = 1; i < account.size(); i++) {
                var email = account.get(i);
                emailToName.put(name, email);
                parent.put(email, email);
            }
        }
        // 构建并查集
        for (List<String> account : accounts) {
            var firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                union(parent, firstEmail, account.get(i));
            }
        }
        // 查找连通分量
        var unions = new HashMap<String, List<String>>();
        for (String email : parent.keySet()) {
            String root = find(parent, email);
            unions.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }
        // 合并结果
        var result = new ArrayList<List<String>>();
        for (List<String> emails : unions.values()) {
            Collections.sort(emails);
            var name = emailToName.get(emails.getFirst());
            var account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            result.add(account);
        }
        return result;
    }

    private void union(Map<String, String> parent, String email1, String email2) {
        String root1 = find(parent, email1);
        String root2 = find(parent, email2);
        if (!root1.equals(root2)) {
            parent.put(root1, root2);
        }
    }

    private String find(Map<String, String> parent, String email) {
        if (!parent.get(email).equals(email)) {
            parent.put(email, find(parent, parent.get(email)));
        }
        return parent.get(email);
    }
}
