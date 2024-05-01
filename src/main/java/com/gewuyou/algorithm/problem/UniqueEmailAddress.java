package com.gewuyou.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 *
 * @author gewuyou
 * @since 2024-05-09 下午3:03:18
 */
public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            // 分割本地名和域名
            String[] parts = email.split("@");
            // 去除本地名中的"."
            String localName = parts[0].replaceAll("\\.", "");
            // 去除本地名中的"+"
            int i = localName.indexOf("+");
           set.add(i==-1?localName+"@"+parts[1]:localName.substring(0,i)+"@"+parts[1]);
        }
        return set.size();
    }
}
