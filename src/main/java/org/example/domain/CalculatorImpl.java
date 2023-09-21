package org.example.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CalculatorImpl implements Calculator{
    private Token current;
    private Operand firstOperand;
    private Operand secondOperand;
    private int result;

    @Override
    public int evaluateExpression(ArrayList<Token> tokenList) throws IllegalArgumentException {
        LinkedList<Operand> stack=new LinkedList<>();
        Iterator<Token> iterator=tokenList.listIterator();
        while(iterator.hasNext())
        {
            current=iterator.next();
            if(current instanceof Operand)
            {
                if(!(stack.size()>=2))
                    stack.push((Operand) current);
                else
                    throw new IllegalArgumentException("Cannot have more than 2 operands at a time");
            }
            else if(current instanceof Operator)
            {
                if(stack.size()>=2)
                {
                    secondOperand=stack.pop();
                    firstOperand=stack.pop();
                    try
                    {
                        result=getResult(firstOperand.getValue(), secondOperand.getValue(), ((Operator) current).getValue());
                        stack.push(new Operand(result));
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                else
                    throw new IllegalArgumentException("Must have exactly 2 operands in the stack to perform a calculation");
            }
        }
        return result;
    }

    private int getResult(int x, int y, String operator) throws IllegalArgumentException
    {
        switch (operator)
        {
            case "+":
                return x+y;
            case "-":
                return x-y;
            case "*":
                return x*y;
            case "/":
                return x/y;
            case "%":
                return x%y;
            default:
                throw new IllegalArgumentException("Illegal operator");
        }
    }
}
