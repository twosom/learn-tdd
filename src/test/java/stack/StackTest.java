package stack;

import exception.Overflow;
import exception.Underflow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    public static final int STACK_SIZE = 5;
    private Stack stack = new Stack();
    private Stack stackWithSize = new Stack(STACK_SIZE);

    @Test
    void canCreateStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void afterOnePush_isNotEmpty() {
        stack.push(0);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.getSize());
    }

    @Test
    void afterOnePushAndPop_isEmpty() {
        stack.push(0);
        stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    void afterTwoPushes_sizeIsTwo() {
        stack.push(0);
        stack.push(0);
        assertEquals(2, stack.getSize());
    }

    @Test
    void poppingEmptyStack_throwsUnderflow() {
        assertThrows(Underflow.class, () -> {
            stack.pop();
        });
    }

    @Test
    void afterPushingX_willPopX() {
        stack.push(99);
        assertEquals(99, stack.pop());
        stack.push(88);
        assertEquals(88, stack.pop());
    }

    @Test
    void afterPushingXAndY_willPopYAndX() {
        stack.push(99);
        stack.push(88);
        assertEquals(88, stack.pop());
        assertEquals(99, stack.pop());
    }

    //TODO
    // 1. stack 생성 시 갯수 받기
    // 2. 숫자 이상 push 하려는 경우 Overflow 예외 던지기
    @Test
    void canCreateStack_withElementsSize() {
        assertTrue(stackWithSize.isEmpty());
    }

    @Test
    void canPushElements_withSpecifiedStackSize() {
        stackWithSize.push(1);
        stackWithSize.push(2);
        stackWithSize.push(3);
        stackWithSize.push(4);
        stackWithSize.push(5);

        assertEquals(5, stackWithSize.getSize());
    }

    @Test
    void pushingOverSizeStack_throwOverflow() {
        assertThrows(Overflow.class, () -> {
            stackWithSize.push(0);
            stackWithSize.push(0);
            stackWithSize.push(0);
            stackWithSize.push(0);
            stackWithSize.push(0);
            stackWithSize.push(0);
        });
    }

}
