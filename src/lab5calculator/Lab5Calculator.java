/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5calculator;

import java.util.ArrayDeque;
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
        
        while(more){
            System.out.println("Current Value"); //NOT COMPLETE
            
            System.out.println("Enter operation and value (i.e. \"+ 4.2\") (E[X]it, [C]lear, [D]isplay):");
            if(!ops.isEmpty())
                System.out.print(", [U]ndo");
            if (!undo.isEmpty())
                System.out.print(", [R]edo");
            System.out.print("):");
            
            char op = consoleInput.next().toLowerCase().charAt(0);
        }
    }
    
}
