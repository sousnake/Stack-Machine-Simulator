
import java.awt.Component;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dell
 */
public class StackMachineFunc {

    int A, B, C, D = 0;
    int stackpointer = 0;
    int pc = 100;
    int[] stack = new int[100];
    private Component frame;
    public void setA(int i){
        A=i;
    }
    
    /**
     *
     * @param str
     * @return
     */
    public int Compatible(String str) {
        if ((str.length() == 1) & (str.equals("a"))) {
            return A;
        } else if ((str.length() == 1) & (str.equals("b"))) {
            return B;
        } else if ((str.length() == 1) & (str.equals("c"))) {
            return C;
        } else {
            return Integer.parseInt(str.substring(1));
        }
    }

    public void Push(String str) {
        stackpointer++;
        stack[stackpointer] = Compatible(str);
    }

    public void Push(int i) {
        stackpointer++;
        stack[stackpointer] = i;
    }

    public int Pop(String str) {
        if (stackpointer <= 0) {
            JOptionPane.showMessageDialog(frame, "No element in Stack\nClick Reset");
            //     System.out.println("Invalid Input");
            //   System.exit(1);
        } else {
            if ((str.length() == 1) & (str.equals("a"))) {
                 A = stack[stackpointer];
                stackpointer--;
                return A;
            } else if ((str.length() == 1) & (str.equals("b"))) {
                 B = stack[stackpointer];
                stackpointer--;
                return B;
            } else if ((str.length() == 1) & (str.equals("c"))) {
                 C = stack[stackpointer];
                stackpointer--;
                return C;
            } else {
                D = stack[stackpointer];
                stackpointer--;
                return D;
            }
        //    return D;
        }
        return 0;
    }
    

    public int Pop() {
        if (stackpointer <= 0) {
            JOptionPane.showMessageDialog(frame, "No element in Stack\nClick Reset");
            //     System.out.println("Invalid Input");
            //   System.exit(1);
        } else {
            D = stack[stackpointer];
            stackpointer--;
        }
        return D;
    }

    public void Add() {
        if (stackpointer <= 1) {
            JOptionPane.showMessageDialog(frame, "Not enough elements in Stack\n Click Reset");
        } else {
            A = Pop();
            A = A + Pop();
            Push(A);
// stack[stackpointer]=A+stack[stackpointer];}
        }
    }

    public void Sub() {
        if (stackpointer <= 1) {
            JOptionPane.showMessageDialog(frame, "Not enough elements in Stack\n Click Reset");
        } else {
            A = Pop();
            A = A - Pop();
            Push(A);
            //stack[stackpointer]=A-stack[stackpointer];}
        }
    }

    public void Mul() {
        if (stackpointer <= 1) {
            JOptionPane.showMessageDialog(frame, "Not enough elements in Stack\n Click Reset");
        } else {
            A = Pop();
            A = A * Pop();
            Push(A);
        }
    }

    public void Div() {
        if (stackpointer <= 1) {
            JOptionPane.showMessageDialog(frame, "Not enough elements in Stack\n Click Reset");
        } else {
            A = Pop();
            int u=Pop();
            if(u!=0){
            A = A % u;Push(A);}
            else{
              JOptionPane.showMessageDialog(frame, "Are u nuts\ndiving by zero is a sin\n Click Reset");  
            }
            
        }
    }

    public void Disp() {
        for (int i = stackpointer; i > 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
