package queue;

import exception.Overflow;
import exception.Underflow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// TODO FIFO
public class QueueTest {
    private Queue queue = new Queue();

    @Test
    void canCreateQueue() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
    }

    @Test
    void afterOnePush_isNotEmpty() {
        queue.push(0);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.getSize());
    }

    @Test
    void afterOnePushAndPop_isEmpty() {
        queue.push(0);
        queue.pop();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
    }

    @Test
    void afterTwoPushes_sizeIsTwo() {
        queue.push(0);
        queue.push(0);
        assertEquals(2, queue.getSize());
    }
    @Test
    void afterTwoPushAndPop_isNotEmpty() {
        queue.push(0);
        queue.push(0);
        queue.pop();
        assertFalse(queue.isEmpty());
    }

    @Test
    void afterPushingX_willPopX() {
        queue.push(99);
        assertEquals(99, queue.pop());
    }

    @Test
    void afterPushingXAndY_willPopXAndY() {
        queue.push(99);
        queue.push(88);
        assertEquals(99, queue.pop());
        assertEquals(88, queue.pop());
    }

    @Test
    void poppingEmptyQueue_throwUnderFlow() {
        assertThrows(Underflow.class, () -> {
            queue.pop();
        });
    }

    @Test
    void pushingOverSizeQueue_throwOverFlow() {
        // default size = 4
        assertThrows(Overflow.class, () -> {
            queue.push(0);
            queue.push(0);
            queue.push(0);
            queue.push(0);
            queue.push(0);
        });
    }


}
