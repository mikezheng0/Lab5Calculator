package lab5calculator;

/*
 * I Mike Zheng, 000348657 certify that this material is my original work. No other person's work has been 
 * used without due acknowledgment. I have not made my work available to anyone else.
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
    return op+" "+value;
    }
    
}
