public class DLList_circular_sentinel {
    private static class IntNode {
        public int item;
        public IntNode prev;
        public IntNode next;

        public IntNode(int i, IntNode p, IntNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public DLList_circular_sentinel() {
        size = 0;

        sentinel = new IntNode(0, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public DLList_circular_sentinel(int x) {
        size = 1;
        sentinel = new IntNode(0, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        IntNode n = new IntNode(x, sentinel, sentinel);
        sentinel.next = n;
        sentinel.prev = n;

    }

    public void addLast(int x) {
        size++;
        IntNode n = new IntNode(x, sentinel.prev, sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
    }

    public void addFirst(int x) {
        size++;
        IntNode n = new IntNode(x, sentinel, sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;

    }

    public void removeFirst() {
        if (size == 0) {
            return;
        }
        size--;
        IntNode tmp = sentinel.next;
        sentinel.next = tmp.next;
        tmp.next.prev = sentinel;
    }

    public void removeLast() {
        if (size == 0) {
            return;
        }
        size--;
        IntNode tmp = sentinel.prev;
        sentinel.prev = tmp.prev;
        tmp.prev.next = sentinel;
    }

    public int size() {
        return size;
    }
}
