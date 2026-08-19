public class DLList_with_two_sentinel {
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

    private IntNode sentFront;
    private IntNode sentBack;
    private int size;

    public DLList_with_two_sentinel() {
        size = 0;
        sentFront = new IntNode(0, null, null);
        sentBack = new IntNode(0, sentFront, null);
        sentFront.next = sentBack;
    }

    public DLList_with_two_sentinel(int x) {
        size = 1;
        sentFront = new IntNode(0, null, null);
        sentBack = new IntNode(0, sentFront, null);
        sentFront.next = sentBack;
        IntNode n = new IntNode(x, sentFront, sentBack);
        sentFront.next = n;
        sentBack.prev = n;

    }

    public void addLast(int x) {
        size++;
        IntNode n = new IntNode(x, sentBack.prev, sentBack);
        sentBack.prev.next = n;
        sentBack.prev = n;
    }

    public void addFirst(int x) {
        size++;
        IntNode n = new IntNode(x, sentFront, sentFront.next);
        sentFront.next.prev = n;
        sentFront.next = n;

    }

    public void removeFirst() {
        if (size == 0) {
            return;
        }
        size--;
        IntNode tmp = sentFront.next;
        sentFront.next = tmp.next;
        tmp.next.prev = sentFront;
    }

    public void removeLast() {
        if (size == 0) {
            return;
        }
        size--;
        IntNode tmp = sentBack.prev;
        sentBack.prev = tmp.prev;
        tmp.prev.next = sentBack;
    }

    public int size() {
        return size;
    }
}
