/*
 * I Mike Zheng, 000348657 certify that this material is my original work. No other person's work has been 
 * used without due acknowledgment. I have not made my work available to anyone else.
 */
package lab5calculator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author mike.zheng
 */
public class Lab5Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<OperationValue> undo = new Stack<>();
        ArrayDeque<OperationValue> ops = new  ArrayDeque<>();
        
        Scanner consoleInput = new Scanner(System.in);
        boolean more = true;
        double currentValue;
        while(more){
            currentValue = 0;
            if (!ops.isEmpty())
            {
                Iterator it = ops.iterator();
                while (it.hasNext()){
                    String CurrentValue = it.next().toString();
                    char calculateop = CurrentValue.charAt(0);
                    double calculateValue = Double.parseDouble(CurrentValue.substring(1).replaceAll("\\s",""));
                    switch (calculateop){
                        case '-':
                            currentValue -= calculateValue;
                            break;
                        case '+':
                            currentValue += calculateValue;
                            break;
                        case '*':
                            currentValue *= calculateValue;
                            break;
                        case '/':
                            currentValue /= calculateValue;
                            break;
                        default:
                    }
                }
            }
            System.out.printf("Current Value = %,.2f\n",currentValue); //NOT COMPLETE
            System.out.print("Enter operation and value (i.e. \"+ 4.2\") (E[X]it, [C]lear, [D]isplay"); 
            if(!ops.isEmpty()){
                System.out.print(", [U]ndo");
            }
            if (!undo.isEmpty())
                System.out.print(", [R]edo");
            System.out.print("): ");
            String inputValue = consoleInput.nextLine();
                    //;
            char op = inputValue.toLowerCase().charAt(0);
            double value = 0;
            OperationValue tempOperation;
            if (inputValue.length() > 1){
                value = Double.parseDouble(inputValue.substring(1).replaceAll("\\s",""));
            }
            switch (op)
            {
                case 'x': 
                    more = false;
                    break;
                case 'u': 
                    if (!ops.isEmpty()){
                        undo.add(ops.removeLast());
                    }
                    else {
                        System.err.println("Error : Invalid Entry " + op);
                    }
                    break;
                case 'r':
                    if (!undo.isEmpty()){
                        ops.addLast(undo.pop());
                    }
                    else {
                        System.err.println("Error : Invalid Entry " + op);
                    }
                    break;
                case 'c':
                    undo.clear();
                    ops.clear();
                    break;
                case 'd':
                    System.out.print("Operations = " + ops.toString() + "\n");
                    System.out.print("UnDo List : " + undo.toString() + "\n");
                    break;
                case '*': case '/': case '+': case '-':
                    tempOperation = new OperationValue(value,op);
                    ops.add(tempOperation);
                    break;
                default: 
                    System.err.println("Error : Invalid Entry " + inputValue);
            }
        }
    }
}
