import static org.junit.Assert.*;
import org.junit.Test;

public class DLList_circular_sentinelTest {


    @Test
    public void testEmptyList() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        assertEquals(0, L.size());

        // sentinel 在位置0
        assertNull(L.get(0));
    }


    @Test
    public void testAddFirst() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.addFirst(10);
        L.addFirst(20);
        L.addFirst(30);

        // sentinel -> 30 -> 20 -> 10

        assertEquals(3, L.size());

        assertNull(L.get(0));
        assertEquals(Integer.valueOf(30), L.get(1));
        assertEquals(Integer.valueOf(20), L.get(2));
        assertEquals(Integer.valueOf(10), L.get(3));
    }


    @Test
    public void testAddLast() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.addLast(10);
        L.addLast(20);
        L.addLast(30);

        // sentinel -> 10 -> 20 -> 30

        assertEquals(3, L.size());

        assertNull(L.get(0));
        assertEquals(Integer.valueOf(10), L.get(1));
        assertEquals(Integer.valueOf(20), L.get(2));
        assertEquals(Integer.valueOf(30), L.get(3));
    }


    @Test
    public void testInsertAfterSentinel() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.addLast(20);
        L.addLast(30);

        // sentinel -> 20 -> 30

        L.insert(10, 0);

        // sentinel -> 10 -> 20 -> 30

        assertEquals(3, L.size());

        assertEquals(Integer.valueOf(10), L.get(1));
        assertEquals(Integer.valueOf(20), L.get(2));
        assertEquals(Integer.valueOf(30), L.get(3));
    }


    @Test
    public void testInsertMiddle() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.addLast(10);
        L.addLast(30);

        // sentinel -> 10 -> 30

        L.insert(20, 1);

        // 在第1个节点(10)之后插入
        // sentinel -> 10 -> 20 -> 30

        assertEquals(3, L.size());

        assertEquals(Integer.valueOf(10), L.get(1));
        assertEquals(Integer.valueOf(20), L.get(2));
        assertEquals(Integer.valueOf(30), L.get(3));
    }


    @Test
    public void testInsertAfterLastNode() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.addLast(10);
        L.addLast(20);

        // sentinel -> 10 -> 20

        L.insert(30, 2);

        // 在节点20之后插入

        assertEquals(3, L.size());

        assertEquals(Integer.valueOf(10), L.get(1));
        assertEquals(Integer.valueOf(20), L.get(2));
        assertEquals(Integer.valueOf(30), L.get(3));
    }


    @Test
    public void testRemoveFirst() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.addLast(10);
        L.addLast(20);
        L.addLast(30);

        assertEquals(Integer.valueOf(10), L.removeFirst());

        // sentinel -> 20 -> 30

        assertEquals(2, L.size());

        assertEquals(Integer.valueOf(20), L.get(1));
        assertEquals(Integer.valueOf(30), L.get(2));
    }


    @Test
    public void testRemoveLast() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.addLast(10);
        L.addLast(20);
        L.addLast(30);

        assertEquals(Integer.valueOf(30), L.removeLast());

        // sentinel -> 10 -> 20

        assertEquals(2, L.size());

        assertEquals(Integer.valueOf(10), L.get(1));
        assertEquals(Integer.valueOf(20), L.get(2));
    }


    @Test
    public void testRemoveAll() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.addLast(10);
        L.addLast(20);
        L.addLast(30);

        assertEquals(Integer.valueOf(10), L.removeFirst());
        assertEquals(Integer.valueOf(20), L.removeFirst());
        assertEquals(Integer.valueOf(30), L.removeFirst());

        assertEquals(0, L.size());

        // sentinel 仍存在
        assertNull(L.get(0));
    }


    @Test
    public void testConstructorWithItem() {
        DLList_circular_sentinel<String> L =
                new DLList_circular_sentinel<>("Hello");

        // sentinel -> Hello

        assertEquals(1, L.size());

        assertNull(L.get(0));
        assertEquals("Hello", L.get(1));
    }


    @Test
    public void testAddAfterRemove() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.addLast(10);
        L.addLast(20);

        assertEquals(Integer.valueOf(20), L.removeLast());

        L.addLast(30);

        // sentinel -> 10 -> 30

        assertEquals(2, L.size());

        assertEquals(Integer.valueOf(10), L.get(1));
        assertEquals(Integer.valueOf(30), L.get(2));
    }


    @Test
    public void testGenericType() {
        DLList_circular_sentinel<String> L =
                new DLList_circular_sentinel<>();

        L.addLast("apple");
        L.addLast("banana");

        assertEquals("apple", L.get(1));
        assertEquals("banana", L.get(2));
    }


    @Test
    public void testLargeInsert() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        for (int i = 1; i <= 100; i++) {
            L.addLast(i);
        }

        // 第50个节点后插入
        L.insert(999, 50);

        assertEquals(101, L.size());

        assertEquals(Integer.valueOf(50), L.get(50));
        assertEquals(Integer.valueOf(999), L.get(51));
        assertEquals(Integer.valueOf(51), L.get(52));
    }


    @Test(expected = RuntimeException.class)
    public void testRemoveFirstEmpty() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.removeFirst();
    }


    @Test(expected = RuntimeException.class)
    public void testRemoveLastEmpty() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.removeLast();
    }


    @Test(expected = RuntimeException.class)
    public void testInsertInvalidPosition() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        // 空链表只有sentinel位置0
        // 不能在不存在节点之后插入
        L.insert(10, 1);
    }


    @Test(expected = RuntimeException.class)
    public void testGetInvalidPosition() {
        DLList_circular_sentinel<Integer> L =
                new DLList_circular_sentinel<>();

        L.addLast(10);

        // sentinel=0, node=1
        L.get(2);
    }
}