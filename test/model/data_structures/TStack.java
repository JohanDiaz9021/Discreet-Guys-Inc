package model.data_structures;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TStack {

    private Stack<String> stack;

    private void setUp1() {
        stack = new Stack<>();

    }

    private void setUp2() {
        stack = new Stack<>();
        stack.push("Mazda");
        stack.push("Ford");
    }

    @Test
    void normalPush() {
        setUp1();

        String car = "Mazda";
        stack.push(car);
        assertEquals(car, stack.pop());
    }

    @Test
    void interestingPush() {
        setUp1();

        String car1 = "Mazda";
        stack.push(car1);
        String car2 = "Ford";
        stack.push(car2);
        String car3 = "Audi";
        stack.push(car3);

        assertEquals(car3, stack.pop());
        assertEquals(car2, stack.pop());
        assertEquals(car1, stack.pop());
    }

    @Test
    void normalPop() {
        setUp2();

        assertNotEquals(null, stack.pop());
        assertNotEquals(null, stack.pop());
    }

    @Test
    void limitPop() {
        setUp2();

        assertDoesNotThrow(() -> stack.pop());
        assertDoesNotThrow(() -> stack.pop());
        assertThrows(NoSuchElementException.class, () -> stack.pop());
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }
}