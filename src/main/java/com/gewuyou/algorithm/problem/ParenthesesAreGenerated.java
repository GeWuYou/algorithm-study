package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author gewuyou
 * @since 2024-04-10 下午1:23:58
 */
public class ParenthesesAreGenerated {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursion(0, 0, n, result, new StringBuilder());
        return result;
    }

    private void recursion(int count, int left, int n, List<String> result, StringBuilder stringBuilder) {
        if (count == 2 * n) {
            result.add(stringBuilder.toString());
            return;
        }
        if (left == n) {
            stringBuilder.append(")");
            recursion(count + 1, left, n, result, new StringBuilder(stringBuilder));
            return;
        }
        if(2*left==stringBuilder.length()){
            stringBuilder.append("(");
            recursion(count + 1, left+1, n, result, new StringBuilder(stringBuilder));
            return;
        }

        recursion(count+1, left + 1, n, result, new StringBuilder(stringBuilder).append("("));
        recursion(count+1, left, n, result, new StringBuilder(stringBuilder).append(")"));
    }

}
