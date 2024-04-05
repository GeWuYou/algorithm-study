package com.gewuyou.algorithm.problem;

/**
 * Excel表列名称
 *
 * @author gewuyou
 * @since 2024-04-07 下午12:37:35
 */
public class ExcelTableColumnName {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        // 如果数字大于0则继续循环
        while (columnNumber > 0) {
            int remainder = columnNumber % 26;
            // 如果取余为0(整除)将remainder置为26并将columnNumber减1
            if (remainder == 0) {
                // 将remainder置为26并将columnNumber减1是因为余数为0时，对应的事Z而不是A
                remainder = 26;
                /*
                 * 当余数remainder为0时，我们将其设为26，然后将columnNumber减1。
                 * 这是因为在Excel列标题中，当对26取余的结果为0时，实际上对应的是字母Z，而不是A。
                 * 通过将columnNumber减1，我们能够在后续的计算中正确地处理这种情况，
                 * 确保余数为0时所对应的是Z而不是A。
                 * */
                columnNumber--;
            }
            /*
             * 余数remainder被转换为字母时进行了加减法操作， (char) (remainder + 'A' - 1)，
             * 这里减去1是为了将余数与A的ASCII码对齐。换句话说，我们想要实现的是余数1对应A，
             * 余数2对应B，余数3对应C，以此类推。
             * 在ASCII码中，大写字母A的值为65，B的值为66，因此通过减去1，可以将余数0对应到字母Z（65 + 25 = 90），
             * 余数1对应到字母A（65 + 0 = 65），依此类推。这种操作确保了余数和真实的Excel列标题之间的对应关系。
             * */
            sb.append((char) (remainder + 'A' - 1));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
