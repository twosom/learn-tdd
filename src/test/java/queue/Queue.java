package queue;

import exception.Overflow;
import exception.Underflow;

public class Queue {


    private int enqueuePos = 0;
    private int dequeuePos = 0;

    private final int[] elements = new int[4];

    public boolean isEmpty() {
        return (this.enqueuePos - this.dequeuePos) == 0;
    }

    public void push(final int element) {
        validate();
        this.elements[this.enqueuePos++] = element;
    }

    private void validate() {
        if (this.elements.length == this.getSize()) throw new Overflow();
    }

    public int pop() {
        if (this.getSize() == 0) throw new Underflow();
        return this.elements[this.dequeuePos++];
    }

    public int getSize() {
        return this.enqueuePos - this.dequeuePos;
    }

}
