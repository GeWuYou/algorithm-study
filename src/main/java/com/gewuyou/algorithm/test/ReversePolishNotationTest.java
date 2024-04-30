package com.gewuyou.algorithm.test;


import com.gewuyou.datastructures.linear.Stack;
import lombok.extern.slf4j.Slf4j;

/**
 * 逆波兰表达式
 * @author GeWuYou
 * @ClassName ReversePolishNotationTest
 * @apiNote
 * @since 2022/9/18 13:46
 */
@Slf4j
public class ReversePolishNotationTest {

    public static void main(String[] args) {
        //中缀表达式 3*（17-15）+18/6 的逆波兰表达式如下 6+3=9
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        log.info("逆波兰表达式的结果为：{}",result);
    }

    /**
     * @param notation 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     */
    public static int calculate(String[] notation) {
        Integer o1;
        Integer o2;
        //1、定义一个栈，用来存储操作数
        Stack<Integer> operands = new Stack<>();
        //2、从左往右遍历逆波兰表达式，得到每一个元素
        for (String s : notation) {

            //3、判断当前元素是运算符还是操作数
            if("+".equals(s)){
                //4、运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                o1 = operands.pop();
                o2 = operands.pop();
                operands.push(o2+o1);
            }else if("-".equals(s)){
                //4、运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                o1 = operands.pop();
                o2 = operands.pop();
                operands.push(o2-o1);
            }else if("*".equals(s)){
                //4、运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                o1 = operands.pop();
                o2 = operands.pop();
                operands.push(o2*o1);
            }else if("/".equals(s)){
                //4、运算符，从栈中弹出两个操作数，完成运算，运算完的结果再压入栈中
                o1 = operands.pop();
                o2 = operands.pop();
                operands.push(o2/o1);
            }else {
                //5、操作数，把该操作数放入到栈中；
                operands.push(Integer.parseInt(s));
            }
        }
        //6、得到栈中最后一个元素，就是逆波兰表达式的结果
        return operands.pop();
    }

}
