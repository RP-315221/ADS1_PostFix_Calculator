package org.example;

import org.example.domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the expression:");
        String expression=scanner.nextLine();
        ArrayList<Token> tokenList=new ArrayList<>();
        String[] tokens=expression.split(" ");
        for(String token:tokens)
        {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%"))
            {
                tokenList.add(new Operator(token));
            }
            else
            {
                tokenList.add(new Operand(Integer.parseInt(token)));
            }
        }
        Calculator calculator=new CalculatorImpl();
        try
        {
            System.out.println(calculator.evaluateExpression(tokenList));
        }
        catch(Exception error)
        {
            System.out.println(error.getMessage());
        }
        System.out.println("New expression? (y/n)");
        String choice=scanner.nextLine();
        if(choice.equals("y"))
            main(args);
        else
            System.exit(0);
    }
}
