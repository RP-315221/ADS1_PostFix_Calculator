package org.example;

import org.example.domain.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Token a=new Operand(1);
        Token b=new Operand(2);
        Token c=new Operator("+");
        Token d=new Operand(5);
        Token e=new Operator("*");

        Token f=new Operand(10);
        Token g=new Operand(1);
        Token h=new Operator("-");
        Token i=new Operand(3);
        Token j=new Operator("/");

        Token k=new Operand(5);
        Token l=new Operand(2);
        Token m=new Operator("%");
        Token n=new Operand(3);
        Token o=new Operator("+");

        ArrayList<Token> tokenList1=new ArrayList<>();
        ArrayList<Token> tokenList2=new ArrayList<>();
        ArrayList<Token> tokenList3=new ArrayList<>();

        tokenList1.add(a);
        tokenList1.add(b);
        tokenList1.add(c);
        tokenList1.add(d);
        tokenList1.add(e);

        tokenList2.add(f);
        tokenList2.add(g);
        tokenList2.add(h);
        tokenList2.add(i);
        tokenList2.add(j);

        tokenList3.add(k);
        tokenList3.add(l);
        tokenList3.add(m);
        tokenList3.add(n);
        tokenList3.add(o);

        Calculator calculator=new CalculatorImpl();
        try
        {
            System.out.println(calculator.evaluateExpression(tokenList1));
            System.out.println(calculator.evaluateExpression(tokenList2));
            System.out.println(calculator.evaluateExpression(tokenList3));
        }
        catch(Exception error)
        {
            System.out.println(error.getMessage());
        }
    }
}