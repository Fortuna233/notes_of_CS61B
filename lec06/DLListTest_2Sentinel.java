import static org.junit.Assert.*;
import org.junit.Test;

public class DLListTest_2Sentinel {

    @Test
    public void testEmptyConstructor() {
        DLList_with_two_sentinel L = new DLList_with_two_sentinel();

        assertEquals(0, L.size());
    }

    @Test
    public void testConstructorWithValue() {
        DLList_with_two_sentinel L = new DLList_with_two_sentinel(10);

        assertEquals(1, L.size());
    }

    @Test
    public void testAddFirst() {
        DLList_with_two_sentinel L = new DLList_with_two_sentinel();

        L.addFirst(10);
        assertEquals(1, L.size());

        L.addFirst(20);
        assertEquals(2, L.size());

        L.addFirst(30);
        assertEquals(3, L.size());
    }

    @Test
    public void testAddLast() {
        DLList_with_two_sentinel L = new DLList_with_two_sentinel();

        L.addLast(10);
        assertEquals(1, L.size());

        L.addLast(20);
        assertEquals(2, L.size());

        L.addLast(30);
        assertEquals(3, L.size());
    }

    @Test
    public void testAddFirstAndLast() {
        DLList_with_two_sentinel L = new DLList_with_two_sentinel();

        L.addFirst(10);
        L.addLast(20);
        L.addFirst(30);
        L.addLast(40);

        assertEquals(4, L.size());
    }

    @Test
    public void testRemoveFirst() {
        DLList_with_two_sentinel L = new DLList_with_two_sentinel();

        L.addLast(10);
        L.addLast(20);
        L.addLast(30);

        assertEquals(3, L.size());

        L.removeFirst();
        assertEquals(2, L.size());

        L.removeFirst();
        assertEquals(1, L.size());

        L.removeFirst();
        assertEquals(0, L.size());
    }

    @Test
    public void testRemoveLast() {
        DLList_with_two_sentinel L = new DLList_with_two_sentinel();

        L.addLast(10);
        L.addLast(20);
        L.addLast(30);

        assertEquals(3, L.size());

        L.removeLast();
        assertEquals(2, L.size());

        L.removeLast();
        assertEquals(1, L.size());

        L.removeLast();
        assertEquals(0, L.size());
    }

    @Test
    public void testRemoveFromEmptyList() {
        DLList_with_two_sentinel L = new DLList_with_two_sentinel();

        L.removeFirst();
        assertEquals(0, L.size());

        L.removeLast();
        assertEquals(0, L.size());
    }

    @Test
    public void testAddAfterRemoveAll() {
        DLList_with_two_sentinel L = new DLList_with_two_sentinel();

        L.addFirst(10);
        L.removeFirst();

        assertEquals(0, L.size());

        L.addLast(20);

        assertEquals(1, L.size());
    }

    @Test
    public void testMixedOperations() {
        DLList_with_two_sentinel L = new DLList_with_two_sentinel();

        L.addFirst(10);
        L.addLast(20);
        L.addFirst(30);

        assertEquals(3, L.size());

        L.removeFirst();
        assertEquals(2, L.size());

        L.removeLast();
        assertEquals(1, L.size());

        L.removeFirst();
        assertEquals(0, L.size());

        L.addFirst(100);
        assertEquals(1, L.size());
    }
}