package stack;

import exception.Overflow;
import exception.Underflow;

public class Stack {

    private int size = 0;
    private int[] elements = new int[2];

    public Stack() {
    }

    public Stack(int size) {
        this.elements = new int[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        if (elements.length == size) throw new Overflow();
        this.elements[size++] = element;
    }

    public int pop() {
        if (this.size == 0) throw new Underflow();
        return this.elements[--size];
    }

    public int getSize() {
        return this.size;
    }
}
