package model.data_structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class THashTable {

    HashTable<Integer, String> hashTable;
    private final int SIZE = 3;

    void setUp1() {
        hashTable = new HashTable<>(SIZE);
    }

    void setUp2() throws Exception {
        hashTable = new HashTable<>(SIZE);
        hashTable.insert(1, "Car");
        hashTable.insert(3, "Cat");
        hashTable.insert(6, "Dog");
    }

    @Test
    void normalInsert() throws Exception {
        setUp1();

        String name1 = "Car";
        hashTable.insert(234, name1);

        assertEquals(name1, hashTable.search(234));
    }

    @Test
    void limitInsert() {
        setUp1();

        assertDoesNotThrow(() -> hashTable.insert(234, "Car"));
        assertDoesNotThrow(() -> hashTable.insert(375, "House"));
        assertDoesNotThrow(() -> hashTable.insert(426, "Dog"));
        assertThrows(Exception.class, () -> hashTable.insert(426, "Cat"));
        assertThrows(Exception.class, () -> hashTable.insert(426, "Lol"));
    }

    @Test
    void interestingInsert() throws Exception {
        setUp1();

        String name1 = "Car";
        assertNotNull(hashTable.insert(234, name1));
        String name2 = "House";
        assertNotNull(hashTable.insert(234, name2));
        String name3 = "Dog";
        assertNotNull(hashTable.insert(234, name3));

    }

    @Test
    void normalDelete() throws Exception {
        setUp2();
        hashTable.delete(3);

        assertNull(hashTable.search(3));

    }

    @Test
    void limitDelete() throws Exception {
        setUp2();

        assertDoesNotThrow(() -> hashTable.delete(1));
        assertDoesNotThrow(() -> hashTable.delete(3));
        assertDoesNotThrow(() -> hashTable.delete(6));

    }

    @Test
    void interestingDelete() throws Exception {
        setUp1();
        assertThrows(Exception.class, () -> hashTable.delete(1));

    }

    @Test
    void normalSearch() throws Exception {
        setUp1();

        String name1 = "Car";
        hashTable.insert(234, name1);

        assertEquals(name1, hashTable.search(234));

    }

    @Test
    void limitSearch() throws Exception {
        setUp2();
        assertNull(hashTable.search(23425));

    }

    @Test
    void interestingSearch() throws Exception {
        setUp1();
        hashTable.insert(3, "hello");
        hashTable.insert(3, "bye");
        assertNotNull(hashTable.search(3));

    }
}