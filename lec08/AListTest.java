import static org.junit.Assert.*;
import org.junit.Test;

public class AListTest {
    @Test
    public void testEmptyList() {
        AList<Integer> L = new AList<>();

        assertEquals(0, L.size());
    }

    @Test
    public void testAddLast() {
        AList<Integer> L = new AList<>();

        L.addLast(10);
        L.addLast(20);
        L.addLast(30);

        assertEquals(3, L.size());
        assertEquals(Integer.valueOf(10), L.get(0));
        assertEquals(Integer.valueOf(20), L.get(1));
        assertEquals(Integer.valueOf(30), L.get(2));
    }

    @Test
    public void testGetLast() {
        AList<String> L = new AList<>();

        L.addLast("apple");
        L.addLast("banana");
        L.addLast("orange");

        assertEquals("orange", L.getLast());
    }

    @Test
    public void testRemoveLast() {
        AList<Integer> L = new AList<>();

        L.addLast(10);
        L.addLast(20);
        L.addLast(30);

        assertEquals(Integer.valueOf(30), L.removeLast());
        assertEquals(2, L.size());
        assertEquals(Integer.valueOf(20), L.getLast());

        assertEquals(Integer.valueOf(20), L.removeLast());
        assertEquals(1, L.size());
        assertEquals(Integer.valueOf(10), L.getLast());
    }

    @Test
    public void testRemoveAll() {
        AList<Integer> L = new AList<>();

        L.addLast(10);
        L.addLast(20);
        L.addLast(30);

        assertEquals(Integer.valueOf(30), L.removeLast());
        assertEquals(Integer.valueOf(20), L.removeLast());
        assertEquals(Integer.valueOf(10), L.removeLast());

        assertEquals(0, L.size());
    }

    @Test
    public void testAddAfterRemove() {
        AList<String> L = new AList<>();

        L.addLast("A");
        L.addLast("B");

        assertEquals("B", L.removeLast());

        L.addLast("C");

        assertEquals(2, L.size());
        assertEquals("A", L.get(0));
        assertEquals("C", L.get(1));
        assertEquals("C", L.getLast());
    }

    @Test
    public void testResize() {
        AList<Integer> L = new AList<>();

        // 初始容量是 64，加入超过 64 个元素，
        // 用于测试自动扩容。
        for (int i = 0; i < 100; i++) {
            L.addLast(i);
        }

        assertEquals(100, L.size());

        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.valueOf(i), L.get(i));
        }
    }

    @Test
    public void testResizeAfterRemove() {
        AList<Integer> L = new AList<>();

        // 扩容到至少 128
        for (int i = 0; i < 100; i++) {
            L.addLast(i);
        }

        // 删除大量元素，触发缩容
        for (int i = 99; i >= 10; i--) {
            assertEquals(Integer.valueOf(i), L.removeLast());
        }

        assertEquals(10, L.size());

        // 确保缩容之后数据仍然正确
        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i), L.get(i));
        }
    }

    @Test(expected = RuntimeException.class)
    public void testGetLastFromEmptyList() {
        AList<Integer> L = new AList<>();

        L.getLast();
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveLastFromEmptyList() {
        AList<Integer> L = new AList<>();

        L.removeLast();
    }
}