package leetCode.stack;

import java.util.Stack;

class MinStack155 {

    Stack<Integer> minStack;
    Stack<Integer> valStack;

    public MinStack155() {
        this.minStack = new Stack<>();
        this.valStack = new Stack<>();
    }
    
    public void push(int val) {
        this.valStack.push(val);
        if (this.minStack.empty()){
            this.minStack.push(val);
        }else {
            this.minStack.push(Math.min(this.minStack.peek(),val));
        }
    }
    
    public void pop() {
        this.valStack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.valStack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }

    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();

    }
}