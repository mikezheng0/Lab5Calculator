package lab5calculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mike.zheng
 */
public class OperationValue {
    private double value;
    private char op;
    OperationValue(double value, char op){
        this.value = value;
        this.op = op;
    }
    public char getOp(){
        return op;
    }
    public double getValue(){
        return value;
    }
    @Override
    public String toString(){
    return "";
    }
    
}
