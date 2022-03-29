package model.data_structures;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TQueue {

    private Queue<String> queue;

    private void setUp1() {
        queue = new Queue<>();

    }

    private void setUp2() {
        queue = new Queue<>();
        queue.enqueue("Mazda");
        queue.enqueue("Audi");
    }

    @Test
    void normalEnqueue() {
        setUp1();

        String car = "Mazda";
        queue.enqueue(car);

        assertEquals(car, queue.dequeue());
    }

    @Test
    void interestingEnqueue() {
        setUp1();

        String car1 = "Mazda";
        queue.enqueue(car1);
        String car2 = "Audi";
        queue.enqueue(car2);
        String car3 = "Ford";
        queue.enqueue(car3);

        assertEquals(car1, queue.dequeue());
        assertEquals(car2, queue.dequeue());
        assertEquals(car3, queue.dequeue());
    }

    @Test
    void normalDequeue() {
        setUp2();

        assertNotEquals(null, queue.dequeue());
        assertNotEquals(null, queue.dequeue());
    }

    @Test
    void limitDequeue() {
        setUp2();

        assertDoesNotThrow(() -> queue.dequeue());
        assertDoesNotThrow(() -> queue.dequeue());
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }
}