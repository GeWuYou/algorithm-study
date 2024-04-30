package com.gewuyou.algorithm.problem;

import com.gewuyou.datastructures.linear.Stack;

import java.util.Scanner;

/**
 * 计算器
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Calculator
 * @apiNote 基于栈实现计算器 使用中缀表达式
 * @since 2022/9/17 9:23
 */
public class Calculator {
    /**
     * 加
     */
    private static final char PLUS_SIGN = '+';
    /**
     * 减
     */
    private static final char MINUS_SIGN = '-';
    /**
     * 乘
     */
    private static final char MULTIPLICATION_SIGN = '*';
    /**
     * 除
     */
    private static final char DIVISION_SIGN = '/';
    /**
     * 退出
     */
    private static final String EXIT = "exit";

    /**
     * 数栈
     *
     * @apiNote 存储数字
     */
    private final Stack<Integer> numberStack = new Stack<>();
    /**
     * 符号栈
     *
     * @apiNote 存储运算符的
     */
    private final Stack<Character> symbolStack = new Stack<>();

    /**
     * 算式
     */
    private String formula;
    /**
     * 扫描器
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * 运行计算器
     *
     * @apiNote 调用此方法执行计算器
     * @since 2022/9/17 10:57
     */
    public void start() {
        System.out.print("计算器已启动！！！\n退出计算器请输入exit\n");
        String command;
        while (true) {
            System.out.print("请输入计算表达式(忽略等号)：");
            command = scanner.nextLine();
            if (command.equals(EXIT)) {
                System.out.println("欢迎下次使用");
                return;
            } else {
                formula = command;
                analyticalFormula();
            }
        }
    }

    /**
     * 解析算式
     *
     * @apiNote 将算式进行解析并存入栈中进行运算
     * @since 2022/9/17 11:06
     */
    private void analyticalFormula() {
        // 1、将字符串转换为字符数组
        char[] chars = formula.toCharArray();
        // 保存临时变量
        int temp;
        // 数字
        int number1;
        int number2;
        for (int i = 0; i < chars.length; i++) {
            // 2、判断c是数字还是运算符
            if (isOperator(chars[i])) {
                // 3、当前符号栈为空，直接入栈
                if (symbolStack.isEmpty()) {
                    symbolStack.push(chars[i]);
                } else {
                    // 4、如果当前符号栈存在符号，则进行比较，如果当前的操作符的优先级小于或者等于栈中符号则需要从数栈中弹出两个数再从符号栈中弹出一个符号进行运算
                    temp = symbolStack.pop();
                    if (compare(priority(temp), priority(chars[i]))) {
                        // 栈先弹后放入的元素，所以先给number2赋值
                        number2 = numberStack.pop();
                        number1 = numberStack.pop();
                        // 5、得到结果入数栈,再将当前结果存入数栈，然后再将当前操作符存存入符号栈中
                        numberStack.push((int) calculate(number1, number2, temp));
                    } else {
                        symbolStack.push((char) temp);
                    }
                    symbolStack.push(chars[i]);
                    // 6、反之则直接将当前操作符存入符号栈
                }
            } else {
                StringBuilder args = new StringBuilder("" + chars[i]);
                if (i + 1 != chars.length) {
                    while (!isOperator(chars[i + 1])) {
                        args.append(chars[i + 1]);
                        i++;
                        if (i == chars.length - 1) {
                            break;
                        }
                    }
                }
                // 7、将数字直接传入数字栈
                numberStack.push(Integer.parseInt(args.toString()));
            }
        }
        // 8、扫描完毕，顺序的从数栈和符号栈中pop对应的数字和符号，并运行
        number2 = numberStack.pop();
        number1 = numberStack.pop();
        // 5、得到结果入数栈,再将当前结果存入数栈，然后再将当前操作符存存入符号栈中
        numberStack.push((int) calculate(number1, number2, symbolStack.pop()));
        // 反转栈
        symbolStack.reversion();
        numberStack.reversion();
        while (!symbolStack.isEmpty()) {
            number1 = numberStack.pop();
            number2 = numberStack.pop();
            // 5、得到结果入数栈,再将当前结果存入数栈，然后再将当前操作符存存入符号栈中
            numberStack.push((int) calculate(number1, number2, symbolStack.pop()));
        }
        // 9、数栈中只有一个数字时为表达式结果
        System.out.println("当前式子结果为：" + numberStack.pop());
    }

    /**
     * 判断运算符优先级
     *
     * @param operator 运算符
     * @return int
     * @apiNote 使用数字作为优先级判断
     * @since 2022/9/17 10:30
     */
    private int priority(int operator) {
        if (operator == MULTIPLICATION_SIGN || operator == DIVISION_SIGN) {
            return 1;
        } else if (operator == PLUS_SIGN || operator == MINUS_SIGN) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 比较优先级
     *
     * @param i 级1
     * @param j 级2
     * @return boolean
     * @apiNote i>j?true:false
     * @since 2022/9/17 11:31
     */
    private boolean compare(int i, int j) {
        return i >= j;
    }

    /**
     * 判断是否是运算符
     *
     * @param operator 输入运算符
     * @return boolean 结果
     * @apiNote 如果是运算符返回true反之为false
     * @since 2022/9/17 10:42
     */
    private boolean isOperator(int operator) {
        return operator == MULTIPLICATION_SIGN || operator == DIVISION_SIGN || operator == PLUS_SIGN || operator == MINUS_SIGN;
    }

    /**
     * 运算方法
     *
     * @param number1  数字1
     * @param number2  数字2
     * @param operator 运算符
     * @return float
     * @apiNote number1 operator number2 = ?
     * @since 2022/9/17 10:44
     */
    private float calculate(int number1, int number2, int operator) {
        float result = 0;
        switch (operator) {
            case PLUS_SIGN:
                result = number1 + number2;
                break;
            case MINUS_SIGN:
                result = number1 - number2;
                break;
            case MULTIPLICATION_SIGN:
                result = number1 * number2;
                break;
            case DIVISION_SIGN:
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    throw new RuntimeException("被除数不能为0");
                }
                break;
            default:
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Calculator calculate = new Calculator();
        calculate.start();
    }
}
