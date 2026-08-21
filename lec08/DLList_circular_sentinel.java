public class DLList_circular_sentinel<T> {
    private static class myNode<T> {
        public T item;
        public myNode<T> prev;
        public myNode<T> next;

        public myNode(T i, myNode<T> p, myNode<T> n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private myNode<T> sentinel;
    private int size;

    public DLList_circular_sentinel() {
        size = 0;

        sentinel = new myNode<T>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public DLList_circular_sentinel(T x) {
        this();
        addFirst(x);
    }

    public void addLast(T x) {
        size++;
        myNode<T> n = new myNode<T>(x, sentinel.prev, sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
    }

    public void addFirst(T x) {
        size++;
        myNode<T> n = new myNode<T>(x, sentinel, sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;
    }

    public void insert(T item, int position) {
        if (position < 0 || position > size) {
            throw new RuntimeException("Invalid position.");
        }

        myNode<T> current = sentinel;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        myNode<T> newNode = new myNode<T>(item, current, current.next);
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty.");
        }
        size--;
        myNode<T> tmp = sentinel.next;
        sentinel.next = tmp.next;
        tmp.next.prev = sentinel;
        tmp.prev = null;
        tmp.next = null;
        return tmp.item;

    }

    public T removeLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty.");
        }
        size--;
        myNode<T> tmp = sentinel.prev;
        sentinel.prev = tmp.prev;
        tmp.prev.next = sentinel;
        tmp.prev = null;
        tmp.next = null;
        return tmp.item;
    }

    public T get(int position) {
        if (position < 0 || position > size) {
            throw new RuntimeException("Invalid position.");
        }

        myNode<T> current = sentinel;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.item;
    }

    public int size() {
        return size;
    }
}
