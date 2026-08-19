public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    public void addLast(int x) {
        size++;

        IntNode tmp = null;
        for (tmp = sentinel; tmp.next != null; tmp = tmp.next) {
        }
        tmp.next = new IntNode(x, null);
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    // private int size(IntNode p) {
    // if (p.next == null) {
    // return 1;
    // }
    // return 1 + size(p.next);
    // }

    // public int size() {
    // return size(first);
    // }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(5);
        L.addLast(10);
        L.addLast(115);
        for (SLList tmp = L; tmp.sentinel != null; tmp.sentinel = tmp.sentinel.next) {
            System.out.println(tmp.sentinel.item);
        }
        System.out.println(L.size);

    }

}
