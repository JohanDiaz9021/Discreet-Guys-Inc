package model.data_structures;

import model.objects.Person;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class TPriorityQueue {

    PriorityQueue<Integer> priorityQueue1;
    PriorityQueue<Person> priorityQueue2;
    private final int SIZE = 3;

    void setUp1() {
        priorityQueue1 = new PriorityQueue<>(SIZE);
    }

    void setUp2() {
        priorityQueue2 = new PriorityQueue<>(SIZE, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getOffice() - o2.getOffice();
            }
        });
    }

    @Test
    void normalInsert() throws Exception {
        setUp1();
        priorityQueue1.offer(3);
        priorityQueue1.offer(2);
        priorityQueue1.offer(4);

        assertEquals(4, priorityQueue1.poll());
        assertEquals(3, priorityQueue1.poll());
        assertEquals(2, priorityQueue1.poll());
    }

    @Test
    void personInsert() throws Exception {
        setUp2();
        Person p1 = new Person("Carlos", 1, 2);
        Person p2 = new Person("Daniela", 2, 1);
        Person p3 = new Person("Daniel", 4, 5);

        priorityQueue2.offer(p1);
        priorityQueue2.offer(p2);
        priorityQueue2.offer(p3);

        assertEquals(p3, priorityQueue2.poll());
        assertEquals(p1, priorityQueue2.poll());
        assertEquals(p2, priorityQueue2.poll());
    }

    @Test
    void limitInsert() throws Exception {
        setUp1();

        assertDoesNotThrow(() -> priorityQueue1.offer(1));
        assertDoesNotThrow(() -> priorityQueue1.offer(2));
        assertDoesNotThrow(() -> priorityQueue1.offer(3));

        assertThrows(Exception.class, () -> priorityQueue1.offer(4));
        assertThrows(Exception.class, () -> priorityQueue1.offer(5));
    }

    @Test
    void normalPoll() throws Exception {
        setUp1();
        priorityQueue1.offer(3);

        assertEquals(3, priorityQueue1.poll());
    }

    @Test
    void interestingPoll() throws Exception {
        setUp1();
        assertThrows(Exception.class, () -> priorityQueue1.poll());
    }

    @Test
    void normalPeek() throws Exception {
        setUp1();

        priorityQueue1.offer(3);

        assertEquals(3, priorityQueue1.peek());
        assertDoesNotThrow(() -> priorityQueue1.poll());
    }
}