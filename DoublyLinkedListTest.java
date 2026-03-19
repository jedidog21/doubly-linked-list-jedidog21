import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList <Integer> doubly = new DoublyLinkedList<Integer>(100);
    @org.junit.jupiter.api.Test
    void add() {
        doubly.add(10);
        doubly.add(20);
        assertEquals(10, doubly.get(0));
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        doubly.add(10);
        doubly.add(0,20);
        assertEquals(20, doubly.get(0));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        doubly.add(10);
        doubly.add(20);
        assertEquals(20, doubly.remove());
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        doubly.add(10);
        doubly.add(20);
        assertEquals(20, doubly.remove(1));
    }

    @org.junit.jupiter.api.Test
    void get() {
        doubly.add(10);
        doubly.add(20);
        assertEquals(10, doubly.get(0));
    }

    @org.junit.jupiter.api.Test
    void set() {
        doubly.add(10);
        doubly.set(0, 20);
        assertEquals(20, doubly.get(0));
    }

    @org.junit.jupiter.api.Test
    void size() {
        doubly.add(10);
        doubly.add(20);
        assertEquals(2, doubly.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        doubly.add(10);
        doubly.add(20);
        assertEquals(false, doubly.isEmpty());
    }
}