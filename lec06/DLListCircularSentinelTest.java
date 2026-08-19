import static org.junit.Assert.*;
import org.junit.Test;

public class DLListCircularSentinelTest {

    @Test
    public void testEmptyConstructor() {
        DLList_circular_sentinel L = new DLList_circular_sentinel();

        assertEquals(0, L.size());
    }

    @Test
    public void testConstructorWithValue() {
        DLList_circular_sentinel L = new DLList_circular_sentinel(10);

        assertEquals(1, L.size());
    }

    @Test
    public void testAddFirst() {
        DLList_circular_sentinel L = new DLList_circular_sentinel();

        L.addFirst(10);
        assertEquals(1, L.size());

        L.addFirst(20);
        assertEquals(2, L.size());

        L.addFirst(30);
        assertEquals(3, L.size());
    }

    @Test
    public void testAddLast() {
        DLList_circular_sentinel L = new DLList_circular_sentinel();

        L.addLast(10);
        assertEquals(1, L.size());

        L.addLast(20);
        assertEquals(2, L.size());

        L.addLast(30);
        assertEquals(3, L.size());
    }

    @Test
    public void testRemoveFirst() {
        DLList_circular_sentinel L = new DLList_circular_sentinel();

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
        DLList_circular_sentinel L = new DLList_circular_sentinel();

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
        DLList_circular_sentinel L = new DLList_circular_sentinel();

        L.removeFirst();
        assertEquals(0, L.size());

        L.removeLast();
        assertEquals(0, L.size());
    }

    @Test
    public void testAddAfterRemoveAll() {
        DLList_circular_sentinel L = new DLList_circular_sentinel();

        L.addFirst(10);
        L.removeFirst();

        assertEquals(0, L.size());

        L.addLast(20);
        assertEquals(1, L.size());

        L.removeLast();
        assertEquals(0, L.size());

        L.addFirst(30);
        assertEquals(1, L.size());
    }

    @Test
    public void testMixedOperations() {
        DLList_circular_sentinel L = new DLList_circular_sentinel();

        L.addFirst(10);  // 10
        L.addLast(20);   // 10 20
        L.addFirst(30);  // 30 10 20
        L.addLast(40);   // 30 10 20 40

        assertEquals(4, L.size());

        L.removeFirst(); // 10 20 40
        assertEquals(3, L.size());

        L.removeLast();  // 10 20
        assertEquals(2, L.size());

        L.removeFirst(); // 20
        assertEquals(1, L.size());

        L.removeLast();  // empty
        assertEquals(0, L.size());
    }

    @Test
    public void testSingleElementRemoveFirst() {
        DLList_circular_sentinel L =
                new DLList_circular_sentinel(10);

        L.removeFirst();

        assertEquals(0, L.size());

        // 删除唯一节点后应该仍能继续使用链表
        L.addFirst(20);
        assertEquals(1, L.size());
    }

    @Test
    public void testSingleElementRemoveLast() {
        DLList_circular_sentinel L =
                new DLList_circular_sentinel(10);

        L.removeLast();

        assertEquals(0, L.size());

        // 删除唯一节点后 circular sentinel 结构应该仍然正确
        L.addLast(20);
        assertEquals(1, L.size());
    }
}