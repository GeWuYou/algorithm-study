package com.gewuyou.algorithm.problem;

/**
 * 找出字符串中第一个匹配项的下标
 *
 * @author gewuyou
 * @since 2024-04-05 下午2:15:11
 */
public class StringIndex {
    /**
     底层实现
     public static int indexOf(byte[] value, int valueCount, byte[] str, int strCount, int fromIndex) {
             byte first = str[0];
             int max = (valueCount - strCount);
             for (int i = fromIndex; i <= max; i++) {
                 // Look for first character.
                 if (value[i] != first) {
                 while (++i <= max && value[i] != first);
                 }
                 // Found first character, now look at the rest of value
                 if (i <= max) {
                 int j = i + 1;
                 int end = j + strCount - 1;
                 for (int k = 1; j < end && value[j] == str[k]; j++, k++);
                 if (j == end) {
                     // Found whole string.
                     return i;
                 }
             }
         }
         return -1;
     }
     这段代码是一个经典的字符串搜索算法，用于在一个字节数组中查找另一个字节数组第一次出现的位置。下面是它的大致逻辑：

     函数的目的是在value字节数组中搜索str字节数组第一次出现的位置。
     首先，它会获取str的第一个字节，然后计算搜索的最大范围。
     然后，它会从指定的fromIndex开始遍历value数组，寻找str的第一个字节出现的位置。
     一旦找到str的第一个字节，它会继续检查value中剩余的字节是否与str匹配。
     如果在整个str数组都找到匹配，就会返回该位置；否则继续搜索直到遍历完整个value数组。
     这个算法是一种简单而有效的字符串搜索算法
     */
    public int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);
    }
}
