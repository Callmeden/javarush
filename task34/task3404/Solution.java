package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        solution.recurse("(-1 + (-2))", 0);  System.out.println("-3 3 - expected output");
        solution.recurse("-sin(2*(-5+1.5*4)+28)", 0);  System.out.println("-0.5 7 - expected output");
        solution.recurse("sin(100)-sin(100)", 0);  System.out.println("0 3 - expected output");
        solution.recurse("-(-22+22*2)", 0);  System.out.println("-22 4 - expected output");
        solution.recurse("-2^(-2)", 0);  System.out.println("-0.25 3 - expected output");
        solution.recurse("-(-2^(-2))+2+(-(-2^(-2)))", 0);  System.out.println("2.5 10 - expected output");
        solution.recurse("(-2)*(-2)", 0);  System.out.println("4 3 - expected output");
        solution.recurse("(-2)/(-2)", 0);  System.out.println("1 3 - expected output");
        solution.recurse("sin(-30)", 0);  System.out.println("-0.5 2 - expected output");
        solution.recurse("cos(-30)", 0);  System.out.println("-0.87 2 - expected output");
        solution.recurse("tan(-30)", 0);  System.out.println("-0.58 2 - expected output");
        solution.recurse("2+8*(9/4-1.5)^(1+1)", 0);  System.out.println("6.5 6 - expected output");
        solution.recurse("0.005", 0);  System.out.println("0.01 0 - expected output");
        solution.recurse("0.0049", 0);  System.out.println("0 0 - expected output");
        solution.recurse("0+0.304", 0);  System.out.println("0.3 1 - expected output");
        solution.recurse("sin(45) - cos(45)", 0);  System.out.println("0 3 - expected output");
        solution.recurse("0/(-3)", 0);  System.out.println("0 2 - expected output");
    }

    public void recurse(final String expression, int countOperation) {
        String temp = expression;
        boolean complete = false;
// operation's patterns
        Pattern mindetect= Pattern.compile("[^\\d)?]-|^-");//патерн для определения унарных минусов, сказочная дурь
        Pattern patPar = Pattern.compile("\\(([^()]*)\\)");//внутренние скобки
        Pattern patrem = Pattern.compile("\\((-?[\\d.]+)\\)");//поиск готовых цифр в скобках для раскрытия
        Pattern pow = Pattern.compile("(-?[\\d.]+)(\\^)(-?[\\d.]+)");//степень удаленно из начала (?:-|\+)
        Pattern sin = Pattern.compile("()(sin|cos|tan)(-?[\\d.]+)");//тригонометрия
        Pattern mul = Pattern.compile("(-?[\\d.]+)([*/])(-?[\\d.]+)");//умножение деление
        Pattern additive = Pattern.compile("(-?[\\d.]+)?([+M])(-?[\\d.]+)");//сложение вычитание
        // Pattern unar=Pattern.compile("()(M)([\\d.]+)");
        Pattern plusser = Pattern.compile("()(--)([\\d.]+)");//поиск двойных плюсов после различных операций
        Pattern round = Pattern.compile("(-?[\\d.]+)");//поиск готовых цифр для округления


        if(countOperation == 0){//добавляем унарные минусы в качестве операций возможно не потреб-ся. переименовываем все - в М
            Matcher matcher = mindetect.matcher(temp);
            temp = temp.replaceAll("-","M");//теперь все необработанные - это M
        }
        temp = temp.replaceAll(" +", "");//выпиливаем пробелы
        String calctemp = temp;
        int start = 0;
        int end = calctemp.length();
        Matcher mathPar = patPar.matcher(temp);//поехали! скобки
        if (mathPar.find()) {

            calctemp = mathPar.group(1);
            start = mathPar.start()+1;
            end = mathPar.end()-1;

        }


        String result = calc(calctemp, sin);//тригонометрия
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start)+result+(temp.length()==end?"":temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, pow);//степень
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start)+result+(temp.length()==end?"":temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, mul);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start)+result+(temp.length()==end?"":temp.substring(end));
            recurse(temp, countOperation);
            return;
        }
        result = calc(calctemp, plusser);
        if (!result.equals("")) {
            temp = temp.substring(0,start)+result+(temp.length()==end?"":temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, additive);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start)+result+(temp.length()==end?"":temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        mathPar = patrem.matcher(temp);
        if (mathPar.find()) {
            temp = temp.substring(0,start-1)+mathPar.group(1)+temp.substring(end+1);
            recurse(temp, countOperation);
            return;
        }
        NumberFormat nf = new DecimalFormat("#.##");
        Double d = Double.parseDouble(temp);
        System.out.println(String.format("%s %d", nf.format(d),countOperation).replace(",","."));

    }

    private String calc(String temp, Pattern pattern) {

        String result = "";
        String temporar = temp;
        Matcher matcher = pattern.matcher(temporar);

        if (matcher.find()) {
            result = temporar.replaceFirst(pattern.pattern(), numerate(matcher));
        }
        return result;
    }

    private String numerate(Matcher matcher) {
        HashMap<String, DoubleBinaryOperator> hashMap = new HashMap();
        hashMap.put("*", (double a, double b) -> a * b);
        hashMap.put("/", (double a, double b) -> a / b);
        hashMap.put("M", (double a, double b) -> a - b);
        hashMap.put("+", (double a, double b) -> a + b);
        hashMap.put("++", (double a, double b) -> b);
        hashMap.put("M-", (double a, double b) -> b);
        hashMap.put("^", (double a, double b) -> Math.pow(a, b));
        hashMap.put("cos", (double a, double b) -> Math.cos(Math.toRadians(b)));
        hashMap.put("sin", (double a, double b) -> Math.sin(Math.toRadians(b)));
        hashMap.put("tan", (double a, double b) -> Math.tan(Math.toRadians(b)));
        String left = "0";
        String right = "0";

        try {
            left = matcher.group(1).equals("") ? "0" : matcher.group(1);
        } catch (Exception e) {
        }

        try {
            right = matcher.group(3).equals("") ? "0" : matcher.group(3);
        } catch (Exception e) {
        }

        Double dleft = Double.parseDouble(left);
        Double dright = Double.parseDouble(right);
        Double result = hashMap.get(matcher.group(2)).applyAsDouble(dleft, dright);
        NumberFormat nf = new DecimalFormat("#.##");

        return String.format("%s", nf.format(result)).replace(",",".");
    }

    public Solution() {
        //don't delete
    }
}
