package org.example.domain;

public class Operator implements Token{
    private String value;

    public Operator(String value)
    {
        this.value=value;
    }

    public String getValue()
    {
        return value;
    }

    public String toString()
    {
        return value;
    }
}
