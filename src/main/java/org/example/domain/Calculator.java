package org.example.domain;

import java.util.ArrayList;

public interface Calculator {
    int evaluateExpression(ArrayList<Token> tokenList);
}
